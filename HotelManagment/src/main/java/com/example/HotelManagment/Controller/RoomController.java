package com.example.HotelManagment.Controller;

import com.example.HotelManagment.Entity.RoomEntity;
import com.example.HotelManagment.Service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin(origins = "http://localhost:4200")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    // Get all rooms
    @GetMapping
    public List<RoomEntity> getAllRooms() {
        return roomService.getAll();
    }

    // Add new room
    @PostMapping
    public RoomEntity addRoom(@RequestBody RoomEntity room) {
        return roomService.save(room);
    }

    // Get room by ID
    @GetMapping("/{id}")
    public RoomEntity getRoom(@PathVariable Long id) {
        return roomService.getById(id);
    }

    // Delete room by ID
    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Long id) {
        roomService.delete(id);
    }
}

