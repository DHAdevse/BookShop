package org.example.bookshoponlinewebsite.repositories;

import org.example.bookshoponlinewebsite.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher,String> {
    public Publisher getPublisherByPublisherName(String name);
}
