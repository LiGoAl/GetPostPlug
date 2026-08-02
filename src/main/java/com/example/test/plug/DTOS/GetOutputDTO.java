package com.example.test.plug.DTOS;

public class GetOutputDTO {
    private String login;
    private String status;

    public GetOutputDTO() {
    }

    public String getLogin() {
        return login;
    }

    public String getStatus() {
        return status;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
