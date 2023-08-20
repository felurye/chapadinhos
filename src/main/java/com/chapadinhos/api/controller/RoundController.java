package com.chapadinhos.api.controller;

import com.chapadinhos.api.mapper.RoundMapper;
import com.chapadinhos.api.request.RoundRequest;
import com.chapadinhos.api.response.RoundResponse;
import com.chapadinhos.domain.entity.Round;
import com.chapadinhos.domain.service.RoundService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/round")
public class RoundController {
    private final RoundService service;
    private final RoundMapper mapper;


    @PostMapping
    public ResponseEntity<RoundResponse> save(@Valid @RequestBody RoundRequest request) {
        Round round = service.save(mapper.toRound(request));

        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toRoundResponse(round));
    }

    @PostMapping("/{roundId}")
    public ResponseEntity<RoundResponse> addChapadinhoRound(@RequestParam Long chapadinhoId, @PathVariable("roundId") Long roundId) {
        Round round = service.saveChapadinho(roundId, chapadinhoId);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toRoundResponse(round));
    }

    @GetMapping
    public ResponseEntity<List<RoundResponse>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toRoundResponseList(service.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoundResponse> getRoundById(@PathVariable Long id) {
        Optional<Round> round = service.findById(id);

        return round.map(value -> ResponseEntity.status(HttpStatus.OK).body(mapper.toRoundResponse(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoundById(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoundResponse> updateRound(@PathVariable Long id, @RequestBody RoundRequest request) {
        Round round = service.update(id, mapper.toRound(request));
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toRoundResponse(round));
    }
}
