/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.BootCampJUnit.model;

/**
 *
 * @author fabio
 */
public class Articulo {

    private String nombre;
    private Double precio;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Articulo(String nombre, Double precio) {
        this.precio = precio;
        this.nombre = nombre;
    }

}
