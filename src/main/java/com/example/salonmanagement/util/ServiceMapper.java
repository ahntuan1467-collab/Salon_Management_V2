package com.example.salonmanagement.util;

import com.example.salonmanagement.dto.ServiceDTO;
import com.example.salonmanagement.entity.ServiceEntity;

public class ServiceMapper {

    public static ServiceDTO toDTO(ServiceEntity entity) {
        if (entity == null) return null;
        ServiceDTO build = ServiceDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .durationMinutes(entity.getDurationMinutes())
                .description(entity.getDescription())
                .status(entity.getStatus())
                .build();
        return build;
    }

    public static ServiceEntity toEntity(ServiceDTO dto) {
        if (dto == null) return null;
        return ServiceEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .price(dto.getPrice())
                .durationMinutes(dto.getDurationMinutes())
                .description(dto.getDescription())
                .status(dto.getStatus())
                .build();
    }

    public static void updateEntity(ServiceEntity entity, ServiceDTO dto) {
        if (entity == null || dto == null) return;
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setDurationMinutes(dto.getDurationMinutes());
        entity.setDescription(dto.getDescription());
        entity.setStatus(dto.getStatus());
    }
}
