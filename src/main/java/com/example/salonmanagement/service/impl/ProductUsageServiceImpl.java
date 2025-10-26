package com.example.salonmanagement.service.impl;

import com.example.salonmanagement.dto.ProductUsageDTO;
import com.example.salonmanagement.entity.ProductUsageEntity;
import com.example.salonmanagement.repository.BookingRepository;
import com.example.salonmanagement.repository.ProductUsageRepository;
import com.example.salonmanagement.service.ProductUsageService;
import com.example.salonmanagement.util.ProductUsageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductUsageServiceImpl implements ProductUsageService {

    private final ProductUsageRepository productRepo;
    private final BookingRepository bookingRepo;

    @Override
    public List<ProductUsageDTO> findAll(String keyword) {
        List<ProductUsageEntity> list = (keyword == null || keyword.isEmpty())
                ? productRepo.findAll()
                : productRepo.search(keyword);
        return list.stream().map(ProductUsageMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public ProductUsageDTO findById(Long id) {
        return productRepo.findById(id)
                .map(ProductUsageMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm sử dụng"));
    }

    @Override
    public ProductUsageDTO save(ProductUsageDTO dto) {
        ProductUsageEntity entity = new ProductUsageEntity();
        entity.setProductName(dto.getProductName());
        entity.setQuantityUsed(dto.getQuantityUsed());
        entity.setUnit(dto.getUnit());
        entity.setUsageDate(LocalDateTime.now());
        entity.setBooking(bookingRepo.findById(dto.getBookingId()).orElse(null));
        return ProductUsageMapper.toDTO(productRepo.save(entity));
    }

    @Override
    public ProductUsageDTO update(Long id, ProductUsageDTO dto) {
        ProductUsageEntity entity = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm sử dụng"));
        ProductUsageMapper.updateEntity(entity, dto);
        entity.setBooking(bookingRepo.findById(dto.getBookingId()).orElse(null));
        return ProductUsageMapper.toDTO(productRepo.save(entity));
    }

    @Override
    public void delete(Long id) {
        productRepo.deleteById(id);
    }
}
