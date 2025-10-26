package com.example.salonmanagement.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;

    private String phone;
    private String email;
    private String specialization; // Chuyên môn
    private String shift; // Ca làm việc
    private Double salary;
    private String status; // Đang làm / Nghỉ
}
