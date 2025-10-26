package com.example.salonmanagement.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.math.BigDecimal;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private BookingEntity booking;

    @Column(precision = 10, scale = 2)
    private BigDecimal amount;

    private LocalDateTime paymentDate;

    private String paymentMethod; // Tiền mặt / Thẻ / Chuyển khoản
}
