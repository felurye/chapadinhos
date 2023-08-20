package com.chapadinhos.domain.service;

import com.chapadinhos.domain.entity.Chapadinho;
import com.chapadinhos.domain.entity.Round;
import com.chapadinhos.domain.repository.ChapadinhoRepository;
import com.chapadinhos.domain.repository.RoundRepository;
import com.chapadinhos.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class RoundService {

    private final RoundRepository repository;
    private final ChapadinhoRepository chapadinhoRepository;

    public Round save(Round round) {
        Optional<Round> optRound = repository.findByName(round.getName());

        if (optRound.isPresent())
            throw new BusinessException("This round name is already registered.");

        return repository.save(round);
    }

    public Round saveChapadinho(Long roundId, Long chapadinhoId) {
        Optional<Round> optRound = repository.findById(roundId);
        Optional<Chapadinho> optChapadinho = chapadinhoRepository.findById(chapadinhoId);

        if (optRound.isEmpty())
            throw new BusinessException("....");

        if (optChapadinho.isEmpty())
            throw new BusinessException("....");

        optRound.get().getChapadinhos().add(optChapadinho.get());

        return repository.save(optRound.get());
    }

    public Round update(Long id, Round round) {
        Optional<Round> optRound = repository.findById(id);

        if (optRound.isEmpty())
            throw new BusinessException("This round is not registered.");

        round.setId(id);

        return save(round);
    }

    public List<Round> findAll() {
        return repository.findAll();
    }

    public Optional<Round> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
