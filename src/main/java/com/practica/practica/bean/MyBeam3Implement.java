package com.practica.practica.bean;

public class MyBeam3Implement implements  MyBeanDependency{

    private Operacion operacion;

    public MyBeam3Implement(Operacion operacion){
        this.operacion = operacion;
    }


    @Override
    public void imprimirDespendency() {
        System.out.println(operacion.suma(2));
        System.out.println("que onda esta es una implementacion de un bean con dependencia :D");

    }
}
