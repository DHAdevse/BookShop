package org.example.bookshoponlinewebsite.models;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
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

    public Cart() {
    }

    public Cart(String userId, List<LineItem> lineItemList) {
        this.userId = userId;
        this.lineItemList = lineItemList;
    }

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
    public double calculateTotal(){
        double totalBill=0;
        for(LineItem item: lineItemList){
            totalBill+=item.getBook().getSellPrice()*item.getQuantity();
        }
        return totalBill;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<LineItem> getLineItemList() {
        return lineItemList;
    }

    public void setLineItemList(List<LineItem> lineItemList) {
        this.lineItemList = lineItemList;
    }
}
