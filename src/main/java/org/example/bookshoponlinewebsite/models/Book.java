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
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> author = new ArrayList<>();

    @JoinColumn(name="publisher_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Publisher publisher;
    @Column(name="sell_price")
    private double sellPrice;
    @Column(name = "description")
    private String description;
    @Column(name="date_publish")
//    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date publishDate;
    @JoinColumn(name="category_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;
    @OneToOne(cascade = CascadeType.MERGE)
    private Stock stock;
    @Column(name="image_book")
    private String imageBook;

    public void addAuthor(Author authorBook)
    {
        this.author.add(authorBook);
        authorBook.getBookList().add(this);
    }
    public void addCategory(Category cate){
        this.category = cate;
        cate.getBookList().add(this);
    }
    public void addPublisher(Publisher publ){
        this.publisher = publ;
        publ.getBookList().add(this);
    }
}
