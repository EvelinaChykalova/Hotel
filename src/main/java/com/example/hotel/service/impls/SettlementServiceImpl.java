package com.example.hotel.service.impls;

import com.example.hotel.model.EvictionOfRooms;
import com.example.hotel.model.Settlement;
import com.example.hotel.repository.EvictionOfRoomsRepository;
import com.example.hotel.repository.SettlementRepository;
import com.example.hotel.service.interfaces.ClientService;
import com.example.hotel.service.interfaces.RoomService;
import com.example.hotel.service.interfaces.SettlementService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SettlementServiceImpl implements SettlementService {
    @Autowired
    SettlementRepository repository;

    @Autowired
    EvictionOfRoomsRepository evictionOfRoomsRepository;

    @Autowired
    ClientService clientService;

    @Autowired
    RoomService roomService;

    //@PostConstruct
    public void init(){
        repository.save(new Settlement());
    }

    @Override
    public List<Settlement> getAll() {
        return repository.findAll();
    }

    @Override
    public Settlement getOne(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Settlement create(Settlement settlement) {
        settlement.setCreatedAt(LocalDateTime.now());
        settlement.setDateOfSettlement(LocalDateTime.now());
        return repository.save(settlement);
    }

    @Override
    public Settlement update(Settlement settlement) {
        String id = settlement.getId();
        Settlement settlement1 = this.getOne(id);
        settlement.setCreatedAt(settlement1.getCreatedAt());
        settlement.setDateOfSettlement(settlement1.getDateOfSettlement());
        settlement.setUpdatedAt(LocalDateTime.now());
        return repository.save(settlement);
    }

    @Override
    public void delete(String id) {
        Settlement settlement = this.getOne(id);
        settlement.setDateOfEviction(LocalDateTime.now());
        evictionOfRoomsRepository.save(new EvictionOfRooms(settlement));
        repository.delete(settlement);
    }
}
