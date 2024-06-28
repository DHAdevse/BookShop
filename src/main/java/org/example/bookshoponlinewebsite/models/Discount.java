package org.example.bookshoponlinewebsite.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
@Table(name = "discount")
public class Discount {
    @Id
    @Column(name = "discount_code")
    private UUID discountCode;
    @Column(name="discount_amount")
    private int discountAmount;
    @OneToOne
    private User user;
    @OneToOne
    private Invoice invoice;

}
