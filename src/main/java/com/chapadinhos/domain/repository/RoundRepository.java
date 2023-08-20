package com.chapadinhos.domain.repository;

import com.chapadinhos.domain.entity.Round;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoundRepository extends JpaRepository<Round, Long> {

    Optional<Round> findByName(String name);
}
