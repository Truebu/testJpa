package com.example.demo.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "statistic")
@Table(name = "statistic")
public class Statistic {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "time",nullable = false,columnDefinition = "TEXT", unique = true)
    private String time;

    @ManyToOne
    @JoinColumn(name = "id_routine_assignament")
    private RoutineAssignament routineAssignament;

}
