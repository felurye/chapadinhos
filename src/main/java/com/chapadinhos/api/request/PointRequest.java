package com.chapadinhos.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PointRequest {

    private Long id;

    @NotNull(message = "The pointDate is required")
    @DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm:ss")
    private LocalDateTime pointDate;

    @NotNull(message = "The chapadinhoRoundId is required")
    private Long chapadinhoRoundId;

}
