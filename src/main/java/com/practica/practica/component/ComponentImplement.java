package com.practica.practica.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplement implements ComponentDependency{
    @Override
    public void saludar() {
        System.out.println("Que se dice mi socio ooooaaaaaa");
    }
}
