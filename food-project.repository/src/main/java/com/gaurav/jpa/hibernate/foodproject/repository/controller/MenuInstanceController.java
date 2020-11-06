package com.gaurav.jpa.hibernate.foodproject.repository.controller;



import com.gaurav.jpa.hibernate.foodproject.repository.entities.MenuInstance;
import com.gaurav.jpa.hibernate.foodproject.repository.messages.ResponseMessage;
import com.gaurav.jpa.hibernate.foodproject.repository.services.MenuInstanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/kitchen")
public class MenuInstanceController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MenuInstanceService menuInstanceService;

    @GetMapping("/menu/all")
    public List<MenuInstance> retrieveMenus(){
        List<MenuInstance> menuInstances = 	menuInstanceService.getAllMenus();
        return menuInstances;
    }

    @GetMapping("/menu")
    public  List<MenuInstance> retrieveMenu( @RequestParam String menuName){
        List<MenuInstance> menuInstances = 	menuInstanceService.getMenusByKeyword(menuName);
        return menuInstances;
    }

    @PostMapping("/menu")
    public ResponseEntity<ResponseMessage> addMenu( @Valid @RequestBody MenuInstance menu){
        MenuInstance menuInstance = menuInstanceService.saveOrUpdateMenu(menu);
        ResponseMessage responseMessage = new ResponseMessage("Saved a new Menu","Save",menuInstance.getId(),"Menu");
        return new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.CREATED)  ;
    }

    @PutMapping("/menu")
    public ResponseEntity<ResponseMessage> updateMenu(@RequestBody MenuInstance menu){
        menuInstanceService.saveOrUpdateMenu(menu);
        ResponseMessage responseMessage = new ResponseMessage("Updated a new Menu","Update",menu.getId(),"Menu");
        return new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.CREATED)  ;
    }

    @DeleteMapping ("/menu")
    public ResponseEntity<ResponseMessage> deleteMenu(@RequestParam Long menuId){
        menuInstanceService.deleteMenuAndItems(menuId);
        ResponseMessage responseMessage = new ResponseMessage("Deleted a Menu","Delete",menuId,"Menu");
        return new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.CREATED)  ;
    }


}
