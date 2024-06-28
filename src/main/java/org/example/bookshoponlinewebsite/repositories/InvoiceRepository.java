package org.example.bookshoponlinewebsite.repositories;

import org.example.bookshoponlinewebsite.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,String> {
    @Query("Select SUM(i.totalAmount) from Invoice i")
    Double calTotalAmount();
    @Query("Select SUM(i.totalPay) from Invoice i ")
    Double calTotalPay();
}

