package org.example.bookshoponlinewebsite.services.impl;

import org.example.bookshoponlinewebsite.models.Role;
import org.example.bookshoponlinewebsite.repositories.RoleRepository;
import org.example.bookshoponlinewebsite.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }
    @Override
    public Role getRoleById(String id) {
        return roleRepository.getReferenceById(id);
    }
}
