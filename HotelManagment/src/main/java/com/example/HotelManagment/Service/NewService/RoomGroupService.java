package com.example.HotelManagment.Service.NewService;


import com.example.HotelManagment.Dto.RoomGroupDTO;
import com.example.HotelManagment.Entity.newEntitys.Room;
import com.example.HotelManagment.Entity.newEntitys.RoomGroup;
import com.example.HotelManagment.Repository.RoomTypeRepository.RoomGroupRepository;
import com.example.HotelManagment.Repository.RoomTypeRepository.RoomRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomGroupService {

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private RoomGroupRepository roomGroupRepository;

    public List<RoomGroupDTO> getAllRoomGroups() {
        return roomGroupRepository.findAll().stream()
                .map(RoomGroupDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public RoomGroupDTO getRoomGroupById(Long id) {
        return roomGroupRepository.findById(id)
                .map(RoomGroupDTO::fromEntity)
                .orElse(null);
    }

    public RoomGroupDTO getRoomGroupByType(String type) {
        return roomGroupRepository.findByType(type)
                .map(RoomGroupDTO::fromEntity)
                .orElse(null);
    }

    public RoomGroupDTO createRoomGroup(RoomGroupDTO roomGroupDTO) {
        RoomGroup roomGroup = new RoomGroup(roomGroupDTO.getType());
        RoomGroup saved = roomGroupRepository.save(roomGroup);
        return RoomGroupDTO.fromEntity(saved);
    }




    // ... existing methods ...

    @Transactional
    public RoomGroupDTO addRoomToGroup(Long groupId, Room room) {
        try {
            RoomGroup roomGroup = roomGroupRepository.findById(groupId)
                    .orElseThrow(() -> new RuntimeException("Room group not found with id: " + groupId));

            if (roomRepository.existsByNumber(room.getNumber())) {
                throw new RuntimeException("Room number already exists: " + room.getNumber());
            }

            roomGroup.setRoom(room);
            RoomGroup saved = roomGroupRepository.save(roomGroup);
            return RoomGroupDTO.fromEntity(saved);
        } catch (Exception e) {
            throw new RuntimeException("Error adding room to group: " + e.getMessage());
        }
    }

    @Transactional
    public RoomGroupDTO removeRoomFromGroup(Long groupId, Long roomId) {
        try {
            RoomGroup roomGroup = roomGroupRepository.findById(groupId)
                    .orElseThrow(() -> new RuntimeException("Room group not found with id: " + groupId));

            Room room = roomRepository.findById(roomId)
                    .orElseThrow(() -> new RuntimeException("Room not found with id: " + roomId));

            if (!room.getRoomGroup().getId().equals(groupId)) {
                throw new RuntimeException("Room does not belong to this group");
            }

            roomGroup.removeRoom(room);
            roomRepository.delete(room);
            RoomGroup saved = roomGroupRepository.save(roomGroup);
            return RoomGroupDTO.fromEntity(saved);
        } catch (Exception e) {
            throw new RuntimeException("Error removing room from group: " + e.getMessage());
        }
    }
}