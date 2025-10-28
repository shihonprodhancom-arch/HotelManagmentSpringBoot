package com.example.HotelManagment.Controller;

import com.example.HotelManagment.Entity.Attendance;
import com.example.HotelManagment.Service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/add")
    public Attendance addAttendance(@RequestBody Attendance attendance) {
        return attendanceService.saveAttendance(attendance);
    }

    @GetMapping("/all")
    public List<Attendance> getAllAttendance() {
        return attendanceService.getAllAttendance();
    }

    @GetMapping("/{id}")
    public Optional<Attendance> getAttendanceById(@PathVariable Long id) {
        return attendanceService.getAttendanceById(id);
    }

    @GetMapping("/staff/{staffId}")
    public List<Attendance> getAttendanceByStaffId(@PathVariable Long staffId) {
        return attendanceService.getAttendanceByStaffId(staffId);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAttendance(@PathVariable Long id) {
        attendanceService.deleteAttendance(id);
    }
}
