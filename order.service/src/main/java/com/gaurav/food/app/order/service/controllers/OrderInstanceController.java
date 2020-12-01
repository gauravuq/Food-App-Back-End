package com.gaurav.food.app.order.service.controllers;

import com.gaurav.food.app.order.service.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class OrderInstanceController {

    @Autowired
    Configuration configuration;

    @PostMapping("/order/create")
    public void createOrder(String paramOne) {
        return;
    }

    @GetMapping("/order/get/{orderId}")
    public void getOrderById() {
        return;
    }

    @GetMapping("/order/get/all/{customerEmail}")
    public void getAllOrders() {
        return;
    }

    @DeleteMapping("/order/remove/{orderId}")
    public void removeOrder() {
        return;
    }

    @GetMapping("/order/configuration")
    public String getConfiguration() {
        return configuration.getMax().toString();
    }

}
