package com.gaurav.jpa.hibernate.foodproject.repository.controller;


import com.gaurav.jpa.hibernate.foodproject.repository.entities.MenuInstance;
import com.gaurav.jpa.hibernate.foodproject.repository.exceptions.MenuInstanceException;
import com.gaurav.jpa.hibernate.foodproject.repository.messages.ResponseMessage;
import com.gaurav.jpa.hibernate.foodproject.repository.services.MenuInstanceService;
import com.gaurav.jpa.hibernate.foodproject.repository.services.MenuPdfGeneratorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/kitchen")
public class MenuInstanceController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MenuInstanceService menuInstanceService;

    @Autowired
    MenuPdfGeneratorService menuPdfGeneratorService;

    @GetMapping("/menu/all")
    public List<MenuInstance> retrieveMenus() {
        List<MenuInstance> menuInstances = menuInstanceService.getAllMenus();
        return menuInstances;
    }

    @GetMapping("/menu/keyword")
    public List<MenuInstance> retrieveMenu(@RequestParam String menuName) {
        List<MenuInstance> menuInstances = menuInstanceService.getMenusByKeyword(menuName);
        return menuInstances;
    }

    @GetMapping("/menu/type_date")
    public MenuInstance retrieveMenuByTypeAndForDate(@RequestParam("menuType") String menuType,
                                                     @RequestParam("menuForDate")
                                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate menuForDate) {
        MenuInstance menuInstances = menuInstanceService.getMenusByTypeAndForDate(menuType, menuForDate);
        return menuInstances;
    }

    @PostMapping("/menu")
    public ResponseEntity<ResponseMessage> addMenu(@Valid @RequestBody MenuInstance menu) {
        MenuInstance menuInstance = menu;
        MenuInstance existingMenuInstance = menuInstanceService.getMenusByTypeAndForDate(menuInstance.getMenuType(), menuInstance.getMenuForDate());
        if (existingMenuInstance != null)
            throw new MenuInstanceException("Menu type already exist for the given date");
        menuInstance = menuInstanceService.saveOrUpdateMenu(menu);
        ResponseMessage responseMessage = new ResponseMessage("Saved a new Menu", "Save", menuInstance.getId(), "Menu");
        return new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.CREATED);
    }

    @PutMapping("/menu")
    public ResponseEntity<ResponseMessage> updateMenu(@RequestBody MenuInstance menu) {
        menuInstanceService.saveOrUpdateMenu(menu);
        ResponseMessage responseMessage = new ResponseMessage("Updated a new Menu", "Update", menu.getId(), "Menu");
        return new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.CREATED);
    }

    @DeleteMapping("/menu")
    public ResponseEntity<ResponseMessage> deleteMenu(@RequestParam Long menuId) {
        try {
            menuInstanceService.deleteMenuAndItems(menuId);
        } catch (Exception exp) {
            throw new MenuInstanceException("Wrong Menu id sent for deletion::" + menuId);
        }
        ResponseMessage responseMessage = new ResponseMessage("Deleted a Menu", "Delete", menuId, "Menu");
        return new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.CREATED);
    }

    @GetMapping(value = "/menu/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> getMenuPdf() {
        var headers = new HttpHeaders();
        ByteArrayInputStream menuPdf;
        List<MenuInstance> menuInstances = menuInstanceService.getAllMenus();
        headers.add("Content-Disposition", "inline; filename=Menu.pdf");  // attachment
        menuPdf = menuPdfGeneratorService.generateMenuWithMenuItems(menuInstances.get(0));
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(menuPdf));
    }


}
