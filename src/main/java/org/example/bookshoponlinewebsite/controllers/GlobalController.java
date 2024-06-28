package org.example.bookshoponlinewebsite.controllers;

import org.example.bookshoponlinewebsite.models.Author;
import org.example.bookshoponlinewebsite.models.Book;
import org.example.bookshoponlinewebsite.models.Category;
import org.example.bookshoponlinewebsite.models.Publisher;
import org.example.bookshoponlinewebsite.services.AuthorService;
import org.example.bookshoponlinewebsite.services.BookService;
import org.example.bookshoponlinewebsite.services.CategoryService;
import org.example.bookshoponlinewebsite.services.PublisherService;
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
}
