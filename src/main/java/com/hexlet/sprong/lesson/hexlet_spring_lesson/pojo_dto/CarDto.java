package com.hexlet.sprong.lesson.hexlet_spring_lesson.pojo_dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {
    private String name;
    private DocumentDto document;
    private List<BoxDto> boxes;

    public CarDto(String name) {
    }
}
