package com.hexlet.sprong.lesson.hexlet_spring_lesson.pojo_dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@ToString
@Setter
@Getter
@NoArgsConstructor
public class UserDto {
    @NotNull
    @Size(min = 3)
    private String username;
    private List<CarDto> cars;
}
