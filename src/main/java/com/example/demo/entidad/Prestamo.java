package com.example.demo.entidad;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.io.Serializable;
import java.util.Date;
import java.util.function.Consumer;

@Data
@Entity
@Table(name="PRESTAMO")
public class Prestamo {

    @Id
    @Column(name = "ID_PRESTAMO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    @Column(name = "ESTADO")
    private String estado;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "FECHA_INICIO")
    private Date finicio;



    // datos usuario y libro

    @Column(name = "ID-USER")
    private Long id_user;

    @Column(name = "ID-LIBROS")
    private Long id_libro;


    public Prestamo(){

    }

    public Prestamo(Long pid, String estado, Date finicio, Long id_user, Long id_libro) {
        this.pid = pid;
        this.estado = estado;
        this.finicio = finicio;
        this.id_user = id_user;
        this.id_libro = id_libro;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFinicio() {
        return finicio;
    }

    public void setFinicio(Date finicio) {
        this.finicio = finicio;
    }


    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public Long getId_libro() {
        return id_libro;
    }

    public void setId_libro(Long id_libro) {
        this.id_libro = id_libro;
    }
}
