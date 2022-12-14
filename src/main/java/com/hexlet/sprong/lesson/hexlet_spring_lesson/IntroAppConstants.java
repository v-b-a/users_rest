package com.hexlet.sprong.lesson.hexlet_spring_lesson;

import com.hexlet.sprong.lesson.hexlet_spring_lesson.exception.CustomException;

public class IntroAppConstants {
    public static final CustomException USER_NOT_FOUNT_EXCEPTION = new CustomException("IA-000",
            "User with current name does not exist.");
    private IntroAppConstants() {
    }
}
