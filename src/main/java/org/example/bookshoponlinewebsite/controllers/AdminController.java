package org.example.bookshoponlinewebsite.controllers;

import org.example.bookshoponlinewebsite.models.*;
import org.example.bookshoponlinewebsite.models.dto.UserDTO;
import org.example.bookshoponlinewebsite.services.*;
import org.example.bookshoponlinewebsite.utils.GenerateID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private PublisherService publisherService;
    @Autowired
    private FavoriteService favoriteService;
    @Autowired
    private CartService cartService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private GenerateID generateID;
    @GetMapping({"/dashboard","/"})
    public String viewDashboard()
    {
        return "/admin/index";
    }
    @GetMapping("/table")
    public String viewTable(){
        return "/admin/table";
    }

    //USER CRUD
    //create user
    @GetMapping("/addNewUserPage")
    public String viewAddUserPage(Model model)
    {
        model.addAttribute("user", new UserDTO());
        return "/admin/addUser";
    }
    @PostMapping("/process-add-user")
    public String processAddUser(@ModelAttribute("user") @Validated UserDTO userDTO, BindingResult bindingResult, @RequestParam String confirmPassword,Model model)
    {
        User userExisting = userService.getUserByUsername(userDTO.getUsername());
        if(userExisting!=null)
            bindingResult.rejectValue("username", null, "Username already exist!");
        userExisting = userService.getUserByEmail(userDTO.getEmail());
        if(userExisting!=null)
            bindingResult.rejectValue("email",null,"Email already exist!");
        if (!userDTO.getPassword().equals(confirmPassword)) {
            bindingResult.rejectValue("password", null, "Passwords do not match");
        }
        if(bindingResult.hasErrors())
        {
            model.addAttribute("user",userDTO);
            return "admin/addUser";
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User user =new User();
        user.setUserId(generateID.generateUserId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());

        Favorite favorite = new Favorite();
        favorite.setUserId(user.getUserId());
        favoriteService.saveAndFlush(favorite);

        Cart cart = new Cart();
        cart.setUserId(user.getUserId());
        cartService.saveAndFlush(cart);
        Discount discount = new Discount();
        // Thêm nhiều role cho user
        if (userDTO.getRoleIdsList() != null || userDTO.getRoleIdsList().isEmpty()) {
            for (Long roleId : userDTO.getRoleIdsList()) {
                Role role = roleService.getRoleById(roleId);
                if (role != null) {
                    user.addRole(role);
                } else {
                    // Xử lý khi không tìm thấy role
                    bindingResult.rejectValue("roleIds", null, "Invalid role selected: " + roleId);
                }
            }
        } else {
            // Xử lý khi không có role nào được chọn
            bindingResult.rejectValue("roleIds", null, "At least one role must be selected");
        }
        userService.addUser(user);

        return "redirect:/admin/table";
    }
    //read user

    //update user
    @GetMapping("updateUserPage/{id}")
    public String viewUpdateUserPage(@PathVariable("id") String id,Model model){
        User user = userService.getUserById(id);
        model.addAttribute("updateUser",user);
        return "/admin/updateUser";}

    @PostMapping("/process-update-user")
    public String processUpdateUser( @ModelAttribute("editUser") User updatedUser) {
        User existingUser = userService.getUserById(updatedUser.getUserId());
        if (existingUser != null) {
            // Cập nhật thông tin của existingUser với dữ liệu từ updatedUser
            existingUser.setFirstName(updatedUser.getFirstName());
            existingUser.setLastName(updatedUser.getLastName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setAddress(updatedUser.getAddress());
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setGender(updatedUser.getGender());
            existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
            userService.updateUser(existingUser);
        }
        return "redirect:/admin/table";
    }
    //delete user
    @GetMapping("/removeUser/{id}")
    public String removeUser( @PathVariable("id") String id)
    {
        userService.deleteUser(id);
        return "redirect:/admin/table";
    }

}
