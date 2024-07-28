package org.example.bookshoponlinewebsite.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="publisher")
public class Publisher {
    @Id
    @Column(name="publisher_id")
    private String publisherId;
    @Column(name="publisher_name")
    private String publisherName;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Book> bookList = new ArrayList<>();
}
