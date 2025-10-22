package com.example.HotelManagment.Controller.NewController;


import com.example.HotelManagment.Dto.RoomGroupDTO;
import com.example.HotelManagment.Service.NewService.RoomGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room-groups")
@CrossOrigin(origins = "http://localhost:4200")
public class RoomGroupController {

    @Autowired
    private RoomGroupService roomGroupService;

    @GetMapping
    public ResponseEntity<List<RoomGroupDTO>> getAllRoomGroups() {
        List<RoomGroupDTO> roomGroups = roomGroupService.getAllRoomGroups();
        return ResponseEntity.ok(roomGroups);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomGroupDTO> getRoomGroupById(@PathVariable Long id) {
        RoomGroupDTO roomGroup = roomGroupService.getRoomGroupById(id);
        if (roomGroup != null) {
            return ResponseEntity.ok(roomGroup);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<RoomGroupDTO> getRoomGroupByType(@PathVariable String type) {
        RoomGroupDTO roomGroup = roomGroupService.getRoomGroupByType(type);
        if (roomGroup != null) {
            return ResponseEntity.ok(roomGroup);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<RoomGroupDTO> createRoomGroup(@RequestBody RoomGroupDTO roomGroupDTO) {
        RoomGroupDTO created = roomGroupService.createRoomGroup(roomGroupDTO);
        return ResponseEntity.ok(created);
    }
}