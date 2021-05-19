package com.example.demo.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "nick_name",nullable = false,columnDefinition = "TEXT", unique = true)
    private String nickname;

    @Column(name = "email",nullable = false,columnDefinition = "TEXT", unique = true)
    private String email;

    @Column(name = "name",nullable = false,columnDefinition = "TEXT")
    private String name;

    @Column(name = "password",nullable = false,columnDefinition = "TEXT")
    private String password;

    @Column(name = "state",nullable = false)
    private Boolean state=true;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_rol", joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_rol"))
    private Set<Rol> rols = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<RoutineAssignament> routineAssignaments = new HashSet<>();
}
