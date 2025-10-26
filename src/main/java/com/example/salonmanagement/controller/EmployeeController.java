package com.example.salonmanagement.controller;

import com.example.salonmanagement.dto.EmployeeDTO;
import com.example.salonmanagement.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping("/list")
    public String list(@RequestParam(defaultValue = "") String keyword, Model model) {
        model.addAttribute("pageTitle", "Quản lý Nhân viên");
        model.addAttribute("content", "employee/list");
        model.addAttribute("employees", service.findAll(keyword));
        model.addAttribute("keyword", keyword);
        return "layout";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("pageTitle", "Thêm Nhân viên");
        model.addAttribute("content", "employee/form");
        model.addAttribute("employee", new EmployeeDTO());
        return "layout";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute EmployeeDTO dto) {
        service.save(dto);
        return "redirect:/employee/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("pageTitle", "Cập nhật Nhân viên");
        model.addAttribute("content", "employee/form");
        model.addAttribute("employee", service.findById(id));
        return "layout";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute EmployeeDTO dto) {
        service.update(id, dto);
        return "redirect:/employee/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/employee/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("pageTitle", "Chi tiết Nhân viên");
        model.addAttribute("content", "employee/detail");
        model.addAttribute("employee", service.findById(id));
        return "layout";
    }
}
