package org.example.bookshoponlinewebsite.services.impl;

import org.example.bookshoponlinewebsite.models.Role;
import org.example.bookshoponlinewebsite.repositories.RoleRepository;
import org.example.bookshoponlinewebsite.repositories.UserRepository;
import org.example.bookshoponlinewebsite.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }
    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findRoleByRoleId(id);
    }

    @Override
    public Role findRoleByName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

//    @Override
//    public List<Role> getRoleIds(List<Long> idList) {
//        roleRepository.findAllByRoleId(idList);
//        return null;
//    }
}
