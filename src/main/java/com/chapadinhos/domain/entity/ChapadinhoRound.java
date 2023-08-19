package com.chapadinhos.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
