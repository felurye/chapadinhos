package com.chapadinhos.api.controller;

import com.chapadinhos.api.mapper.ChapadinhoMapper;
import com.chapadinhos.api.request.ChapadinhoRequest;
import com.chapadinhos.api.response.ChapadinhoResponse;
import com.chapadinhos.domain.entity.Chapadinho;
import com.chapadinhos.domain.service.ChapadinhoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/chapadinho")
public class ChapadinhoController {
    private final ChapadinhoService service;
    private final ChapadinhoMapper mapper;

    @PostMapping
    public ResponseEntity<ChapadinhoResponse> save(@RequestBody ChapadinhoRequest request) {
        Chapadinho chapadinho = service.save(mapper.toChapadinho(request));

        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toChapadinhoResponse(chapadinho));
    }

    @GetMapping
    public ResponseEntity<List<ChapadinhoResponse>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toChapadinhoResponseList(service.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChapadinhoResponse> getChapadinhoById(@PathVariable Long id) {
        Optional<Chapadinho> chapadinho = service.findById(id);

        return chapadinho.map(value -> ResponseEntity.status(HttpStatus.OK).body(mapper.toChapadinhoResponse(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChapadinhoById(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChapadinhoResponse> updateChapadinho(@PathVariable Long id, @RequestBody ChapadinhoRequest request) {
        Chapadinho chapadinho = service.update(id, mapper.toChapadinho(request));
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toChapadinhoResponse(chapadinho));
    }
}
