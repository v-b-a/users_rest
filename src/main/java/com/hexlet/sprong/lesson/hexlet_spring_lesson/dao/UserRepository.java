package com.hexlet.sprong.lesson.hexlet_spring_lesson.dao;

import com.hexlet.sprong.lesson.hexlet_spring_lesson.model_entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

        List<User> findUserByUsername(String username);
        User findUserById(Long userId);
//    User
}
