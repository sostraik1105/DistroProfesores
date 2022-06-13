package com.sostraik1903.distroprofes_v3.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "profesor")
public class Profesor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProfesor;

    @Column
    private String nombres;

    @Column
    private String apellidoPat;

    @Column
    private String apellidoMat;

    @Column(unique = true, nullable = false)
    private String email;

    @Column
    private String telefono;

    @Column
    private Integer edad;

    @DateTimeFormat(pattern = "yyyy-MM-dd", iso= DateTimeFormat.ISO.DATE)
    private LocalDate fecContrato;

    @OneToOne(mappedBy = "profesor")
    private Encargado encargado;

    @ManyToMany(mappedBy = "profesores")
    private Set<Curso> cursos = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "idPlana", nullable = false)
    private Plana plana;

    public Profesor() {
    }

    public Profesor(Integer idProfesor, String nombres, String apellidoPat, String apellidoMat, String email, String telefono, Integer edad, LocalDate fecContrato) {
        this.idProfesor = idProfesor;
        this.nombres = nombres;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.email = email;
        this.telefono = telefono;
        this.edad = edad;
        this.fecContrato = fecContrato;
    }

    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPat() {
        return apellidoPat;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    public String getApellidoMat() {
        return apellidoMat;
    }

    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public LocalDate getFecContrato() {
        return fecContrato;
    }

    public void setFecContrato(LocalDate fecContrato) {
        this.fecContrato = fecContrato;
    }

    public Encargado getEncargado() {
        return encargado;
    }

    public void setEncargado(Encargado encargado) {
        this.encargado = encargado;
    }

    public Set<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }

    public Plana getPlana() {
        return plana;
    }

    public void setPlana(Plana plana) {
        this.plana = plana;
    }
}
