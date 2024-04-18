package com.example.demo.servicio.implementacion;

import com.example.demo.entidad.Libro;
import com.example.demo.repositorio.LibroRepo;
import com.example.demo.servicio.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LibroServiceImpl implements LibroService {

    private LibroRepo libroRepo;

    @Autowired
    public LibroServiceImpl(LibroRepo libroRepo) {
        this.libroRepo = libroRepo;
    }
    @Override
    public Libro guardarLibro(Libro l) {
        return libroRepo.save(l);
    }

    @Override
    public ResponseEntity<Libro> actualizarLibro(Long lid, Libro nuevo){
        return libroRepo.findById(lid)
                .map(libro -> {
                    libro.setTitulo(nuevo.getTitulo());
                    libro.setAutor(nuevo.getAutor());
                    libro.setFecha(nuevo.getFecha());
                    libro.setSinopsis(nuevo.getSinopsis());
                    libro.setPag(nuevo.getPag());
                    libro.setGenero(nuevo.getGenero());
                    libro.setEstado(nuevo.getEstado());


                    Libro actualizado = libroRepo.save(libro);
                    return ResponseEntity.ok(actualizado);
                })
                .orElse(ResponseEntity.notFound().build());

    }

    @Override
    public List<Libro> verLibros() {
        return libroRepo.findAll();
    }

    @Override
    public Libro unLibro(Long lid) {
        return libroRepo.findById(lid).orElse(null);
    }

    @Override
    public void eliminarLibro(Long lid) {
        libroRepo.deleteById(lid);
    }


}
