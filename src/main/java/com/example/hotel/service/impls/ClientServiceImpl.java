package com.example.hotel.service.impls;

import com.example.hotel.model.Client;
import com.example.hotel.model.enums.ClientStatus;
import com.example.hotel.repository.ClientRepository;
import com.example.hotel.service.interfaces.ClientService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository repository;

    //@PostConstruct
    public void init(){
        repository.save(new Client());
    }

    @Override
    public List<Client> getAll() {
        return repository.findAll();
    }

    @Override
    public Client getOne(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Client create(Client client) {
        client.setCreatedAt(LocalDateTime.now());
        return repository.save(client);
    }

    @Override
    public Client update(Client client) {
        String id = client.getId();
        Client client1 = this.getOne(id);
        client.setCreatedAt(client1.getCreatedAt());
        client.setUpdatedAt(LocalDateTime.now());
        return repository.save(client);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
