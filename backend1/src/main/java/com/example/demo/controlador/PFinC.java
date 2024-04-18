package com.example.demo.controlador;

import com.example.demo.entidad.Prestamo;
import com.example.demo.entidad.PrestamoFin;
import com.example.demo.repositorio.PFinRepo;
import com.example.demo.servicio.implementacion.PFinImpl;
import com.example.demo.servicio.implementacion.PrestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/pfin/")
public class PFinC {

    @Autowired
    private PFinImpl pFin;
    @Autowired
    private PFinRepo repo;

    @Autowired
    private PrestServiceImpl prestService;

    // GUARDAR PRESTAMO FINALIZADO
    @PostMapping(path = "/save")
    public PrestamoFin nuevoPrestamo (@RequestBody PrestamoFin prestamoFin) {
        return pFin.nuevoPrestamo(prestamoFin);
    }

    // VER TODOS
    @GetMapping(path = "/ver")
    public List<PrestamoFin> verPrestamos() {
        return pFin.verPrestamos();
    }
    @GetMapping(path = "/getone/{id}")
    public Optional<PrestamoFin> unPrestamo(@PathVariable Long id) {
        return pFin.unPrestamo(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void eliminarP(@PathVariable Long id) {
        pFin.eliminarP(id);
    }
}
