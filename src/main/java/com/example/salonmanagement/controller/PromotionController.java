package com.example.salonmanagement.controller;

import com.example.salonmanagement.dto.PromotionDTO;
import com.example.salonmanagement.service.PromotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/promotion")
@RequiredArgsConstructor
public class PromotionController {

    private final PromotionService service;

    @GetMapping("/list")
    public String list(@RequestParam(defaultValue = "") String keyword, Model model) {
        model.addAttribute("pageTitle", "Quản lý Khuyến mãi");
        model.addAttribute("content", "promotion/list");
        model.addAttribute("promotions", service.findAll(keyword));
        model.addAttribute("keyword", keyword);
        return "layout";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("pageTitle", "Thêm Khuyến mãi");
        model.addAttribute("content", "promotion/form");
        model.addAttribute("promotion", new PromotionDTO());
        return "layout";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute PromotionDTO dto) {
        service.save(dto);
        return "redirect:/promotion/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("pageTitle", "Cập nhật Khuyến mãi");
        model.addAttribute("content", "promotion/form");
        model.addAttribute("promotion", service.findById(id));
        return "layout";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute PromotionDTO dto) {
        service.update(id, dto);
        return "redirect:/promotion/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/promotion/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("pageTitle", "Chi tiết Khuyến mãi");
        model.addAttribute("content", "promotion/detail");
        model.addAttribute("promotion", service.findById(id));
        return "layout";
    }
}
