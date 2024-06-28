package org.example.bookshoponlinewebsite.controllers;

import org.example.bookshoponlinewebsite.models.Category;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HomeController {
    @GetMapping( {"/index","/"})
    public String index()
    {
        return "index";
    }
    @GetMapping("shop")
    public String shop()
    {
        return "shop";
    }
    @GetMapping("detail")
    public String detail()
    {
        return "detail";
    }
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
    @GetMapping("login")
    public String login(){return "login";}
    @GetMapping("register")
    public String register(){return "register";}
}
