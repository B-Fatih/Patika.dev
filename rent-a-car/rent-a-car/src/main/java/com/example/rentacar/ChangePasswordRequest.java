package com.example.rentacar;

import javax.validation.constraints.NotNull;

public class ChangePasswordRequest {

    @NotNull(message = "oldPassword is required")
    private String oldPassword;

    @NotNull(message = "password is required")
    private String password;

    @NotNull(message = "passwordRepeat is required")
    private String passwordRepeat;

    public String getOldPassword() {
        return oldPassword;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNewPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }
}
