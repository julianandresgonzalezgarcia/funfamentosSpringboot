package com.practica.practica.caseuse;

import com.practica.practica.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserBorrar {
    private UserService userService;

    public UserBorrar(UserService userService) {
        this.userService = userService;
    }

    public void Borrar(Long id){
        userService.BorrarUsuario(id);
    }
}
