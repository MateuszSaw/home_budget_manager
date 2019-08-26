package com.javagda19.home_budget.controller;

import com.javagda19.home_budget.model.Income;
import com.javagda19.home_budget.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path = "/")
public class IndexController {

    @Autowired
    IncomeService incomeService;

    @GetMapping(path = "/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "loginForm";
    }

    @GetMapping("/homePageAfterLogin")
    public String pageAfterLogin(Model model, @Valid Income income) {
        model.addAttribute("amountSum", incomeService.getSumOfAmount(incomeService.getAllIncome()));
        return "homePageAfterLogin";
    }
}
