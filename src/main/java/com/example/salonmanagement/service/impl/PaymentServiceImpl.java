package com.example.salonmanagement.service.impl;

import com.example.salonmanagement.dto.PaymentDTO;
import com.example.salonmanagement.entity.*;
import com.example.salonmanagement.repository.*;
import com.example.salonmanagement.service.PaymentService;
import com.example.salonmanagement.util.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepo;
    private final BookingRepository bookingRepo;

    @Override
    public List<PaymentDTO> findAll(String keyword) {
        List<PaymentEntity> list = (keyword == null || keyword.isEmpty())
                ? paymentRepo.findAll()
                : paymentRepo.search(keyword);
        return list.stream().map(PaymentMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public PaymentDTO findById(Long id) {
        return paymentRepo.findById(id)
                .map(PaymentMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy thanh toán"));
    }

    @Override
    public PaymentDTO save(PaymentDTO dto) {
        PaymentEntity entity = new PaymentEntity();
        entity.setBooking(bookingRepo.findById(dto.getBookingId()).orElse(null));
        entity.setAmount(dto.getAmount());
        entity.setPaymentDate(LocalDateTime.now());
        entity.setPaymentMethod(dto.getPaymentMethod());
        return PaymentMapper.toDTO(paymentRepo.save(entity));
    }

    @Override
    public PaymentDTO update(Long id, PaymentDTO dto) {
        PaymentEntity entity = paymentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy thanh toán"));
        PaymentMapper.updateEntity(entity, dto);
        entity.setBooking(bookingRepo.findById(dto.getBookingId()).orElse(null));
        return PaymentMapper.toDTO(paymentRepo.save(entity));
    }

    @Override
    public void delete(Long id) {
        paymentRepo.deleteById(id);
    }
}
