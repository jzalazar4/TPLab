package com.example.demo.repositorio;

import com.example.demo.entidad.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestRepo extends JpaRepository<Prestamo, Long> {
    //@Query("SELECT p FROM Prestamo p WHERE p.id_user = :userId AND p.id_libro = :libroId AND p.estado = :estado")

    //List<Prestamo> activos(Long userId, Long libroId, String estado);

}
