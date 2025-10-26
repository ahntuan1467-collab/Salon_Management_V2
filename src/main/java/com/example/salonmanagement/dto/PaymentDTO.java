package com.example.salonmanagement.dto;

import lombok.*;
import java.time.LocalDateTime;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDTO {
    private Long id;
    private Long bookingId;
    private String customerName;
    private String serviceName;
    private BigDecimal amount;
    private LocalDateTime paymentDate;
    private String paymentMethod;
}
