package com.example.salonmanagement.repository;

import com.example.salonmanagement.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.math.BigDecimal;
import java.util.List;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

    // 🔍 Tìm kiếm theo tên khách hàng
    @Query("SELECT p FROM PaymentEntity p WHERE LOWER(p.booking.customer.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<PaymentEntity> search(String keyword);

    // 💰 Tổng doanh thu hôm nay
    @Query("SELECT COALESCE(SUM(p.amount), 0) FROM PaymentEntity p WHERE DATE(p.paymentDate) = CURRENT_DATE")
    BigDecimal getTodayRevenue();

    // 💰 Tổng doanh thu tháng này
    @Query("""
           SELECT COALESCE(SUM(p.amount), 0)
           FROM PaymentEntity p
           WHERE MONTH(p.paymentDate) = MONTH(CURRENT_DATE)
           AND YEAR(p.paymentDate) = YEAR(CURRENT_DATE)
           """)
    BigDecimal getMonthRevenue();
}
