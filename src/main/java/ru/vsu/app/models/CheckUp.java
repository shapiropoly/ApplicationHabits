package ru.vsu.app.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "check_up")
public class CheckUp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "check_up_id")
    private int id;

    @Column(name = "date_check_up")
    private Date dateCheckUp;

    @ManyToOne
    @JoinColumn(name = "user_to_habit_id")
    private UserToHabit userToHabitId;
}
