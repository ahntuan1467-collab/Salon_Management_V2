package com.example.salonmanagement.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

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

    private String code; // Mã khuyến mãi
    private String name;

    @Column(precision = 10, scale = 2)
    private BigDecimal discount; // phần trăm hoặc số tiền giảm

    private LocalDate startDate;
    private LocalDate endDate;

    private String description;
    private String status; // "Hoạt động" / "Hết hạn"
}
