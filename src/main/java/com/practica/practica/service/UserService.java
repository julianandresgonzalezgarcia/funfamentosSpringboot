package com.practica.practica.service;

import com.practica.practica.entity.User;
import com.practica.practica.repository.UserRepositorio;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    private final Log log = LogFactory.getLog(UserService.class);

    UserRepositorio userRepositorio;

    public UserService(UserRepositorio userRepositorio) {
        this.userRepositorio = userRepositorio;
    }
    @Transactional
    public void GuardarInfo(List<User> users){
        users.stream()
                .peek(user -> System.out.println("Usuario Reguistrado"+user))
                .forEach(userRepositorio::save);
    }

    public List<User> BuscarInfo(){
        return userRepositorio.findAll();
    }

    public User GuardarUsuario(User user) {
        return userRepositorio.save(user);
    }

    public void BorrarUsuario(Long id){
        userRepositorio.deleteById(id);
    }

    public User ActualizarUsuario(User newUser, Long id){
       return userRepositorio.findById(id)
                .map(   user -> {
                        user.setEmial(newUser.getEmial());
                        user.setAños(newUser.getAños());
                        user.setNombre(newUser.getNombre());
                        return userRepositorio.save(user);
                    }
                ).get();
    }

    /*public void BuscarInfo(List<User> users){
        for (User user: users){
            System.out.println(user);
        }
    }*/
}
