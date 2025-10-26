package com.example.salonmanagement.service;

import com.example.salonmanagement.dto.CustomerDTO;
import java.util.List;

public interface CustomerService {
    List<CustomerDTO> findAll(String keyword);
    CustomerDTO findById(Long id);
    CustomerDTO save(CustomerDTO dto);
    CustomerDTO update(Long id, CustomerDTO dto);
    void delete(Long id);
}
