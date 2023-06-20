package com.example.hotel.model;

import com.example.hotel.model.enums.Comfort;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Room {
    @Id
    private String id;
    private String number;
    private Integer numberOfPeople;
    private Comfort comfort;
    private Double price;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Room(String number, Integer numberOfPeople, Comfort comfort, Double price) {
        this.number = number;
        this.numberOfPeople = numberOfPeople;
        this.comfort = comfort;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(id, room.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
