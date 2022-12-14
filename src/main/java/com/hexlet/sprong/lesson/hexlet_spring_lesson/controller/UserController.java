package com.hexlet.sprong.lesson.hexlet_spring_lesson.controller;

import com.hexlet.sprong.lesson.hexlet_spring_lesson.exception.CustomException;
import com.hexlet.sprong.lesson.hexlet_spring_lesson.pojo_dto.UserDto;
import com.hexlet.sprong.lesson.hexlet_spring_lesson.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/v1.0")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public String createComplexUser(@Valid @RequestBody UserDto userDto) {
        userService.createComplexUser(userDto);
        return "OK";
    }
    @PostMapping("/users/one")
    public String createUser(@Valid @RequestBody UserDto userDto) {
        userService.createUser(userDto);
        return "OK";
    }
    @GetMapping("/users/{username}")
    public ResponseEntity getUserByName(@PathVariable(name = "username") String username) {
        try {
            return (ResponseEntity) userService.getUsersByName(username);
        } catch (CustomException e) {
            if (Objects.equals(e.getErrorCode(), "IA-000")) {
                return ResponseEntity.badRequest().body("");
            }
            return ResponseEntity.internalServerError().body("");
        }
    }
}
