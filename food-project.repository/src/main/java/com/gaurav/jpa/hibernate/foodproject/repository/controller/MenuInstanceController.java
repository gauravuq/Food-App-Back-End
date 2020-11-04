package com.gaurav.jpa.hibernate.foodproject.repository.controller;


import com.gaurav.jpa.hibernate.foodproject.repository.entities.MenuInstance;
import com.gaurav.jpa.hibernate.foodproject.repository.repositories.MenuInstanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

/*    @PostMapping("/menu")
    public RequestEntity retrieveAllUsers(){
        List<MenuInstance> menuInstances = 	menuInstanceRepo.findAll();
        return menuInstances;
    }*/

}
