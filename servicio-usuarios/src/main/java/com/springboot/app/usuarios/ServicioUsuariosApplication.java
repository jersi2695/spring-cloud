package com.springboot.app.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan({"com.springboot.app.commons.usuarios.model.entity"})
@SpringBootApplication
public class ServicioUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioUsuariosApplication.class, args);
	}

}
