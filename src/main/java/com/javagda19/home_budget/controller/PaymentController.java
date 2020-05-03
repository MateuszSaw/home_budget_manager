package com.javagda19.home_budget.controller;

import com.javagda19.home_budget.model.Payment;
import com.javagda19.home_budget.model.PaymentDto;
import com.javagda19.home_budget.model.Target;
import com.javagda19.home_budget.service.PaymentService;
import com.javagda19.home_budget.service.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(path = "/payment/")
public class PaymentController {

    private final PaymentService paymentService;
    private final TargetService targetService;

    @Autowired
    public PaymentController(PaymentService paymentService, TargetService targetService) {
        this.paymentService = paymentService;
        this.targetService = targetService;
    }



    @GetMapping(path = "/list")
    public String getPaymentList(Model model,
                                 @Valid Target target) {
        model.addAttribute("paymentList", paymentService.getAllPayment());
        model.addAttribute("target" , target);
        return "paymentList";
    }

    @GetMapping(path = "/delete")
    public String paymentDelete(@RequestParam("paymentId") Long id) {
        paymentService.removePaymentById(id);
        return "redirect:/payment/list";

    }

    @GetMapping(path = "/add")
        public String paymentForm(Model model, @Valid Target target){
        Payment payment = new Payment();
            model.addAttribute("newPaymentDTO", new PaymentDto());
            model.addAttribute("targetList", targetService.getAllTargets());
            return "paymentForm";
    }

    @PostMapping(path = "/add")
    public String saveNewPayment(@Valid PaymentDto paymentDto){
        try{
            paymentService.addPaymentToTarget(paymentDto);
        } catch (Exception e){
            return "redirect:/payment/add";
        }
      return "redirect:/payment/list";
    }


    @PostMapping("/save")
    public String createPayment(Model model, @Valid Payment payment) {
        try {
            paymentService.updatePayment(payment);
        } catch (Exception e) {
            model.addAttribute("newPayment", payment);
            return "paymentForm";
        }
        return "redirect:/payment/list";
    }
    @GetMapping(path = "/update")
    public String updatePaymentForm(@RequestParam(name = "paymentId") Long id, Model model) {
        Optional<Payment> paymentOptional = paymentService.getPaymentById(id);
        if (paymentOptional.isPresent()) {
            model.addAttribute("payment", paymentOptional.get());
            return "paymentUpdateForm";
        }
        return "redirect:/payment/list";
    }

    @PostMapping("/update")
    public String updatePayment(Model model, @Valid Payment payment) {
        try {
            paymentService.updatePayment(payment);
        } catch (Exception e) {
            model.addAttribute("newPayment", payment);
            return "paymentUpdateForm";
        }
        return "redirect:/newPayment/list";
    }


}