package com.example.demo.servicio;

import com.example.demo.entidad.Prestamo;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PrestService {

    Prestamo nuevoPrestamo (Prestamo prestamo);
    List<Prestamo> verPrestamos();
    ResponseEntity<Prestamo> actualizarP(Long pid, Prestamo p);
    Optional<Prestamo> unPrestamo(Long pid);
    void eliminarP(Long pid);
    //void devolver(Long pid);
}
