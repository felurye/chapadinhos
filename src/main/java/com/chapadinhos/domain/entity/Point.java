package com.chapadinhos.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "points")
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "point_date")
    private LocalDateTime pointDate;

    @ManyToOne
    private ChapadinhoRound chapadinhoRound;
}
