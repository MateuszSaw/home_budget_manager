package com.javagda19.home_budget.repository;

import com.javagda19.home_budget.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {

    Optional<Income> findAllById(Long incomeId);
}
