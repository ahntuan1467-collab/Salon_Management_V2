package com.example.salonmanagement.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDTO {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String specialization;
    private String shift;
    private Double salary;
    private String status;
}
