package com.practica.practica.controller;

import com.practica.practica.caseuse.GetUse;
import com.practica.practica.caseuse.UserActualizar;
import com.practica.practica.caseuse.UserBorrar;
import com.practica.practica.caseuse.UserCrear;
import com.practica.practica.entity.User;
import com.practica.practica.repository.UserRepositorio;
import net.bytebuddy.asm.Advice;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    public GetUse getUse;
    public UserCrear userCrear;
    public UserBorrar userBorrar;
    public UserActualizar userActualizar;
    public UserRepositorio userRepositorio;

    public UserRestController(GetUse getUse, UserCrear userCrear, UserBorrar userBorrar,UserActualizar userActualizar, UserRepositorio userRepositorio) {
        this.getUse = getUse;
        this.userCrear = userCrear;
        this.userBorrar = userBorrar;
        this.userActualizar = userActualizar;
        this.userRepositorio = userRepositorio;
    }
    @GetMapping("/")
    List<User> get(){
        return getUse.ObtenerUsuarios();
    }

    @PostMapping("/")
    ResponseEntity<User> nuevoUsuario(@RequestBody User user){
        return new ResponseEntity<>(userCrear.Guardar(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity borrarUsuario(@PathVariable Long id){
        userBorrar.Borrar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    ResponseEntity<User> cambiarUsuario(@RequestBody User user, @PathVariable Long id){
        return new ResponseEntity<>(userActualizar.Actualizar(user,id),HttpStatus.OK);
    }

    @GetMapping("/pageable")
    List<User> userPageable(@RequestParam int page, @RequestParam int index){
        return userRepositorio.findAll(PageRequest.of(page, index)).getContent();
    }
}
