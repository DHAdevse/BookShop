package org.example.bookshoponlinewebsite.services.impl;

import org.example.bookshoponlinewebsite.models.Stock;
import org.example.bookshoponlinewebsite.repositories.StockRepository;
import org.example.bookshoponlinewebsite.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockRepository stockRepository;
    @Override
    public Stock getStockById(String id) {
        return stockRepository.getReferenceById(id);
    }
    @Override
    public Stock saveAndFlush(Stock stock) {
        return stockRepository.saveAndFlush(stock);
    }


}
