package com.example.hotel.controller.rest;

import com.example.hotel.model.Client;
import com.example.hotel.model.EvictionOfRooms;
import com.example.hotel.service.interfaces.EvictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/evictions")
public class EvictionOfRoomsRestController {
    @Autowired
    EvictionService evictionService;

    @GetMapping("/")
    public List<EvictionOfRooms> getAll(){
        return evictionService.getAll();
    }

    @GetMapping("/{id}")
    public EvictionOfRooms getOne(@PathVariable String id){
        return evictionService.getOne(id);
    }

    @PostMapping("/")
    public EvictionOfRooms create(@RequestBody EvictionOfRooms evictionOfRooms){
        return evictionService.create(evictionOfRooms);
    }

    @PutMapping("/")
    public EvictionOfRooms update(@RequestBody EvictionOfRooms evictionOfRooms){
        return evictionService.update(evictionOfRooms);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        evictionService.delete(id);
    }
}
