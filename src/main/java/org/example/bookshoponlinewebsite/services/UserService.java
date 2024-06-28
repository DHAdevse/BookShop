package org.example.bookshoponlinewebsite.services;

import org.example.bookshoponlinewebsite.models.User;

import java.util.List;

public interface UserService {
    //CRUD USER
    User addUser(User user);
    User getUserByuserName(String username);
    User getUserById(String id);
    User updateUser(User user);
    boolean deleteUser(String id);
    List<User> getAllUser();

}
