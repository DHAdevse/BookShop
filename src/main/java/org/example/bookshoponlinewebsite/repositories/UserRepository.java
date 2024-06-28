package org.example.bookshoponlinewebsite.repositories;

import org.example.bookshoponlinewebsite.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    public User getUserByUserId(String id);
    public User getUserByUsername(String username);

}
