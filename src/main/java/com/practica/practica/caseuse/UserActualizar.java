package com.practica.practica.caseuse;

import com.practica.practica.entity.User;
import com.practica.practica.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserActualizar {
    private UserService userService;

    public UserActualizar(UserService userService) {
        this.userService = userService;
    }

    public User Actualizar(User newUser, Long id){
        return userService.ActualizarUsuario(newUser,id);

    }
}
