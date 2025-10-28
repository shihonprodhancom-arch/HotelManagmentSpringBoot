package com.example.HotelManagment.Service;

import com.example.HotelManagment.Entity.Attendance;
import com.example.HotelManagment.Repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    public Optional<Attendance> getAttendanceById(Long id) {
        return attendanceRepository.findById(id);
    }

    public List<Attendance> getAttendanceByStaffId(Long staffId) {
        return attendanceRepository.findByStaffId(staffId);
    }

    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }
}
