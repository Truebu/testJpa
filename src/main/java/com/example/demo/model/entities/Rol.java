package com.example.demo.model.entities;

import com.example.demo.model.enums.RolName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "rol")
@Table(name = "rol")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private RolName rolName;

    public Rol(@NotNull RolName rolName) {
        this.rolName = rolName;
    }
}
