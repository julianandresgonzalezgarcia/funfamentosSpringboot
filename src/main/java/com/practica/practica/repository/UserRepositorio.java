package com.practica.practica.repository;

import com.practica.practica.dto.UserDto;
import com.practica.practica.entity.User;
import net.bytebuddy.TypeCache;
import org.hibernate.sql.Select;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepositorio  extends PagingAndSortingRepository<User, Long> {

    @Query("Select u from User u WHERE u.años=?1")
    Optional<User> findUserAños(LocalDate años);
    @Query("Select u from User u WHERE u.nombre like ?1%")
    List<User> findUsuarios(String nombre, Sort sort);

    List<User> findBynombre(String nombre);

    Optional<User> findByemialAndNombre(String emial, String nombre);

    List<User> findByNombreLike(String nombre);

    List<User> findByNombreOrEmial(String nombre, String email);

    List<User> findByAñosBetween(LocalDate inicio, LocalDate Final);

    List<User> findByEmialLikeOrderByIdDesc(String email);

    List<User> findByEmialContainingOrderByIdAsc(String email);

    @Query("SELECT new com.practica.practica.dto.UserDto(u.id, u.nombre, u.años)"+
            " FROM User u "+
            " where u.emial=:paraCorreo "+
            " and u.nombre=:paraNombre ")
    Optional<UserDto> getAllByEmialAndNombre(@Param("paraCorreo") String email,
                                             @Param("paraNombre") String nombre);

    List<User> findAll();


}
