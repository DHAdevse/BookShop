package org.example.bookshoponlinewebsite.services.impl;

import org.example.bookshoponlinewebsite.models.Book;
import org.example.bookshoponlinewebsite.models.Stock;
import org.example.bookshoponlinewebsite.repositories.BookRepository;
import org.example.bookshoponlinewebsite.repositories.StockRepository;
import org.example.bookshoponlinewebsite.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private StockRepository stockRepository;
    @Override
    @Transactional
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book saveAndFlush(Book book) {
        return bookRepository.saveAndFlush(book);
    }

    @Override
    public Book getBookById(String id) {
        return bookRepository.getReferenceById(id);
    }

    @Override
    public Book getBookByName(String name) {
        Book book = bookRepository.getBookByBookName(name);
        return book;
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    public boolean deleteBook(String bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        // Remove the book from all authors
        book.getAuthor().forEach(author -> author.getBookList().remove(book));

        // Remove the stock
        if (book.getStock() != null) {
            Stock stock = book.getStock();
            book.setStock(null);
            stockRepository.delete(stock);
        }

        // Remove the book from the category
        if (book.getCategory() != null) {
            book.getCategory().getBookList().remove(book);
            book.setCategory(null);
        }

        // Remove the book from the publisher
        if (book.getPublisher() != null) {
            book.getPublisher().getBookList().remove(book);
            book.setPublisher(null);
        }

        // Finally, delete the book
        bookRepository.delete(book);
        return true;
    }

    @Override
    public List<Book> getAllBookOfCategory(String categoryName) {
        return bookRepository.getAllByCategory_CategoryName(categoryName);
    }

    @Override
    public List<Book> getAllBookOfPublisher(String publisherName)
    {
        return  bookRepository.findAllByPublisher_PublisherName(publisherName);
    }

    @Override
    public List<Book> getAllBookOfAuthor(String authorName) {
        return null;
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public void update(Book newBook) {
         bookRepository.save(newBook);
    }

}
