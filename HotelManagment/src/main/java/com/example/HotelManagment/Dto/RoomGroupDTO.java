package com.example.HotelManagment.Dto;



import com.example.HotelManagment.Entity.newEntitys.RoomGroup;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class RoomGroupDTO {
    private Long id;
    private String type;
    private List<RoomDTO> rooms;

    // Constructors
    public RoomGroupDTO() {}

    public RoomGroupDTO(String type, List<RoomDTO> rooms) {
        this.type = type;
        this.rooms = rooms;
    }

    // Static factory method from Entity
    public static RoomGroupDTO fromEntity(RoomGroup roomGroup) {
        RoomGroupDTO dto = new RoomGroupDTO();
        dto.setId(roomGroup.getId());
        dto.setType(roomGroup.getType());
        dto.setRooms(roomGroup.getRooms().stream()
                .map(RoomDTO::fromEntity)
                .collect(Collectors.toList()));
        return dto;
    }
}