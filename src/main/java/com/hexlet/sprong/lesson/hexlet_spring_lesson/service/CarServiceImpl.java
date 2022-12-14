package com.hexlet.sprong.lesson.hexlet_spring_lesson.service;

import com.hexlet.sprong.lesson.hexlet_spring_lesson.dao.CarRepository;
import com.hexlet.sprong.lesson.hexlet_spring_lesson.model_entity.Car;
import com.hexlet.sprong.lesson.hexlet_spring_lesson.pojo_dto.CarDto;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class CarServiceImpl implements CarService {
    private CarRepository carRepository;
    private UserService userService;

    public CarServiceImpl(CarRepository carRepository, UserService userService) {
        this.carRepository = carRepository;
        this.userService = userService;
    }

    //    @Override
    public List<Car> saveAll(List<CarDto> cars) {
        List<Car> carList = cars.stream()
                .map(carDto -> {
                    Car car = new Car();
                    car.setName(carDto.getName());
                    return car;
                }).collect(Collectors.toList());
        carRepository.saveAll(carList);
        return carList;
    }

    @Override
    public void createCar(CarDto carDto, Long userId) {
        Car car = new Car();
        car.setName(carDto.getName());
        car.setUser(userService.findUserById(userId));
        carRepository.save(car);

    }
}
