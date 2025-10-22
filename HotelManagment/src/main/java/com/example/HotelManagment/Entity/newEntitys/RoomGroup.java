package com.example.HotelManagment.Entity.newEntitys;



import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "room_types")
public class RoomGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String type;

    @OneToMany(mappedBy = "roomGroup", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Room> rooms = new ArrayList<>();

    // Constructors
    public RoomGroup() {}

    public RoomGroup(String type) {
        this.type = type;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public List<Room> getRooms() { return rooms; }
    public void setRooms(List<Room> rooms) { this.rooms = rooms; }

    public void setRoom(Room room) {
        rooms.add(room);
        room.setRoomGroup(this);
    }

    public void removeRoom(Room room) {
        rooms.remove(room);
    }
}
