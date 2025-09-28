package com.example.HotelManagment.Service;

import com.example.HotelManagment.Entity.GuestEntity;
import com.example.HotelManagment.Repository.GuestRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {

    private final GuestRepository guestRepository;

    public GuestServiceImpl(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @Override
    public List<GuestEntity> getAll() {
        return guestRepository.findAll();
    }

    @Override
    public GuestEntity save(GuestEntity guest) {
        return guestRepository.save(guest);
    }

    @Override
    public void delete(Long id) {
        guestRepository.deleteById(id);
    }
}

