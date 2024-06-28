package org.example.bookshoponlinewebsite.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenerateID {
    private EntityManager entityManager;

    @Autowired
    public GenerateID(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public String generateId(String query, String prefix) {
        String lastId;
        try {
            TypedQuery<String> query1 = entityManager.createQuery(query, String.class);
            query1.setMaxResults(1);
            lastId = query1.getSingleResult();
        } catch (NoResultException e) {
            return prefix + "0000";
        }
        int number = Integer.parseInt(lastId.substring(4));
        number++;
        return String.format("%s%04d", prefix, number);
    }

    public String generateAuthorId() {
        String query = "SELECT a.authorId FROM Author a ORDER BY a.authorId DESC";
        return generateId(query, "AUTH");
    }

    public String generateBookId() {
        String query = "SELECT b.bookId FROM Book b ORDER BY b.bookId DESC";
        return generateId(query, "BOOK");
    }

    public String generateCategoryId() {
        String query = "SELECT c.categoryId FROM Category c ORDER BY c.categoryId DESC";
        return generateId(query, "CATE");
    }

    public String generatePublisherId() {
        String query = "SELECT p.publisherId FROM Publisher p ORDER BY p.publisherId DESC";
        return generateId(query, "PUBL");
    }

    public String generateUserId()
    {
        String query = "SELECT u.userId FROM User u ORDER BY u.userId DESC";
        return generateId(query, "USER");
    }

    public String generateStockId()
    {
        String query = "SELECT s.stockId FROM Stock s ORDER BY s.stockId DESC";
        return generateId(query, "STOC");
    }

    public String generateLineItemId()
    {
        String query = "SELECT l.lineItemId FROM LineItem l ORDER BY l.lineItemId DESC";
        return generateId(query, "LINE");
    }

    public String generateBillId()
    {
        String query = "SELECT i.invoiceId FROM Invoice i ORDER BY i.invoiceId DESC";
        return generateId(query, "BILL");
    }
}
