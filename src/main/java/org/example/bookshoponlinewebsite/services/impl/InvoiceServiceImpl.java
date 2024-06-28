package org.example.bookshoponlinewebsite.services.impl;

import org.example.bookshoponlinewebsite.models.Invoice;
import org.example.bookshoponlinewebsite.repositories.InvoiceRepository;
import org.example.bookshoponlinewebsite.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Override
    public Invoice addInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice saveAndFlush(Invoice invoice) {
        return invoiceRepository.saveAndFlush(invoice);
    }

    @Override
    public Invoice getInvoiceByUserId(String userId) {
        return invoiceRepository.getReferenceById(userId);
    }

    @Override
    public double calTotalAmount() {
        return invoiceRepository.calTotalAmount();
    }

    @Override
    public double calTotalPay() {
        return invoiceRepository.calTotalPay();
    }
}
