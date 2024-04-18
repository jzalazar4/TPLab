package com.example.demo.servicio;

import com.example.demo.entidad.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    User guardarUser(User u);
    List<User> verUsuarios();
    ResponseEntity<User> actualizarUser(Long uid, User u);
    User unUser(Long uid);
    void eliminarUser(Long uid);

}
