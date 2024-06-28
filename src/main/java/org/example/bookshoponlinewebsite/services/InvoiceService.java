package org.example.bookshoponlinewebsite.services;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.bookshoponlinewebsite.models.Invoice;

public interface InvoiceService {
    public Invoice addInvoice(Invoice invoice);
    public Invoice saveAndFlush(Invoice invoice);
    public Invoice getInvoiceByUserId(String userId);
    public double calTotalAmount();
    public double calTotalPay();
}
