package com.example.salonmanagement.service;

import com.example.salonmanagement.dto.ServiceDTO;
import java.util.List;

public interface ServiceService {
    List<ServiceDTO> findAll(String keyword);
    ServiceDTO findById(Long id);
    ServiceDTO save(ServiceDTO dto);
    ServiceDTO update(Long id, ServiceDTO dto);
    void delete(Long id);
}
