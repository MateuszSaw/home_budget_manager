package com.javagda19.home_budget.controller;

import com.javagda19.home_budget.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(path = "/")
public class IndexController {

    @Autowired
    PaymentService paymentService;

    @GetMapping(path = "/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "loginForm";
    }

    @GetMapping("/homePageAfterLogin")
    public String pageAfterLogin(Model model) {
        model.addAttribute("amountSum", paymentService.getSumOfPayment(paymentService.getAllPayment()));
        return "homePageAfterLogin";
    }
}
