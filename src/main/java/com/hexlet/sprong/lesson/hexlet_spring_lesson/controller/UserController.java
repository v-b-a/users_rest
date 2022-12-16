package com.hexlet.sprong.lesson.hexlet_spring_lesson.controller;

import com.hexlet.sprong.lesson.hexlet_spring_lesson.exception.CustomException;
import com.hexlet.sprong.lesson.hexlet_spring_lesson.model_entity.User;
import com.hexlet.sprong.lesson.hexlet_spring_lesson.pojo_dto.UserDto;
import com.hexlet.sprong.lesson.hexlet_spring_lesson.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1.0/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("")
    public String createComplexUser(@Valid @RequestBody UserDto userDto) {
        userService.createComplexUser(userDto);
        return "OK";
    }
    @PostMapping("/one")
    public String createUser(@Valid @RequestBody UserDto userDto) {
        userService.createUser(userDto);
        return "OK";
    }
    @GetMapping("/{username}")
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
    @GetMapping("/filter")
    public List<User> getUsersByFilter(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "order_id", required = false) Long orderId
    ) {
        return userService.findUsersByParams(username, id, orderId);
    }
}
