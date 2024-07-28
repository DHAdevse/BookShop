package org.example.bookshoponlinewebsite.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
@Table(name= "category")
public class Category {
    @Id
    @Column(name="category_id")
    private String categoryId;
    @Column(name="category_name")
    private String categoryName;
    @OneToMany(fetch = FetchType.LAZY, mappedBy ="category",cascade ={
            CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH
    } )
    private List<Book> bookList = new ArrayList<>();
}
