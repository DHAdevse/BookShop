package org.example.bookshoponlinewebsite.services;

import org.example.bookshoponlinewebsite.models.Cart;

public interface CartService {
    public Cart saveAndFlush(Cart cart);
}
