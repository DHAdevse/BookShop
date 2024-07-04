package org.example.bookshoponlinewebsite.controllers;

import org.example.bookshoponlinewebsite.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private BookRepository bookRepository;
    @GetMapping( {"/shop"})
    public String shop()
    {
        return "shop";
    }
    @GetMapping("/wishlist")
    public String wishlist()
    {
        return "wishlist";
    }
    @GetMapping("/detail")
    public String detail(){return "detail";}
    @GetMapping("checkout")
    public String checkout()
    {
        return "checkout";
    }
    @GetMapping("cart")
    public String cart(){
        return "cart";
    }
    @GetMapping("contact")
    public String contact()
    {
        return "contact";
    }

}
