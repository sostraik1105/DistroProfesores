package com.sostraik1903.distroprofes_v3.entity;

public class CursoProfesor {
    private Curso curso;
    private Profesor profesor;

    public CursoProfesor() {
    }

    public CursoProfesor(Curso curso, Profesor profesor) {
        this.curso = curso;
        this.profesor = profesor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}
