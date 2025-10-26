package com.example.salonmanagement.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingDTO {
    private Long id;
    private LocalDateTime bookingTime;
    private Long customerId;
    private String customerName;
    private Long employeeId;
    private String employeeName;
    private Long serviceId;
    private String serviceName;
    private String status;
    private String note;
}
