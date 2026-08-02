package com.example.test.plug.DTOS;

public class PostInputDTO {
    private String login;
    private String password;

    public PostInputDTO() {
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
