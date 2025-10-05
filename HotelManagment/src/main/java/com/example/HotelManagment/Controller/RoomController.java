package com.example.HotelManagment.Controller;



import com.example.HotelManagment.Entity.RoomEntity;
import com.example.HotelManagment.Service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin(origins = "http://localhost:4200")  // Angular default port
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<RoomEntity> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public RoomEntity getRoomById(@PathVariable Long id) {
        return roomService.getRoomById(id);
    }

    @PostMapping
    public RoomEntity createRoom(@RequestBody RoomEntity room) {
        return roomService.createRoom(room);
    }

    @PutMapping("/{id}")
    public RoomEntity updateRoom(@PathVariable Long id, @RequestBody RoomEntity room) {
        return roomService.updateRoom(id, room);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
    }
}


