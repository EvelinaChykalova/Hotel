package com.example.hotel.service.impls;

import com.example.hotel.model.Room;
import com.example.hotel.model.enums.Comfort;
import com.example.hotel.repository.RoomRepository;
import com.example.hotel.service.interfaces.RoomService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomRepository repository;

    //@PostConstruct
    public void init(){
        repository.save(new Room());
    }

    @Override
    public List<Room> getAll() {
        return repository.findAll();
    }

    @Override
    public Room getOne(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Room create(Room room) {
        room.setCreatedAt(LocalDateTime.now());
        return repository.save(room);
    }

    @Override
    public Room update(Room room) {
        String id = room.getId();
        Room room1 = this.getOne(id);
        room.setCreatedAt(room1.getCreatedAt());
        room.setUpdatedAt(LocalDateTime.now());
        return repository.save(room);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
