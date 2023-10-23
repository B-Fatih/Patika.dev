package com.example.rentacar;
import javax.validation.constraints.NotNull;

public class CarUpdateRequest {

    @NotNull(message = "id is required")
    private Long id;

    @NotNull(message = "name is required")
    private String name;

    @NotNull(message = "plaka is required")
    private String plaka;

    @NotNull(message = "brand is required")
    private String brand;

    @NotNull(message = "model is required")
    private String model;

    @NotNull(message = "year is required")
    private String year;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPlaka() {
        return plaka;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(String year) {
        this.year = year;
    }



}