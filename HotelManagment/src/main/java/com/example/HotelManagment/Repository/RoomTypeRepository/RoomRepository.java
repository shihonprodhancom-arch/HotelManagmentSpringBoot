package com.example.HotelManagment.Repository.RoomTypeRepository;




import com.example.HotelManagment.Entity.newEntitys.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> findByNumber(Integer number);
    List<Room> findByRoomGroupType(String type);
    boolean existsByNumber(Integer number);


    // Custom query for advanced search
//    @Query("SELECT r FROM Room r WHERE " +
//            "(:maxPrice IS NULL OR r.price <= :maxPrice) AND " +
//            "(:minCapacity IS NULL OR r.capacity >= :minCapacity)")
//    List<Room> findByPriceAndCapacity(@Param("maxPrice") Double maxPrice,
//                                      @Param("minCapacity") Integer minCapacity);

    // Find rooms by services (requires more complex query)
//    @Query("SELECT r FROM Room r JOIN r.services s WHERE s IN :services GROUP BY r HAVING COUNT(s) = :serviceCount")
//    List<Room> findByServices(@Param("services") List<String> services,
//                              @Param("serviceCount") Long serviceCount);

    // Find available rooms (you can extend this for booking functionality)
//    @Query("SELECT r FROM Room r WHERE r.id NOT IN " +
//            "(SELECT b.room.id FROM Booking b WHERE b.status IN ('CONFIRMED', 'CHECKED_IN'))")
//    List<Room> findAvailableRooms();
}