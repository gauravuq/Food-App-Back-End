package com.gaurav.jpa.hibernate.foodproject.repository.repositories;

import com.gaurav.jpa.hibernate.foodproject.repository.entities.MenuItemInstance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemInstanceRepo extends JpaRepository<MenuItemInstance, Long> {
}
