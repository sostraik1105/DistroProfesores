package com.sostraik1903.distroprofes_v3.mapper;

import com.sostraik1903.distroprofes_v3.entity.Plana;

public class PlanaMapper {
    private Integer idPlana;
    private String especialidad;

    public PlanaMapper() {
    }

    public PlanaMapper(Integer idPlana, String especialidad) {
        this.idPlana = idPlana;
        this.especialidad = especialidad;
    }

    public PlanaMapper(Plana plana) {
        this(plana.getIdPlana(), plana.getEspecialidad());
    }


    public Integer getIdPlana() {
        return idPlana;
    }

    public void setIdPlana(Integer idPlana) {
        this.idPlana = idPlana;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
