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

    private Double servicePrice;

    // ✅ Thêm để lưu và hiển thị khuyến mãi được chọn
    private Long promotionId;

    // ✅ Nếu bạn muốn hiển thị tên/ma khuyến mãi trong danh sách thanh toán
    private String promotionName;
}
