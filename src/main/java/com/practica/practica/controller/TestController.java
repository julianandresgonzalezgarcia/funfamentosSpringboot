package com.practica.practica.controller;

import com.practica.practica.Configuration.BeanNombrePropiedad;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {


    @RequestMapping
    @ResponseBody
    public ResponseEntity<String> funcion(){
        return  new ResponseEntity<>("UPPPPA me salio flaaamma, ja que si que, ta chimba", HttpStatus.OK);
    }
}
