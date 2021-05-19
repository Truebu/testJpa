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
@Entity(name = "score")
@Table(name = "score")
public class Score {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "commentary",nullable = false,columnDefinition = "TEXT", unique = true)
    private String commentary;

    @Column(name = "assessment",nullable = false,columnDefinition = "INT", unique = true)
    private String assessment;

    @ManyToOne
    @JoinColumn(name = "id_routine_assignament")
    private RoutineAssignament routineAssignament;

}