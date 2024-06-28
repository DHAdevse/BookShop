package org.example.bookshoponlinewebsite.services.impl;

import org.example.bookshoponlinewebsite.models.User;
import org.example.bookshoponlinewebsite.repositories.UserRepository;
import org.example.bookshoponlinewebsite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }
    @Override
    public User getUserByuserName(String name) {
        return userRepository.getUserByUsername(name);
    }

    @Override
    public User getUserById(String id) {
        return userRepository.getUserByUserId(id);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }
    @Override
    public boolean deleteUser(String id)
    {
        User user = userRepository.getUserByUserId(id);
        if(user!=null)
        {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
