package com.example.salonmanagement.util;

import com.example.salonmanagement.dto.EmployeeDTO;
import com.example.salonmanagement.entity.EmployeeEntity;

public class EmployeeMapper {

    public static EmployeeDTO toDTO(EmployeeEntity entity) {
        if (entity == null) return null;
        return EmployeeDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .phone(entity.getPhone())
                .email(entity.getEmail())
                .specialization(entity.getSpecialization())
                .shift(entity.getShift())
                .salary(entity.getSalary())
                .status(entity.getStatus())
                .build();
    }

    public static EmployeeEntity toEntity(EmployeeDTO dto) {
        if (dto == null) return null;
        return EmployeeEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .specialization(dto.getSpecialization())
                .shift(dto.getShift())
                .salary(dto.getSalary())
                .status(dto.getStatus())
                .build();
    }

    public static void updateEntity(EmployeeEntity entity, EmployeeDTO dto) {
        if (entity == null || dto == null) return;
        entity.setName(dto.getName());
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());
        entity.setSpecialization(dto.getSpecialization());
        entity.setShift(dto.getShift());
        entity.setSalary(dto.getSalary());
        entity.setStatus(dto.getStatus());
    }
}
