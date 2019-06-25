package com.javagda19.home_budget.controller;

import com.javagda19.home_budget.model.Income;
import com.javagda19.home_budget.model.IncomeCategory;
import com.javagda19.home_budget.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(path = "/income/")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @GetMapping(path = "/list")
    public String getListIncome(Model model) {
        model.addAttribute("incomeList", incomeService.getAllIncome());
        return "incomeList";
    }

    @GetMapping(path = "/delete")
    public String incomeDelete(@RequestParam("incomeId") Long id) {
        incomeService.removeIncomeById(id);
        return "redirect:/income/list";

    }

    @GetMapping(path = "/add")
    public String incomeForm(Model model) {
        model.addAttribute("newIncome", new Income());
        model.addAttribute("incomeTypes", IncomeCategory.values());
        return "incomeForm";
    }


    @PostMapping("/save")
    public String createIncome(Model model, @Valid Income income) {
        try {
            incomeService.updateIncome(income);
        } catch (Exception e) {
            model.addAttribute("income", income);
            return "incomeForm";
        }
        return "redirect:/income/list";
    }
    @GetMapping(path = "/update")
    public String updateForm(@RequestParam(name = "incomeId") Long id, Model model){
        Optional<Income> incomeOptional = incomeService.getIncomeById(id);
        model.addAttribute("incomeTypes", IncomeCategory.values());

        if(incomeOptional.isPresent()){
            model.addAttribute("income", incomeOptional.get());
            return "incomeUpdateForm";
        }
        return "redirect:/income/list";
    }
    @PostMapping("/update")
    public String updateIncome (Model model, @Valid Income income){
        try{
            incomeService.updateIncome(income);
        }catch (Exception e){
            model.addAttribute("income", income);
            return "incomeUpdateForm";
        }
        return "redirect:/income/list";
    }
}

