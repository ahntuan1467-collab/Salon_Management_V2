package com.example.salonmanagement.controller;

import com.example.salonmanagement.dto.ServiceDTO;
import com.example.salonmanagement.service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/service")
@RequiredArgsConstructor
public class ServiceController {

    private final ServiceService service;

    @GetMapping("/list")
    public String list(@RequestParam(defaultValue = "") String keyword, Model model) {
        model.addAttribute("pageTitle", "Quản lý Dịch vụ");
        model.addAttribute("content", "service/list");
        model.addAttribute("services", service.findAll(keyword));
        model.addAttribute("keyword", keyword);
        return "layout";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("pageTitle", "Thêm Dịch vụ");
        model.addAttribute("content", "service/form");
        model.addAttribute("serviceItem", new ServiceDTO());
        return "layout";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute ServiceDTO dto) {
        service.save(dto);
        return "redirect:/service/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("pageTitle", "Cập nhật Dịch vụ");
        model.addAttribute("content", "service/form");
        model.addAttribute("serviceItem", service.findById(id));
        return "layout";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute ServiceDTO dto) {
        service.update(id, dto);
        return "redirect:/service/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/service/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("pageTitle", "Chi tiết Dịch vụ");
        model.addAttribute("content", "service/detail");
        model.addAttribute("serviceItem", service.findById(id));
        return "layout";
    }
}
