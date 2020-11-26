package com.gaurav.food.app.order.service.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class OrderInstanceController {

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
}
