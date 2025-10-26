package com.example.salonmanagement.repository;

import com.example.salonmanagement.entity.VoucherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VoucherRepository extends JpaRepository<VoucherEntity, Long> {
    List<VoucherEntity> findByActiveTrue(); // lấy tất cả voucher đang hoạt động
}
