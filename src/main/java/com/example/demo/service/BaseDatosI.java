package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Articulo;

@Service
public interface BaseDatosI {

	public void iniciar();
	
	public Integer insertarArticulo(Articulo articulo);
	
	public Articulo buscarArticulo(Integer identificador);
	
	
}
