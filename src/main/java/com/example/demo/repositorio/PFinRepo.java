package com.example.demo.repositorio;

import com.example.demo.entidad.PrestamoFin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PFinRepo extends JpaRepository<PrestamoFin, Long> {
}
