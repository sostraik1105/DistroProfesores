package com.sostraik1903.distroprofes_v3.mapper;

import com.sostraik1903.distroprofes_v3.entity.Curso;

public class CursoMapper {
    private Integer idCurso;
    private String nombre;
    private Integer numAlumnos;
    private Integer duracion;

    public CursoMapper() {
    }

    public CursoMapper(Integer idCurso, String nombre, Integer numAlumnos, Integer duracion) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.numAlumnos = numAlumnos;
        this.duracion = duracion;
    }

    public CursoMapper(Curso curso){
        this(curso.getIdCurso(), curso.getNombre(), curso.getNumAlumnos(), curso.getDuracion());
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
}
