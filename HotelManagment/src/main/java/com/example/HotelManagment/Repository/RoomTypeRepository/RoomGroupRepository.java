package com.example.HotelManagment.Repository.RoomTypeRepository;




import com.example.HotelManagment.Entity.newEntitys.RoomGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomGroupRepository extends JpaRepository<RoomGroup, Long> {
    Optional<RoomGroup> findByType(String type);
    boolean existsByType(String type);
}