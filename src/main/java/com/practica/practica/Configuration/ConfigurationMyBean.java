package com.practica.practica.Configuration;

import com.practica.practica.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationMyBean {
    @Bean
    public MyBean myBean(){
        return new MyBean2Implement();
    }

    @Bean
    public Operacion beanOperacion(){
        return new operacionImplement();
    }

    @Bean
    public MyBeam3Implement beanOperaciondependency(Operacion operacion){
        return new MyBeam3Implement(operacion);
    }

}
