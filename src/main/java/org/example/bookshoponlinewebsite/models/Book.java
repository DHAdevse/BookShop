package org.example.bookshoponlinewebsite.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="book")
public class Book {
    @Id
    @Column(name="book_id")
    private String bookId;
    @Column(name="book_name")
    private String bookName;
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name="book_author",
            joinColumns = @JoinColumn(referencedColumnName = "book_id"),
            inverseJoinColumns = @JoinColumn(referencedColumnName = "author_id"))
    private List<Author> author;

    @JoinColumn(name="publisher_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Publisher publisher;
    @Column(name="sell_price")
    private double sellPrice;
    @Column(name = "description")
    private String description;
    @Column(name="date_publish")
    @Temporal(TemporalType.DATE)
    private Date publishDate;
    @JoinColumn(name="category_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
    @OneToOne
    private Stock stock;
    @Column(name="image_book")
    private String imageBook;
//    @Transient
//    @Lob


}
