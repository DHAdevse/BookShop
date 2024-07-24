package org.example.bookshoponlinewebsite.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="role")
public class Role {
    @Id
    @Column(name="role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roleId;
    @Column(name="role_name")
    private String roleName;
    @ManyToMany(mappedBy = "roleList",fetch = FetchType.EAGER)
    private List<User> userList;
}
