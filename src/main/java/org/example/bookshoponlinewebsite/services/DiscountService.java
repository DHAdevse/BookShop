package org.example.bookshoponlinewebsite.services;

import org.example.bookshoponlinewebsite.models.Discount;

import java.util.List;

public interface DiscountService {
    Discount addDiscount(Discount discount);
    Discount getDiscountbyId(String id);
    Discount updateDiscount(Discount discount);
    boolean deleteDiscount(String id);
    public List<Discount> getAllDiscount();
}
