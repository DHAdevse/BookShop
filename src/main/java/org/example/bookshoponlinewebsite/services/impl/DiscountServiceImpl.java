package org.example.bookshoponlinewebsite.services.impl;

import org.example.bookshoponlinewebsite.models.Discount;
import org.example.bookshoponlinewebsite.repositories.DiscountRepository;
import org.example.bookshoponlinewebsite.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService {
    @Autowired
    private DiscountRepository dis;
    @Override
    public Discount addDiscount(Discount discount) {
        return dis.save(discount);
    }

    @Override
    public Discount getDiscountbyId(String id) {
        return dis.getReferenceById(id);
    }

    @Override
    public Discount updateDiscount(Discount discount) {
        return dis.save(discount);
    }

    @Override
    public boolean deleteDiscount(String id) {
        if(dis.existsById(id))
        {
            dis.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Discount> getAllDiscount() {
        return dis.findAll();
    }
}
