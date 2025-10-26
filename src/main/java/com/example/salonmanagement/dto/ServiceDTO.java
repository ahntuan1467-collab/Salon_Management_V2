package com.example.salonmanagement.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceDTO {
    private Long id;

    @NotBlank(message = "Tên dịch vụ không được để trống")
    private String name;

    @NotNull(message = "Giá không được để trống")
    @DecimalMin(value = "10000.0", message = "Giá tối thiểu là 10.000 VNĐ")
    private BigDecimal price;

    @NotNull(message = "Thời lượng không được để trống")
    @Min(value = 10, message = "Thời lượng tối thiểu là 10 phút")
    @Max(value = 300, message = "Thời lượng tối đa là 300 phút")
    private Integer durationMinutes;

    private String description;

    @NotBlank(message = "Trạng thái không được để trống")
    private String status;
}
