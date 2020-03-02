package com.springboot.app.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@RibbonClient(name="servicio-productos")
@EnableEurekaClient
@EnableFeignClients
// Eneables Hystrix to manage the error, exception and lantency handle
@EnableCircuitBreaker
public class ServicioItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioItemApplication.class, args);
	}

}
