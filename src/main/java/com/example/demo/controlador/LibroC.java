package com.example.demo.controlador;

import com.example.demo.entidad.Libro;
import com.example.demo.repositorio.LibroRepo;
import com.example.demo.servicio.implementacion.LibroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/libros/")
public class LibroC {

    @Autowired
    private LibroServiceImpl libroService;
    @Autowired
    private LibroRepo libroRepo;

    @PostMapping(path="/save")      // FUNCIONA
    public Libro guardarLibro(@RequestBody Libro l) {


        return libroService.guardarLibro(l);
    }


    // ACTUALIZAR LIBRO
    @PutMapping(path="/update/{lid}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable Long lid, @RequestBody Libro nuevo) {

        return libroService.actualizarLibro(lid, nuevo);
    }

    @GetMapping(path="/ver")        // FUNCIONA
    public List<Libro> verLibros() {
        return libroService.verLibros();
    }

    @GetMapping(path="/getone/{lid}")   //FUNCIONA
    public Libro unLibro(@PathVariable Long lid) {
        return libroService.unLibro(lid);
    }

    @DeleteMapping(path="/delete/{lid}")    //FUNCIONA
    public void eliminarLibro(@PathVariable Long lid) {
        libroService.eliminarLibro(lid);
    }


}
