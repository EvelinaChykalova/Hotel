package com.example.hotel.service.impls;

import com.example.hotel.model.EvictionOfRooms;
import com.example.hotel.repository.EvictionOfRoomsRepository;
import com.example.hotel.service.interfaces.EvictionService;
import com.example.hotel.service.interfaces.SettlementService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EvictionServiceImpl implements EvictionService {
    @Autowired
    EvictionOfRoomsRepository repository;

    @Autowired
    SettlementService settlementService;

    //@PostConstruct
    public void init(){
        repository.save(new EvictionOfRooms());
    }

    @Override
    public List<EvictionOfRooms> getAll() {
        return repository.findAll();
    }

    @Override
    public EvictionOfRooms getOne(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public EvictionOfRooms create(EvictionOfRooms evictionOfRooms) {
        return null;
    }

    @Override
    public EvictionOfRooms update(EvictionOfRooms evictionOfRooms) {
        return null;
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id)
        ;
    }
}
