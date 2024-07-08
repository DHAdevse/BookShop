package org.example.bookshoponlinewebsite.models;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
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
    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(name="cart_lineitem",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="lineitem_id"))
    private List<LineItem> lineItemList;
    @Transactional
    public void addLineItem(LineItem lineItem){
        if (lineItemList==null)
        {
            lineItemList = new ArrayList<>();
        }
        lineItemList.add(lineItem);
    }
    @Transactional
    public void removeLineItem(LineItem item) {
        if (lineItemList != null) {
            lineItemList.remove(item);
        }
    }

}
