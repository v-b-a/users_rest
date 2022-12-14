package com.hexlet.sprong.lesson.hexlet_spring_lesson.model_entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Getter
@Setter
@Entity(name = "cars")
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
    @OneToOne(cascade = CascadeType.ALL)
    private Document document;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "cars")
    private List<Box> boxes;
    @OneToOne
    private Order order;

    public Car(String name, User user) {
        this.name = name;
        this.user = user;
    }
}
