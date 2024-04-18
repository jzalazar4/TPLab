package com.example.demo.servicio.implementacion;

import com.example.demo.entidad.Libro;
import com.example.demo.entidad.Prestamo;
import com.example.demo.entidad.User;
import com.example.demo.exception.ErrorMsj;
import com.example.demo.repositorio.LibroRepo;
import com.example.demo.repositorio.PrestRepo;
import com.example.demo.repositorio.UserRepo;
import com.example.demo.servicio.PrestService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PrestServiceImpl implements PrestService {

    @Autowired
    private LibroRepo libroRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    PrestRepo prestRepo;
    @Autowired
    PFinImpl pFin;

                // GUARDAR PRESTAMO
    @Override
    public Prestamo nuevoPrestamo (Prestamo prestamo) {


        Libro libro = libroRepo.getById(prestamo.getId_libro());
        User user = userRepo.getById(prestamo.getId_user());
        if(libro != null && libro.getEstado().equalsIgnoreCase("disponible")) {
            if (user != null) {

                prestamo.setEstado("Activo");

                // MODIFICAR EL ESTADO DEL LIBRO
                libro.setEstado("No disponible");
                libroRepo.save(libro);

                return prestRepo.save(prestamo);
            }

        }
        return null;
    }
    // DEVOLVER LIBRO
  /*  @Transactional
    public void devolver (Long pid) {
        Prestamo prestamo = prestRepo.findById(pid)
                .orElseThrow(() -> new ErrorMsj("Prestamo no encontrado"));

        // ENVIAR LIBRO A PRESTAMO_FIN
        pFin.nuevoPrestamo(fecha,pid);

        // Eliminar el prestamo activo
        prestRepo.delete(prestamo);
    }*/
      /*  Optional<Prestamo> verPrestamo = prestRepo.findById(pid);

        if (verPrestamo.isPresent()) {
            Prestamo prestamo = verPrestamo.get();
            prestamo.setEstado("Finalizado");

            Optional<Libro> verLibro =  libroRepo.findById(prestamo.getId_libro());

            if (verLibro.isPresent()){
                Libro l = verLibro.get();
                l.setEstado("Disponible");
                libroRepo.save(l);
                prestRepo.deleteById(prestamo.getPid());
            }

        } else {

            throw new ErrorMsj("No se encontró el préstamo con ID " + pid);
        }*/

    @Override
    public List<Prestamo> verPrestamos() {
        return prestRepo.findAll();
    }

    @Override
    public ResponseEntity<Prestamo> actualizarP(Long pid, Prestamo p) {
        Optional<Prestamo> prestamoOptional = prestRepo.findById(pid);

        if (prestamoOptional.isPresent()) {
            Prestamo prestamoExistente = prestamoOptional.get();

            // Actualizar el libro si se proporciona un nuevo ID de libro
            if (p.getId_libro() != null) {
                prestamoExistente.setId_libro(p.getId_libro());
            }

            // Actualizar el usuario si se proporciona un nuevo ID de usuario
            if (p.getId_user() != null) {
                prestamoExistente.setId_user(p.getId_user());
            }

            // Actualizar la fecha de inicio de préstamo si se proporciona
            if (p.getFinicio() != null) {
                prestamoExistente.setFinicio(p.getFinicio());
            }

            Prestamo prestamoActualizado = prestRepo.save(prestamoExistente);
            return ResponseEntity.ok(prestamoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @Override
    public Optional<Prestamo> unPrestamo(Long pid) {
        return prestRepo.findById(pid);
    }
    @Override
    public void  eliminarP( Long pid) {
        Optional<Prestamo> optionalPrestamo = prestRepo.findById(pid);
        Prestamo prestamo = optionalPrestamo.orElseThrow(() ->
                new RuntimeException("No se pudo encontrar el préstamo"));

        Long idLibro = prestamo.getId_libro();

        Optional<Libro> optionalLibro = libroRepo.findById(idLibro);
        Libro libro = optionalLibro.orElseThrow(() ->
                new RuntimeException("No se pudo encontrar el libro"));

        // Actualizar el estado del libro a "disponible"
        libro.setEstado("Disponible");
        libroRepo.save(libro);

        prestRepo.deleteById(pid);
    }
}
