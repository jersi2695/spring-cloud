package com.springboot.app.productos.models.service;

import java.util.List;

import com.springboot.app.commons.model.entity.Producto;

public interface IProductoService  {
	
	List<Producto> findAll();
	
	Producto findById(Long id);
	
	Producto save(Producto producto);
	
	void delete(Long id);

}
