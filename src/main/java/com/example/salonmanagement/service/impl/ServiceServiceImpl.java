package com.example.salonmanagement.service.impl;

import com.example.salonmanagement.dto.ServiceDTO;
import com.example.salonmanagement.entity.ServiceEntity;
import com.example.salonmanagement.repository.ServiceRepository;
import com.example.salonmanagement.service.ServiceService;
import com.example.salonmanagement.util.ServiceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository repository;

    @Override
    public List<ServiceDTO> findAll(String keyword) {
        List<ServiceEntity> list = (keyword == null || keyword.isEmpty())
                ? repository.findAll()
                : repository.search(keyword);
        return list.stream().map(ServiceMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public ServiceDTO findById(Long id) {
        return repository.findById(id)
                .map(ServiceMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy dịch vụ"));
    }

    @Override
    public ServiceDTO save(ServiceDTO dto) {
        ServiceEntity entity = ServiceMapper.toEntity(dto);
        return ServiceMapper.toDTO(repository.save(entity));
    }

    @Override
    public ServiceDTO update(Long id, ServiceDTO dto) {
        ServiceEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy dịch vụ"));
        ServiceMapper.updateEntity(entity, dto);
        return ServiceMapper.toDTO(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
