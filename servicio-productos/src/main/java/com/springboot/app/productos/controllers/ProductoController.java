package com.springboot.app.productos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.productos.models.entity.Producto;
import com.springboot.app.productos.models.service.IProductoService;

@RestController
public class ProductoController {
	
	@Autowired
	private IProductoService productoService;
	
	@Autowired
	private Environment enviroment;
	
	@Value("${server.port}")
	private Integer port;
	
	
	@GetMapping("/listar")
	public List<Producto> listar(){
		return productoService.findAll().stream().
				map(x -> {
					x.setPort(port);
					return x;
				}).collect(Collectors.toList());
	}
	
	@GetMapping("/detalle/{id}")
	public Producto detalle(@PathVariable(name = "id") Long id) {
		Producto producto =  productoService.findById(id);
		producto.setPort(port);
		return producto;
	}

}
