package com.example.salonmanagement.util;

import com.example.salonmanagement.dto.BookingDTO;
import com.example.salonmanagement.entity.BookingEntity;

public class BookingMapper {

    public static BookingDTO toDTO(BookingEntity entity) {
        if (entity == null) return null;
        return BookingDTO.builder()
                .id(entity.getId())
                .bookingTime(entity.getBookingTime())
                .customerId(entity.getCustomer() != null ? entity.getCustomer().getId() : null)
                .customerName(entity.getCustomer() != null ? entity.getCustomer().getName() : null)
                .employeeId(entity.getEmployee() != null ? entity.getEmployee().getId() : null)
                .employeeName(entity.getEmployee() != null ? entity.getEmployee().getName() : null)
                .serviceId(entity.getService() != null ? entity.getService().getId() : null)
                .serviceName(entity.getService() != null ? entity.getService().getName() : null)
                .status(entity.getStatus())
                .note(entity.getNote())
                .build();
    }

    public static void updateEntity(BookingEntity entity, BookingDTO dto) {
        if (entity == null || dto == null) return;
        entity.setBookingTime(dto.getBookingTime());
        entity.setStatus(dto.getStatus());
        entity.setNote(dto.getNote());
    }
}
