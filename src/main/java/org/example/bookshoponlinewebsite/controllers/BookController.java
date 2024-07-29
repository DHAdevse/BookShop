package org.example.bookshoponlinewebsite.controllers;

import org.example.bookshoponlinewebsite.models.Book;
import org.example.bookshoponlinewebsite.models.Stock;
import org.example.bookshoponlinewebsite.services.BookService;
import org.example.bookshoponlinewebsite.services.StockService;
import org.example.bookshoponlinewebsite.utils.GenerateID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller

public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private GenerateID generateID;
    @Autowired
    private StockService stockService;
    //BOOK CRUD
    @GetMapping("/admin/addBookPage")
    public String viewAddBookPage(Model model)
    {
        model.addAttribute("book", new Book());
        return "/admin/addBook";
    }
        @GetMapping("admin/removeBook/{id}")
        public String deleteBook(@PathVariable("id") String bookId)
        {
            bookService.deleteBook(bookId);
            return "redirect:/admin/table";
        }
    @PostMapping("/admin/process-add-book")
    public String addNewBook(@ModelAttribute("bookTemp") @Validated Book bookTemp,
                             @RequestParam("stockQuantity") Integer stockQuantity,
                             @RequestParam("importPrice") double importPrice,
                             RedirectAttributes redirect) {

            // Tạo mới Book
            Book newBook = new Book();
            newBook.setBookId(generateID.generateBookId());
            newBook.setBookName(bookTemp.getBookName());
            newBook.setPublishDate(bookTemp.getPublishDate());
            newBook.setDescription(bookTemp.getDescription());
            newBook.setSellPrice(bookTemp.getSellPrice() * 1.2);
            newBook.setImageBook(bookTemp.getImageBook());

            // Thiết lập các mối quan hệ
            newBook.setAuthor(new ArrayList<>(bookTemp.getAuthor()));
            newBook.setCategory(bookTemp.getCategory());
            newBook.setPublisher(bookTemp.getPublisher());

            // Lưu Book
            bookService.save(newBook);

            // Tạo mới Stock
            Stock stock = new Stock();
            stock.setStockId(newBook.getBookId());
            stock.setQuantity(stockQuantity);
            stock.setImportPrice(importPrice);
            stock = stockService.save(stock);

            // Thiết lập mối quan hệ giữa Book và Stock
            // Liên kết Book và Stock
            newBook.setStock(stock);
            bookService.update(newBook);
            // Lưu Book (sẽ cascade lưu Stock)

            redirect.addFlashAttribute("successMessage", "Book added successfully!");

        return "redirect:/admin/table";
    }

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
