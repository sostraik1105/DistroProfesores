package com.sostraik1903.distroprofes_v3.controller;

import com.sostraik1903.distroprofes_v3.entity.Curso;
import com.sostraik1903.distroprofes_v3.entity.CursoProfesor;
import com.sostraik1903.distroprofes_v3.entity.Profesor;
import com.sostraik1903.distroprofes_v3.service.CursoService;
import com.sostraik1903.distroprofes_v3.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/curso_profe")
public class CursoProfesorRestController {
    @Autowired
    private ProfesorService profesorService;

    @Autowired
    private CursoService cursoService;

    public CursoProfesorRestController() {
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody CursoProfesor cursoProfesor){
        Curso cursoDb = cursoService.findById(cursoProfesor.getCurso().getIdCurso());

        if(cursoDb != null){
            Profesor profesorDb = profesorService.findById(cursoProfesor.getProfesor().getIdProfesor());

            if(profesorDb != null){
                cursoDb.addProfesor(profesorDb);
                cursoService.update(cursoDb);

                return new ResponseEntity<>("curso x profesor registrado", HttpStatus.OK);
            }

            return new ResponseEntity<>("Profesor no existe",HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Curso no existe",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET(){
        Collection<Object[]> collection = cursoService.findAllWithProfesores();

        if(collection.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(collection, HttpStatus.OK);
        }
    }
}
