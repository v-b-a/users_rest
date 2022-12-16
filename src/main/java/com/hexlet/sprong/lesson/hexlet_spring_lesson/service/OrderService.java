package com.hexlet.sprong.lesson.hexlet_spring_lesson.service;

public interface OrderService {
    void createOrder(Long userId);

    void handleCarInProd(Long carId, Long orderId);

    void handleCarProdCompleted(Long carId);

    void handleCarDelivered(Long carId);

    void handleFinish(Long carId);
}
