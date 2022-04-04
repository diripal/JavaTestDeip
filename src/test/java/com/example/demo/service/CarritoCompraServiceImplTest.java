package com.example.demo.service;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.model.Articulo;


@RunWith(MockitoJUnitRunner.class)
public class CarritoCompraServiceImplTest {

	@InjectMocks
	private CarritoCompraServiceImpl carritoService = new CarritoCompraServiceImpl();
	
	@Mock
	private BaseDatosImpl baseDatos;
	
	@Test
	public void testLimpiarCesta() {
		carritoService.addArticulo(new Articulo("Sudadera", 20.00d));
		carritoService.limpiarCesta();
		
		assertTrue(carritoService.getNumArticulos() == 0);
	}

	@Test
	public void testAddArticulo() {
		carritoService.addArticulo(new Articulo("Sudadera", 20.00d));
		
		assertTrue(carritoService.getNumArticulos() > 0);
	}

	@Test
	public void testGetNumArticulos() {
		carritoService.addArticulo(new Articulo("Sudadera", 20.00d));
		carritoService.addArticulo(new Articulo("Pantalon", 30.00d));
		carritoService.addArticulo(new Articulo("Mochila", 25.00d));
		carritoService.addArticulo(new Articulo("Gorra", 50.00d));
		
		assertTrue(carritoService.getNumArticulos() == 4);
	}

	@Test
	public void testGetArticulos() {
		
		
		
	}

	@Test
	public void testTotalPrice() {
		
		carritoService.addArticulo(new Articulo("Sudadera", 20.00d));
		carritoService.addArticulo(new Articulo("Pantalon", 30.00d));
		carritoService.addArticulo(new Articulo("Mochila", 25.00d));
		carritoService.addArticulo(new Articulo("Gorra", 50.00d));
		
		assertTrue(carritoService.totalPrice() == 125.00d);
	}

	@Test
	public void testCalculadorDescuento() {
		
		
		
		assertTrue(carritoService.calculadorDescuento(10.00d, 20.00d) == 8.00d);
	}

	@Test
	public void testAplicarDescuento() {
		
		Articulo articulo = new Articulo("Camiseta",15.00d);
		
		when(baseDatos.buscarArticulo(any(Integer.class))).thenReturn(articulo);
		Double descuento = carritoService.aplicarDescuento(1, 20.00d);
		assertEquals(Double.valueOf(12.00d),descuento);
	}
	
	@Test
	public void testInsertar() {
		Articulo articulo = new Articulo("Camisa",15.00d);
		Integer id = carritoService.insertarArticulo(articulo);
		
		Articulo articulo2 = carritoService.getArticulo(id);
		assertSame(articulo,articulo2);
		
		verify(baseDatos,times(1)).insertarArticulo(articulo);
	}
	
}
