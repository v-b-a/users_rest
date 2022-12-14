package com.hexlet.sprong.lesson.hexlet_spring_lesson.dao;

import com.hexlet.sprong.lesson.hexlet_spring_lesson.model_entity.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
}
