package org.example.bookshoponlinewebsite.controllers;

import org.example.bookshoponlinewebsite.models.Category;
import org.example.bookshoponlinewebsite.services.CategoryService;
import org.example.bookshoponlinewebsite.utils.GenerateID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private GenerateID generateID;

    //CRUD Category
    @PostMapping("admin/addCategory")
    public String addCategory(@ModelAttribute Category category)
    {
        Category categoryCreate = new Category();
        categoryCreate.setCategoryId(generateID.generateCategoryId());
        categoryCreate.setCategoryName(category.getCategoryName());
        categoryService.saveandFlush(categoryCreate);
        return "redirect:/admin/table";
    }
    @PostMapping("admin/updateCategory")
    public String updateCategory(@RequestParam("categoryId") String categoryId, @RequestParam("newCategoryName") String newCategoryName){
        Category category= categoryService.getCategoryById(categoryId);
        category.setCategoryName(newCategoryName);
        return "admin/table";
    }
    @GetMapping("admin/removeCategory/{id}")
    public String removeCategory(@PathVariable("id") String categoryId){
        categoryService.deleteCategory(categoryId);
        return "redirect:/admin/table";
     }


}
