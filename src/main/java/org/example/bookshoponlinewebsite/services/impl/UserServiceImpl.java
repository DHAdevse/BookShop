package org.example.bookshoponlinewebsite.services.impl;

import org.example.bookshoponlinewebsite.models.User;
import org.example.bookshoponlinewebsite.models.dto.UserDTO;
import org.example.bookshoponlinewebsite.repositories.UserRepository;
import org.example.bookshoponlinewebsite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }
    @Override
    public User getUserByUsername(String name) {
        return userRepository.getUserByUsername(name);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public User authenticateAccount(String username, String password) {
        return userRepository.getUserByUsernameAndPassword(username,password);
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

    @Override
    public User save(UserDTO userDTO) {
        User user = new User(userDTO.getUsername(), passwordEncoder.encode(userDTO.getPassword()),userDTO.getFirstName(),userDTO.getLastName(),userDTO.getEmail());
        return userRepository.save(user);
    }
}
