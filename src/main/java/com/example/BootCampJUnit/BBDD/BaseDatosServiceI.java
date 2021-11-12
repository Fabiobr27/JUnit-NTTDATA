/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.BootCampJUnit.BBDD;

import com.example.BootCampJUnit.model.Articulo;

/**
 *
 * @author fabio
 */
public interface BaseDatosServiceI {
    
    
    public void initBD();
    
    public Articulo findArticuloByID(Integer id);
    public String insertarArticulo (Articulo articulo);

    public Integer lastIndex();

	Integer insertarArticuloById(int id, Articulo articulo);

    
}
