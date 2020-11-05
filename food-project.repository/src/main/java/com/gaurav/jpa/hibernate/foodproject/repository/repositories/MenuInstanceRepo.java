package com.gaurav.jpa.hibernate.foodproject.repository.repositories;

import com.gaurav.jpa.hibernate.foodproject.repository.entities.MenuInstance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// no need for transaction annotation
public interface MenuInstanceRepo extends JpaRepository<MenuInstance,Long> {
    public List<MenuInstance> findByMenuNameContains(String menuName);

}
