package com.example.rentacar;
import javax.validation.constraints.NotNull;

public class DeleteCarRequest {

    @NotNull(message = "id is required")
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}