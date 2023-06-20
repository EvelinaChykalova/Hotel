package com.example.hotel.model;

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
public class Settlement {
    @Id
    private String id;
    private Client client;
    private Room room;
    private LocalDateTime dateOfSettlement;
    private LocalDateTime dateOfEviction;
    private String note;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Settlement(Client client, Room room, String note) {
        this.client = client;
        this.room = room;
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Settlement that = (Settlement) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
