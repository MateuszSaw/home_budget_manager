package com.javagda19.home_budget.service;

import com.javagda19.home_budget.model.Income;
import com.javagda19.home_budget.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class IncomeService {
    @Autowired
    private IncomeRepository incomeRepository;

    public List<Income> getAllIncome() {
        return incomeRepository.findAll();
    }

    public Optional<Income> getIncomeById(Long id) {
        return incomeRepository.findById(id);
    }

    public void removeIncomeById(Long id) {
        incomeRepository.deleteById(id);
    }

    public void addIncome(Income income) {
        incomeRepository.save(income);
    }
    public void updateIncome (Income income){
        incomeRepository.save(income);
    }
}
