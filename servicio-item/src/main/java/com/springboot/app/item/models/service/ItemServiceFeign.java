package com.springboot.app.item.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.springboot.app.item.clients.IProductoClienteRest;
import com.springboot.app.item.models.entity.Item;
import com.springboot.app.commons.model.entity.Producto;

@Service("serviceFeign")
@Primary
public class ItemServiceFeign implements IItemService {
	
	@Autowired
	private IProductoClienteRest productoClienteRest;

	@Override
	public List<Item> findAll() {
		List<Producto> productos = productoClienteRest.listar();
		return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		Producto producto = productoClienteRest.detalle(id);
		return new Item(producto, cantidad);
	}

	@Override
	public Producto save(Producto producto) {
		return productoClienteRest.crear(producto);
	}

	@Override
	public Producto update(Producto producto, Long id) {
		return productoClienteRest.editar(producto, id);
	}

	@Override
	public void delete(Long id) {
		productoClienteRest.eliminar(id);
	}

}
