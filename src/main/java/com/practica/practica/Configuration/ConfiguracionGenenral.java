package com.practica.practica.Configuration;

import com.practica.practica.pojo.MyOnePojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:connection.properties")
@EnableConfigurationProperties(MyOnePojo.class)
public class ConfiguracionGenenral {
    @Value("${value.nombre}")
    public String nombre;

    @Value("${value.apellido}")
    public String apellido;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${driver}")
    private String driver;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;


    @Bean
    public BeanNombrePropiedad funcion(){
        return new ImplementacionDelNombre(nombre, apellido);
    }

    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:testdb");
        dataSourceBuilder.username("userJulian");
        dataSourceBuilder.password("");
        return  dataSourceBuilder.build();
    }


}
