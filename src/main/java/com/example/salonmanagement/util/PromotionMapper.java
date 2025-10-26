package com.example.salonmanagement.util;

import com.example.salonmanagement.dto.PromotionDTO;
import com.example.salonmanagement.entity.PromotionEntity;

public class PromotionMapper {

    public static PromotionDTO toDTO(PromotionEntity entity) {
        if (entity == null) return null;
        return PromotionDTO.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .discount(entity.getDiscount())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .description(entity.getDescription())
                .status(entity.getStatus())
                .build();
    }

    public static PromotionEntity toEntity(PromotionDTO dto) {
        if (dto == null) return null;
        return PromotionEntity.builder()
                .id(dto.getId())
                .code(dto.getCode())
                .name(dto.getName())
                .discount(dto.getDiscount())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .description(dto.getDescription())
                .status(dto.getStatus())
                .build();
    }

    public static void updateEntity(PromotionEntity entity, PromotionDTO dto) {
        if (entity == null || dto == null) return;
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setDiscount(dto.getDiscount());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setDescription(dto.getDescription());
        entity.setStatus(dto.getStatus());
    }
}
