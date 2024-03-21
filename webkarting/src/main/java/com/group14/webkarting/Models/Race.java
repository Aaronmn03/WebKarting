package com.group14.webkarting.Models;

import java.util.List;

import com.group14.webkarting.utils.Driver;

public class Race {
    private Long id;
    private List<Driver> listDrivers;
    private int numberLaps;

    public Race(List<Driver> listDrivers,int numberLaps){
        this.listDrivers = listDrivers;
        this.numberLaps = numberLaps;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Driver> getListDrivers() {
        return listDrivers;
    }

    public void setListDrivers(List<Driver> listDrivers) {
        this.listDrivers = listDrivers;
    }

    public int getNumberLaps() {
        return numberLaps;
    }

    public void setNumberLaps(int numberLaps) {
        this.numberLaps = numberLaps;
    }
    
}
