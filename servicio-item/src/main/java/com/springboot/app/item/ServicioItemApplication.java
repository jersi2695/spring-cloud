package com.springboot.app.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@RibbonClient(name="servicio-productos")
//Eneables Hystrix to manage the error, exception and lantency handle
@EnableCircuitBreaker
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EntityScan({"com.springboot.app.commons.model.entity"})
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class ServicioItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioItemApplication.class, args);
	}

}
