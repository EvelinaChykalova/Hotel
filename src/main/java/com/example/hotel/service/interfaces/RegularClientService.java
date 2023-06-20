package com.example.hotel.service.interfaces;

import com.example.hotel.model.Client;
import com.example.hotel.model.RegularClient;

import java.util.List;

public interface RegularClientService {
    List<RegularClient> getAll();
    RegularClient getOne(String id);
    RegularClient create(RegularClient regularClient);
    RegularClient update(RegularClient regularClient);
    void delete(String id);
}
