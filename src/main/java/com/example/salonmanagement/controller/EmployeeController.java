package com.example.salonmanagement.controller;

import com.example.salonmanagement.dto.EmployeeDTO;
import com.example.salonmanagement.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    // 🟢 Danh sách dịch vụ (hiển thị trong dropdown)
    private List<String> getSpecializations() {
        return List.of("Cắt tóc", "Nhuộm", "Massage", "Gội đầu", "Làm móng");
    }

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
        model.addAttribute("specializations", getSpecializations());
        return "layout";
    }

    // 🟢 Thêm @Valid để kích hoạt validation DTO
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("employee") EmployeeDTO dto,
                       BindingResult result,
                       Model model) {

        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Thêm Nhân viên");
            model.addAttribute("content", "employee/form");
            model.addAttribute("specializations", getSpecializations());
            return "layout";
        }

        service.save(dto);
        return "redirect:/employee/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("pageTitle", "Cập nhật Nhân viên");
        model.addAttribute("content", "employee/form");
        model.addAttribute("employee", service.findById(id));
        model.addAttribute("specializations", getSpecializations());
        return "layout";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id,
                         @Valid @ModelAttribute("employee") EmployeeDTO dto,
                         BindingResult result,
                         Model model) {

        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Cập nhật Nhân viên");
            model.addAttribute("content", "employee/form");
            model.addAttribute("specializations", getSpecializations());
            return "layout";
        }

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
