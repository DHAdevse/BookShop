package org.example.bookshoponlinewebsite.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.example.bookshoponlinewebsite.models.Cart;
import org.example.bookshoponlinewebsite.models.Discount;
import org.example.bookshoponlinewebsite.models.Favorite;
import org.example.bookshoponlinewebsite.models.User;
import org.example.bookshoponlinewebsite.models.dto.UserDTO;
import org.example.bookshoponlinewebsite.services.CartService;
import org.example.bookshoponlinewebsite.services.FavoriteService;
import org.example.bookshoponlinewebsite.services.UserService;
import org.example.bookshoponlinewebsite.utils.GenerateID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class Login_Logout_SignupController {
    @Autowired
    private UserService userService;
    @Autowired
    private FavoriteService favoriteService;
    @Autowired
    private CartService cartService;
    @Autowired
    private GenerateID generateID;
    @GetMapping("/register")
    public String showRegisterPage(Model model, UserDTO userDto) {
        model.addAttribute("user", userDto);
        return "register";
    }

    @PostMapping("/register")
    public String registerSave(@ModelAttribute("user") @Valid UserDTO userDto,
                               BindingResult result,
                               @RequestParam("confirmPassword") String confirmPassword,
                               Model model) {
        User existingUser = userService.getUserByUsername(userDto.getUsername());
        User existUser = userService.getUserByEmail(userDto.getEmail());
        if (existingUser != null) {
            result.rejectValue("username", null, "Username already exists");
        }
        if (existUser != null) {
            result.rejectValue("email", null, "Email already exists");
        }
        if (!userDto.getPassword().equals(confirmPassword)) {
            result.rejectValue("password", null, "Passwords do not match");
        }

        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "register";
        }
        BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();

        User user =new User();
        user.setUserId(generateID.generateUserId());
        user.setUsername(userDto.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());

        Favorite favorite = new Favorite();
        favorite.setUserId(user.getUserId());
        favoriteService.saveAndFlush(favorite);

        Cart cart = new Cart();
        cart.setUserId(user.getUserId());
        cartService.saveAndFlush(cart);
        Discount discount = new Discount();

        userService.addUser(user);

        return "redirect:/login";
    }
    @GetMapping("login")
    public String login(Model model, UserDTO userDTO){
        model.addAttribute("user",userDTO);
        return "login";
    }
    @PostMapping("login")
    public String loginSession(Model model, HttpSession session,UserDTO userDTO)
    {
        User authUser = userService.authenticateAccount(userDTO.getUsername(),userDTO.getPassword());
        if(authUser!=null)
        {
            session.setAttribute("authUser",authUser);
            return "redirect:/index";
        }
            return "redirect:/login?error";
    }
    @PostMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/?logout";  // Chuyển hướng về trang chủ với thông báo đăng xuất
    }
}
