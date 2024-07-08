package org.example.bookshoponlinewebsite.controllers;

import jakarta.servlet.http.HttpSession;
import org.example.bookshoponlinewebsite.models.Book;
import org.example.bookshoponlinewebsite.models.Cart;
import org.example.bookshoponlinewebsite.models.LineItem;
import org.example.bookshoponlinewebsite.services.BookService;
import org.example.bookshoponlinewebsite.services.CartService;
import org.example.bookshoponlinewebsite.services.LineItemService;
import org.example.bookshoponlinewebsite.utils.GenerateID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private BookService bookService;
    @Autowired
    private LineItemService lineItemService;
    @Autowired
    private GenerateID generateID;
    @GetMapping("")
    public String cart(HttpSession session){
        Cart cart = (Cart) session.getAttribute("cart");
//        if(cart != null){
//
//            session.setAttribute("subtotal", subtotal);
//            session.setAttribute("total", total);
//        }
        return "cart";
    }

    @GetMapping("add-to-cart/")
    public String addCart(HttpSession session,
                          @PathVariable("bookId") String bookId,
                          @PathVariable(value = "quantity", required = false) Integer quantity,
                          RedirectAttributes redirect) {
        if(quantity==null) {quantity=1;}

        // Kiểm tra xem người dùng đã đăng nhập chưa
        if(session.getAttribute("authUser")==null){
            return "redirect:/login?redirectUrl:/book/"+bookId;
        }
        // Thêm sản phẩm vào giỏ hàng
        // Giả sử bạn có một service để lấy thông tin sản phẩm
        Book book= bookService.getBookById(bookId);
        if (book == null) {
            redirect.addFlashAttribute("error", "Book does not exist");
            return "redirect:/book";
        }
        if(book.getStock().getQuantity()<quantity){
            if(book.getStock().getQuantity()<1)
            {
                redirect.addFlashAttribute("error", "Book was sold out");
            }
            else
            {
                redirect.addFlashAttribute("error","The quantiy requested exceeds the quantity in stock! Contain: "+ book.getStock().getQuantity());
            }
            return "redirect:/book/"+ book.getBookId();
        }

        // Lấy giỏ hàng từ session hoặc tạo mới nếu chưa có
        Cart cart =(Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        // Check the book was in cart??
        for(LineItem lineItem: cart.getLineItemList())
        {
            if(lineItem.getBook().getBookId().equals(book.getBookId()))
            {
                if(lineItem.getQuantity()+quantity> book.getStock().getQuantity())
                {
                    redirect.addFlashAttribute("error", "The quantiy requested exceeds the quantity in stock! Contain: "+ book.getStock().getQuantity());
                    return "redirect:/book/"+book.getBookId();
                }
                else{
                    lineItem.setQuantity(lineItem.getQuantity()+quantity);
                    lineItemService.saveAndFlush(lineItem);
                }
                return "cart";
            }
        }
        LineItem lineItem = new LineItem();
        lineItem.setLineItemId(generateID.generateLineItemId());
        lineItem.setBook(book);
        lineItem.setQuantity(quantity);
        lineItemService.addLineItem(lineItem);
        cart.addLineItem(lineItem);
        cartService.saveAndFlush(cart);


        // Cập nhật giỏ hàng trong session
        session.setAttribute("cart", cart);

        // Thêm thông báo thành công
        redirect.addFlashAttribute("success", "Add to cart successfully!!!");
        return "redirect:/cart";
    }
//    @GetMapping("update-cart")
//    public String updateCart(HttpSession session, @PathVariable("bookId") String bookId, @PathVariable("quantity") int quantity)
//    {
//
//    }
}
