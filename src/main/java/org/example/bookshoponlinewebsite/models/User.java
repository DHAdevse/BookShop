package org.example.bookshoponlinewebsite.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

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
    @Column(name = "email", unique = true)
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
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roleList=new ArrayList<>();

    public String getRoleByName(String roleName)
    {

        for (Role role:roleList)
        {
            if(Objects.equals(role.getRoleName(), roleName)){
                return roleName;
            }
        }
        return null;
    }
    public void addRole(Role role) {
        this.roleList.add(role);
        role.getUserList().add(this);
    }

    public void removeRole(Role role) {
        this.roleList.remove(role);
        role.getUserList().remove(this);
    }
    public User(String username, String password, String firstName,String lastName,String email){
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
