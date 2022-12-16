package com.hexlet.sprong.lesson.hexlet_spring_lesson.controller;

import com.hexlet.sprong.lesson.hexlet_spring_lesson.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1.0/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/")
    public String createOrder(@RequestParam("user_id") Long userId) {
        orderService.createOrder(userId);
        return "OK";
    }
    @PutMapping("{order_id}/status/car_in_prod")
    public String handleCarInProd(@PathVariable("order_id") Long orderId, @RequestParam("car_id") Long carId) {
        orderService.handleCarInProd(orderId, carId);
        return "OK";
    }
    @PutMapping("/status/car_prod_completed")
    public String handleCarProdCompleted(@RequestParam("car_id") Long carId) {
        orderService.handleCarProdCompleted(carId);
        return "OK";
    }
    @PutMapping("/status/car_delivered")
    public String handleCarDelivered(@RequestParam("car_id") Long carId) {
        orderService.handleCarDelivered(carId);
        return "OK";
    }
    @PutMapping("/status/finish")
    public String handleFinish(@RequestParam("car_id") Long carId) {
        orderService.handleFinish(carId);
        return "OK";
    }

}
