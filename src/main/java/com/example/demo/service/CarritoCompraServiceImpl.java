package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Articulo;

public class CarritoCompraServiceImpl implements CarritoCompraService{

	private List<Articulo> cesta = new ArrayList<>();
	
	@Autowired
	BaseDatosImpl baseDatos;
	
	@Override
	public void limpiarCesta() {
		
		cesta.clear();
	}

	@Override
	public void addArticulo(Articulo articulo) {
		
		cesta.add(articulo);
		
	}

	@Override
	public Integer getNumArticulos() {
		
		return cesta.size();
	}

	@Override
	public List<Articulo> getArticulos() {
		
		return cesta;
	}

	@Override
	public Double totalPrice() {
		
		Double price = 0.0d;
		
		for(Articulo ar : cesta) {
			price = price + ar.getPrecio();
		}
		
		System.out.println(price);
		
		return price;
	}

	@Override
	public Double calculadorDescuento(Double precio, Double porcentaje) {

		return precio - precio*porcentaje/100;
	}

	@Override
	public Double aplicarDescuento(Integer idArticulo, Double porcentaje) {

		baseDatos.iniciar();
		Articulo articulo = baseDatos.buscarArticulo(idArticulo);
		if(Optional.ofNullable(articulo).isPresent()) {
			return calculadorDescuento(articulo.getPrecio(), porcentaje);
		}else {
			System.out.println("No se ha encontrado el articulo con ID: "+idArticulo);
		}
		
		
		return 0D;
	}

	@Override
	public Integer insertarArticulo(Articulo articulo) {
		
		return  baseDatos.insertarArticulo(articulo);
	}

	@Override
	public Articulo getArticulo(Integer idArticulo) {
		
		
		return baseDatos.buscarArticulo(idArticulo);
	}
	

}
