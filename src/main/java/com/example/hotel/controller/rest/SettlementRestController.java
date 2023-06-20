package com.example.hotel.controller.rest;

import com.example.hotel.model.Room;
import com.example.hotel.model.Settlement;
import com.example.hotel.service.interfaces.SettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/settlements")
public class SettlementRestController {
    @Autowired
    SettlementService settlementService;

    @GetMapping("/")
    public List<Settlement> getAll(){
        return settlementService.getAll();
    }

    @GetMapping("/{id}")
    public Settlement getOne(@PathVariable String id){
        return settlementService.getOne(id);
    }

    @PostMapping("/")
    public Settlement create(@RequestBody Settlement settlement){
        return settlementService.create(settlement);
    }

    @PutMapping("/")
    public Settlement update(@RequestBody Settlement settlement){
        return settlementService.update(settlement);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        settlementService.delete(id);
    }
}
