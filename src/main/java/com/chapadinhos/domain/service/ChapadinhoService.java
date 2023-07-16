package com.chapadinhos.domain.service;

import com.chapadinhos.domain.entity.Chapadinho;
import com.chapadinhos.domain.repository.ChapadinhoRepository;
import com.chapadinhos.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ChapadinhoService {

    private final ChapadinhoRepository repository;

    public Chapadinho save(Chapadinho chapadinho) {
        Optional<Chapadinho> optChapadinho = repository.findByName(chapadinho.getName());

        /*
         * Caso o nome informado estiver presente no banco é validado se foi informado um id
         * e se é o mesmo do nome informado, pois nesse cenário um update dos valores deve
         * ser realizado.
         */
        if (optChapadinho.isPresent() && !optChapadinho.get().getId().equals(chapadinho.getId()))
            throw new BusinessException("This chapadinho is already registered.");

        return repository.save(chapadinho);
    }

    public List<Chapadinho> findAll() {
        return repository.findAll();
    }

    public Optional<Chapadinho> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
