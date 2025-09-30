package com.example.HotelManagment.Service;

import com.example.HotelManagment.Entity.RoomEntity;
import com.example.HotelManagment.Repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<RoomEntity> getAll() {
        return roomRepository.findAll();
    }

    public RoomEntity save(RoomEntity room) {
        return roomRepository.save(room);
    }

    public RoomEntity getById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        roomRepository.deleteById(id);
    }
}

