package org.example.bookshoponlinewebsite.payments;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.bookshoponlinewebsite.models.Cart;
import org.example.bookshoponlinewebsite.models.Invoice;
import org.example.bookshoponlinewebsite.services.InvoiceService;
import org.example.bookshoponlinewebsite.utils.GenerateID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class VNPayController {
    @Autowired
    private VNPayService vnPayService;
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private GenerateID generateID;

    @PostMapping({"payment"})
    public String paymentHome(HttpSession session,Model model) {
        Cart cart =(Cart) session.getAttribute("cart");
        // Tạo invoice mới
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(generateID.generateBillId());
        invoice.setOrderDate(new Date());
        invoice.setTotalAmount(cart.calculateTotal());
        invoice.setStatus(false);
        invoice.setPaymentMethod("VNPay");

        // Các thông tin khác có thể được set tùy theo yêu cầu của bạn
        long threeDays = 60*60*24*3*1000;
        Date delivery = new Date(new Date().getTime()+threeDays);
        invoice.setDeliveryDate(delivery);

        //Set ship fee
        if(invoice.getTotalAmount()>100)
            invoice.setShipFee(0);
        else invoice.setShipFee(10);
        invoice.setTotalPay(cart.calculateTotal()+invoice.getShipFee());

        // Lưu invoice vào session
        session.setAttribute("currentInvoice", invoice);

        return "createOrder";
    }

    // Chuyển hướng người dùng đến cổng thanh toán VNPAY
    @PostMapping("/submitOrder")
    public String submitOrder(@RequestParam("amount") double orderTotal,
                              @RequestParam("orderInfo") String orderInfo,
                              HttpServletRequest request) {
        String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        String vnpayUrl = vnPayService.createOrder(request, orderTotal, orderInfo, baseUrl);
        return "redirect:" + vnpayUrl;
    }

    // Sau khi hoàn tất thanh toán, VNPAY sẽ chuyển hướng trình duyệt về URL này
    @GetMapping("/vnpay-payment-return")
    public String paymentCompleted(HttpServletRequest request, Model model) {
        int paymentStatus = vnPayService.orderReturn(request);

        String orderInfo = request.getParameter("vnp_OrderInfo");
        String paymentTime = request.getParameter("vnp_PayDate");
        String transactionId = request.getParameter("vnp_TransactionNo");
        String totalPrice = request.getParameter("vnp_Amount");

        model.addAttribute("orderId", orderInfo);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("paymentTime", paymentTime);
        model.addAttribute("transactionId", transactionId);

        return paymentStatus == 1 ? "orderSuccess" : "orderFail";
    }
}
