package org.example.bookshoponlinewebsite.models;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="favorite")
public class Favorite {
    @Id
    @Column(name = "user_id")
    private String userId;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="favorite_book",
            joinColumns = @JoinColumn(name= "user_id"),
            inverseJoinColumns = @JoinColumn(name="book_id"))
    private List<Book> bookList;
    @OneToOne
    private User user;
    @Transactional
    public void addBook(Book book)
    {
        if(bookList==null)
        {
            bookList = new ArrayList<>();
        }
        bookList.add(book);
    }
    @Transactional
    public void removeBook(Book book) {
        if (bookList != null) {
            bookList.remove(book);
        }
    }
}
