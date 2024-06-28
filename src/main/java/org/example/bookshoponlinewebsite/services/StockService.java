package org.example.bookshoponlinewebsite.services;

import org.example.bookshoponlinewebsite.models.Stock;

public interface StockService {
    Stock getStockById(String id);
    Stock saveAndFlush(Stock stock);
}
