package org.example.bookshoponlinewebsite.repositories;

import org.example.bookshoponlinewebsite.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock,String> {
}
