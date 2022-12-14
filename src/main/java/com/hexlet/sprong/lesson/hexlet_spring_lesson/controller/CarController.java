package com.hexlet.sprong.lesson.hexlet_spring_lesson.controller;

import com.hexlet.sprong.lesson.hexlet_spring_lesson.pojo_dto.CarDto;
import com.hexlet.sprong.lesson.hexlet_spring_lesson.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1.0")
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/cars")
    public String createCar(@RequestBody CarDto carDto, @RequestParam("user_id") Long userId) {
        carService.createCar(carDto, userId);
        return "OK";
    }
}
