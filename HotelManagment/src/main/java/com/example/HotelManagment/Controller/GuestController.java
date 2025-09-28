package com.example.HotelManagment.Controller;

import com.example.HotelManagment.Entity.GuestEntity;

import com.example.HotelManagment.Service.GuestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guests")
@CrossOrigin(origins = "http://localhost:4200")
public class GuestController {

    private final GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    // Get all guests
    @GetMapping
    public List<GuestEntity> getAllGuests() {
        return guestService.getAll();
    }

    // Add new guest
    @PostMapping
    public GuestEntity addGuest(@RequestBody GuestEntity guest) {
        return guestService.save(guest);
    }

    // Delete guest by ID
    @DeleteMapping("/{id}")
    public void deleteGuest(@PathVariable Long id) {
        guestService.delete(id);
    }
}

