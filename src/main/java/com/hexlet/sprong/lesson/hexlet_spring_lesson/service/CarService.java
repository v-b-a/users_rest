package com.hexlet.sprong.lesson.hexlet_spring_lesson.service;

import com.hexlet.sprong.lesson.hexlet_spring_lesson.pojo_dto.CarDto;

public interface CarService {
    void createCar(CarDto carDto, Long userUd);
}
