package com.gaurav.jpa.hibernate.foodproject.repository.services;

import com.gaurav.jpa.hibernate.foodproject.repository.entities.MenuInstance;
import com.gaurav.jpa.hibernate.foodproject.repository.exceptions.MenuInstanceException;
import com.gaurav.jpa.hibernate.foodproject.repository.repositories.MenuInstanceRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS,scopeName ="prototype")
public class MenuInstanceService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MenuInstanceRepo menuInstanceRepo;

    public List<MenuInstance> getAllMenus() {
        List<MenuInstance> menuInstances = menuInstanceRepo.findAll();
        return menuInstances;
    }

    public List<MenuInstance> getMenusByKeyword(String keyword) {
        List<MenuInstance> menuInstances = menuInstanceRepo.findByMenuNameContains(keyword);
        return menuInstances;
    }

    public MenuInstance saveOrUpdateMenu(MenuInstance menuInstance) {
        return menuInstanceRepo.save(menuInstance);
    }

    public void deleteMenuAndItems(Long menuId) {
            menuInstanceRepo.deleteById(menuId);
    }

    public MenuInstance getMenusByTypeAndForDate(String menuType, LocalDate menuForDate) {
        return menuInstanceRepo.findByMenuTypeAndMenuForDate(menuType,menuForDate);
    }
}
