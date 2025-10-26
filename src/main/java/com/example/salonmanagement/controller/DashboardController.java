package com.example.salonmanagement.controller;

import com.example.salonmanagement.repository.*;
import com.example.salonmanagement.entity.PaymentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class DashboardController {

    @Autowired private CustomerRepository customerRepository;
    @Autowired private BookingRepository bookingRepository;
    @Autowired private PaymentRepository paymentRepository;
    @Autowired private ServiceRepository serviceRepository;
    @Autowired private EmployeeRepository employeeRepository;
    @Autowired private PromotionRepository promotionRepository;

    @GetMapping({"/", "/index", "/dashboard"})
    public String showDashboard(Model model) {

        // ✅ Tổng số lượng
        model.addAttribute("totalCustomers", customerRepository.count());
        model.addAttribute("totalBookings", bookingRepository.count());
        model.addAttribute("totalServices", serviceRepository.count());
        model.addAttribute("totalEmployees", employeeRepository.count());
        model.addAttribute("totalPromotions", promotionRepository.count());

        // ✅ Tổng doanh thu (convert BigDecimal -> double an toàn)
        double totalRevenue = paymentRepository.findAll().stream()
                .map(PaymentEntity::getAmount)
                .filter(Objects::nonNull)
                .mapToDouble(BigDecimal::doubleValue)
                .sum();
        model.addAttribute("totalRevenue", totalRevenue);

        // ✅ Doanh thu theo tháng
        Map<Integer, Double> revenueByMonth = paymentRepository.findAll().stream()
                .filter(p -> p.getPaymentDate() != null && p.getAmount() != null)
                .collect(Collectors.groupingBy(
                        p -> p.getPaymentDate().getMonthValue(),
                        Collectors.summingDouble(p -> p.getAmount().doubleValue())
                ));

        List<String> months = Arrays.asList("1","2","3","4","5","6","7","8","9","10","11","12");
        List<Double> revenues = months.stream()
                .map(m -> revenueByMonth.getOrDefault(Integer.parseInt(m), 0.0))
                .collect(Collectors.toList());

        model.addAttribute("months", months);
        model.addAttribute("revenues", revenues);

        model.addAttribute("pageTitle", "Dashboard - Salon Management");

        return "index"; // ✅ giữ nguyên template index.html
    }
}
