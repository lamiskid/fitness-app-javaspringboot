package com.fitness.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
//import static javax.persistence.FetchType.LAZY;
//import static javax.persistence.GenerationType.IDENTITY;


@Getter
@Setter
@ToString
@Entity
@Table(name = "users",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
        }
)
public class User {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = IDENTITY)
    private Long Id;

    @Column(
            length = 20,
            nullable = false
    )
    private String username;

    @Column(
            length = 50,
            nullable = false
    )
    private String email;

    @Column(
            length = 120,
            nullable = false
    )
    private String password;

    @ManyToMany(fetch = LAZY)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(
                    name = "user_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id"
            )
    )
    private Set<Role> roles;

    public User(){
    }

    public User(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
