package com.example.hotel.controller.rest;

import com.example.hotel.model.Bill;
import com.example.hotel.service.interfaces.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bills")
public class BillRestController {
    @Autowired
    BillService billService;

    @GetMapping("/")
    public List<Bill> getAll(){
        return billService.getAll();
    }

    @GetMapping("/{id}")
    public Bill getOne(@PathVariable String id){
        return billService.getOne(id);
    }

    @PostMapping("/")
    public Bill create(@RequestBody Bill bill){
        return billService.create(bill);
    }

    @PutMapping("/")
    public Bill update(@RequestBody Bill bill){
        return billService.update(bill);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        billService.delete(id);
    }
}
