package org.example.bookshoponlinewebsite.controllers;

import org.example.bookshoponlinewebsite.models.Author;
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
    public String deleteBook(@PathVariable("BookId") String bookId)
    {
        bookService.deleteBook(bookId);
        return "redirect:/admin/table";
    }
    @PostMapping("/admin/process-add-book")
    public String addNewBook(@ModelAttribute("bookTemp") @Validated Book bookTemp, @RequestParam("stockQuantity") int stockQuantity,@RequestParam("importPrice") double imprice,RedirectAttributes redirect)
    {
        Book newBook = new Book();
            newBook.setImageBook(bookTemp.getImageBook());
			newBook.setBookId(generateID.generateBookId());
			newBook.setBookName(bookTemp.getBookName());
			newBook.setPublishDate(bookTemp.getPublishDate());
			newBook.setDescription(bookTemp.getDescription());
			newBook.setSellPrice(bookTemp.getSellPrice() * 1.2);
			newBook.setImageBook(bookTemp.getImageBook());

			List<Book> bookList1 = new ArrayList<>();
			bookList1.add(newBook);
            for(Author author: bookTemp.getAuthor())
            {
                newBook.addAuthor(author);
            }
			newBook.addCategory(bookTemp.getCategory());
			newBook.addPublisher(bookTemp.getPublisher());
//			bookService.save(newBook);
//			 add book to stock
			Stock stock = new Stock();
			stock.setStockId(generateID.generateStockId());
			stock.setQuantity(stockQuantity);
			newBook.setStock(stock);
//			stockService.saveAndFlush(stock);

			stock.setBook(newBook);
			stock.setQuantity(stockQuantity);
			stock.setImportPrice(imprice);
			stockService.saveAndFlush(stock);
			bookService.saveAndFlush(newBook);
            redirect.addFlashAttribute("successMessage", "Book added successfully!");


        return "redirect:/admin/addBook";
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
