package ru.vsu.app.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "users_to_habits")
public class UserToHabit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_to_habits_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "habit_id")
    private Habit habit;

    @Column(name = "frequency")
    private String frequency;

    @Column(name = "reply")
    private int reply;

    @Column(name = "date_start")
    private LocalDate dateStart;


    public UserToHabit() {
    }

    public UserToHabit(User user, Habit habit, String frequency,
                       int reply, LocalDate dateStart) {
        this.user = user;
        this.habit = habit;
        this.frequency = frequency;
        this.reply = reply;
        this.dateStart = dateStart;
    }
}
