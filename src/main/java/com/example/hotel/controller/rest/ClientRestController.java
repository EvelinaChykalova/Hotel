package com.example.hotel.controller.rest;

import com.example.hotel.model.Bill;
import com.example.hotel.model.Client;
import com.example.hotel.service.interfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientRestController {
    @Autowired
    ClientService clientService;

    @GetMapping("/")
    public List<Client> getAll(){
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    public Client getOne(@PathVariable String id){
        return clientService.getOne(id);
    }

    @PostMapping("/")
    public Client create(@RequestBody Client client){
        return clientService.create(client);
    }

    @PutMapping("/")
    public Client update(@RequestBody Client client){
        return clientService.update(client);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        clientService.delete(id);
    }
}
