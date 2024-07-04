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
//    @GetMapping("")
//    public String GetAllBook(Model model){
//        List<Book> bookList = bookService.getAllBook();
//        model.addAttribute("books", bookList);
//        return "index";
//    }
//    @GetMapping("/book/{id}")
//    public String bookDetails(@PathVariable("id") String id, Model model) {
//        Book currentBook = bookService.getBookById(id);
//        List<Book> bookList = bookService.getAllBook();
//        int currentIndex = bookList.indexOf(currentBook);
//
//        String prevId = currentIndex > 0 ? bookList.get(currentIndex - 1).getBookId() : bookList.getLast().getBookId();
//        String nextId = currentIndex < bookList.size() - 1 ? bookList.get(currentIndex + 1).getBookId() : bookList.getFirst().getBookId();
//
//        model.addAttribute("book", currentBook);
//        model.addAttribute("prevId", prevId);
//        model.addAttribute("nextId", nextId);
//        return "detail";
//    }
}
