package com.example.hotel.repository;

import com.example.hotel.model.EvictionOfRooms;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvictionOfRoomsRepository extends MongoRepository<EvictionOfRooms, String> {

}
