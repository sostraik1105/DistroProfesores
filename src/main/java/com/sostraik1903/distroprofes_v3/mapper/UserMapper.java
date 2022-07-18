package com.sostraik1903.distroprofes_v3.mapper;

import com.sostraik1903.distroprofes_v3.entity.UserVO;

public class UserMapper {
    private Integer userId;
    private String username;
    private String nombre;
    private String apellidos;
    private String email;
    private String celular;

    public UserMapper() {
    }

    public UserMapper(Integer userId, String username, String nombre, String apellidos, String email, String celular) {
        this.userId = userId;
        this.username = username;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.celular = celular;
    }

    public UserMapper(UserVO userVO){
        this(
            userVO.getUserId(),
            userVO.getUsername(),
            userVO.getNombre(),
            userVO.getApellidos(),
            userVO.getEmail(),
            userVO.getCelular()
        );
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
