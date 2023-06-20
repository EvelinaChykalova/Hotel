package com.example.hotel.service.interfaces;

import com.example.hotel.model.Client;
import com.example.hotel.model.Room;

import java.util.List;

public interface RoomService {
    List<Room> getAll();
    Room getOne(String id);
    Room create(Room room);
    Room update(Room room);
    void delete(String id);
}
