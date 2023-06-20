package com.example.hotel.controller.rest;

import com.example.hotel.model.RegularClient;
import com.example.hotel.model.Room;
import com.example.hotel.service.interfaces.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomRestController {
    @Autowired
    RoomService roomService;

    @GetMapping("/")
    public List<Room> getAll(){
        return roomService.getAll();
    }

    @GetMapping("/{id}")
    public Room getOne(@PathVariable String id){
        return roomService.getOne(id);
    }

    @PostMapping("/")
    public Room create(@RequestBody Room room){
        return roomService.create(room);
    }

    @PutMapping("/")
    public Room update(@RequestBody Room room){
        return roomService.update(room);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        roomService.delete(id);
    }
}
