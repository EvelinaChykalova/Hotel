package com.example.hotel.service.impls;

import com.example.hotel.model.Bill;
import com.example.hotel.model.Client;
import com.example.hotel.model.Room;
import com.example.hotel.model.Settlement;
import com.example.hotel.model.enums.ClientStatus;
import com.example.hotel.repository.BillRepository;
import com.example.hotel.service.interfaces.BillService;
import com.example.hotel.service.interfaces.ClientService;
import com.example.hotel.service.interfaces.RoomService;
import com.example.hotel.service.interfaces.SettlementService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    BillRepository repository;

    @Autowired
    ClientService clientService;

    @Autowired
    SettlementService settlementService;

    @Autowired
    RoomService roomService;

    //@PostConstruct
    public void init(){
        repository.save(new Bill());
    }

    @Override
    public List<Bill> getAll() {
        return repository.findAll();
    }

    @Override
    public Bill getOne(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Bill create(Bill bill) {
        bill.setCreatedAt(LocalDateTime.now());
        return repository.save(bill);
    }

    @Override
    public Bill update(Bill bill) {
        String id = bill.getId();
        Bill bill1 = this.getOne(id);
        bill.setCreatedAt(bill1.getCreatedAt());
        bill.setUpdatedAt(LocalDateTime.now());
        return repository.save(bill);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    private double getTotalDiscount(Client client, List<Settlement> settlementList){
        Double discount1 = 0.0;
        Double discount2 = 0.0;
        if(client.getClientStatus() == ClientStatus.REGULAR){
            discount1 = 0.02;
        }
        if(settlementList.stream().mapToDouble(el -> el.getRoom().getPrice()).sum() > 10){
            discount2 = 0.03;
        }
        return discount1 + discount2;
    }
    private double getTotalSum(Client client, List<Settlement> settlementList, List<Room> roomList){
        double suma = roomList.stream().mapToDouble(Room::getPrice).sum();
        return suma - suma * getTotalDiscount(client, settlementList);
    }
    public void getBill(Client client, List<Settlement> settlementList, List<Room> roomList){
        Bill bill = new Bill();
        bill.setClient(client);
        bill.setSettlements(settlementList);
        bill.setDiscount(getTotalDiscount(client, settlementList));
        bill.setTotalSum(getTotalSum(client, settlementList, roomList));

    }
}
