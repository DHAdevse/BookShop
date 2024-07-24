package org.example.bookshoponlinewebsite.repositories;

import org.example.bookshoponlinewebsite.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    public Role findByRoleName(String roleName);
//    public List<Role> findAllByRoleId(List<Long>id);
    public Role findRoleByRoleId(Long id);
}
