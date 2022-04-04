package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;


import com.example.demo.model.Articulo;

public class BaseDatosImpl implements BaseDatosI{
	
	private Map<Integer, Articulo> baseDatos;

	@Override
	public void iniciar() {
		baseDatos = new HashMap<>();
		baseDatos.put(1, new Articulo("Camiseta", 10.50d));
		baseDatos.put(2, new Articulo("Pantalones", 20.50d));
		baseDatos.put(3, new Articulo("Sudadera", 30.00d));
		baseDatos.put(4, new Articulo("Gorra", 50.00d));
		baseDatos.put(5, new Articulo("Camisa", 30.00d));
		
	}

	@Override
	public Integer insertarArticulo(Articulo articulo) {
		
		baseDatos.put(baseDatos.size(), articulo);
		
		return baseDatos.size()-1;
	}

	@Override
	public Articulo buscarArticulo(Integer identificador) {
		
		return baseDatos.get(identificador);
	}

}
