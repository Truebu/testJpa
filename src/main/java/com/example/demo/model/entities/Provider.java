package com.example.demo.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "provider")
@Table(name = "provider")
public class Provider {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name_provider",nullable = false,columnDefinition = "TEXT", unique = true)
    private String nameProvider;

    @Column(name = "email",nullable = false,columnDefinition = "TEXT", unique = true)
    private String email;

    @Column(name = "name",nullable = false,columnDefinition = "TEXT")
    private String name;

    @Column(name = "password",nullable = false,columnDefinition = "TEXT")
    private String password;

    @Column(name = "state",nullable = false)
    private Boolean state=true;

    @OneToMany(mappedBy = "provider")
    private Set<Advertising> advertisings = new HashSet<>();
}

