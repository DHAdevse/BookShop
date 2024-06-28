package org.example.bookshoponlinewebsite.models;

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
@Table(name= "cart")
public class Cart {
    @Id
    @Column(name="user_id")
    private String userId;
    @ManyToMany
    @JoinTable(name="cart_lineitem",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="lineitem_id"))
    private List<LineItem> lineItemList;

}
