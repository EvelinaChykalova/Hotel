package com.example.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Bill {
    @Id
    private String id;
    private Client client;
    private List<Settlement> settlements;
    private List<Room> rooms;
    private double discount;
    private double totalSum;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Bill(Client client, List<Settlement> settlements, List<Room> rooms, double discount,
                double totalSum) {
        this.client = client;
        this.settlements = settlements;
        this.rooms = rooms;
        this.discount = discount;
        this.totalSum = totalSum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return Objects.equals(id, bill.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
