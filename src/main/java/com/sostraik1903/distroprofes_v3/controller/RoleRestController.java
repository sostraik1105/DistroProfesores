package com.sostraik1903.distroprofes_v3.controller;

import com.sostraik1903.distroprofes_v3.entity.RoleVO;
import com.sostraik1903.distroprofes_v3.mapper.RoleMapper;
import com.sostraik1903.distroprofes_v3.service.RolService;
import com.sostraik1903.distroprofes_v3.util.UtilMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/roles")
public class RoleRestController {
    @Autowired
    private RolService rolService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET(){
        Collection<RoleVO> collection = rolService.findAll();

        Collection<RoleMapper> collectionMapper = UtilMappers.toRole(collection);

        if(collection.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(collectionMapper, HttpStatus.OK);
        }

    }

    @GetMapping("/buscar/{roleId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer roleId){
        RoleVO roleDb = rolService.findById(roleId);

        RoleMapper userMapper = new RoleMapper(roleDb);

        if(roleDb != null){
            return new ResponseEntity<>(userMapper, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody RoleVO roleVO){
        rolService.create(roleVO);
        return new ResponseEntity<>(roleVO ,HttpStatus.CREATED);
    }

    @PutMapping("/editar/{roleId}")
    public ResponseEntity<?> editar_PUT(
            @RequestBody RoleVO rolEditado,
            @PathVariable Integer roleId
    ){
        RoleVO roleDb = rolService.findById(roleId);

        if(roleDb != null){
            roleDb.setRole(rolEditado.getRole());

            rolService.update(roleDb);

            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error, no registrado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{roleId}")
    public ResponseEntity<?> eliminar_DELETE(@PathVariable Integer roleId){
        RoleVO roleDb = rolService.findById(roleId);
        if(roleDb != null){
            rolService.delete(roleId);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error, no registrado", HttpStatus.NOT_FOUND);
        }
    }
}
