/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.BootCampJUnit.BBDD;

import com.example.BootCampJUnit.model.Articulo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
class CarritoCompraServiceImplTest {
	
@Mock
	private BaseDatosServiceImpl bbddService;

	@InjectMocks
	private CarritoCompraServiceImpl carritoCompraService = new CarritoCompraServiceImpl();

	
	List<Articulo> listaArticulos = new ArrayList<>();
	/**
	 * Test of limpiarCesta method, of class CarritoCompraServiceImpl.
	 */
	@Test
	@Order(4)
	public void testLimpiarCesta() {
		Articulo articulo1 = new Articulo("Camiseta", 15.5);

		carritoCompraService.addArticulo(articulo1);
		carritoCompraService.limpiarCesta();
		assertEquals(0, carritoCompraService.getArticulos().size());
	}

	/**
	 * Test of addArticulo method, of class CarritoCompraServiceImpl.
	 */
	@Test
	@Order(2)
	public void testAddArticulo() {
		Articulo articulo1 = new Articulo("Camiseta", 15.5);

		carritoCompraService.addArticulo(articulo1);

		assertEquals(1, carritoCompraService.getArticulos().size());
	}

	/**
	 * Test of getNumArticulo method, of class CarritoCompraServiceImpl.
	 * 
	 * @return
	 */
	@Test
	@Order(3)
	public Integer testGetNumArticulo() {

		return carritoCompraService.getNumArticulo();

	}

	@Test
	public void getArticulos() {
		
	
		assertTrue(carritoCompraService.getArticulos().containsAll(listaArticulos));


	}

	/**
	 * Test of totalPrice method, of class CarritoCompraServiceImpl.
	 */
	@Test
	@Order(1)
	public void testTotalPrice() {

		System.out.println("Total Precio Test");

		carritoCompraService.addArticulo(new Articulo("articulo1", 10.5));
		carritoCompraService.addArticulo(new Articulo("articulo2", 20.5));
		carritoCompraService.addArticulo(new Articulo("articulo3", 30.5));

		System.out.println("Precio Total : " + carritoCompraService.totalPrice());

		assertEquals(carritoCompraService.totalPrice(), 61.5);
		
	}

	/**
	 * Test of calculadorDescuento method, of class CarritoCompraServiceImpl.
	 */
	@Test
	public void testCalculadorDescuento() {

		System.out.println("Calcular descuento " + carritoCompraService.calculadorDescuento(17.6, 50d));
		assertEquals(carritoCompraService.calculadorDescuento(17.6d, 50d), 8.8);
	}

	/**
	 * Test of aplicarDescuento method, of class CarritoCompraServiceImpl.
	 */
	@Test
	public void testAplicarDescuento() {
		Articulo articulo = new Articulo("Pantalon",17.6);
		when(bbddService.findArticuloByID(any(Integer.class))).thenReturn(articulo);
		Double res = carritoCompraService.aplicarDescuento(1, 50D);
		System.out.println("Aplicar Descuento : "  + res);
		assertEquals(8.8, res);
		Mockito.verify(bbddService, times(1)).findArticuloByID(any(Integer.class));
	}
	
	@Test
	public void testAplicarDescuentoFail() {
	
		when(bbddService.findArticuloByID(any(Integer.class))).thenReturn(null);
		Double descuento = 5.0;
		assertNull(carritoCompraService.aplicarDescuento(1, descuento));
	}
	@Test

	void testInsertarArticuloById() {

		Articulo articulo = new Articulo("Zapatilla", 190.9D);
		int id = 1;
		
		when(bbddService.insertarArticuloById(any(Integer.class), any(Articulo.class))).thenReturn(8);
		id = carritoCompraService.insertarArticuloById(8, articulo);
		
		assertEquals(8, id);
		assertTrue(carritoCompraService.getArticulos().contains(articulo));
		verify(bbddService, atLeast(1)).insertarArticuloById(any(Integer.class), any(Articulo.class));
	}

}
