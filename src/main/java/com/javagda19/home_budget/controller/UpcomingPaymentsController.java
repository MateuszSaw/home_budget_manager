package com.javagda19.home_budget.controller;

import com.javagda19.home_budget.model.ExpenditureCategory;
import com.javagda19.home_budget.model.Income;
import com.javagda19.home_budget.model.IncomeCategory;
import com.javagda19.home_budget.model.UpcomingPayments;
import com.javagda19.home_budget.service.IncomeService;
import com.javagda19.home_budget.service.UpcomingPaymentsService;
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
@RequestMapping(path = "/upcomingPayments/")
public class UpcomingPaymentsController {

    @Autowired
private UpcomingPaymentsService upcomingPaymentsService;

    @GetMapping(path = "/list")
    public String getListUpcomingPayments(Model model) {
        model.addAttribute("upcomingPaymentsList", upcomingPaymentsService.getAllUpcomingPayments());
        return "upcomingPaymentsList";
    }

    @GetMapping(path = "/delete")
    public String upcomingPaymentsDelete(@RequestParam("upcomingPaymentsId") Long id) {
        upcomingPaymentsService.removeUpcomingPaymentsById(id);
        return "redirect:/upcomingPayments/list";

    }

    @GetMapping(path = "/add")
    public String upcomingPaymentsForm(Model model) {
        model.addAttribute("newUpcomingPayments", new UpcomingPayments());
        model.addAttribute("expenditureTypes", ExpenditureCategory.values());
        return "upcomingPaymentsForm";
    }


    @PostMapping("/save")
    public String createUpcomingPayments(Model model, @Valid UpcomingPayments upcomingPayments) {
        try {
            upcomingPaymentsService.updateUpcomingPayments(upcomingPayments);
        } catch (Exception e) {
            model.addAttribute("upcomingPayments", upcomingPayments);
            return "upcomingPaymentsForm";
        }
        return "redirect:/upcomingPayments/list";
    }
    @GetMapping(path = "/update")
    public String updateUpcomingPaymentsForm(@RequestParam(name = "upcomingPaymentsId") Long id, Model model){
        Optional<UpcomingPayments> upcomingPaymentsOptional = upcomingPaymentsService.getUpcomingPaymentsById(id);
        model.addAttribute("expenditureTypes", ExpenditureCategory.values());
        if(upcomingPaymentsOptional.isPresent()){
            model.addAttribute("upcomingPayments", upcomingPaymentsOptional.get());
            return "upcomingPaymentsUpdateForm";
        }
        return "redirect:/upcomingPayments/list";
    }
    @PostMapping("/update")
    public String updateUpcomingPayments (Model model, @Valid UpcomingPayments upcomingPayments){
        try{
            upcomingPaymentsService.updateUpcomingPayments(upcomingPayments);
        }catch (Exception e){
            model.addAttribute("upcomingPayments", upcomingPayments);
            return "upcomingPaymentsUpdateForm";
        }
        return "redirect:/upcomingPayments/list";
    }
}

