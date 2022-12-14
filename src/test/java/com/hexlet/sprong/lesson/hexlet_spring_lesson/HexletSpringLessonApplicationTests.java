package com.hexlet.sprong.lesson.hexlet_spring_lesson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hexlet.sprong.lesson.hexlet_spring_lesson.pojo_dto.CarDto;
import com.hexlet.sprong.lesson.hexlet_spring_lesson.pojo_dto.UserDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HexletSpringLessonApplicationTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    ResourceLoader resourceLoader;

    @Test
    void getUserByUsername_positive() throws Exception {
        String username = "Egor4";
        mockMvc.perform(MockMvcRequestBuilders.get("/v1.0/users/" + username))
                .andExpect(status().isOk());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Egor_not", "Ivan 99"})
    void getUserByUsername_negative(String username) throws Exception {
//        String username = "Egor_not";
        mockMvc.perform(MockMvcRequestBuilders.get("/v1.0/users/" + username))
                .andExpect(status().isBadRequest());
    }

    @Test
    void createUser_positive() throws Exception {
        var userDto = new UserDto();
        var carDto = new CarDto();
        carDto.setName("Volvo XC 40");
        userDto.setUsername("Bari_test");
        userDto.setCars(List.of(carDto));
        mockMvc.perform(MockMvcRequestBuilders.post("/v1.0/users")
                        .content(objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @ParameterizedTest
    @ValueSource(strings = {"request/less_then_3_chars_username.json", "request/null_username.json"})
    void createUser_negative(String requestDataPath) throws Exception {
        UserDto userDto = objectMapper.readValue(
                resourceLoader.getResource("classpath:" + requestDataPath).getFile(), UserDto.class);
        mockMvc.perform(MockMvcRequestBuilders.post("/v1.0/users")
                        .content(objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

}
