package com.sostraik1903.distroprofes_v3.controller;

import com.sostraik1903.distroprofes_v3.entity.UserVO;
import com.sostraik1903.distroprofes_v3.mapper.UserMapper;
import com.sostraik1903.distroprofes_v3.service.UserService;
import com.sostraik1903.distroprofes_v3.util.UtilMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UsersRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET(){
        Collection<UserVO> collection = userService.findAll();

        Collection<UserMapper> collectionMapper = UtilMappers.toUsers(collection);

        if(collection.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(collectionMapper, HttpStatus.OK);
        }

    }

    @GetMapping("/buscar/{userId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer userId){
        UserVO userDb = userService.findById(userId);

        UserMapper userMapper = new UserMapper(userDb);

        if(userDb != null){
            return new ResponseEntity<>(userMapper, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody UserVO userVO){
        userService.create(userVO);
        return new ResponseEntity<>(userVO ,HttpStatus.CREATED);
    }

    @PutMapping("/editar/{userId}")
    public ResponseEntity<?> editar_PUT(
            @RequestBody UserVO userEditado,
            @PathVariable Integer userId
    ){
        UserVO userDb = userService.findById(userId);

        // Para actualizar y encriptar...
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hash = passwordEncoder.encode(userDb.getPassword());

        if(userDb != null){
            userDb.setUsername(userEditado.getUsername());
            userDb.setPassword(hash);
            userDb.setCelular(userEditado.getCelular());
            userDb.setEmail(userEditado.getEmail());

            userService.update(userDb);

            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error, no registrado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{userId}")
    public ResponseEntity<?> eliminar_DELETE(@PathVariable Integer userId){
        UserVO userDb = userService.findById(userId);
        if(userDb != null){
            userService.delete(userId);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error, no registrado", HttpStatus.NOT_FOUND);
        }
    }
}
