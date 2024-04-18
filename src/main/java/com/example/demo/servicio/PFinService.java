package com.example.demo.servicio;

import com.example.demo.entidad.Prestamo;
import com.example.demo.entidad.PrestamoFin;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PFinService {

    PrestamoFin nuevoPrestamo (PrestamoFin prestamoFin);
    List<PrestamoFin> verPrestamos();
    Optional<PrestamoFin> unPrestamo(Long id);
    void eliminarP(Long id);
}
