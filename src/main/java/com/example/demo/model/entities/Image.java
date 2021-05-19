package com.example.demo.model.entities;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity(name = "image")
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "image_route",nullable = false,columnDefinition = "TEXT")
    private String imageRoute;

    @Column(name = "format",nullable = false,columnDefinition = "TEXT")
    private String format;

    @ManyToOne
    @JoinColumn(name = "id_routine")
    private Routine routine= new Routine();

    public Image(int id, String imageRoute, int idRoutine, String format) {
        this.id = (long) id;
        this.routine.setId((long) idRoutine);
        this.imageRoute = imageRoute;
        this.format = format;
    }
}
