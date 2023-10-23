package com.example.rentacar;

import jakarta.persistence.*;

@Entity
@Table(name = "tokens",
        indexes = {
                @Index(name = "index_token", columnList = "token"),
                @Index(name = "index_user_id", columnList = "user_id")
        })
public class TokenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "token")
    private String token;

    @Column(name = "user_id")
    private Long user_id;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

}


