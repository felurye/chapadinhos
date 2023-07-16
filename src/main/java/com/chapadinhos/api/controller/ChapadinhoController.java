package com.chapadinhos.api.controller;

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

    @PostMapping
    public ResponseEntity<Chapadinho> save(@RequestBody Chapadinho chapadinho) {
        Chapadinho chapadinhoResponse = service.save(chapadinho);

        return ResponseEntity.status(HttpStatus.CREATED).body(chapadinhoResponse);
    }

    @GetMapping
    public ResponseEntity<List<Chapadinho>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chapadinho> getChapadinhoById(@PathVariable Long id) {
        Optional<Chapadinho> chapadinho = service.findById(id);

        return chapadinho.map(value -> ResponseEntity.status(HttpStatus.OK).body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChapadinhoById(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping
    public ResponseEntity<Chapadinho> updateChapadinho(@RequestBody Chapadinho chapadinho) {
        Chapadinho chapadinhoResponse = service.save(chapadinho);
        return ResponseEntity.status(HttpStatus.OK).body(chapadinhoResponse);
    }
}
