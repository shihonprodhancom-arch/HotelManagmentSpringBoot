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
            return bookingRepository.save(existingBooking);
        }).orElse(null);
    }

    @Override
    public void delete(Long id) {
        bookingRepository.deleteById(id);
    }
}
