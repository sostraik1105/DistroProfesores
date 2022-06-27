package com.sostraik1903.distroprofes_v3.controller;

import com.sostraik1903.distroprofes_v3.entity.Encargado;
import com.sostraik1903.distroprofes_v3.mapper.EncargadoMapper;
import com.sostraik1903.distroprofes_v3.service.EncargadoService;
import com.sostraik1903.distroprofes_v3.util.UtilMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/encargados")
public class EncargadoRestController {

    @Autowired
    private EncargadoService encargadoService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET(){
        Collection<Encargado> collection = encargadoService.findAll();

        Collection<EncargadoMapper> collectionMapper = UtilMappers.toEncargado(collection);

        if(collection.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(collectionMapper, HttpStatus.OK);
        }
    }

    @GetMapping("/buscar/{encargadoId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer encargadoId){
        Encargado encargadoDb = encargadoService.findById(encargadoId);

        EncargadoMapper encargadoMapper = new EncargadoMapper(encargadoDb);

        if(encargadoDb != null){
            return new ResponseEntity<>(encargadoMapper, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody Encargado encargado){
        encargadoService.create(encargado);
        return new ResponseEntity<>(encargado ,HttpStatus.CREATED);
    }

    @PutMapping("/editar/{idEncargado}")
    public ResponseEntity<?> editar_PUT(
            @RequestBody Encargado encargadoEditado,
            @PathVariable Integer idEncargado
    ){
        Encargado encargadodb = encargadoService.findById(idEncargado);

        if(encargadodb != null){
            encargadodb.setPlana(encargadoEditado.getPlana());
            encargadodb.setProfesor(encargadoEditado.getProfesor());
            encargadoService.update(encargadodb);

            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error, no registrado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{idEncargado}")
    public ResponseEntity<?> eliminar_DELETE(@PathVariable Integer idEncargado){
        Encargado encargadodb = encargadoService.findById(idEncargado);
        if(encargadodb != null){
            encargadoService.delete(idEncargado);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error, no registrado", HttpStatus.NOT_FOUND);
        }
    }

}
