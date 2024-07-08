package org.example.bookshoponlinewebsite.services.impl;

import org.example.bookshoponlinewebsite.models.Cart;
import org.example.bookshoponlinewebsite.repositories.CartRepository;
import org.example.bookshoponlinewebsite.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Override
    public Cart saveAndFlush(Cart cart) {
        return cartRepository.saveAndFlush(cart);
    }
    @Override
    public Cart getCartByUserId(String UserId) {
        return cartRepository.getReferenceById(UserId);
    }
}
