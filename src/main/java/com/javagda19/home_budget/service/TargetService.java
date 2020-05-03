package com.javagda19.home_budget.service;

import com.javagda19.home_budget.model.Payment;
import com.javagda19.home_budget.model.Target;
import com.javagda19.home_budget.repository.TargetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TargetService {

    @Autowired
    TargetRepository targetRepository;

    public List<Target> getAllTargets() {
        return targetRepository.findAll();
    }

    public Optional<Target> getTargetById(Long id) {
        return targetRepository.findById(id);
    }

    public void removetargetById(Long id) {
        targetRepository.deleteById(id);
    }

    public void addTarget(Target target) {
        targetRepository.save(target);
    }

    public void updateTarget(Target target) {
        targetRepository.save(target);
    }



}
