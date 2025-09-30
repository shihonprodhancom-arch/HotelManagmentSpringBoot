package com.example.HotelManagment.Entity;



import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "payments")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private String method;

    private LocalDateTime paymentDate;

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private BookingEntity booking;
}

