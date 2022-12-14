package com.hexlet.sprong.lesson.hexlet_spring_lesson.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends Exception {
    private String errorCode;
    private String message;

}
