package com.example.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class EvictionOfRooms {
    @Id
    private String id;
    private Settlement settlement;

    public EvictionOfRooms(Settlement settlement) {
        this.settlement = settlement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EvictionOfRooms that = (EvictionOfRooms) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
