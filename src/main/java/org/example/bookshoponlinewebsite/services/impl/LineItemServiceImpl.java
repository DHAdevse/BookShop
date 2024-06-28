package org.example.bookshoponlinewebsite.services.impl;

import org.example.bookshoponlinewebsite.models.LineItem;
import org.example.bookshoponlinewebsite.repositories.LineItemRepository;
import org.example.bookshoponlinewebsite.services.LineItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return lineItemRepository.save(lineItem);
    }

    @Override
    public LineItem getLineItem(String userid) {
        return lineItemRepository.getReferenceById(userid);
    }

    @Override
    public List<LineItem> getListItemOfCart(String userId) {
        return lineItemRepository.getLineItemsByLineItemId(userId);
    }
}
