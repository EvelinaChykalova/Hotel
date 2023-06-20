package com.example.hotel.model;

import com.example.hotel.model.enums.ClientStatus;
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
public class Client {
    @Id
    private String id;
    private String lastName;
    private String firstName;
    private String patronymic;
    private String passportData;
    private String comment;
    private ClientStatus clientStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Client(String lastName, String firstName, String patronymic, String passportData,
                  String comment, ClientStatus clientStatus) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.passportData = passportData;
        this.comment = comment;
        this.clientStatus = clientStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
