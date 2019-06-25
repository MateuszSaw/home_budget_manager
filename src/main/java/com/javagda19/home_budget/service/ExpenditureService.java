package com.javagda19.home_budget.service;

import com.javagda19.home_budget.model.Expenditure;
import com.javagda19.home_budget.model.Income;
import com.javagda19.home_budget.repository.ExpenditureRepository;
import com.javagda19.home_budget.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ExpenditureService {
    @Autowired
    private ExpenditureRepository expenditureRepository;

    public List<Expenditure> getAllExpenditure() {
        return expenditureRepository.findAll();
    }

    public Optional<Expenditure> getExpenditureById(Long id) {
        return expenditureRepository.findById(id);
    }

    public void removeExpenditureById(Long id) {
        expenditureRepository.deleteById(id);
    }

    public void addExpenditure(Expenditure expenditure) {
        expenditureRepository.save(expenditure);
    }
    public void updateExpenditure (Expenditure expenditure){
        expenditureRepository.save(expenditure);
    }
}
