package ru.vsu.app.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "habits_to_collections")
public class HabitToCollection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "habit_id")
    private Habit habit;

    @ManyToOne
    @JoinColumn(name = "collection_id")
    private Collection collection;

    public HabitToCollection() {
    }

    public HabitToCollection(Habit habit, Collection collection) {
        this.habit = habit;
        this.collection = collection;
    }
}
