package org.example.bookshoponlinewebsite.services.impl;

import org.example.bookshoponlinewebsite.models.User;
import org.example.bookshoponlinewebsite.models.dto.CustomUserDetails;
import org.example.bookshoponlinewebsite.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);
        if(user==null)
            throw new UsernameNotFoundException("Username or Password not found");
        return new CustomUserDetails(user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(),user.getEmail(),authorities());
    }
    public Collection<? extends GrantedAuthority> authorities() {
        return Arrays.asList(new SimpleGrantedAuthority("USER"));
    }
}
