/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.BootCampJUnit.BBDD;

import com.example.BootCampJUnit.model.Articulo;
import java.util.List;

/**
 *
 * @author fabio
 */
public interface CarritoCompraServiceI {

	// Vacia la cesta
	public void limpiarCesta();

	// Añade un articulo a la cesta
	public void addArticulo(Articulo a);

	// Devuelve el numero de articulos en la cesta
	public Integer getNumArticulo();

	// Devuelve la lista de todos los artciulos añadidos
	public List<Articulo> getArticulos();

	// Devuelve el precio total de las compra
	public Double totalPrice();

	// Aplica un descuento a un produdcto dado su precio
	public Double calculadorDescuento(Double precio, Double porcentajeDescuento);

	public Double aplicarDescuento(Integer idArticulo, Double porcentaje);

	Integer insertarArticuloById(int id, Articulo articulo);

}
