package com.pma.pimacpt.security.model;

import javax.validation.constraints.NotBlank;

public class UserLoginModel {
    @NotBlank
    private String user;
    @NotBlank
    private String password;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
