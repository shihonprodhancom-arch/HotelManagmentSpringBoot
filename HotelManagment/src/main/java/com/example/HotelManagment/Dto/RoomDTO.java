package com.example.HotelManagment.Dto;



import com.example.HotelManagment.Entity.newEntitys.Room;
import lombok.Data;

import java.util.List;

@Data
public class RoomDTO {
    private Long id;
    private Integer number;
    private Double price;
    private Integer capacity;
    private List<String> services;
    private String image;

    // Constructors
    public RoomDTO() {}

    public RoomDTO(Integer number, Double price, Integer capacity, List<String> services, String image) {
        this.number = number;
        this.price = price;
        this.capacity = capacity;
        this.services = services;
        this.image = image;
    }
    // Static factory method from Entity
    public static RoomDTO fromEntity(Room room) {
        RoomDTO dto = new RoomDTO();
        dto.setId(room.getId());
        dto.setNumber(room.getNumber());
        dto.setPrice(room.getPrice());
        dto.setCapacity(room.getCapacity());
        dto.setServices(room.getServices());
        dto.setImage(room.getImage());
        return dto;
    }
}
