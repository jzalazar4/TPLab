package com.example.demo.entidad;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name="LIBROS")
public class Libro {

    @Id
    @Column(name = "ID_LIBRO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lid;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "AUTOR")
    private String autor;

    @Column(name = "PAGINAS")
    private Integer pag;

    @Column(name = "GENERO")
    private String genero;

    @Column(name = "SINOPSIS")
    private String sinopsis;
    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "F.PUBLICACION")
    private LocalDate fecha;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "ID_LIBROS", joinColumns = {@JoinColumn(name = "ID_LIBRO")},
            inverseJoinColumns = {@JoinColumn(name = "ID_PRESTAMOFIN")})
    private List<PrestamoFin> prestamos;


    public Libro(){

    }

    public Libro(Long lid, String titulo, String autor, Integer pag, String genero, String sinopsis, String estado, LocalDate fecha) {
        this.lid = lid;
        this.titulo = titulo;
        this.autor = autor;
        this.pag = pag;
        this.genero = genero;
        this.sinopsis = sinopsis;
        this.estado = estado;
        this.fecha = fecha;

    }


    public Long getLid() {
        return lid;
    }

    public void setLid(Long lid) {
        this.lid = lid;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getPag() {
        return pag;
    }

    public void setPag(Integer pag) {
        this.pag = pag;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
