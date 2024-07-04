package org.example.bookshoponlinewebsite.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.bookshoponlinewebsite.models.User;
import org.example.bookshoponlinewebsite.repositories.UserRepository;
import org.example.bookshoponlinewebsite.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private UserRepository userService;
    @Autowired
    private CartService cartService;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        String username = authentication.getName();
        User user = userService.getUserByUsername(username);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("authUser", user);
        }
        response.sendRedirect("/index");
    }
}
