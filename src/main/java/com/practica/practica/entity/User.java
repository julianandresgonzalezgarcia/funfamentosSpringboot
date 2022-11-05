package com.practica.practica.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_user", nullable = false, unique = true)
    private long id;

    @Column(length = 50)
    private String nombre;

    @Column(length = 50, unique = true)
    private String emial;

    private LocalDate años;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Post> posts = new ArrayList<>();

    public User() {
    }

    public User(String nombre, String emial, LocalDate años) {
        this.nombre = nombre;
        this.emial = emial;
        this.años = años;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmial() {
        return emial;
    }

    public void setEmial(String emial) {
        this.emial = emial;
    }

    public LocalDate getAños() {
        return años;
    }

    public void setAños(LocalDate años) {
        this.años = años;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", emial='" + emial + '\'' +
                ", años=" + años +
                ", posts=" + posts +
                '}';
    }
}
