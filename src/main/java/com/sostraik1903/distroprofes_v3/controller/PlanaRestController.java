package com.sostraik1903.distroprofes_v3.controller;

import com.sostraik1903.distroprofes_v3.entity.Plana;
import com.sostraik1903.distroprofes_v3.mapper.PlanaMapper;
import com.sostraik1903.distroprofes_v3.service.PlanaService;
import com.sostraik1903.distroprofes_v3.util.UtilMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/planas")
public class PlanaRestController {
    @Autowired
    private PlanaService planaService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET(){
        Collection<Plana> collection = planaService.findAll();

        Collection<PlanaMapper> collectionMapper = UtilMappers.toPlana(collection);

        if(collection.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(collectionMapper, HttpStatus.OK);
        }
    }

    @GetMapping("/buscar/{idPlana}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer idPlana){
        Plana planaDb = planaService.findById(idPlana);

        PlanaMapper planaMapper = new PlanaMapper(planaDb);

        if(planaDb != null){
            return new ResponseEntity<>(planaMapper, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody Plana plana){
        planaService.create(plana);
        return new ResponseEntity<>(plana ,HttpStatus.CREATED);
    }

    @PutMapping("/editar/{idPlana}")
    public ResponseEntity<?> atualizar_PUT(
            @RequestBody Plana planaEditada,
            @PathVariable Integer idPlana
    ){
        Plana planaDb = planaService.findById(idPlana);

        if(planaDb != null){
            planaDb.setEspecialidad(planaEditada.getEspecialidad());

            planaService.update(planaDb);

            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Plana no encontrada", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{idPlana}")
    public ResponseEntity<?> eliminar_DELETE(@PathVariable Integer idPlana){
        Plana planaDb = planaService.findById(idPlana);

        if(planaDb != null){
            planaService.delete(idPlana);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error, no dictamos este curso", HttpStatus.NOT_FOUND);
        }
    }
}
