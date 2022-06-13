package com.sostraik1903.distroprofes_v3.mapper;

import com.sostraik1903.distroprofes_v3.entity.Plana;
import com.sostraik1903.distroprofes_v3.entity.Profesor;

import java.time.LocalDate;

public class ProfesorMapper {
    private Integer idProfesor;
    private String nombres;
    private String apellidoPat;
    private String apellidoMat;
    private String email;
    private String telefono;
    private Integer edad;
    private LocalDate fecContrato;
    private String especialidad;

    public ProfesorMapper() {
    }

    public ProfesorMapper(
            Integer idProfesor,
            String nombres,
            String apellidoPat,
            String apellidoMat,
            String email,
            String telefono,
            Integer edad,
            LocalDate fecContrato,
            String especialidad
    ) {
        this.idProfesor = idProfesor;
        this.nombres = nombres;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.email = email;
        this.telefono = telefono;
        this.edad = edad;
        this.fecContrato = fecContrato;
        this.especialidad = especialidad;
    }

    public ProfesorMapper(Profesor profesor) {
        this(profesor.getIdProfesor(),
                profesor.getNombres(),
                profesor.getApellidoPat(),
                profesor.getApellidoMat(),
                profesor.getEmail(),
                profesor.getTelefono(),
                profesor.getEdad(),
                profesor.getFecContrato(),
                profesor.getPlana().getEspecialidad()
        );
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
