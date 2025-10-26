package com.example.salonmanagement.service;

import com.example.salonmanagement.dto.PromotionDTO;
import java.util.List;

public interface PromotionService {

    List<PromotionDTO> findAll(String keyword);
    PromotionDTO findById(Long id);
    PromotionDTO save(PromotionDTO dto);
    PromotionDTO update(Long id, PromotionDTO dto);
    void delete(Long id);

    // ✅ Thêm hàm này để PaymentController có thể gọi
    List<PromotionDTO> findActivePromotions();
}
