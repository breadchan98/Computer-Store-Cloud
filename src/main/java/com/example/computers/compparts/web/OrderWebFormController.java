package com.example.computers.compparts.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import org.springframework.web.bind.support.SessionStatus;

import lombok.extern.slf4j.Slf4j;

import com.example.computers.compparts.domain.PCOrder;

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
    public String processOrder(@ModelAttribute("customPCOrder") PCOrder order, SessionStatus sessionStatus) {
        log.info("Order submitted: {}", order);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
