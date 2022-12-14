package com.hexlet.sprong.lesson.hexlet_spring_lesson.controller;

import com.hexlet.sprong.lesson.hexlet_spring_lesson.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1.0/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/")
    public String createOrder() {

    }
}
