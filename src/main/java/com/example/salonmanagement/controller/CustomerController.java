package com.example.salonmanagement.controller;

import com.example.salonmanagement.dto.CustomerDTO;
import com.example.salonmanagement.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    private final CustomerService service;

    /**
     * Danh sách khách hàng
     */
    @GetMapping({"/list", "/", ""})
    public String list(@RequestParam(defaultValue = "") String keyword, Model model) {
        model.addAttribute("pageTitle", "Quản lý Khách hàng");
        model.addAttribute("content", "customer/list");
        model.addAttribute("customers", service.findAll(keyword));
        model.addAttribute("keyword", keyword);
        return "layout";
    }

    /**
     * Form thêm mới khách hàng
     */
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("pageTitle", "Thêm Khách hàng");
        model.addAttribute("content", "customer/form");
        model.addAttribute("customer", new CustomerDTO());
        return "layout";
    }

    /**
     * Lưu khách hàng mới
     */
    @PostMapping("/save")
    public String save(@ModelAttribute CustomerDTO dto) {
        try {
            service.save(dto);
            log.info("Đã thêm khách hàng mới: {}", dto.getName());
        } catch (Exception e) {
            log.error("Lỗi khi lưu khách hàng: ", e);
        }
        return "redirect:/customer/list";
    }


    /**
     * Form sửa khách hàng
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        try {
            model.addAttribute("pageTitle", "Cập nhật Khách hàng");
            model.addAttribute("content", "customer/form");
            model.addAttribute("customer", service.findById(id));
            return "layout";
        } catch (Exception e) {
            log.error("Không tìm thấy khách hàng ID: {}", id, e);
            return "redirect:/customer/list";
        }
    }

    /**
     * Cập nhật khách hàng
     */
    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute CustomerDTO dto) {
        try {
            service.update(id, dto);
            log.info("Đã cập nhật khách hàng ID {}", id);
        } catch (Exception e) {
            log.error("Lỗi khi cập nhật khách hàng ID: {}", id, e);
        }
        return "redirect:/customer/list";
    }

    /**
     * Xóa khách hàng
     */
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        try {
            service.delete(id);
            log.info("Đã xóa khách hàng ID {}", id);
        } catch (Exception e) {
            log.error("Lỗi khi xóa khách hàng ID: {}", id, e);
        }
        return "redirect:/customer/list";
    }

    /**
     * Chi tiết khách hàng
     */
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        try {
            model.addAttribute("pageTitle", "Chi tiết Khách hàng");
            model.addAttribute("content", "customer/detail");
            model.addAttribute("customer", service.findById(id));
            return "layout";
        } catch (Exception e) {
            log.error("Không thể tải chi tiết khách hàng ID: {}", id, e);
            return "redirect:/customer/list";
        }
    }
}
