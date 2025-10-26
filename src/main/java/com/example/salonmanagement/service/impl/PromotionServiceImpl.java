package com.example.salonmanagement.service.impl;

import com.example.salonmanagement.dto.PromotionDTO;
import com.example.salonmanagement.entity.PromotionEntity;
import com.example.salonmanagement.repository.PromotionRepository;
import com.example.salonmanagement.service.PromotionService;
import com.example.salonmanagement.util.PromotionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PromotionServiceImpl implements PromotionService {

    private final PromotionRepository repo;

    @Override
    public List<PromotionDTO> findAll(String keyword) {
        List<PromotionEntity> list = (keyword == null || keyword.isEmpty())
                ? repo.findAll()
                : repo.search(keyword);
        return list.stream().map(PromotionMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public PromotionDTO findById(Long id) {
        return repo.findById(id)
                .map(PromotionMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khuyến mãi"));
    }

    @Override
    public PromotionDTO save(PromotionDTO dto) {
        PromotionEntity entity = PromotionMapper.toEntity(dto);
        return PromotionMapper.toDTO(repo.save(entity));
    }

    @Override
    public PromotionDTO update(Long id, PromotionDTO dto) {
        PromotionEntity entity = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khuyến mãi"));
        PromotionMapper.updateEntity(entity, dto);
        return PromotionMapper.toDTO(repo.save(entity));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
