package com.example.demo.servicio;

import com.example.demo.entidad.Libro;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LibroService {

    Libro guardarLibro(Libro l);
    ResponseEntity<Libro> actualizarLibro(Long lid, Libro nuevo);
    List<Libro> verLibros();

    Libro unLibro(Long lid);
    void eliminarLibro(Long lid);


}
