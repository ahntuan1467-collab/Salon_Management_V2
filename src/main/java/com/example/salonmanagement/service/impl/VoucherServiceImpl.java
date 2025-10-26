package com.example.salonmanagement.service.impl;

import com.example.salonmanagement.dto.VoucherDTO;
import com.example.salonmanagement.entity.VoucherEntity;
import com.example.salonmanagement.repository.VoucherRepository;
import com.example.salonmanagement.service.VoucherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VoucherServiceImpl implements VoucherService {

    private final VoucherRepository repo;

    @Override
    public List<VoucherDTO> findAllActive() {
        return repo.findByActiveTrue().stream()
                .map(v -> VoucherDTO.builder()
                        .id(v.getId())
                        .code(v.getCode())
                        .discount(v.getDiscount())
                        .build())
                .collect(Collectors.toList());
    }
}
