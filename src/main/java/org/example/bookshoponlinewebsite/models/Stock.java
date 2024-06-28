package org.example.bookshoponlinewebsite.models;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
@Table(name="stock")
public class Stock {
    @Id
    private String stockId;
    private int quantity;
    @Column(name="import_price")
    private double importPrice;
    @OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "stock")
    private Book book;
}
