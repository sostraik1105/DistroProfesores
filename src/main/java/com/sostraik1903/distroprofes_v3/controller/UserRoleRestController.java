package com.sostraik1903.distroprofes_v3.controller;

import com.sostraik1903.distroprofes_v3.entity.RoleVO;
import com.sostraik1903.distroprofes_v3.entity.UserRole;
import com.sostraik1903.distroprofes_v3.entity.UserVO;
import com.sostraik1903.distroprofes_v3.service.RolService;
import com.sostraik1903.distroprofes_v3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/user_role")
public class UserRoleRestController {
    @Autowired
    private UserService userService;

    @Autowired
    private RolService rolService;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody UserRole userRole){
            UserVO userDb = userService.findById(userRole.getUserVO().getUserId());

        if(userDb != null){
            RoleVO rolDb = rolService.findById(userRole.getRoleVO().getRoleId());

            if(rolDb != null){
                userDb.addRole(rolDb);
                userService.update(userDb);

                return new ResponseEntity<>("User x Rol registrado", HttpStatus.OK);
            }

            return new ResponseEntity<>("Rol no existe",HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Usuario no existe",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET(){
        Collection<Object[]> collection = userService.findAllWhitRole();

        if(collection.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(collection, HttpStatus.OK);
        }
    }
}
