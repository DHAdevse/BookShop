package org.example.bookshoponlinewebsite.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name="invoice")
public class Invoice {
    @Id
    @Column(name="invoice_id")
    private String invoiceID;
    @Column(name="order_date")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @Temporal(TemporalType.DATE)
    @Column(name="delivery_date")
    private Date deliveryDate;
    @Column(name="total_amount")
    private double totalAmount;
    @Column(name="total_pay")
    private double totalPay;
    @Column(name="Status")
    private String status;
    @Column(name="payment_method")
    private String paymentMethod;
    @OneToOne()
    private Discount discountList;

}
