package com.javagda19.home_budget.repository;

import com.javagda19.home_budget.model.Target;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TargetRepository extends JpaRepository<Target, Long> {
    Optional<Target> findById(Long id);

    boolean existsById(Long id);
}
