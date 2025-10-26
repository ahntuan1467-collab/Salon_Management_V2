package com.example.salonmanagement.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Entity đại diện cho bảng khuyến mãi (promotions)
 * Lưu thông tin mã, tên, phần trăm giảm giá, thời gian hiệu lực và trạng thái
 */
@Entity
@Table(name = "promotions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromotionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Mã khuyến mãi, ví dụ: SALE10 */
    @Column(nullable = false, unique = true, length = 50)
    private String code;

    /** Tên chương trình khuyến mãi */
    @Column(nullable = false, length = 255)
    private String name;

    /** Tỷ lệ giảm giá theo phần trăm (ví dụ: 15.00 = 15%) */
    @Column(precision = 5, scale = 2, nullable = false)
    private BigDecimal discount;

    /** Ngày bắt đầu khuyến mãi */
    @Column(nullable = false)
    private LocalDate startDate;

    /** Ngày kết thúc khuyến mãi */
    @Column(nullable = false)
    private LocalDate endDate;

    /** Mô tả chi tiết (tuỳ chọn) */
    @Column(length = 500)
    private String description;

    /** Trạng thái khuyến mãi: "Hoạt động" / "Hết hạn" / "Tạm ngưng" */
    @Column(length = 50)
    private String status;
}
