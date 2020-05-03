package com.javagda19.home_budget.service;

import com.javagda19.home_budget.model.Payment;
import com.javagda19.home_budget.model.PaymentDto;
import com.javagda19.home_budget.model.Target;
import com.javagda19.home_budget.repository.PaymentRepository;
import com.javagda19.home_budget.repository.TargetRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
private TargetRepository targetRepository;

    public List<Payment> getAllPayment() {
        return paymentRepository.findAll();
    }




    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public void removePaymentById(Long id) {
        paymentRepository.deleteById(id);
    }

    public void addPayment(Payment payment) {

        paymentRepository.save(payment);
    }

    public void updatePayment(Payment payment) {
        paymentRepository.save(payment);
    }

    public double getSumOfPayment(List<Payment> paymentList) {
        double sumOfPayments = 0;
        for (int i = 0; i < paymentList.size(); i++) {
            sumOfPayments += paymentList.get(i).getIncome();
        }

        return sumOfPayments;
    }
    public void addPaymentToTarget (PaymentDto paymentDto){

        Target target = targetRepository.getOne(paymentDto.getTargetId());
        Payment payment = new Payment(paymentDto.getName(),paymentDto.getIncome(), target);
        payment = paymentRepository.save(payment);
        targetRepository.save(target);

    }
}

