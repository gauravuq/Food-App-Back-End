package com.gaurav.jpa.hibernate.foodproject.repository.controller;


import com.gaurav.jpa.hibernate.foodproject.repository.entities.MenuInstance;
import com.gaurav.jpa.hibernate.foodproject.repository.repositories.MenuInstanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menuinstance")
public class MenuInstanceController {

    @Autowired
    MenuInstanceRepo menuInstanceRepo;

    @GetMapping("/all/menu")
    public List<MenuInstance> retrieveAllUsers(){
        List<MenuInstance> menuInstances = 	menuInstanceRepo.findAll();
        return menuInstances;
    }

    @PostMapping("/menu")
    public ResponseEntity<String> addMenu(@RequestBody MenuInstance menuInstance){
        menuInstanceRepo.save(menuInstance);
        return new ResponseEntity<>("Success!! Added a New Menu", HttpStatus.CREATED)  ;
    }
    

}
