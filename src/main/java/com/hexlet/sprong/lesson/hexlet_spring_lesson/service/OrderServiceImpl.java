package com.hexlet.sprong.lesson.hexlet_spring_lesson.service;

import com.hexlet.sprong.lesson.hexlet_spring_lesson.dao.OrderRepository;
import com.hexlet.sprong.lesson.hexlet_spring_lesson.model_entity.Car;
import com.hexlet.sprong.lesson.hexlet_spring_lesson.model_entity.Order;
import com.hexlet.sprong.lesson.hexlet_spring_lesson.model_entity.Status;
import com.hexlet.sprong.lesson.hexlet_spring_lesson.model_entity.User;

public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepository;
    UserService userService;
    private CarService carService;

    public OrderServiceImpl(OrderRepository orderRepository, UserService userService, CarService carService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.carService = carService;
    }

    @Override
    public void createOrder(Long userId) {
        Order order = new Order();
        User user = userService.findUserById(userId);
        order.setUser(user);
        order.setStatus(Status.START);
        orderRepository.save(order);
    }

    @Override
    public void handleCarInProd(Long orderId, Long carId) {
        Order order = orderRepository.findOrderById(orderId);
        Car car = carService.getCarById(carId);
        car.setOrder(order);
        order.setCar(car);
        order.setStatus(Status.CAR_IN_PRODUCTION);
        orderRepository.save(order);
    }

    @Override
    public void handleCarProdCompleted(Long carId) {
        Car car = carService.getCarById(carId);
        Order order = orderRepository.findOrderByCar(car);
        order.setStatus(Status.CAR_PROD_COMPLETED);
        orderRepository.save(order);
    }

    @Override
    public void handleCarDelivered(Long carId) {
        Car car = carService.getCarById(carId);
        Order order = orderRepository.findOrderByCar(car);
        order.setStatus(Status.CAR_DELIVERED);
        orderRepository.save(order);
    }

    @Override
    public void handleFinish(Long carId) {
        Car car = carService.getCarById(carId);
        Order order = orderRepository.findOrderByCar(car);
        order.setStatus(Status.FINISH);
        orderRepository.save(order);
    }
}
