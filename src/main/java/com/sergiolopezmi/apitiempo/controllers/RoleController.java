package com.sergiolopezmi.apitiempo.controllers;

import com.sergiolopezmi.apitiempo.entities.Role;
import com.sergiolopezmi.apitiempo.pojos.RolePojo;
import com.sergiolopezmi.apitiempo.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/roles")
public class RoleController {
    @Autowired
    RoleRepository roleRepository;

    @GetMapping
    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }

    @PostMapping
    public ResponseEntity saveNewRole(@RequestBody RolePojo roleIn) {
        if(roleIn.getRoleName() != null){
            roleIn.setRoleName(roleIn.getRoleName().toUpperCase());
            return ResponseEntity.ok()
                    .body(roleRepository.save(roleIn));
        }
        return ResponseEntity.badRequest()
                .body("Nombre no informado correctamente");
    }
}
