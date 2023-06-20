package com.example.hotel.service.interfaces;


import com.example.hotel.model.EvictionOfRooms;

import java.util.List;

public interface EvictionService {
    List<EvictionOfRooms> getAll();
    EvictionOfRooms getOne(String id);
    EvictionOfRooms create(EvictionOfRooms evictionOfRooms);
    EvictionOfRooms update(EvictionOfRooms evictionOfRooms);
    void delete(String id);
}
