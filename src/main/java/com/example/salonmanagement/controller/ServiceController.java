package com.example.salonmanagement.controller;

import com.example.salonmanagement.dto.ServiceDTO;
import com.example.salonmanagement.service.ServiceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/service")
@RequiredArgsConstructor
public class ServiceController {

    private final ServiceService service;

    /** 🔹 Hiển thị danh sách dịch vụ */
    @GetMapping("/list")
    public String list(@RequestParam(defaultValue = "") String keyword, Model model) {
        model.addAttribute("pageTitle", "Quản lý Dịch vụ");
        model.addAttribute("content", "service/list");
        model.addAttribute("services", service.findAll(keyword));
        model.addAttribute("keyword", keyword);
        return "layout";
    }

    /** 🔹 Form thêm mới dịch vụ */
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("pageTitle", "Thêm Dịch vụ");
        model.addAttribute("content", "service/form");
        model.addAttribute("serviceItem", new ServiceDTO());
        // Danh sách 5 loại dịch vụ cố định
        model.addAttribute("serviceNames", getServiceNames());
        return "layout";
    }

    /** 🔹 Lưu dịch vụ mới (có kiểm tra lỗi) */
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("serviceItem") ServiceDTO dto,
                       BindingResult result,
                       Model model) {

        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Thêm Dịch vụ");
            model.addAttribute("content", "service/form");
            model.addAttribute("serviceNames", getServiceNames());
            return "layout";
        }

        service.save(dto);
        return "redirect:/service/list";
    }

    /** 🔹 Form cập nhật dịch vụ */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("pageTitle", "Cập nhật Dịch vụ");
        model.addAttribute("content", "service/form");
        model.addAttribute("serviceItem", service.findById(id));
        model.addAttribute("serviceNames", getServiceNames());
        return "layout";
    }

    /** 🔹 Cập nhật dịch vụ (có kiểm tra lỗi) */
    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id,
                         @Valid @ModelAttribute("serviceItem") ServiceDTO dto,
                         BindingResult result,
                         Model model) {

        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Cập nhật Dịch vụ");
            model.addAttribute("content", "service/form");
            model.addAttribute("serviceNames", getServiceNames());
            return "layout";
        }

        service.update(id, dto);
        return "redirect:/service/list";
    }

    /** 🔹 Xóa dịch vụ */
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/service/list";
    }

    /** 🔹 Xem chi tiết dịch vụ */
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("pageTitle", "Chi tiết Dịch vụ");
        model.addAttribute("content", "service/detail");
        model.addAttribute("serviceItem", service.findById(id));
        return "layout";
    }

    /** 🔹 Danh sách dịch vụ cố định */
    private List<String> getServiceNames() {
        return List.of("Cắt tóc", "Nhuộm", "Massage", "Gội đầu", "Làm móng");
    }
}
