package ru.vsu.app.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "check_up")
public class CheckUp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "date_check", nullable = false)
    private LocalDate dateCheckUp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_to_habit_id", referencedColumnName = "id")
    private UserToHabit userToHabit;

    public CheckUp() {
    }

    public CheckUp(LocalDate dateCheckUp, UserToHabit userToHabit) {
        this.dateCheckUp = dateCheckUp;
        this.userToHabit = userToHabit;
    }
}
