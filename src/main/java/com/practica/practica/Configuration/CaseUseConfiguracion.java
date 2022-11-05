package com.practica.practica.Configuration;

import com.practica.practica.caseuse.GetUse;
import com.practica.practica.caseuse.GetUseImplementacion;
import com.practica.practica.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguracion {

    @Bean
    GetUse getUse(UserService userService){
        return new GetUseImplementacion(userService);

    }
}
