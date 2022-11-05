package com.practica.practica.caseuse;

import com.practica.practica.entity.User;
import com.practica.practica.service.UserService;

import java.util.List;

public class GetUseImplementacion implements GetUse{

    public UserService userService;

    public GetUseImplementacion(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> ObtenerUsuarios() {
        return userService.BuscarInfo();
    }
}
