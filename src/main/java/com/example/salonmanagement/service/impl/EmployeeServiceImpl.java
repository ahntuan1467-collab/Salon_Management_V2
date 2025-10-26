package com.example.salonmanagement.service.impl;

import com.example.salonmanagement.dto.EmployeeDTO;
import com.example.salonmanagement.entity.EmployeeEntity;
import com.example.salonmanagement.repository.EmployeeRepository;
import com.example.salonmanagement.service.EmployeeService;
import com.example.salonmanagement.util.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    @Override
    public List<EmployeeDTO> findAll(String keyword) {
        List<EmployeeEntity> list = (keyword == null || keyword.isEmpty())
                ? repository.findAll()
                : repository.search(keyword);
        return list.stream().map(EmployeeMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO findById(Long id) {
        return repository.findById(id)
                .map(EmployeeMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy nhân viên"));
    }

    @Override
    public EmployeeDTO save(EmployeeDTO dto) {
        EmployeeEntity entity = EmployeeMapper.toEntity(dto);
        return EmployeeMapper.toDTO(repository.save(entity));
    }

    @Override
    public EmployeeDTO update(Long id, EmployeeDTO dto) {
        EmployeeEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy nhân viên"));
        EmployeeMapper.updateEntity(entity, dto);
        return EmployeeMapper.toDTO(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
