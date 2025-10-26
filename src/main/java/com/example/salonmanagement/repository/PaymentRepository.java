package com.example.salonmanagement.repository;

import com.example.salonmanagement.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

    @Query("SELECT p FROM PaymentEntity p WHERE LOWER(p.booking.customer.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<PaymentEntity> search(String keyword);
}
