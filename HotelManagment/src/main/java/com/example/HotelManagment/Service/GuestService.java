package com.example.HotelManagment.Service;


import com.example.HotelManagment.Entity.GuestEntity;

import java.util.List;

public interface GuestService {
    List<GuestEntity> getAll();
    GuestEntity save(GuestEntity guest);
    void delete(Long id);
}
