package org.example.bookshoponlinewebsite.repositories;

import org.example.bookshoponlinewebsite.models.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, String> {
}
