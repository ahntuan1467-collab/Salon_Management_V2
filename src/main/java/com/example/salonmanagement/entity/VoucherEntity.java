package com.example.salonmanagement.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "voucher")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VoucherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code; // SALE10, MEMBER,...

    private Double discount; // 0.1 = 10%

    private Boolean active = true; // Có hiệu lực hay không
}
