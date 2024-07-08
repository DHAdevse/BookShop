package org.example.bookshoponlinewebsite.services;

import org.example.bookshoponlinewebsite.models.Book;

import java.util.List;

public interface BookService {
    //CRUD BOOK
    Book save(Book book);
    Book getBookById(String id);
    Book getBookByName(String name);
    Book updateBook(Book book);
    boolean deleteBook(String id);

    List<Book> getAllBookOfCategory(String categoryName);
    List<Book> getAllBookOfPublisher(String publisherName);
    List<Book> getAllBookOfAuthor(String authorName);
    List<Book> getAllBook();
}
