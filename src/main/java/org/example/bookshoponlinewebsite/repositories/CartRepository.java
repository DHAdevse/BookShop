package org.example.bookshoponlinewebsite.repositories;

import org.example.bookshoponlinewebsite.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,String> {
    public Cart getCartByUserId(String UserId);

}
