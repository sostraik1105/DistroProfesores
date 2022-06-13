package com.sostraik1903.distroprofes_v3.mapper;

import com.sostraik1903.distroprofes_v3.entity.Encargado;

public class EncargadoMapper {
    private Integer idEncargado;
    private String plana;
    private String profesor;

    public EncargadoMapper() {}

    public EncargadoMapper(Integer idEncargado, String plana, String profesor) {
        this.idEncargado = idEncargado;
        this.plana = plana;
        this.profesor = profesor;
    }

    public EncargadoMapper(Encargado encargado) {
        this(encargado.getIdEncargado(), encargado.getPlana().getEspecialidad(), encargado.getProfesor().getEmail());
    }

    public Integer getIdEncargado() {
        return idEncargado;
    }

    public void setIdEncargado(Integer idEncargado) {
        this.idEncargado = idEncargado;
    }

    public String getPlana() {
        return plana;
    }

    public void setPlana(String plana) {
        this.plana = plana;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }
}
