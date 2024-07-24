package org.example.bookshoponlinewebsite.services;

import org.example.bookshoponlinewebsite.models.Invoice;

import java.util.List;

public interface InvoiceService {
    public Invoice addInvoice(Invoice invoice);
    public Invoice saveAndFlush(Invoice invoice);
    public Invoice getInvoiceByUserId(String userId);
    public List<Invoice> getAllInvoice();
}
