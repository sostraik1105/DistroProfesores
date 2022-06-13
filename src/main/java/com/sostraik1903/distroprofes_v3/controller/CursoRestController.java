package com.sostraik1903.distroprofes_v3.controller;

import com.sostraik1903.distroprofes_v3.entity.Curso;
import com.sostraik1903.distroprofes_v3.mapper.CursoMapper;
import com.sostraik1903.distroprofes_v3.service.CursoService;
import com.sostraik1903.distroprofes_v3.util.UtilMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/cursos")
public class CursoRestController {

    @Autowired
    public CursoService cursoService;

    public CursoRestController(){};

    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET(){
        Collection<Curso> collection = cursoService.findAll();

        Collection<CursoMapper> collectionMapper = UtilMappers.toCurso(collection);

        if(collection.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(collectionMapper, HttpStatus.OK);
        }
    }

    @GetMapping("/buscar/{idCurso}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer idCurso){
        Curso cursoDb = cursoService.findById(idCurso);

        CursoMapper curso = new CursoMapper(cursoDb);


        if(cursoDb != null){
            return new ResponseEntity<>(curso, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody Curso curso){
        cursoService.create(curso);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/editar/{idCurso}")
    public ResponseEntity<?> atualizar_PUT(
            @RequestBody Curso cursoEditado,
            @PathVariable Integer idCurso
    ){
        Curso cursoDb = cursoService.findById(idCurso);

        if(cursoDb != null){
            cursoDb.setNombre(cursoEditado.getNombre());
            cursoDb.setNumAlumnos(cursoEditado.getNumAlumnos());
            cursoDb.setDuracion(cursoEditado.getDuracion());

            cursoService.update(cursoDb);

            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error, no dictamos este curso", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{idCurso}")
    public ResponseEntity<?> eliminar_DELETE(@PathVariable Integer idCurso){
        Curso cursoDb = cursoService.findById(idCurso);

        if(cursoDb != null){
            cursoService.delete(idCurso);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error, no dictamos este curso", HttpStatus.NOT_FOUND);
        }
    }
}
