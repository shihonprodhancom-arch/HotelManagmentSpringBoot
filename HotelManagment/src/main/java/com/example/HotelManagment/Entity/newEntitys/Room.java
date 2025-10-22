package com.example.HotelManagment.Entity.newEntitys;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "rooms")
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer number;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer capacity;

    @ElementCollection
    @CollectionTable(name = "room_services", joinColumns = @JoinColumn(name = "room_id"))
    @Column(name = "service")
    private List<String> services;

    @Column(nullable = false)
    private String image;

    @ManyToOne
    @JoinColumn(name = "room_type_id", nullable = false)
    private RoomGroup roomGroup;

    // Constructors
    public Room() {}

    public Room(Integer number, Double price, Integer capacity, List<String> services, String image, RoomGroup roomGroup) {
        this.number = number;
        this.price = price;
        this.capacity = capacity;
        this.services = services;
        this.image = image;
        this.roomGroup = roomGroup;
    }

    public <T> Room(int i, double v, int i1, List<String> list, String s) {
        this.number = i;
        this.price = v;
        this.capacity = i1;
        this.services = list;
        this.image = s;
    }
}
