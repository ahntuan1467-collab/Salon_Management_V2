package com.example.salonmanagement.service.impl;

import com.example.salonmanagement.dto.CustomerDTO;
import com.example.salonmanagement.entity.CustomerEntity;
import com.example.salonmanagement.repository.CustomerRepository;
import com.example.salonmanagement.service.CustomerService;
import com.example.salonmanagement.util.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    @Override
    public List<CustomerDTO> findAll(String keyword) {
        List<CustomerEntity> list;

        if (keyword == null || keyword.trim().isEmpty()) {
            // ✅ Lấy tất cả khách hàng
            list = repository.findAll();
        } else {
            // ✅ Tìm kiếm có chứa từ khóa
            list = repository.search(keyword.trim());
        }

        return list.stream().map(e -> CustomerDTO.builder()
                .id(e.getId())
                .name(e.getName())
                .phone(e.getPhone())
                .email(e.getEmail())
                .address(e.getAddress())
                .memberType(e.getMemberType())
                .build()).collect(Collectors.toList());
    }

    @Override
    public CustomerDTO findById(Long id) {
        return repository.findById(id)
                .map(CustomerMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @Override
    public CustomerDTO save(CustomerDTO dto) {
        CustomerEntity entity = new CustomerEntity();
        entity.setName(dto.getName());
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());
        entity.setMemberType(dto.getMemberType());
        repository.save(entity);
        return dto;
    }

    @Override
    public CustomerDTO update(Long id, CustomerDTO dto) {
        CustomerEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        CustomerMapper.updateEntity(entity, dto);
        return CustomerMapper.toDTO(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
