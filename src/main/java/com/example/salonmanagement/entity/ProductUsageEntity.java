package com.example.salonmanagement.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "product_usage")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductUsageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private Integer quantityUsed;
    private String unit; // ml, chai, tuýp, v.v.

    private LocalDateTime usageDate;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private BookingEntity booking;
}
