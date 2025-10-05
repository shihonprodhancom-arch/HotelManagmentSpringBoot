package com.example.HotelManagment.Service;



import com.example.HotelManagment.Entity.RoomEntity;
import com.example.HotelManagment.Repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<RoomEntity> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public RoomEntity getRoomById(Long id) {
        return roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room not found"));
    }

    @Override
    public RoomEntity createRoom(RoomEntity room) {
        return roomRepository.save(room);
    }

    @Override
    public RoomEntity updateRoom(Long id, RoomEntity room) {
        RoomEntity existingRoom = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));
        existingRoom.setNumber(room.getNumber());
        existingRoom.setType(room.getType());
        existingRoom.setStatus(room.getStatus());
        existingRoom.setPrice(room.getPrice());
        return roomRepository.save(existingRoom);
    }

    @Override
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}

