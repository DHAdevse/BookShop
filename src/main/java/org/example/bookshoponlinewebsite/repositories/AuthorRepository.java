package org.example.bookshoponlinewebsite.repositories;

import org.example.bookshoponlinewebsite.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,String> {
    public Author getAuthorByAuthorName(String name);
    public Author getAuthorByAuthorId(String id);
}
