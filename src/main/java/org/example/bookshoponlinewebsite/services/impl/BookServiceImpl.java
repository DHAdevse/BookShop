package org.example.bookshoponlinewebsite.services.impl;

import org.example.bookshoponlinewebsite.models.Book;
import org.example.bookshoponlinewebsite.repositories.BookRepository;
import org.example.bookshoponlinewebsite.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
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

    @Override
    public boolean deleteBook(String id) {
        if(bookRepository.existsById(id)){
            bookRepository.deleteById(id);
            return true;
        }
        return false;
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

}
