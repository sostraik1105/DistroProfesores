package com.sostraik1903.distroprofes_v3.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "curso")
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCurso;

    @Column
    private String nombre;

    @Column
    private Integer numAlumnos;

    @Column
    private Integer duracion;

    @ManyToMany
    @JoinTable(
            name = "profesores_curso",
            joinColumns = @JoinColumn(name = "idCurso"),
            inverseJoinColumns = @JoinColumn(name = "idProfesor")
    )
    Set<Profesor> profesores = new HashSet<>();

    public Curso() {
    }

    public Curso(Integer idCurso, String nombre, Integer numAlumnos, Integer duracion) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.numAlumnos = numAlumnos;
        this.duracion = duracion;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumAlumnos() {
        return numAlumnos;
    }

    public void setNumAlumnos(Integer numAlumnos) {
        this.numAlumnos = numAlumnos;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Set<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(Set<Profesor> profesores) {
        this.profesores = profesores;
    }
}
