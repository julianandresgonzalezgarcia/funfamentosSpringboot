package com.practica.practica.dto;

import java.time.LocalDate;

public class UserDto {

    private Long id;
    private String nombre;
    private LocalDate años;

    public UserDto(Long id, String nombre, LocalDate años) {
        this.id = id;
        this.nombre = nombre;
        this.años = años;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getAños() {
        return años;
    }

    public void setAños(LocalDate años) {
        this.años = años;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", años=" + años +
                '}';
    }
}
