package com.example.test.plug.DTOS;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class UserDTO {
    @NotNull
    @NotBlank
    private String login;
    @NotNull
    @NotBlank
    private String password;
    @NotNull
    @NotBlank
    private String email;
    @Setter(AccessLevel.NONE)
    private LocalDateTime date;
    @JsonIgnore
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public UserDTO(String login, String password, String email, LocalDateTime date) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.date = date;
    }

    @JsonCreator
    public UserDTO() {
        this.date = LocalDateTime.now();
    }
}
