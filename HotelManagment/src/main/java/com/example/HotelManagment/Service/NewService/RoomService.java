package com.example.HotelManagment.Service.NewService;




import com.example.HotelManagment.Dto.RoomDTO;
import com.example.HotelManagment.Dto.RoomGroupDTO;
import com.example.HotelManagment.Entity.newEntitys.Room;
import com.example.HotelManagment.Entity.newEntitys.RoomGroup;
import com.example.HotelManagment.Repository.RoomTypeRepository.RoomRepository;
import com.example.HotelManagment.Repository.RoomTypeRepository.RoomGroupRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {

    @Autowired
    private RoomGroupRepository roomGroupRepository;

    @Autowired
    private RoomRepository roomRepository;

    // Initialize sample data
    @PostConstruct
    public void initSampleData() {
        if (roomGroupRepository.count() == 0) {
            createSampleData();
        }
    }

    private void createSampleData() {
        // Single Rooms
        RoomGroup single = new RoomGroup("Single");
        single.setRoom(new Room(101, 2000.0, 1, Arrays.asList("WiFi", "AC"), "assets/img/download (1).jpg", single));
        single.setRoom(new Room(102, 2100.0, 1, Arrays.asList("WiFi", "AC"), "assets/img/download (2).jpg", single));
        single.setRoom(new Room(103, 2200.0, 1, Arrays.asList("WiFi", "AC"), "assets/img/download (3).jpg", single));
        single.setRoom(new Room(104, 2300.0, 1, Arrays.asList("WiFi", "AC"), "assets/img/download (5).jpg", single));
        roomGroupRepository.save(single);

        // Double Rooms
        RoomGroup doubleType = new RoomGroup("Double");
        doubleType.setRoom(new Room(201, 3000.0, 2, Arrays.asList("WiFi", "AC", "TV"), "assets/img/markus-spiske-g5ZIXjzRGds-unsplash.jpg", doubleType));
        doubleType.setRoom(new Room(202, 3100.0, 2, Arrays.asList("WiFi", "AC", "TV"), "assets/img/manuel-moreno-DGa0LQ0yDPc-unsplash.jpg", doubleType));
        doubleType.setRoom(new Room(203, 3200.0, 2, Arrays.asList("WiFi", "AC", "TV"), "assets/img/gettyimages-1390233984-612x612.jpg", doubleType));
        doubleType.setRoom(new Room(204, 3300.0, 2, Arrays.asList("WiFi", "AC", "TV"), "assets/img/download (4).jpg", doubleType));
        doubleType.setRoom(new Room(205, 3400.0, 2, Arrays.asList("WiFi", "AC", "TV"), "assets/img/gettyimages-154945734-612x612.jpg", doubleType));
        roomGroupRepository.save(doubleType);

        // Suite Rooms
        RoomGroup suite = new RoomGroup("Suite");
        suite.setRoom(new Room(301, 5000.0, 4, Arrays.asList("WiFi", "AC", "TV", "Mini Bar"), "assets/img/gettyimages-1148452746-612x612.jpg", suite));
        suite.setRoom(new Room(302, 5100.0, 4, Arrays.asList("WiFi", "AC", "TV", "Mini Bar"), "assets/img/gettyimages-1266155634-612x612.jpg", suite));
        suite.setRoom(new Room(303, 5200.0, 4, Arrays.asList("WiFi", "AC", "TV", "Mini Bar"), "assets/img/gettyimages-1300135335-612x612.jpg", suite));
        roomGroupRepository.save(suite);

        // Honeymoon Rooms
        RoomGroup honeymoon = new RoomGroup("Honeymoon");
        honeymoon.setRoom(new Room(401, 6000.0, 2, Arrays.asList("WiFi", "AC", "TV", "Jacuzzi"), "assets/img/download (6).jpg", honeymoon));
        honeymoon.setRoom(new Room(402, 6200.0, 2, Arrays.asList("WiFi", "AC", "TV", "Jacuzzi"), "assets/img/gettyimages-1334117383-612x612.jpg", honeymoon));
        roomGroupRepository.save(honeymoon);

        // Family Rooms
        RoomGroup family = new RoomGroup("Family");
        family.setRoom(new Room(501, 7000.0, 5, Arrays.asList("WiFi", "AC", "TV"), "assets/img/gettyimages-1148452746-612x612.jpg", family));
        family.setRoom(new Room(502, 7100.0, 5, Arrays.asList("WiFi", "AC", "TV"), "assets/img/manuel-moreno-DGa0LQ0yDPc-unsplash.jpg", family));
        roomGroupRepository.save(family);

        // VIP Rooms
        RoomGroup vip = new RoomGroup("VIP");
        vip.setRoom(new Room(601, 12000.0, 3, Arrays.asList("WiFi", "AC", "TV", "Mini Bar", "Private Pool"), "assets/img/gettyimages-1334117383-612x612.jpg", vip));
        vip.setRoom(new Room(602, 12500.0, 3, Arrays.asList("WiFi", "AC", "TV", "Mini Bar", "Private Pool"), "assets/img/gettyimages-1390233984-612x612.jpg", vip));
        roomGroupRepository.save(vip);
    }

    public List<RoomGroupDTO> getAllRoomGroups() {
        List<RoomGroup> roomGroups = roomGroupRepository.findAll();

        return roomGroups.stream()
                .map(roomGroup -> new RoomGroupDTO(
                        roomGroup.getType(),
                        roomGroup.getRooms().stream()
                                .map(room -> new RoomDTO(
                                        room.getNumber(),
                                        room.getPrice(),
                                        room.getCapacity(),
                                        room.getServices(),
                                        room.getImage()
                                ))
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    public List<RoomGroupDTO> getRoomsByType(String type) {
        List<RoomGroup> roomGroups = roomGroupRepository.findAll().stream()
                .filter(rt -> rt.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());

        return roomGroups.stream()
                .map(roomGroup -> new RoomGroupDTO(
                        roomGroup.getType(),
                        roomGroup.getRooms().stream()
                                .map(room -> new RoomDTO(
                                        room.getNumber(),
                                        room.getPrice(),
                                        room.getCapacity(),
                                        room.getServices(),
                                        room.getImage()
                                ))
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

//    public Room getRoomByNumber(Integer roomNumber) {
//        return roomRepository.findByNumber(roomNumber)
//                .orElseThrow(() -> new RuntimeException("Room not found with number: " + roomNumber));
//    }

    public RoomDTO getRoomByNumber(Integer number) {
        return roomRepository.findByNumber(number)
                .map(RoomDTO::fromEntity)
                .orElseThrow(() -> new RuntimeException("Room not found with number: " + number));
    }

    public List<RoomDTO> getAllRooms() {
        try {
            return roomRepository.findAll().stream()
                    .map(RoomDTO::fromEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving rooms: " + e.getMessage());
        }
    }

    public RoomDTO getRoomById(Long id) {
        return roomRepository.findById(id)
                .map(RoomDTO::fromEntity)
                .orElseThrow(() -> new RuntimeException("Room not found with id: " + id));
    }

//

    public List<RoomDTO> getRoomsByGroupType(String type) {
        try {
            return roomRepository.findByRoomGroupType(type).stream()
                    .map(RoomDTO::fromEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving rooms by type: " + e.getMessage());
        }
    }

    public RoomDTO createRoom(RoomDTO roomDTO) {
        try {
            if (roomRepository.existsByNumber(roomDTO.getNumber())) {
                throw new RuntimeException("Room number already exists: " + roomDTO.getNumber());
            }

            Room room = new Room(
                    roomDTO.getNumber(),
                    roomDTO.getPrice(),
                    roomDTO.getCapacity(),
                    roomDTO.getServices(),
                    roomDTO.getImage()
            );

            Room saved = roomRepository.save(room);
            return RoomDTO.fromEntity(saved);
        } catch (Exception e) {
            throw new RuntimeException("Error creating room: " + e.getMessage());
        }
    }

    public RoomDTO updateRoom(Long id, RoomDTO roomDTO) {
        try {
            Room existingRoom = roomRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Room not found with id: " + id));

            // Check if number is being changed and if it conflicts with existing room
            if (!existingRoom.getNumber().equals(roomDTO.getNumber()) &&
                    roomRepository.existsByNumber(roomDTO.getNumber())) {
                throw new RuntimeException("Room number already exists: " + roomDTO.getNumber());
            }

            existingRoom.setNumber(roomDTO.getNumber());
            existingRoom.setPrice(roomDTO.getPrice());
            existingRoom.setCapacity(roomDTO.getCapacity());
            existingRoom.setServices(roomDTO.getServices());
            existingRoom.setImage(roomDTO.getImage());

            Room updated = roomRepository.save(existingRoom);
            return RoomDTO.fromEntity(updated);
        } catch (Exception e) {
            throw new RuntimeException("Error updating room: " + e.getMessage());
        }
    }

    public void deleteRoom(Long id) {
        try {
            if (!roomRepository.existsById(id)) {
                throw new RuntimeException("Room not found with id: " + id);
            }
            roomRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting room: " + e.getMessage());
        }
    }

    public List<RoomDTO> searchRooms(Double maxPrice, Integer minCapacity, List<String> services) {
        try {
            // This is a basic implementation - you might want to create a custom repository method
            return roomRepository.findAll().stream()
                    .filter(room -> maxPrice == null || room.getPrice() <= maxPrice)
                    .filter(room -> minCapacity == null || room.getCapacity() >= minCapacity)
                    .filter(room -> services == null || services.isEmpty() ||
                            room.getServices().containsAll(services))
                    .map(RoomDTO::fromEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error searching rooms: " + e.getMessage());
        }
    }
}