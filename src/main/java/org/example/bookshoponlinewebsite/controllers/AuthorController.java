package org.example.bookshoponlinewebsite.controllers;

import org.example.bookshoponlinewebsite.enums.ErrorResponse;
import org.example.bookshoponlinewebsite.models.Author;
import org.example.bookshoponlinewebsite.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;

@Controller
public class AuthorController {
    @Autowired
    private AuthorService authorService;
//    @GetMapping("all")
//    public String getAllAuthor(Model model)
//    {
//        try {
//            List<Author> authorList = authorService.getAllAuthor();
//            model.addAttribute("authors",authorList);
//            return "index";
//        }catch(Exception e)
//        {
//            return "index";
//        }
//    }
    @GetMapping("search/{name}")
    public String getAuthorByName(@PathVariable("name") String name)
    {
        try {
            Author author = authorService.getAuthorByName(name);
            return "index";
        }catch(Exception e)
        {
            return "index";
        }
    }
    @PostMapping("add")
    public ResponseEntity<?> addAuthor(@RequestBody Author author)
    {
        try {
            Author authordata = authorService.addAuthor(author);
            return new ResponseEntity<Author>(authordata,HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(ErrorResponse.INPUT_ERROR,HttpStatus.NOT_ACCEPTABLE);
        }
    }
    @PutMapping("update/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable("id") String id, @RequestBody Author author)
    {
        try {
            Author authordata = authorService.updateAuthor(author);
            return new ResponseEntity<Author>(authordata,HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(ErrorResponse.INPUT_ERROR,HttpStatus.NOT_ACCEPTABLE);
        }
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteAuthor(String id)
    {
        try{
            Author author = authorService.getAuthorById(id);
            authorService.removeAuthor(id);
            return new ResponseEntity<>("DELETED",HttpStatus.OK);
        }catch(Exception e)
        {
            return new ResponseEntity<>(ErrorResponse.AUTHOR_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }
}
