package com.example.salonmanagement.util;

import com.example.salonmanagement.dto.ProductUsageDTO;
import com.example.salonmanagement.entity.ProductUsageEntity;

public class ProductUsageMapper {

    public static ProductUsageDTO toDTO(ProductUsageEntity entity) {
        if (entity == null) return null;
        return ProductUsageDTO.builder()
                .id(entity.getId())
                .productName(entity.getProductName())
                .quantityUsed(entity.getQuantityUsed())
                .unit(entity.getUnit())
                .usageDate(entity.getUsageDate())
                .bookingId(entity.getBooking() != null ? entity.getBooking().getId() : null)
                .customerName(entity.getBooking() != null && entity.getBooking().getCustomer() != null
                        ? entity.getBooking().getCustomer().getName() : "")
                .build();
    }

    public static void updateEntity(ProductUsageEntity entity, ProductUsageDTO dto) {
        if (entity == null || dto == null) return;
        entity.setProductName(dto.getProductName());
        entity.setQuantityUsed(dto.getQuantityUsed());
        entity.setUnit(dto.getUnit());
        entity.setUsageDate(dto.getUsageDate());
    }
}
