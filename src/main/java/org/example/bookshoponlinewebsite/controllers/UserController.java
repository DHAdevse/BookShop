package org.example.bookshoponlinewebsite.controllers;

import org.example.bookshoponlinewebsite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserController {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UserService userService;

    @GetMapping({"/index", "/"})
    public String index(Model model, Principal principal) {
        if (principal != null && !"anonymousUser".equals(principal.getName())) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
            model.addAttribute("userdetail", userDetails);
        }
        return "index";
    }


}
