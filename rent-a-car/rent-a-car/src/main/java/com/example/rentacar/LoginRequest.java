package com.example.rentacar;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

public class LoginRequest {

    @NotNull(message = "Username is required")
    @Length(min = 4, message = "Username must be at least 4 characters long")
    private String username;

    @NotNull(message = "Password is required")
    @Length(min = 4, message = "Password must be at least 4 characters long")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername() {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword() {
        this.password = password;
    }
}