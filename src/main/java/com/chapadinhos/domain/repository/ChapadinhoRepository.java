package com.chapadinhos.domain.repository;

import com.chapadinhos.domain.entity.Chapadinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChapadinhoRepository extends JpaRepository<Chapadinho, Long> {

    Optional<Chapadinho> findByName(String name);
}
