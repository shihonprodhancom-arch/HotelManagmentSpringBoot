package com.example.HotelManagment.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String guest;          // Guest name
    private Double amount;         // Payment amount
    private String method;         // Cash, Card, Bkash, Nagad
    private LocalDate date;        // Payment date

    // Card details (optional)
    private String bankName;
    private String cardNumber;
    private String expiryDate;

    // Mobile payment details (optional)
    private String accountNumber;
    private String transactionId;

    // Optional booking reference
    @Column(name = "booking_id", nullable = true)
    private Long bookingId;        // can be null
}
