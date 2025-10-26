package com.example.salonmanagement.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDTO {

    private Long id;

    @NotBlank(message = "Tên nhân viên không được để trống")
    private String name;

    @Pattern(regexp = "^[0-9]{10}$", message = "Số điện thoại phải gồm 10 chữ số")
    private String phone;

    @Email(message = "Email không hợp lệ")
    @NotBlank(message = "Email không được để trống")
    private String email;

    @NotBlank(message = "Vui lòng chọn chuyên môn (dịch vụ)")
    private String specialization; // Cắt tóc, Nhuộm, Massage, Gội đầu, Làm móng

    @NotBlank(message = "Ca làm việc không được để trống")
    private String shift;

    @NotNull(message = "Lương không được để trống")
    @Positive(message = "Lương phải lớn hơn 0")
    private Double salary;

    @NotBlank(message = "Trạng thái không được để trống")
    private String status;
}
