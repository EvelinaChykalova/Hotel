package com.example.hotel.repository;

import com.example.hotel.model.Settlement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettlementRepository extends MongoRepository<Settlement, String> {

}
