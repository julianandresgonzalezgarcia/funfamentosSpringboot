package com.practica.practica;

import com.practica.practica.Configuration.BeanNombrePropiedad;
import com.practica.practica.bean.MyBeam3Implement;
import com.practica.practica.bean.MyBean;
import com.practica.practica.component.ComponentDependency;
import com.practica.practica.entity.User;
import com.practica.practica.pojo.MyOnePojo;
import com.practica.practica.repository.UserRepositorio;
import com.practica.practica.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class PracticaApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeam3Implement myBeam3Implement;
	private MyOnePojo myOnePojo;
	private UserRepositorio userRepositorio;
	List<User> listaUsuarios = new ArrayList<>();
	private BeanNombrePropiedad beanNombrePropiedad;
	private UserService userService;

	public PracticaApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeam3Implement myBeam3Implement, BeanNombrePropiedad beanNombrePropiedad, MyOnePojo myOnePojo, UserRepositorio userRepositorio, UserService userService){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeam3Implement = myBeam3Implement;
		this.beanNombrePropiedad = beanNombrePropiedad;
		this.myOnePojo = myOnePojo;
		this.userRepositorio = userRepositorio;
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(PracticaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Ejemplos();
		GuadadoDeUsuarios();
		//GuardadoDeUsuarios();
		//EncontrarUsuarios();
		//EncontrarPorNombre();
		//EncontrarPorEdad();
	}

    public void GuadadoDeUsuarios(){

		User user1 = new User("Jose","Jose@gmail.com",LocalDate.of(2022,05,10));
		User user2 = new User("Olga","Olga@gmail.com",LocalDate.of(2022,07,15));
		User user3 = new User("Pedro","Pedro@gmail.com",LocalDate.of(2022,11,9));
		List<User> users = Arrays.asList(user1, user2, user3);
		try{
			System.out.println("Exito!!!");
			userService.GuardarInfo(users);
		}catch (Exception e){
			System.out.println("UPPSS algo salio mal, el Error es:"+e);
		}

		userService.BuscarInfo()
				.stream()
				.forEach(user -> System.out.println("Los usuarios almacenados son: "+user));
		//userService.BuscarInfo(users);
    }

	public void GuardadoDeUsuarios(){
		User user = new User("Julian","Julian@gmail.com", LocalDate.of(2021,03,15));
		User user1 = new User("User1","User1@gmail.com", LocalDate.of(2021,04,15));
		User user2 = new User("User2","User2@gmail.com", LocalDate.of(2022,05,16));
		User user3 = new User("User3","User3@gmail.com", LocalDate.of(2022,06,17));
		User user4 = new User("User4","User4@gmail.com", LocalDate.of(2022,07,18));
		listaUsuarios = Arrays.asList(user, user1, user2, user3, user4);
		listaUsuarios.stream().forEach(userRepositorio::save);
	}

	public void EncontrarPorEdad(){
		System.out.println("El usuario con la Edad selecionada es: "+userRepositorio.findUserAños(LocalDate.of(2021,03,14))
				.orElseThrow(()-> new RuntimeException("No se encontro ningun usuario con el paramentro establecido")));
	}

	public void EncontrarPorNombre(){
		userRepositorio.findUsuarios("User", Sort.by("id").ascending())
				.stream()
				.forEach(user -> System.out.println("Los Usuarios con el nombre son: "+user));
	}

	public void EncontrarUsuarios(){

		/*for (User respuesta : listaUsuarios){
			System.out.println(respuesta);
		}
		userRepositorio.findBynombre("User1")
				.stream()
				.forEach(user -> System.out.println("El Usuario con el nombre estableciod es: "+user));

		System.out.println(userRepositorio.findByemialAndNombre("User1@gmail.com","User1"));

		userRepositorio.findByNombreLike("%u%")
				.stream()
				.forEach(user -> System.out.println("Los usuarios Encontrados son: "+user));

		userRepositorio.findByNombreOrEmial("Julian","User2@gmail.com")
				.stream()
				.forEach(user -> System.out.println("Los resultados con los filtros establecidos son: "+user));

		userRepositorio.findByAñosBetween(LocalDate.of(2021,03,15),LocalDate.of(2022,05,16))
				.stream()
				.forEach(user -> System.out.println("Los resultados con los filtros establecidos son: "+user));

		userRepositorio.findByEmialLikeOrderByIdDesc("%User%")
				.stream()
				.forEach(user -> System.out.println("Los resultados con los filtros establecidos son: "+user));

		userRepositorio.findByEmialContainingOrderByIdAsc("gmail")
				.stream()
				.forEach(user -> System.out.println("El resultado con los filtros establecidos son: "+user));*/

		System.out.println(userRepositorio.getAllByEmialAndNombre("Julian@gmail.com",
						"Julian")
				.orElseThrow(()->
						new RuntimeException("No se encontro nungun usuario con los filtros etablecidos")));

	}



	public void Ejemplos(){

		componentDependency.saludar();
		myBean.inprimir();
		myBeam3Implement.imprimirDespendency();
		System.out.println(beanNombrePropiedad.funcion());
		System.out.println("Correo: "+myOnePojo.getEmail()+" Contraseña: "+myOnePojo.getPass()+" Edad: "+myOnePojo.getEdad());


	}
}
