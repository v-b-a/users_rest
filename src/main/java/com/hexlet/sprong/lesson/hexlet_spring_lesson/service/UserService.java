package com.hexlet.sprong.lesson.hexlet_spring_lesson.service;

import com.hexlet.sprong.lesson.hexlet_spring_lesson.exception.CustomException;
import com.hexlet.sprong.lesson.hexlet_spring_lesson.model_entity.User;
import com.hexlet.sprong.lesson.hexlet_spring_lesson.pojo_dto.UserDto;

import java.util.List;

public interface UserService {
    void createComplexUser(UserDto userDto);
    List<UserDto> getUsersByName(String username) throws CustomException;
    void createUser(UserDto userDto);


    User findUserById(Long userId);
}
