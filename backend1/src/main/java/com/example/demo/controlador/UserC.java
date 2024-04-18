package com.example.demo.controlador;

import com.example.demo.entidad.User;
import com.example.demo.repositorio.UserRepo;
import com.example.demo.servicio.implementacion.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/user")
public class UserC {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRepo userRepo;

                //VER USUARIOS
    @GetMapping(path = "/ver")
    public List<User> verUsuarios() {
        return userService.verUsuarios();
    }

                // GUARDAR USUARIO
    @PostMapping(path = "/save")
    public User guardarUser(@RequestBody User u) {
        return userService.guardarUser(u);
    }

            // ACTUALIZAR USUARIO
    @PutMapping(path = "/update/{uid}")
    public ResponseEntity<User> actualizarUser(@PathVariable Long uid, @RequestBody User u) {

     return userService.actualizarUser(uid,u);
    }

                // VER UN USUARIO
    @GetMapping(path = "/getone/{uid}")
    public User unUser(@PathVariable Long uid) {
        return userService.unUser(uid);
    }

                // ELIMINAR USUARIO
    @DeleteMapping(path = "/delete/{uid}")
    public void eliminarUser(@PathVariable Long uid) {
        userService.eliminarUser(uid);
    }
}
