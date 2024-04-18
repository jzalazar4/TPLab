package com.example.demo.servicio.implementacion;

import com.example.demo.entidad.Libro;
import com.example.demo.entidad.Prestamo;
import com.example.demo.entidad.PrestamoFin;
import com.example.demo.exception.ErrorMsj;
import com.example.demo.repositorio.LibroRepo;
import com.example.demo.repositorio.PFinRepo;
import com.example.demo.repositorio.PrestRepo;
import com.example.demo.repositorio.UserRepo;
import com.example.demo.servicio.PFinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service

public class PFinImpl implements PFinService {

    @Autowired
    private PFinRepo repo;
    @Autowired
    private LibroRepo libroRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PrestRepo prestRepo;
    @Override
    public PrestamoFin nuevoPrestamo(PrestamoFin prestamoFin) {
        Optional<Prestamo> optionalPrestamo = prestRepo.findById(prestamoFin.getId_prestamo());
        if(optionalPrestamo.isPresent()) {
            Prestamo prestamo = optionalPrestamo.orElseThrow(() ->
                    new ErrorMsj("No se pudo encontrar el prestamo"));

            PrestamoFin p = new PrestamoFin();
            p.setId_libro(prestamo.getId_libro());
            p.setId_user(prestamo.getId_user());
            p.setFfin(prestamo.getFinicio());
            p.setEstado("Finalizado");
            p.setFfin(prestamoFin.getFfin());

            return repo.save(p);
        } else {
            throw new ErrorMsj("No se pudo guardar el prestamo");
        }
    }

    @Override
    public List<PrestamoFin> verPrestamos() {
        return repo.findAll();
    }

    @Override
    public Optional<PrestamoFin> unPrestamo(Long id) {
        return repo.findById(id);
    }

    @Override
    public void eliminarP(Long id) {
        repo.deleteById(id);
    }
}
