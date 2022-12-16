package com.hexlet.sprong.lesson.hexlet_spring_lesson.config;

import com.hexlet.sprong.lesson.hexlet_spring_lesson.dao.CarRepository;
import com.hexlet.sprong.lesson.hexlet_spring_lesson.dao.OrderRepository;
import com.hexlet.sprong.lesson.hexlet_spring_lesson.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IntroAppConfig {

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }
    @Bean
    public CarService carService(CarRepository carRepository, UserService userService) {
        return new CarServiceImpl(carRepository, userService);
    }
    @Bean
    public OrderService orderService(OrderRepository orderRepository, UserService userService, CarService carService) {
        return new OrderServiceImpl(orderRepository , userService, carService);
    }
}
