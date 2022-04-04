package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Articulo;

public interface CarritoCompraService {

	public void limpiarCesta();
	
	public void addArticulo(Articulo articulo);
	
	public Integer getNumArticulos();
	
	public List<Articulo> getArticulos();
	
	public Double totalPrice();
	
	public Double calculadorDescuento(Double precio, Double porcentaje);

	public Double aplicarDescuento(Integer idArticulo, Double porcentaje);
	
	public Integer insertarArticulo(Articulo a);
	
	public Articulo getArticulo(Integer id);
}
