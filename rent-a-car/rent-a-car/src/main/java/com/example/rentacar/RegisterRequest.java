package com.example.rentacar;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

public class RegisterRequest {

    @NotNull(message = "Username is required")
    @Length(min = 4, message = "Username must be at least 4 characters long")
    private String username;

    @NotNull(message = "Password is required")
    @Length(min = 4, message = "Password must be at least 4 characters long")
    private String password;

    @NotNull(message = "Password repeat is required")
    @Length(min = 4, message = "Password repeat must be at least 4 characters long")
    private String passwordRepeat;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

        public String getPasswordRepeat() {
            return passwordRepeat;
        }

        public void setPasswordRepeat(String passwordRepeat) {
            this.passwordRepeat = passwordRepeat;
        }
}