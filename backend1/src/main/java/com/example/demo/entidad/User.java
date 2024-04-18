package com.example.demo.entidad;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name="USUARIO")
public class User {
    @Id
    @Column(name = "ID_USER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;
    @Column(name = "NOMBRE")
    private String nom;
    @Column(name = "APELLIDO")
    private String ape;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "TELEFONO")
    private Long tel;

    /* @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "ID_USER", joinColumns = {@JoinColumn(name = "ID_USER")},
            inverseJoinColumns = {@JoinColumn(name = "ID_PRESTAMOFIN")})
    private List<PrestamoFin> prestamos;

     @Enumerated(EnumType.STRING)
     @Column(name = "ROL")
     private UserRol rol;

     private boolean activo   /* @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
     @JoinTable(name = "users_roles", joinColumns = {@JoinColumn(name = "ID_USER")},
             inverseJoinColumns = {@JoinColumn(name = "id_rol")})
     private List<Rol> roles;

 */
    public User(){

    }

    public User(Long uid, String nom, String ape, String email, Long tel) {
        this.uid = uid;
        this.nom = nom;
        this.ape = ape;
        this.email = email;
        this.tel = tel;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApe() {
        return ape;
    }

    public void setApe(String ape) {
        this.ape = ape;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }
}