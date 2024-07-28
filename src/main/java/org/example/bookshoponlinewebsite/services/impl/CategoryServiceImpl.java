package org.example.bookshoponlinewebsite.services.impl;

import org.example.bookshoponlinewebsite.models.Category;
import org.example.bookshoponlinewebsite.repositories.CategoryRepository;
import org.example.bookshoponlinewebsite.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category saveandFlush(Category category) {
        return categoryRepository.saveAndFlush(category);
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository.getCategoriesByCategoryName(name);
    }
    @Override
    public Category getCategoryById(String id){
        return categoryRepository.getReferenceById(id);
    }
    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public boolean deleteCategory(String id) {
        Category category = categoryRepository.getCategoriesByCategoryId(id);
        if(category!=null)
        {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public List<Category> getCategoryList(){
        return categoryRepository.findAll();
    }
}
