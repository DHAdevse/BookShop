package org.example.bookshoponlinewebsite.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="favorite_book",
            joinColumns = @JoinColumn(name= "user_id"),
            inverseJoinColumns = @JoinColumn(name="book_id"))
    private List<Book> bookList;
    @OneToOne
    private User user;
}
