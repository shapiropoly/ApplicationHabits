package ru.vsu.app.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users_to_habits")
public class UserToHabit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "habit_id")
    private Habit habit;

    @Column(name = "frequency")
    private String frequency;

    @Column(name = "replay")
    private int replay;

    @Column(name = "date_start")
    private LocalDate dateStart;

    @OneToMany(mappedBy = "userToHabit", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CheckUp> checkUps;


    public UserToHabit() {
    }

    public UserToHabit(User user, Habit habit, String frequency,
                       int replay, LocalDate dateStart) {
        this.user = user;
        this.habit = habit;
        this.frequency = frequency;
        this.replay = replay;
        this.dateStart = dateStart;
    }
}
