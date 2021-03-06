package com.springboot.app.item.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springboot.app.item.models.entity.Item;
import com.springboot.app.commons.model.entity.Producto;

@Service("serviceRestTemplate")
public class ItemServiceImpl implements IItemService {
	
	@Autowired
	private RestTemplate clienteRest;

	@Override
	public List<Item> findAll() {
		List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://servicio-productos/listar", Producto[].class));
		return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("id", id.toString());
		Producto producto = clienteRest.getForObject("http://servicio-productos/detalle/{id}" , Producto.class, parameters);
		return new Item(producto, cantidad);
	}

	@Override
	public Producto save(Producto producto) {
		
		HttpEntity<Producto> body = new HttpEntity<Producto>(producto);
		
		ResponseEntity<Producto> resposeProducto = clienteRest.exchange("http://servicio-productos/crear", HttpMethod.POST, body, Producto.class);
		return resposeProducto.getBody();
	}

	@Override
	public Producto update(Producto producto, Long id) {
		HttpEntity<Producto> body = new HttpEntity<Producto>(producto);
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("id", id.toString());
		ResponseEntity<Producto> resposeProducto = clienteRest.exchange("http://servicio-productos/editar/{id}", HttpMethod.PUT, body, Producto.class, parameters);
		return resposeProducto.getBody();
	}

	@Override
	public void delete(Long id) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("id", id.toString());
		clienteRest.delete("http://servicio-productos/eliminar/{id}", parameters);		
	}

}
