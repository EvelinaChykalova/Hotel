package com.example.hotel.service.impls;

import com.example.hotel.model.Client;
import com.example.hotel.model.RegularClient;
import com.example.hotel.repository.RegularClientRepository;
import com.example.hotel.service.interfaces.ClientService;
import com.example.hotel.service.interfaces.RegularClientService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class RegularClientServiceImpl implements RegularClientService {
    @Autowired
    RegularClientRepository repository;

    @Autowired
    ClientService clientService;

    //@PostConstruct
    public void init(){
        repository.save(new RegularClient());
    }

    @Override
    public List<RegularClient> getAll() {
        return repository.findAll();
    }

    @Override
    public RegularClient getOne(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public RegularClient create(RegularClient regularClient) {
        regularClient.setRegistration(LocalDateTime.now());
        return repository.save(regularClient);
    }

    @Override
    public RegularClient update(RegularClient regularClient) {
        String id = regularClient.getId();
        RegularClient regularClient1 = this.getOne(id);
        regularClient.setRegistration(regularClient1.getRegistration());
        regularClient.setUpdatedAt(LocalDateTime.now());
        return repository.save(regularClient);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
