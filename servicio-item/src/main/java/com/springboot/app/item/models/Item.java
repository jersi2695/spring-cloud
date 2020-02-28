package com.springboot.app.item.models;

public class Item {
	
	private Producto producto;
	
	private Integer cantidad;
	
	private Double total;
	
	public Item() {}

	public Item(Producto producto, int cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Double getTotal() {
		return producto.getPrecio() * cantidad.doubleValue();
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
	
	

}
