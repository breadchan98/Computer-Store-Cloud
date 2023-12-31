package com.example.computers.compparts.web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import org.springframework.web.bind.support.SessionStatus;

import lombok.extern.slf4j.Slf4j;

import com.example.computers.compparts.domain.PCOrder;

import jakarta.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("customPCOrder")

public class OrderWebFormController {
    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(
        @ModelAttribute("customPCOrder") @Valid PCOrder order, 
        Errors errors, SessionStatus sessionStatus) {
        
        //If there are any errors in the order form, it resets the html
        if(errors.hasErrors()) {
            return "orderForm";
        }

        log.info("Order submitted: {}", order);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
