package com.javagda19.home_budget.controller;

import com.javagda19.home_budget.model.Target;
import com.javagda19.home_budget.service.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(path = "/target")
public class TargetController {


    @Autowired
    TargetService targetService = new TargetService();

    @GetMapping(path = "/list")
    public String getTargetList(Model model) {
        model.addAttribute("targetList", targetService.getAllTargets());
        return "targetList";
    }

    @GetMapping(path = "/delete")
    public String targetDelete(@RequestParam("targetId") Long id) {
        targetService.removetargetById(id);
        return "redirect:/target/list";

    }

    @GetMapping(path = "/add")
    public String targetForm(Model model) {
        model.addAttribute("newTarget", new Target());
        return "targetForm";
    }


    @PostMapping("/save")
    public String createPayment(Model model, @Valid Target target) {
        try {
            targetService.updateTarget(target);
        } catch (Exception e) {
            model.addAttribute("target", target);
            return "targetForm";
        }
        return "redirect:/target/list";
    }

    @GetMapping(path = "/update")
    public String updateTargetForm(@RequestParam(name = "targetId") Long id, Model model) {
        Optional<Target> targetOptional = targetService.getTargetById(id);

        if (targetOptional.isPresent()) {
            model.addAttribute("target", targetOptional.get());
            return "targetUpdateForm";
        }
        return "redirect:/target/list";
    }

    @PostMapping("/update")
    public String updateTarget(Model model, @Valid Target target) {
        try {
            targetService.updateTarget(target);
        } catch (Exception e) {
            model.addAttribute("target", target);
            return "targetUpdateForm";
        }
        return "redirect:/target/list";
    }

}