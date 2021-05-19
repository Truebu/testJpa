package com.example.demo.model.entities;

import com.example.demo.model.enums.CategoryName;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity(name = "category")
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CategoryName categoryName;

    public Category(@NotNull CategoryName categoryName) {
        this.categoryName = categoryName;
    }
}