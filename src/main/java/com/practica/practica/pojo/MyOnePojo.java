package com.practica.practica.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.security.PublicKey;

@ConstructorBinding
@ConfigurationProperties(prefix = "user")
public class MyOnePojo {

    public String email;
    public  String Pass;
    public  int edad;

    public MyOnePojo(String email, String pass, int edad) {
        this.email = email;
        Pass = pass;
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
