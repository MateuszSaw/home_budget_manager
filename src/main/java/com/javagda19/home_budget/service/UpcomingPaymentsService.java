package com.javagda19.home_budget.service;

import com.javagda19.home_budget.model.Income;
import com.javagda19.home_budget.model.UpcomingPayments;
import com.javagda19.home_budget.repository.IncomeRepository;
import com.javagda19.home_budget.repository.UpcomingPaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UpcomingPaymentsService {
    @Autowired
    private UpcomingPaymentsRepository upcomingPaymentsRepository;

    public List<UpcomingPayments> getAllUpcomingPayments() {
        return upcomingPaymentsRepository.findAll();
    }

    public Optional<UpcomingPayments> getUpcomingPaymentsById(Long id) {
        return upcomingPaymentsRepository.findById(id);
    }

    public void removeUpcomingPaymentsById(Long id) {
        upcomingPaymentsRepository.deleteById(id);
    }

    public void addUpcomingPayments(UpcomingPayments upcomingPayments) {
        upcomingPaymentsRepository.save(upcomingPayments);
    }
    public void updateUpcomingPayments (UpcomingPayments upcomingPayments){
        upcomingPaymentsRepository.save(upcomingPayments);
    }
}
