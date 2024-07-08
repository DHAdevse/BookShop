package org.example.bookshoponlinewebsite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
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
    @GetMapping("contact")
    public String contact()
    {
        return "contact";
    }

}
