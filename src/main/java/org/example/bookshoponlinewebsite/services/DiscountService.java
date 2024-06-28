package org.example.bookshoponlinewebsite.services;

import org.example.bookshoponlinewebsite.models.Discount;

import java.util.UUID;

public interface DiscountService {
    Discount addDiscount(Discount discount);
    Discount getDiscountbyId(UUID id);
    Discount updateDiscount(Discount discount);
    boolean deleteDiscount(UUID id);
}
