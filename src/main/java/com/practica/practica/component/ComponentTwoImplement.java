package com.practica.practica.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImplement implements ComponentDependency {
    @Override
    public void saludar() {
        System.out.println("Hola mi perro soy yo, pero desde otra implementacion");
    }
}
