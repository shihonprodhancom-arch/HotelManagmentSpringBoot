package com.example.HotelManagment.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "extra_services")
public class ExtraService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double price;

    private LocalDateTime createdAt = LocalDateTime.now();


}
