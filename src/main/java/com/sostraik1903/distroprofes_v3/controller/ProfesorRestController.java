package com.sostraik1903.distroprofes_v3.controller;

import com.sostraik1903.distroprofes_v3.entity.Profesor;
import com.sostraik1903.distroprofes_v3.mapper.ProfesorMapper;
import com.sostraik1903.distroprofes_v3.service.ProfesorService;
import com.sostraik1903.distroprofes_v3.util.UtilMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/profesores")
public class ProfesorRestController {

    @Autowired
    public ProfesorService profesorService;

    public ProfesorRestController(){}

    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET(){
        Collection<Profesor> collection = profesorService.findAll();

        Collection<ProfesorMapper> collectionMapper = UtilMappers.toProfesor(collection);

        if(collection.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(collectionMapper, HttpStatus.OK);
        }
    }

    @GetMapping("/buscar/{profesorId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer profesorId){
        Profesor profesorDb = profesorService.findById(profesorId);

        ProfesorMapper profesorMapper = new ProfesorMapper(profesorDb);

        if(profesorDb != null){
            return new ResponseEntity<>(profesorMapper, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody Profesor profesor){
        profesorService.create(profesor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/editar/{idProfesor}")
    public ResponseEntity<?> editar_PUT(
            @RequestBody Profesor profesorEditado,
            @PathVariable Integer idProfesor
    ){
        Profesor profesorDb = profesorService.findById(idProfesor);

        if(profesorDb != null){
            profesorDb.setTelefono(profesorEditado.getTelefono());
            profesorDb.setEmail(profesorEditado.getEmail());
            profesorDb.setPlana(profesorEditado.getPlana());
            profesorService.update(profesorDb);

            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error, no dictamos este curso", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{idProfesor}")
    public ResponseEntity<?> eliminar_DELETE(@PathVariable Integer idProfesor){
        Profesor ProfesorDb = profesorService.findById(idProfesor);

        if(ProfesorDb != null){
            profesorService.delete(idProfesor);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error, no dictamos este curso", HttpStatus.NOT_FOUND);
        }
    }
}
