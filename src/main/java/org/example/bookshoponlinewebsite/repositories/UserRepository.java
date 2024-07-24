package org.example.bookshoponlinewebsite.repositories;

import org.example.bookshoponlinewebsite.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    public User getUserByUserId(String userId);
    public User getUserByUsername(String username);
    public User getUserByEmail(String email);
    public User getUserByUsernameAndPassword(String username, String password);

}
