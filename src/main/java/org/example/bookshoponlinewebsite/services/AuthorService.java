package org.example.bookshoponlinewebsite.services;

import org.example.bookshoponlinewebsite.models.Author;

import java.util.List;

public interface AuthorService {
    //CRUD AUTHOR
    //Add author
    Author addAuthor(Author author);
    public Author saveAndFlush(Author author);
    //Find author by name
    public Author getAuthorByName(String name);
    public List<Author> getAllAuthor();
    // Update Author;
    public Author updateAuthor(Author author);
    // Delete author by ID
    boolean removeAuthor(String id);
    Author getAuthorById(String name);
}
