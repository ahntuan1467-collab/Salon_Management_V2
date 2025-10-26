package com.example.salonmanagement.dto;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromotionDTO {
    private Long id;
    private String code;
    private String name;
    private BigDecimal discount;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    private String status;
}
