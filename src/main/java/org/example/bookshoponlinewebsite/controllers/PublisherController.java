package org.example.bookshoponlinewebsite.controllers;

import org.example.bookshoponlinewebsite.models.Author;
import org.example.bookshoponlinewebsite.models.Publisher;
import org.example.bookshoponlinewebsite.repositories.PublisherRepository;
import org.example.bookshoponlinewebsite.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/publisher")
public class PublisherController {
    @Autowired
    private PublisherService publisherService;
    @GetMapping("all")
    public String getAllPublishers(Model model)
    {
        try {
            List<Publisher> publisherList = publisherService.getListPublisher();
            model.addAttribute("publishers",publisherList);
            return "index";
        }catch(Exception e)
        {
            return "index";
        }
    }
}
