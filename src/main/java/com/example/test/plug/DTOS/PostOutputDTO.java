package com.example.test.plug.DTOS;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class PostOutputDTO {
    private String login;
    private String password;
    @Setter(AccessLevel.NONE)
    private String date;
    @JsonIgnore
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public PostOutputDTO(String login, String password) {
        this.login = login;
        this.password = password;
        this.date = LocalDateTime.now().format(formatter);
    }

    public void setDate() {
        this.date = LocalDateTime.now().format(formatter);
    }
}
