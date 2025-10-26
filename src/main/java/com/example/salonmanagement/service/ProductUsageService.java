package com.example.salonmanagement.service;

import com.example.salonmanagement.dto.ProductUsageDTO;

import java.util.List;

public interface ProductUsageService {
    List<ProductUsageDTO> findAll(String keyword);
    ProductUsageDTO findById(Long id);
    ProductUsageDTO save(ProductUsageDTO dto);
    ProductUsageDTO update(Long id, ProductUsageDTO dto);
    void delete(Long id);
}
