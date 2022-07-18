package com.sostraik1903.distroprofes_v3.util;

import com.sostraik1903.distroprofes_v3.entity.*;
import com.sostraik1903.distroprofes_v3.mapper.*;

import java.util.ArrayList;
import java.util.Collection;

public class UtilMappers {
    public static Collection<CursoMapper> toCurso(Collection<Curso> cursos){
        Collection<CursoMapper> mapper = new ArrayList<>();

        for(Curso curso : cursos){
            CursoMapper cursoMapper = new CursoMapper(curso);
            mapper.add(cursoMapper);
        }

        return mapper;
    }

    public static Collection<ProfesorMapper> toProfesor(Collection<Profesor> profesores){
        Collection<ProfesorMapper> mapper = new ArrayList<>();

        for(Profesor profesor : profesores){
            ProfesorMapper profesorMapper = new ProfesorMapper(profesor);
            mapper.add(profesorMapper);
        }

        return mapper;
    }

    public static Collection<PlanaMapper> toPlana(Collection<Plana> planas){
        Collection<PlanaMapper> mapper = new ArrayList<>();

        for(Plana plana : planas){
            PlanaMapper planaMapper = new PlanaMapper(plana);
            mapper.add(planaMapper);
        }

        return mapper;
    }

    public static Collection<EncargadoMapper> toEncargado(Collection<Encargado> encargados){
        Collection<EncargadoMapper> mapper = new ArrayList<>();

        for(Encargado encargado : encargados){
            EncargadoMapper encargadoMapper = new EncargadoMapper(encargado);
            mapper.add(encargadoMapper);
        }
        return mapper;
    }

    public static Collection<CursoProfesorMapper> toCursoProfesor(Collection<CursoProfesor> cursoProfesores){
        Collection<CursoProfesorMapper> mapper = new ArrayList<>();

        for(CursoProfesor cursoProfesor : cursoProfesores){
            CursoProfesorMapper cursoProfesorMapper = new CursoProfesorMapper(cursoProfesor);
            mapper.add(cursoProfesorMapper);
        }
        return mapper;
    }

    public static Collection<UserMapper> toUsers(Collection<UserVO> users){
        Collection<UserMapper> mapper = new ArrayList<>();

        for(UserVO user : users){
            UserMapper userMapper = new UserMapper(user);
            mapper.add(userMapper);
        }
        return mapper;
    }

    public static Collection<RoleMapper> toRole(Collection<RoleVO> roles){
        Collection<RoleMapper> mapper = new ArrayList<>();

        for(RoleVO role : roles){
            RoleMapper roleMapper = new RoleMapper(role);
            mapper.add(roleMapper);
        }
        return mapper;
    }
}
