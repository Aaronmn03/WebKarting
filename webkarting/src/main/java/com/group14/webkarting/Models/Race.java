package com.group14.webkarting.Models;

import java.time.LocalTime;
import java.time.LocalDate;
import java.util.List;

import com.group14.webkarting.utils.Driver;

public class Race {
    private Long id;
    private List<Driver> listDrivers;
    private LocalDate date;
    private LocalTime startRace;
    private LocalTime endRace;

    public Race(List<Driver> listDrivers, LocalDate date, LocalTime startRace, LocalTime endRace){
        this.listDrivers = listDrivers;
        this.date = date;
        this.startRace = startRace;
        this.endRace = endRace;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartRace() {
        return startRace;
    }

    public void setStartRace(LocalTime startRace) {
        this.startRace = startRace;
    }

    public LocalTime getEndRace() {
        return endRace;
    }

    public void setEndRace(LocalTime endRace) {
        this.endRace = endRace;
    }

    
}
