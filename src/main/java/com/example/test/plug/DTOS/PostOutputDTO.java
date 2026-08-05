package com.example.test.plug.DTOS;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class PostOutputDTO {
    private String login;
    private String password;
    private String date;
    @JsonIgnore
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void setDate() {
        this.date = LocalDateTime.now().format(formatter);
    }
}
