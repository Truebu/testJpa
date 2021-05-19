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
@Entity(name = "advertising")
@Table(name = "advertising")
public class Advertising {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "image_route",nullable = false,columnDefinition = "TEXT")
    private String imageRoute;

    @Column(name = "format",nullable = false,columnDefinition = "TEXT")
    private String format;

    @Column(name = "url",nullable = false,columnDefinition = "TEXT")
    private String url;

    @ManyToOne
    @JoinColumn(name = "id_provider")
    private Provider provider;
}
