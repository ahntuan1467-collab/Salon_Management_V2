package com.example.salonmanagement.util;

import com.example.salonmanagement.dto.PaymentDTO;
import com.example.salonmanagement.entity.PaymentEntity;

public class PaymentMapper {

    public static PaymentDTO toDTO(PaymentEntity entity) {
        if (entity == null) return null;
        return PaymentDTO.builder()
                .id(entity.getId())
                .bookingId(entity.getBooking() != null ? entity.getBooking().getId() : null)
                .customerName(entity.getBooking() != null && entity.getBooking().getCustomer() != null
                        ? entity.getBooking().getCustomer().getName() : "")
                .serviceName(entity.getBooking() != null && entity.getBooking().getService() != null
                        ? entity.getBooking().getService().getName() : "")
                .amount(entity.getAmount())
                .paymentDate(entity.getPaymentDate())
                .paymentMethod(entity.getPaymentMethod())
                .build();
    }

    public static void updateEntity(PaymentEntity entity, PaymentDTO dto) {
        if (entity == null || dto == null) return;
        entity.setAmount(dto.getAmount());
        entity.setPaymentDate(dto.getPaymentDate());
        entity.setPaymentMethod(dto.getPaymentMethod());
    }
}
