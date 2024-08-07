package com.group14.webkarting.Models;

import java.util.List;

import com.group14.webkarting.utils.Driver;
import com.group14.webkarting.utils.Lap;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<Driver> listDrivers;
    private int numberLaps;

    public Race(){
        
    }

    public Race(List<Driver> listDrivers,int numberLaps){
        this.listDrivers = listDrivers;
        this.numberLaps = numberLaps;
        listDrivers.sort(new Driver.DriverComparator());
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
    
    public Lap getBestDriverLap(){
        return listDrivers.get(0).getBestLap();
    }

    public Lap getFastestLap() {
        Lap fastestLap = listDrivers.get(0).getListLaps().get(0);
        for (Driver driver : listDrivers) {
            for (Lap lap : driver.getListLaps()) {
                if ( lap.getTotalTime() < fastestLap.getTotalTime()) {
                    fastestLap = lap;
                }
            }
        }
        
        return fastestLap;
    }
    
}
