package com.javagda19.home_budget.repository;

import com.javagda19.home_budget.model.Expenditure;
import com.javagda19.home_budget.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpenditureRepository extends JpaRepository<Expenditure, Long> {

    Optional<Expenditure> findAllById(Long expenditureId);
}
