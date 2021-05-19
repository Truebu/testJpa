package com.example.demo.model.entities;

import lombok.*;

import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "routine_assignament")
@Table(name = "routine_assignament")
public class RoutineAssignament {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "date_start",nullable = true,columnDefinition = "DATE")
    private Date date_start = new Date();

    @Column(name = "date_end",nullable = true,columnDefinition = "DATE")
    private Date date_end;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_routine")
    private Routine routine;

    @OneToMany(mappedBy = "routine_assignament")
    private Set<Score> scores = new HashSet<>();

    @OneToMany(mappedBy = "routine_assignament")
    private Set<Statistic> statistics = new HashSet<>();

    @OneToMany(mappedBy = "routine_assignament")
    private Set<KeepRoutine> keepRoutines = new HashSet<>();

    public RoutineAssignament(int id, User user, int idRoutine) {
        this.id = (long) id;
        this.routine = new Routine((long) idRoutine);
        this.user = user;
    }
}
