package com.chapadinhos.api.controller;

import com.chapadinhos.domain.service.ChapadinhoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class HomeController {
    private final ChapadinhoService service;

    @GetMapping
    public String home() {
        return "Hello";
    }
}
