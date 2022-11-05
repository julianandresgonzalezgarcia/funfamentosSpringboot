package com.practica.practica.repository;

import com.practica.practica.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepositorio extends JpaRepository<Post, Long> {

}
