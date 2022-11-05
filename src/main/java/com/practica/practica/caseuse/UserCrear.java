package com.practica.practica.caseuse;

import com.practica.practica.entity.User;
import com.practica.practica.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserCrear {
    private UserService userService;

    public UserCrear(UserService userService) {
        this.userService = userService;
    }

    public User Guardar(User user){
        return userService.GuardarUsuario(user);
    }
}
