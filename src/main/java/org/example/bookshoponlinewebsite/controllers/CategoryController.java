package org.example.bookshoponlinewebsite.controllers;

import org.example.bookshoponlinewebsite.models.Category;
import org.example.bookshoponlinewebsite.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;


import javax.swing.text.html.parser.Entity;
import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


}
