package org.example.bookshoponlinewebsite.controllers;

import org.example.bookshoponlinewebsite.models.Author;
import org.example.bookshoponlinewebsite.services.AuthorService;
import org.example.bookshoponlinewebsite.utils.GenerateID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private GenerateID generateID;
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
    @PostMapping("admin/addAuthor")
    public String addAuthor( @ModelAttribute("authorCreate") Author author)
    {

        Author authordata = new Author();
        authordata.setAuthorId(generateID.generateAuthorId());
        authordata.setAuthorName(author.getAuthorName());
        authordata.setDob(author.getDob());
        authorService.saveAndFlush(authordata);
        return "redirect:/admin/table";
    }
    @PostMapping("/admin/updateAuthor")
    public String updateAuthor(@RequestParam("authorId") String id,
                               @RequestParam("newAuthorName") String newName,
                               @RequestParam("dob") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date newDob) {
        Author author = authorService.getAuthorById(id);
        author.setAuthorName(newName);
        author.setDob(newDob);
        authorService.saveAndFlush(author);
        return "redirect:/admin/table";
    }
    @GetMapping("admin/removeAuthor/{id}")
    public String deleteAuthor(@PathVariable String id)
    {
        authorService.removeAuthor(id);
        return "redirect:/admin/table";
}
}
