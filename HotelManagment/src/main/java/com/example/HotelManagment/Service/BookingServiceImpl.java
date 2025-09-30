package com.example.HotelManagment.Service;

import com.example.HotelManagment.Entity.BookingEntity;
import com.example.HotelManagment.Repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<BookingEntity> getAll() {
        return bookingRepository.findAll();
    }

    @Override
    public BookingEntity getById(Long id) {
        Optional<BookingEntity> booking = bookingRepository.findById(id);
        return booking.orElse(null);
    }

    @Override
    public BookingEntity save(BookingEntity booking) {
        // Ensure non-null fields for new bookings
        if (booking.getStatus() == null) booking.setStatus("Pending");
        if (booking.getPaymentMethod() == null) booking.setPaymentMethod("");
        if (booking.getPaymentInfo() == null) booking.setPaymentInfo("");
        return bookingRepository.save(booking);
    }

    @Override
    public BookingEntity update(Long id, BookingEntity booking) {
        return bookingRepository.findById(id).map(existingBooking -> {
            existingBooking.setGuestName(booking.getGuestName());
            existingBooking.setRoomNumber(booking.getRoomNumber());
            existingBooking.setCheckInDate(booking.getCheckInDate());
            existingBooking.setCheckOutDate(booking.getCheckOutDate());
            existingBooking.setTotalPrice(booking.getTotalPrice());
            existingBooking.setStatus(booking.getStatus() != null ? booking.getStatus() : existingBooking.getStatus());
            existingBooking.setPaymentMethod(booking.getPaymentMethod() != null ? booking.getPaymentMethod() : existingBooking.getPaymentMethod());
            existingBooking.setPaymentInfo(booking.getPaymentInfo() != null ? booking.getPaymentInfo() : existingBooking.getPaymentInfo());
            return bookingRepository.save(existingBooking);
        }).orElse(null);
    }

    @Override
    public void delete(Long id) {
        bookingRepository.deleteById(id);
    }
}
