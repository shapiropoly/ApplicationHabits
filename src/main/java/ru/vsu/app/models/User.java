package ru.vsu.app.models;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;


    @ManyToMany (fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_to_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> role_ids = new ArrayList<>();

    @Column(name = "dateregistration")
    private LocalDate dateRegistration;

    @Column(name = "datelastactivity")
    private LocalDate dateLastActivity;

    public User() {
    }

    public User(String name, String username, String email,
                String password, ArrayList<Role> role_ids, LocalDate dateRegistration,
                LocalDate dateLastActivity) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role_ids = role_ids;
        this.dateRegistration = dateRegistration;
        this.dateLastActivity = dateLastActivity;
    }

    @Override
    public String toString() {
        return "User: " + id + " " + name + " " + username + " " + dateRegistration;
    }
}