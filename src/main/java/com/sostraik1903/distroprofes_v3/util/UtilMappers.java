package com.sostraik1903.distroprofes_v3.util;

import com.sostraik1903.distroprofes_v3.entity.Curso;
import com.sostraik1903.distroprofes_v3.entity.Encargado;
import com.sostraik1903.distroprofes_v3.entity.Plana;
import com.sostraik1903.distroprofes_v3.entity.Profesor;
import com.sostraik1903.distroprofes_v3.mapper.CursoMapper;
import com.sostraik1903.distroprofes_v3.mapper.EncargadoMapper;
import com.sostraik1903.distroprofes_v3.mapper.PlanaMapper;
import com.sostraik1903.distroprofes_v3.mapper.ProfesorMapper;

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
}
