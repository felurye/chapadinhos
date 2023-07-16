package com.chapadinhos.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "chapadinhos_round")
public class ChapadinhoRound {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Chapadinho chapadinho;

    @ManyToOne
    private Round round;
}
