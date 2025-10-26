package com.example.salonmanagement.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductUsageDTO {
    private Long id;
    private String productName;
    private Integer quantityUsed;
    private String unit;
    private LocalDateTime usageDate;
    private Long bookingId;
    private String customerName;
}
