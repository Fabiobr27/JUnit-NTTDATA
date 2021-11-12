/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.BootCampJUnit.BBDD;

import com.example.BootCampJUnit.model.Articulo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fabio
 */
@Service
public class CarritoCompraServiceImpl implements CarritoCompraServiceI {

    @Autowired
    private BaseDatosServiceImpl baseDatos;
    List<Articulo> listaArticulos = new ArrayList<>();

    @Override
    public void limpiarCesta() {
        listaArticulos.clear();
    }

    @Override
    public void addArticulo(Articulo a) {
        listaArticulos.add(a);
    }

    @Override
    public Integer getNumArticulo() {
        
        
        return listaArticulos.size();
    }

    @Override
    public List<Articulo> getArticulos() {
        return listaArticulos;
    }

    @Override
    public Double totalPrice() {
        Double Total = 00.0;
        for (Articulo articulo : listaArticulos) {
            Total = Total + articulo.getPrecio();
        }
        return Total;
    }

    @Override
    public Double calculadorDescuento(Double precio, Double porcentajeDescuento) {
        Double Descuento = precio*porcentajeDescuento/100;
        return Descuento;
    }

    @Override
    public Double aplicarDescuento(Integer idArticulo, Double porcentaje) {
        
        Double resultado = null;
        Articulo articulo = baseDatos.findArticuloByID(idArticulo);
        if(articulo != null){
             resultado = calculadorDescuento(articulo.getPrecio(), porcentaje);
        }else{
            System.out.println("No se ha encontrado ningun articulo con ID : " + idArticulo);
        }
       
        
        return resultado;
        
        
    }
    
	@Override
	public Integer insertarArticuloById(int id, Articulo articulo) {
		listaArticulos.add(articulo);
		return baseDatos.insertarArticuloById(id, articulo);
	}
    


}
