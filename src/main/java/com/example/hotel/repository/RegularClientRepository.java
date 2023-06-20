package com.example.hotel.repository;

import com.example.hotel.model.RegularClient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegularClientRepository extends MongoRepository<RegularClient, String> {

}
