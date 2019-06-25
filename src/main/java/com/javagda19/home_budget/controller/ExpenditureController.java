package com.javagda19.home_budget.controller;

import com.javagda19.home_budget.model.Expenditure;
import com.javagda19.home_budget.model.ExpenditureCategory;
import com.javagda19.home_budget.service.ExpenditureService;
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
@RequestMapping(path = "/expenditure/")
public class ExpenditureController {

    @Autowired
    ExpenditureService expenditureService;

    @GetMapping(path = "/list")
    public String getListExpenditure(Model model) {
        model.addAttribute("expenditureList", expenditureService.getAllExpenditure());
        return "expenditureList";
    }

    @GetMapping(path = "/delete")
    public String expenditureDelete(@RequestParam("expenditureId") Long id) {
        expenditureService.removeExpenditureById(id);
        return "redirect:/expenditure/list";

    }

    @GetMapping(path = "/add")
    public String expenditureForm(Model model) {
        model.addAttribute("newExpenditure", new Expenditure());
        model.addAttribute("expenditureTypes", ExpenditureCategory.values());
        return "expenditureForm";
    }


    @PostMapping("/save")
    public String createExpenditure(Model model, @Valid Expenditure expenditure) {
        try {
            expenditureService.updateExpenditure(expenditure);
        } catch (Exception e) {
            model.addAttribute("expenditure", expenditure);
            return "expenditureForm";
        }
        return "redirect:/expenditure/list";
    }
    @GetMapping(path = "/update")
    public String updateExpenditureForm(@RequestParam(name = "expenditureId") Long id, Model model){
        Optional<Expenditure> expenditureOptional = expenditureService.getExpenditureById(id);
        model.addAttribute("expenditureTypes", ExpenditureCategory.values());

        if(expenditureOptional.isPresent()){
            model.addAttribute("expenditure", expenditureOptional.get());
            return "expenditureUpdateForm";
        }
        return "redirect:/expenditure/list";
    }
    @PostMapping("/update")
    public String updateExpenditure (Model model, @Valid Expenditure expenditure){
        try{
            expenditureService.updateExpenditure(expenditure);
        }catch (Exception e){
            model.addAttribute("expenditure", expenditure);
            return "expenditureUpdateForm";
        }
        return "redirect:/expenditure/list";
    }


}
