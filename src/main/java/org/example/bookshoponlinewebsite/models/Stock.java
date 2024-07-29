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
@Table(name="stock")
public class Stock {
    @Id
    private String stockId;
    private Integer quantity;
    @Column(name="import_price")
    private double importPrice;
    @OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "stock")
    private Book book;

    public void addBook(Book book)
    {
        this.book = book;
        book.setStock(this);
    }
}
