package org.example.bookshoponlinewebsite.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name="invoice")
public class Invoice {
    @Id
    @Column(name="invoice_id")
    private String invoiceId;
    @Column(name="order_date")
    private Date orderDate;
    @Temporal(TemporalType.DATE)
    @Column(name="delivery_date")
    private Date deliveryDate;
    @Column(name="total_amount")
    private double totalAmount;
    @Column(name="total_pay")
    private double totalPay;
    @Column(name="Status")
    private boolean status;
    @Column(name="ship_fee")
    private double shipFee;
    @Column(name="payment_method")
    private String paymentMethod;
    @OneToOne()
    private Discount discount;

}
