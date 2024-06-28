package org.example.bookshoponlinewebsite.repositories;

import org.example.bookshoponlinewebsite.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,String> {
    public Book getBookByBookName(String name);
    public List<Book> getAllByCategory_CategoryName(String name);
    public List<Book> findAllByPublisher_PublisherName(String name);


//    public List<Book> findAllByAuthor_Empty
}
