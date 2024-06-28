package org.example.bookshoponlinewebsite.repositories;

import org.example.bookshoponlinewebsite.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,String> {
    public Category getCategoriesByCategoryName(String name);
    public Category getCategoriesByCategoryId(String id);
}
