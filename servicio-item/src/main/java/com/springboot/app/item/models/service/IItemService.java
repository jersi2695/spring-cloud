package com.springboot.app.item.models.service;

import java.util.List;

import com.springboot.app.item.models.entity.Item;
import com.springboot.app.commons.model.entity.Producto;

public interface IItemService {

	public List<Item> findAll();
	public Item findById(Long id, Integer cantidad);
	
	Producto save(Producto producto);
	
	Producto update(Producto producto, Long id);
	
	void delete(Long id);
}
