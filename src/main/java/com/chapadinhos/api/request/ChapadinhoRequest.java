package com.chapadinhos.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChapadinhoRequest {
    private Long id;

    @NotBlank(message = "The name of the chapadinho is required")
    private String name;
}
