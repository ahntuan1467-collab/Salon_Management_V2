package com.example.salonmanagement.repository;

import com.example.salonmanagement.entity.ProductUsageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ProductUsageRepository extends JpaRepository<ProductUsageEntity, Long> {

    @Query("SELECT p FROM ProductUsageEntity p WHERE LOWER(p.productName) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<ProductUsageEntity> search(String keyword);
}
