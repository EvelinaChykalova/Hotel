package com.example.hotel.controller.rest;

import com.example.hotel.model.EvictionOfRooms;
import com.example.hotel.model.RegularClient;
import com.example.hotel.service.interfaces.RegularClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/regular-clients")
public class RegularClientRestController {
    @Autowired
    RegularClientService regularClientService;

    @GetMapping("/")
    public List<RegularClient> getAll(){
        return regularClientService.getAll();
    }

    @GetMapping("/{id}")
    public RegularClient getOne(@PathVariable String id){
        return regularClientService.getOne(id);
    }

    @PostMapping("/")
    public RegularClient create(@RequestBody RegularClient regularClient){
        return regularClientService.create(regularClient);
    }

    @PutMapping("/")
    public RegularClient update(@RequestBody RegularClient regularClient){
        return regularClientService.update(regularClient);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        regularClientService.delete(id);
    }
}
