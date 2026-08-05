package com.example.test.plug.DTOS;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PostInputDTO {
    @NotNull
    @NotBlank
    private String login;
    @NotNull
    @NotBlank
    private String password;
}
