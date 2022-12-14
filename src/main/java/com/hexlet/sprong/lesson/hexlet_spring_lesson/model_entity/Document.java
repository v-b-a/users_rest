package com.hexlet.sprong.lesson.hexlet_spring_lesson.model_entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "documents")
@Getter
@Setter
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String serialNumber;
    @OneToOne(cascade = CascadeType.ALL)
    private Car car;
}
