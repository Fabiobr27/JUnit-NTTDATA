package com.example.BootCampJUnit;

import com.example.BootCampJUnit.BBDD.BaseDatosServiceI;
import com.example.BootCampJUnit.model.Articulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootCampJUnitApplication implements CommandLineRunner {
    
    @Autowired
    private BaseDatosServiceI baseDatosService;
    
    public static void main(String[] args) {
        SpringApplication.run(BootCampJUnitApplication.class, args);
    }
    
    @Override
    public void run(String... args) throws Exception {

        baseDatosService.initBD();
        Articulo articulo = new Articulo("Calcetines", 5.95);
        baseDatosService.insertarArticulo(articulo);
        baseDatosService.findArticuloByID(baseDatosService.lastIndex());

    }
    
}
