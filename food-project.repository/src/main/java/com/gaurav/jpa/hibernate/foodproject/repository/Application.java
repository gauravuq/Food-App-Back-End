package com.gaurav.jpa.hibernate.foodproject.repository;

import com.gaurav.jpa.hibernate.foodproject.repository.entities.MenuInstance;
import com.gaurav.jpa.hibernate.foodproject.repository.entities.MenuItemInstance;
import com.gaurav.jpa.hibernate.foodproject.repository.repositories.MenuInstanceRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(Application.class);

	@Autowired
	MenuInstanceRepo menuInstanceRepo;

	@Autowired
	RestTemplateBuilder restTemplateBuilder;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Starting Food Project's Back-End");
//		Optional<MenuInstance> menuInstance = menuInstanceRepo.findById(1000L);
//		logger.info("{}",menuInstance.get());
		// find and delete one instance of MenuInstance
		//menuRepoSpringData.delete(menuInstance.get());
		// find every instance MenuInstance
		List<MenuInstance> menuInstances = 	menuInstanceRepo.findAll();
		System.out.println(menuInstances);
		// delete every instance of MenuInstance
		//menuRepoSpringData.deleteAll(menuInstances);
		// create a MenuInstance and save it
		MenuItemInstance item1 = new MenuItemInstance("Item 3","I7","Amit","N/A");
		MenuItemInstance item2 = new MenuItemInstance("Item 4","I8","Shakti","N/A");

		MenuInstance menuInstance1 = new MenuInstance("BaraKahna 2","Amit","N/A");
		menuInstance1.addMenuItemInstance(item1);
		menuInstance1.addMenuItemInstance(item2);
		menuInstanceRepo.save(menuInstance1);
	}


}

