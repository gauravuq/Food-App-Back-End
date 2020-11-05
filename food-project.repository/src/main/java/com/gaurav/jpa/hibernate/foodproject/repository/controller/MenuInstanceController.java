package com.gaurav.jpa.hibernate.foodproject.repository.controller;


import com.gaurav.jpa.hibernate.foodproject.repository.entities.MenuInstance;
import com.gaurav.jpa.hibernate.foodproject.repository.repositories.MenuInstanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kitchen")
public class MenuInstanceController {

    @Autowired
    MenuInstanceRepo menuInstanceRepo;

    @GetMapping("/menu/all")
    public List<MenuInstance> retrieveMenus(){
        List<MenuInstance> menuInstances = 	menuInstanceRepo.findAll();
        return menuInstances;
    }

    @GetMapping("/menu")
    public List<MenuInstance> retrieveMenu( @RequestParam String menuName){
        List<MenuInstance> menuInstances = 	menuInstanceRepo.findByMenuNameContains(menuName);
        return menuInstances;
    }

    @PostMapping("/menu")
    public ResponseEntity<String> addMenu(@RequestBody MenuInstance menuInstance){
        menuInstanceRepo.save(menuInstance);
        return new ResponseEntity<>("Success!! Added a New Menu", HttpStatus.CREATED)  ;
    }

    @PutMapping("/menu")
    public ResponseEntity<String> updateMenu(@RequestBody MenuInstance menuInstance){
        menuInstanceRepo.save(menuInstance);
        return new ResponseEntity<>("Success!! Updated a Menu", HttpStatus.CREATED)  ;
    }

    @DeleteMapping ("/menu")
    public ResponseEntity<String> deleteMenu(@RequestParam Long menuId){
        menuInstanceRepo.deleteById(menuId);
        return new ResponseEntity<>("Success!! Deleted a Menu", HttpStatus.CREATED)  ;
    }


}
