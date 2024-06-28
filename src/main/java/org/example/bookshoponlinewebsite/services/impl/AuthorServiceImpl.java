package org.example.bookshoponlinewebsite.services.impl;

import org.example.bookshoponlinewebsite.models.*;
import org.example.bookshoponlinewebsite.repositories.AuthorRepository;
import org.example.bookshoponlinewebsite.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    //Create author
    public Author addAuthor (Author author){

        return authorRepository.save(author);
    }
    @Override
    public Author getAuthorByName(String author_name) {

        return authorRepository.getAuthorByAuthorName(author_name);
    }

    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }

    @Override
    public Author updateAuthor(Author author)
    {
        return authorRepository.save(author);

    }
    @Override
    public boolean removeAuthor(String id) {
        if(authorRepository.existsById(id))
        {
            authorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Author getAuthorById(String id) {
        return authorRepository.getAuthorByAuthorId(id);
    }
}
