package com.sostraik1903.distroprofes_v3.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "plana")
public class Plana implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlana;

    @Column
    private String especialidad;

    @OneToOne(mappedBy = "plana")
    private Encargado encargado;

    @OneToMany(mappedBy = "plana")
    private Collection<Profesor> listaProfesores = new ArrayList<>();

    public Plana() {
    }

    public Plana(Integer idPlana, String especialidad) {
        this.idPlana = idPlana;
        this.especialidad = especialidad;
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

    public Encargado getEncargado() {
        return encargado;
    }

    public void setEncargado(Encargado encargado) {
        this.encargado = encargado;
    }

    public Collection<Profesor> getListaProfesores() {
        return listaProfesores;
    }

    public void setListaProfesores(Collection<Profesor> listaProfesores) {
        this.listaProfesores = listaProfesores;
    }
}
