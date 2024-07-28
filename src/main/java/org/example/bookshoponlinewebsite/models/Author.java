package org.example.bookshoponlinewebsite.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name="author")
public class Author {
    @Id
    @Column(name="author_id")
    private String authorId;
    @Getter
    @Column(name="author_name")
    private String authorName;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    @ManyToMany(mappedBy ="author",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Book> bookList = new ArrayList<>();

}
