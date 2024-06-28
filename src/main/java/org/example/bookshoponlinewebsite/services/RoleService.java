package org.example.bookshoponlinewebsite.services;

import org.example.bookshoponlinewebsite.models.Role;

public interface RoleService {
    Role addRole(Role role);
    Role getRoleById(String id);
}
