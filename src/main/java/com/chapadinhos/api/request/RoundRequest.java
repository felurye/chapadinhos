package com.chapadinhos.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoundRequest {
    private Long id;

    @NotBlank(message = "The name of round is required")
    private String name;

    @NotNull(message = "The startDate is required")
    @DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm:ss")
    private LocalDateTime startDate;

    @Future
    @NotNull(message = "The endDate is required")
    @DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm:ss")
    private LocalDateTime endDate;

    @NotNull(message = "The minPointsWin is required")
    private int minPointsToWin;
}
