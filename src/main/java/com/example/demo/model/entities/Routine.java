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
@Entity(name = "routine")
@Table(name = "routine")
public class Routine {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name_routine",nullable = false,columnDefinition = "TEXT")
    private String nameroutine;

    @Column(name = "description",nullable = true,columnDefinition = "TEXT")
    private String description;

    @Column(name = "state",nullable = false)
    private Boolean state=true;

    @Column(name = "equipment",nullable = false)
    private Boolean equipment;

    @Column(name = "average_score", nullable = true)
    private int averageScore;

    @Column(name = "recommendation",nullable = true,columnDefinition = "TEXT")
    private String recommendations;

    @Column(name = "routine_creation",nullable = true)
    private Date routineCreation;

    @OneToMany(mappedBy = "routine")
    private Set<RoutineAssignament> routineAssignaments = new HashSet<>();

    @OneToMany(mappedBy = "routine")
    private Set<Image>  images = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "category_routine", joinColumns = @JoinColumn(name = "id_routine"),
            inverseJoinColumns = @JoinColumn(name = "id_cateory"))
    private Set<Category> categories = new HashSet<>();

    public Routine(Long id) {
        this.id = id;
    }
}
