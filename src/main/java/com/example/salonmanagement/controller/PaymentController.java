package com.example.salonmanagement.controller;

import com.example.salonmanagement.dto.PaymentDTO;
import com.example.salonmanagement.repository.BookingRepository;
import com.example.salonmanagement.service.PaymentService;
import com.example.salonmanagement.service.PromotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;
    private final BookingRepository bookingRepo;
    private final PromotionService promotionService; // ✅ Thêm service khuyến mãi

    @GetMapping("/list")
    public String list(@RequestParam(defaultValue = "") String keyword, Model model) {
        model.addAttribute("pageTitle", "Quản lý Thanh toán");
        model.addAttribute("content", "payment/list");
        model.addAttribute("payments", paymentService.findAll(keyword));
        model.addAttribute("keyword", keyword);
        return "layout";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("pageTitle", "Thêm Thanh toán");
        model.addAttribute("content", "payment/form");
        model.addAttribute("payment", new PaymentDTO());
        model.addAttribute("bookings", bookingRepo.findAll());
        model.addAttribute("promotions", promotionService.findActivePromotions()); // ✅ lấy danh sách khuyến mãi
        return "layout";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute PaymentDTO dto) {
        paymentService.save(dto);
        return "redirect:/payment/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("pageTitle", "Cập nhật Thanh toán");
        model.addAttribute("content", "payment/form");
        model.addAttribute("payment", paymentService.findById(id));
        model.addAttribute("bookings", bookingRepo.findAll());
        model.addAttribute("promotions", promotionService.findActivePromotions()); // ✅ hiển thị lại
        return "layout";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute PaymentDTO dto) {
        paymentService.update(id, dto);
        return "redirect:/payment/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        paymentService.delete(id);
        return "redirect:/payment/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("pageTitle", "Chi tiết Thanh toán");
        model.addAttribute("content", "payment/detail");
        model.addAttribute("payment", paymentService.findById(id));
        return "layout";
    }
}
