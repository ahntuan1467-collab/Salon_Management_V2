package com.example.salonmanagement.service;

import com.example.salonmanagement.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {
    List<PaymentDTO> findAll(String keyword);
    PaymentDTO findById(Long id);
    PaymentDTO save(PaymentDTO dto);
    PaymentDTO update(Long id, PaymentDTO dto);
    void delete(Long id);
}
