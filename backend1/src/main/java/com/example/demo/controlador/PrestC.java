package com.example.demo.controlador;

import com.example.demo.entidad.Prestamo;
import com.example.demo.repositorio.PrestRepo;
import com.example.demo.servicio.implementacion.PrestServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/prestamo/")

public class PrestC {
    @Autowired
    private PrestRepo prestRepo;
    @Autowired
    private PrestServiceImpl prestService;

    @PostMapping(path = "/save")
    public Prestamo nuevoPrestamo (@RequestBody Prestamo prestamo) {
        return prestService.nuevoPrestamo(prestamo);
    }

    @GetMapping(path = "/ver")
    public List<Prestamo> verPrestamos() {
        return prestService.verPrestamos();

    }
    @PutMapping(path = "/update/{pid}")
    public ResponseEntity<Prestamo> actualizarP(@PathVariable Long pid, @RequestBody Prestamo p) {
        return prestService.actualizarP(pid,p);
    }
    @GetMapping(path = "/getone/{pid}")
    public Optional<Prestamo> unPrestamo(@PathVariable Long pid) {
        return prestService.unPrestamo(pid);
    }

    @DeleteMapping(path = "/delete/{pid}")
    public void eliminarP(@PathVariable Long pid) {
        prestService.eliminarP(pid);
    }
/*
    @PutMapping(path = "/devolver/{pid}")
    public void devolver(@PathVariable Long pid) {
        prestService.devolver(pid);
    }*/
}