package org.example.bookshoponlinewebsite.controllers;

import org.example.bookshoponlinewebsite.models.*;
import org.example.bookshoponlinewebsite.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@ControllerAdvice
public class GlobalController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private PublisherService publisherService;
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;
    @ModelAttribute("categories")
    public List<Category> getCategories() {

        return categoryService.getCategoryList();
    }
    @ModelAttribute("authors")
    public List<Author> getAuthors()
    {
        return authorService.getAllAuthor();
    }
    @ModelAttribute("publishers")
    public List<Publisher> getPublishers()
    {
        return publisherService.getListPublisher();
    }
    @ModelAttribute("books")
    public List<Book> getBooks()
    {
        return bookService.getAllBook();
    }
    @ModelAttribute("users")
    public List<User> getUsers(){
        return userService.getAllUser();
    }
}
