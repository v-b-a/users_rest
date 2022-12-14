package com.hexlet.sprong.lesson.hexlet_spring_lesson.dao;

import com.hexlet.sprong.lesson.hexlet_spring_lesson.model_entity.Document;
import org.springframework.data.repository.CrudRepository;

public interface DocumentRepository extends CrudRepository<Document, Long> {
}
