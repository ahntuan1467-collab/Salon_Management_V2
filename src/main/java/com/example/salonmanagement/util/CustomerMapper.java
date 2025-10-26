package com.example.salonmanagement.util;

import com.example.salonmanagement.dto.CustomerDTO;
import com.example.salonmanagement.entity.CustomerEntity;

public class CustomerMapper {

    public static CustomerDTO toDTO(CustomerEntity entity) {
        if (entity == null) return null;
        return CustomerDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .phone(entity.getPhone())
                .email(entity.getEmail())
                .address(entity.getAddress())
                .memberType(entity.getMemberType())
                .build();
    }

    public static CustomerEntity toEntity(CustomerDTO dto) {
        if (dto == null) return null;
        return CustomerEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .address(dto.getAddress())
                .memberType(dto.getMemberType())
                .build();
    }

    public static void updateEntity(CustomerEntity entity, CustomerDTO dto) {
        if (entity == null || dto == null) return;
        entity.setName(dto.getName());
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());
        entity.setAddress(dto.getAddress());
        entity.setMemberType(dto.getMemberType());
    }
}
