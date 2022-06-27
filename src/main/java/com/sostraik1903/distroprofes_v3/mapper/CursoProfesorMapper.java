package com.sostraik1903.distroprofes_v3.mapper;

import com.sostraik1903.distroprofes_v3.entity.CursoProfesor;

public class CursoProfesorMapper {
    private Integer idCurso;
    private String nombreCurso;
    private Integer idProfesor;
    private String nombreProfe;

    public CursoProfesorMapper() {
    }

    public CursoProfesorMapper(Integer idCurso, String nombreCurso, Integer idProfesor, String nombreProfe) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.idProfesor = idProfesor;
        this.nombreProfe = nombreProfe;
    }

    public CursoProfesorMapper(CursoProfesor cursoProfesor){
        this(cursoProfesor.getCurso().getIdCurso(),
                cursoProfesor.getCurso().getNombre(),
                cursoProfesor.getProfesor().getIdProfesor(),
                cursoProfesor.getCurso().getNombre());
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombreProfe() {
        return nombreProfe;
    }

    public void setNombreProfe(String nombreProfe) {
        this.nombreProfe = nombreProfe;
    }
}
