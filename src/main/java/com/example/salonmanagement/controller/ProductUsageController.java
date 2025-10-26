package com.example.salonmanagement.controller;

import com.example.salonmanagement.dto.ProductUsageDTO;
import com.example.salonmanagement.repository.BookingRepository;
import com.example.salonmanagement.service.ProductUsageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productusage")
@RequiredArgsConstructor
public class ProductUsageController {

    private final ProductUsageService service;
    private final BookingRepository bookingRepo;

    @GetMapping("/list")
    public String list(@RequestParam(defaultValue = "") String keyword, Model model) {
        model.addAttribute("pageTitle", "Quản lý Sản phẩm sử dụng");
        model.addAttribute("content", "productusage/list");
        model.addAttribute("products", service.findAll(keyword));
        model.addAttribute("keyword", keyword);
        return "layout";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("pageTitle", "Thêm Sản phẩm sử dụng");
        model.addAttribute("content", "productusage/form");
        model.addAttribute("product", new ProductUsageDTO());
        model.addAttribute("bookings", bookingRepo.findAll());
        return "layout";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute ProductUsageDTO dto) {
        service.save(dto);
        return "redirect:/productusage/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("pageTitle", "Cập nhật Sản phẩm sử dụng");
        model.addAttribute("content", "productusage/form");
        model.addAttribute("product", service.findById(id));
        model.addAttribute("bookings", bookingRepo.findAll());
        return "layout";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute ProductUsageDTO dto) {
        service.update(id, dto);
        return "redirect:/productusage/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/productusage/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("pageTitle", "Chi tiết Sản phẩm sử dụng");
        model.addAttribute("content", "productusage/detail");
        model.addAttribute("product", service.findById(id));
        return "layout";
    }
}
