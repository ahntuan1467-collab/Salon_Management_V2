package com.example.salonmanagement.repository;

import com.example.salonmanagement.entity.PromotionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PromotionRepository extends JpaRepository<PromotionEntity, Long> {

    // 🔍 Tìm kiếm theo tên hoặc mã khuyến mãi
    @Query("SELECT p FROM PromotionEntity p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(p.code) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<PromotionEntity> search(String keyword);

    // ✅ Tìm các khuyến mãi đang hoạt động
    List<PromotionEntity> findByStatus(String status);
}
