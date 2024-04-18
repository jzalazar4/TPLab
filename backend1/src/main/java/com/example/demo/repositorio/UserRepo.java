package com.example.demo.repositorio;

import com.example.demo.entidad.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
   // @Query("SELECT u FROM User u WHERE u.username = :username ")
   // Optional<User> findUserByUsername(@Param("username") String username);

    //@Query("SELECT u FROM User u WHERE u.email = :email ")
    //Optional<User> findUserByEmail(@Param("email")String email);

    //@Query("SELECT u FROM User u WHERE u.username = :username ")
    //boolean existsUserByUsername(String username);
}
