package com.springboot.app.productos.models.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.app.productos.models.entity.Producto;

public interface IProductoService extends JpaRepository<Producto, Long> {

}
