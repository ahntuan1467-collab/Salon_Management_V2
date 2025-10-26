package com.example.salonmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @GetMapping("/home/customers")
    public String redirectCustomers() {
        return "redirect:/customer/list";
    }

    @GetMapping("/employee")
    public String redirectEmployee() {
        return "redirect:/employee/list";
    }

    @GetMapping("/services")
    public String redirectServices() {
        return "redirect:/service/list";
    }

    @GetMapping("/booking")
    public String redirectBooking() {
        return "redirect:/booking/list";
    }

    @GetMapping("/payment")
    public String redirectPayment() {
        return "redirect:/payment/list";
    }

    @GetMapping("/promotion")
    public String redirectPromotion() {
        return "redirect:/promotion/list";
    }

    @GetMapping("/productusage")
    public String redirectProductusage() {
        return "redirect:/productusage/list";
    }
}
