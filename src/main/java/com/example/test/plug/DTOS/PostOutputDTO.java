package com.example.test.plug.DTOS;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PostOutputDTO {
    private String login;
    private String password;
    private String date;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public PostOutputDTO() {
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getDate() {
        return date;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDate() {
        this.date = LocalDateTime.now().format(formatter);
    }
}
