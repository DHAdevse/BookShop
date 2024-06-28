package org.example.bookshoponlinewebsite.models;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
@Table(name = "lineitem")
public class LineItem {
    @Id
    @Column(name="lineitem_id")
    private String lineItemId;
    @Column(name="quantity")
    private int quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;
}
