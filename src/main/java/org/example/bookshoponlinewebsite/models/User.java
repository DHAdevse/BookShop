package org.example.bookshoponlinewebsite.models;


import jakarta.persistence.*;
import lombok.*;


import java.util.Date;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
@Table(name="users")
public class User {
    @Id
    @Column(name="user_id")
    private String userId;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name = "", unique = true)
    private String email;
    private String address;
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Column(unique = true)
    private String username;
    private String password;
    private String gender;
    private String phoneNumber;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Discount> discountList;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Favorite favorite;
    @OneToMany(fetch = FetchType.LAZY, cascade ={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
    private List<Invoice> invoiceList;
    @OneToOne(fetch = FetchType.LAZY)
    private Role role;

}
