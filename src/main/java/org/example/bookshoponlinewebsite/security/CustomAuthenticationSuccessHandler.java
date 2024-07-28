package org.example.bookshoponlinewebsite.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.bookshoponlinewebsite.models.*;
import org.example.bookshoponlinewebsite.repositories.UserRepository;
import org.example.bookshoponlinewebsite.services.CartService;
import org.example.bookshoponlinewebsite.services.FavoriteService;
import org.example.bookshoponlinewebsite.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartService cartService;
    @Autowired
    private FavoriteService favoriteService;
    @Autowired
    private InvoiceService invoiceService;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        String username = authentication.getName();
        User user = userRepository.getUserByUsername(username);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("authUser", user);
            Cart cart = cartService.getCartByUserId(user.getUserId());
            session.setAttribute("cart",cart);
            Favorite favorite = favoriteService.getFavoriteByUserId(user.getUserId());
            session.setAttribute("favorite", favorite);
            Invoice invoice = new Invoice();
            session.setAttribute("currentInvoice",invoice);
            List<Role> roles = user.getRoleList();
            for(Role role: roles)
            {
                if(Objects.equals(role.getRoleName(), "ADMIN"))
                    response.sendRedirect("/admin/dashboard");
            }
//            response.sendRedirect("/");
        }
        else{
            response.sendRedirect("/index");  // Chuyển hướng mặc định cho các role khác
        }

//        response.sendRedirect("/index");
    }
}
