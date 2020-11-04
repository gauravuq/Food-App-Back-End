package com.gaurav.jpa.hibernate.foodproject.repository.repositories;

import com.gaurav.jpa.hibernate.foodproject.repository.entities.MenuInstance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuInstanceRepo extends JpaRepository<MenuInstance,Long> {
}
