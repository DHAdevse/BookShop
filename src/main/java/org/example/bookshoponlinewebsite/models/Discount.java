package org.example.bookshoponlinewebsite.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
@Table(name = "discount")
public class Discount {
    @Id
    @Column(name = "discount_code")
    private String discountCode;
    @Column(name="discount_amount")
    private int discountAmount;
    @OneToOne
    private User user;
    @OneToOne
    private Invoice invoice;

}
