package org.example.bookshoponlinewebsite.repositories;

import org.example.bookshoponlinewebsite.models.LineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LineItemRepository extends JpaRepository<LineItem,String> {
    public List<LineItem> getLineItemsByLineItemId(String userId);
}
