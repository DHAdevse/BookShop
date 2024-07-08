package org.example.bookshoponlinewebsite.services.impl;

import jakarta.transaction.Transactional;
import org.example.bookshoponlinewebsite.models.LineItem;
import org.example.bookshoponlinewebsite.repositories.LineItemRepository;
import org.example.bookshoponlinewebsite.services.LineItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class LineItemServiceImpl implements LineItemService {
    @Autowired
    private LineItemRepository lineItemRepository;
    @Override
    public LineItem addLineItem(LineItem lineItem) {
        return lineItemRepository.save(lineItem);
    }

    @Override
    public boolean deleteLineItem(String id) {
        if(lineItemRepository.existsById(id))
        {
            lineItemRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public LineItem updateLineItem(LineItem lineItem) {
        return lineItemRepository.saveAndFlush(lineItem);
    }
    @Override
    public LineItem getLineItem(String userid) {
        return lineItemRepository.getReferenceById(userid);
    }
    @Transactional
    @Override
    public LineItem saveAndFlush(LineItem lineItem) {
        return lineItemRepository.saveAndFlush(lineItem);
    }
}
