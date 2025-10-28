package com.example.HotelManagment.Repository;

//import com.example.HotelManagment.Entity.Attendance;
//import com.example.HotelManagment.Entity.Staff;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//import java.time.LocalDate;
//import java.util.List;
//
//@Repository
//public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
//    List<Attendance> findByStaff(Staff staff);
//    List<Attendance> findByDate(LocalDate date);
//}




import com.example.HotelManagment.Entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    // Spring Data JPA automatically implements this method
    List<Attendance> findByStaffId(Long staffId);
}

