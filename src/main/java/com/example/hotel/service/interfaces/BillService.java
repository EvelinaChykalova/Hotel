package com.example.hotel.service.interfaces;

import com.example.hotel.model.Bill;
import com.example.hotel.model.Client;

import java.util.List;

public interface BillService {
    List<Bill> getAll();
    Bill getOne(String id);
    Bill create(Bill bill);
    Bill update(Bill bill);
    void delete(String id);
}
