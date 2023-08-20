package com.chapadinhos.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PointResponse {
    private Long id;
    private LocalDateTime pointDate;
    private RoundResponse round;
    private ChapadinhoResponse chapadinho;
}
