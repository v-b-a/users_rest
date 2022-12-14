package com.hexlet.sprong.lesson.hexlet_spring_lesson.service;

import com.hexlet.sprong.lesson.hexlet_spring_lesson.IntroAppConstants;
import com.hexlet.sprong.lesson.hexlet_spring_lesson.dao.UserRepository;
import com.hexlet.sprong.lesson.hexlet_spring_lesson.exception.CustomException;
import com.hexlet.sprong.lesson.hexlet_spring_lesson.model_entity.Box;
import com.hexlet.sprong.lesson.hexlet_spring_lesson.model_entity.Car;
import com.hexlet.sprong.lesson.hexlet_spring_lesson.model_entity.Document;
import com.hexlet.sprong.lesson.hexlet_spring_lesson.model_entity.User;
import com.hexlet.sprong.lesson.hexlet_spring_lesson.pojo_dto.CarDto;
import com.hexlet.sprong.lesson.hexlet_spring_lesson.pojo_dto.UserDto;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

//@AllArgsConstructor
@NoArgsConstructor
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createComplexUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());

        user.setCars(userDto.getCars().stream()
                .map(carDto -> {
                    Car car = new Car();
                    car.setName(carDto.getName());
                    car.setUser(user);

                    Document document = new Document();
                    document.setCar(car);
                    document.setSerialNumber(carDto.getDocument().getSerialNumber());
                    car.setDocument(document);

                    car.setBoxes(carDto.getBoxes().stream().map(boxDto -> {
                                Box box = new Box();
                                box.setNumber(boxDto.getNumber());
                                box.setCars(List.of(car));
                                return box;
                            })
                            .collect(Collectors.toList()));
                    return car;
                }).collect(Collectors.toList()));

        userRepository.save(user);
        LOGGER.info("User has been created");
    }

    @Override
    public List<UserDto> getUsersByName(String username) throws CustomException {
        List<User> users = userRepository.findUserByUsername(username);
        if (!CollectionUtils.isEmpty(users)) {
            return users.stream()
                    .map(user -> {
                        UserDto userDto = new UserDto(user.getUsername(), user.getCars().stream()
                                .map(car -> {
                                    CarDto carDto = new CarDto(car.getName());
                                    return carDto;
                                })
                                .collect(Collectors.toList()));
                        return userDto;
                    }).collect(Collectors.toList());
        }
        throw IntroAppConstants.USER_NOT_FOUNT_EXCEPTION;
    }

    @Override
    public void createUser(UserDto userDto) {
        User user = new User(userDto.getUsername());
        userRepository.save(user);
    }

    @Override
    public User findUserById(Long userId) {
        return userRepository.findUserById(userId);
    }
}
