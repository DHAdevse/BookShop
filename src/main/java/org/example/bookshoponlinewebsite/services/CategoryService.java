package org.example.bookshoponlinewebsite.services;

import org.example.bookshoponlinewebsite.models.Category;
import org.example.bookshoponlinewebsite.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CategoryService {
    //CRUD CATEGORY
    Category addCategory(Category category);
    Category getCategoryByName(String name);
    Category getCategoryById(String id);
    Category updateCategory(Category category);
    boolean deleteCategory(String id);
    List<Category> getCategoryList();
}
