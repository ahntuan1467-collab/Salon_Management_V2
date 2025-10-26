package com.example.salonmanagement.service;

import com.example.salonmanagement.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> findAll(String keyword);
    EmployeeDTO findById(Long id);
    EmployeeDTO save(EmployeeDTO dto);
    EmployeeDTO update(Long id, EmployeeDTO dto);
    void delete(Long id);
}
