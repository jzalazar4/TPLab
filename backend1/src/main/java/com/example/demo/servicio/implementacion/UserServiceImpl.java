package com.example.demo.servicio.implementacion;

import com.example.demo.entidad.User;
import com.example.demo.repositorio.UserRepo;
import com.example.demo.servicio.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

   private UserRepo userRepo;
   @Autowired
   public UserServiceImpl(UserRepo userRepo){
       this.userRepo = userRepo;
   }
    @Override
    public User guardarUser(User u) {
        return userRepo.save(u);
    }

    @Override
    public List<User> verUsuarios() {
        return userRepo.findAll();
    }

    @Override
    public ResponseEntity<User> actualizarUser(Long uid, User u) {

            return userRepo.findById(uid)
                    .map(user -> {
                        user.setNom(u.getNom());
                        user.setApe(u.getApe());
                        user.setTel(u.getTel());
                        user.setEmail(u.getEmail());

                        User nuevo = userRepo.save(user);
                        return ResponseEntity.ok(nuevo);
                    })
                    .orElse(ResponseEntity.notFound().build());

    }

    @Override
    public User unUser(Long uid) {
        return userRepo.findById(uid).orElse(null);
    }

    @Override
    public void eliminarUser(Long uid) {
        userRepo.deleteById(uid);
    }
}
