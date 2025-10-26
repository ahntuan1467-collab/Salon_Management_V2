package com.example.salonmanagement.dto;

import lombok.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceDTO {
    private Long id;
    private String name;
    private BigDecimal price;
    private Integer durationMinutes;
    private String description;
    private String status;
}
