package com.example.hotel.service.interfaces;

import com.example.hotel.model.Client;
import com.example.hotel.model.Settlement;

import java.util.List;

public interface SettlementService {
    List<Settlement> getAll();
    Settlement getOne(String id);
    Settlement create(Settlement settlement);
    Settlement update(Settlement settlement);
    void delete(String id);
}
