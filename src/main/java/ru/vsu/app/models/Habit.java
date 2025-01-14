package ru.vsu.app.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "habits")
public class Habit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @JsonBackReference
    private Category category;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "habits_to_collections",
            joinColumns = @JoinColumn(name = "habit_id"),
            inverseJoinColumns = @JoinColumn(name = "collection_id")
    )
    private List<Collection> collections_id = new ArrayList<>();


    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinTable(
            name = "users_to_habits",
            joinColumns = @JoinColumn(name = "habit_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users_id = new ArrayList<>();


    public Habit() {
    }

    public Habit(String title, String description, Category category, String image) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Habit: " + id + " " + title;
    }
}
