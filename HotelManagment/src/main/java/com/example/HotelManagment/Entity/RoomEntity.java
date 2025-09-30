package com.example.HotelManagment.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "rooms")
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomNumber;   // e.g. 101, 202
    private String type;         // e.g. "Single", "Double", "Suite"
    private Double pricePerNight;
    private Boolean available;   // true = available, false = booked
}

