package com.example.salonmanagement.controller;

import com.example.salonmanagement.dto.BookingDTO;
import com.example.salonmanagement.repository.*;
import com.example.salonmanagement.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService service;
    private final CustomerRepository customerRepo;
    private final EmployeeRepository employeeRepo;
    private final ServiceRepository serviceRepo;

    @GetMapping("/list")
    public String list(@RequestParam(defaultValue = "") String keyword, Model model) {
        model.addAttribute("pageTitle", "Quản lý Đặt lịch");
        model.addAttribute("content", "booking/list");
        model.addAttribute("bookings", service.findAll(keyword));
        model.addAttribute("keyword", keyword);
        return "layout";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("pageTitle", "Thêm Đặt lịch");
        model.addAttribute("content", "booking/form");
        model.addAttribute("booking", new BookingDTO());
        model.addAttribute("customers", customerRepo.findAll());
        model.addAttribute("employees", employeeRepo.findAll());
        model.addAttribute("services", serviceRepo.findAll());
        return "layout";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BookingDTO dto) {
        service.save(dto);
        return "redirect:/booking/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("pageTitle", "Cập nhật Đặt lịch");
        model.addAttribute("content", "booking/form");
        model.addAttribute("booking", service.findById(id));
        model.addAttribute("customers", customerRepo.findAll());
        model.addAttribute("employees", employeeRepo.findAll());
        model.addAttribute("services", serviceRepo.findAll());
        return "layout";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute BookingDTO dto) {
        service.update(id, dto);
        return "redirect:/booking/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/booking/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("pageTitle", "Chi tiết Đặt lịch");
        model.addAttribute("content", "booking/detail");
        model.addAttribute("booking", service.findById(id));
        return "layout";
    }
}
