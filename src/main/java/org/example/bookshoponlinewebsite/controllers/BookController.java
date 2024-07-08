package org.example.bookshoponlinewebsite.controllers;

import org.example.bookshoponlinewebsite.models.Book;
import org.example.bookshoponlinewebsite.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller

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
    @GetMapping({"/book/{bookId}"})
    public String bookdetail(@PathVariable String bookId, Model model){
        Book book = bookService.getBookById(bookId);
        if(book != null)
        {
            model.addAttribute("book",book);
            return "bookdetail";
        }
       return "/";
    }
}
