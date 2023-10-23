package com.example.rentacar;

import com.example.rentacar.CarEntity;

import java.util.List;

public class CarsResponse {
    private List<CarEntity> data;
    private Long total;

    public CarsResponse() {
    }

    public CarsResponse(List<CarEntity> data, Long total) {
        this.data = data;
        this.total = total;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<CarEntity> getData() {
        return data;
    }

    public void setData(List<CarEntity> data) {
        this.data = data;
    }
}
