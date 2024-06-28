package org.example.bookshoponlinewebsite.services;

import org.example.bookshoponlinewebsite.models.Author;
import org.example.bookshoponlinewebsite.models.Book;

import java.util.List;

public interface AuthorService {
    //CRUD AUTHOR
    //Add author
    Author addAuthor(Author author);
    //Find author by name
    Author getAuthorByName(String name);
    List<Author> getAllAuthor();
    // Update Author;
    Author updateAuthor(Author author);
    // Delete author by ID
    boolean removeAuthor(String id);
    Author getAuthorById(String name);
}
