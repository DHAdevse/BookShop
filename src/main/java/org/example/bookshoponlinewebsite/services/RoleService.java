package org.example.bookshoponlinewebsite.services;

import org.example.bookshoponlinewebsite.models.Role;

public interface RoleService {
    public Role addRole(Role role);
    public Role getRoleById(Long id);
    public Role findRoleByName(String roleName);
//    public List<Role> getRoleIds(List<Long> id) ;
}
