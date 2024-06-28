package org.example.bookshoponlinewebsite.controllers;

import org.example.bookshoponlinewebsite.models.Book;
import org.example.bookshoponlinewebsite.repositories.BookRepository;
import org.example.bookshoponlinewebsite.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("category")
    public String GetAllBookOfCategory(@PathVariable("categoryName") String categoryName, Model model)
    {
        List<Book> listBookOfCategory = bookService.getAllBookOfCategory(categoryName);
        model.addAttribute("booksOfCategory", listBookOfCategory);
        return "index";
    }
//    @GetMapping("")
//    public String GetAllBook(Model model){
//        List<Book> bookList = bookService.getAllBook();
//        model.addAttribute("books", bookList);
//        return "index";
//    }
    @GetMapping("/{id}")
    public String bookDetails(@PathVariable("id") String id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "detail";
    }
}
