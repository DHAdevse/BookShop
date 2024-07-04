package org.example.bookshoponlinewebsite.services;

import org.example.bookshoponlinewebsite.models.dto.UserDTO;
import org.example.bookshoponlinewebsite.models.User;

import java.util.List;

public interface UserService {
    //CRUD USER
    public User addUser(User user);
    public User getUserById(String id);
    public User updateUser(User user);
    public boolean deleteUser(String id);
    public List<User> getAllUser();
    public User save (UserDTO userDTO );
    public User getUserByUsername(String username);
    public User getUserByEmail(String email);
    public User authenticateAccount(String username, String password);
}
