package com.group14.webkarting.utils;

import java.util.Comparator;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Driver extends Person{
    @OneToMany
    private List<Lap> listLaps;
    @OneToOne
    @JoinColumn(name = "id_BestLap")
    private Lap bestLap;
    private float midLap;
    private int nKart;
    private float totalTime;

    public Driver(){
        super();
    }

    public Driver(DNI dni, String name, String surname, List<Lap> listLaps,int nKart) {
        super(dni, name, surname);
        this.listLaps = listLaps;
        this.nKart = nKart;
        this.midLap = 0;
        this.totalTime = getTotalTime(listLaps); 
        this.bestLap = getBestLap();
    }

    public Driver(Person person, List<Lap> listLaps,Lap bestLap, float midLap ,int nKart){
        super(person);
        this.listLaps = listLaps;
        this.nKart = nKart;
        this.bestLap = bestLap;
        this.midLap = midLap;
        this.totalTime = getTotalTime(listLaps); 
        this.bestLap = getBestLap();
    }


    public List<Lap> getListLaps() {
        return listLaps;
    }


    public void setListLaps(List<Lap> listLaps) {
        this.listLaps = listLaps;
    }


    public int getnKart() {
        return nKart;
    }


    public void setnKart(int nKart) {
        this.nKart = nKart;
    }


    public Lap getBestLap() {      
        if(bestLap == null){
            List<Lap> sortedlistLaps = listLaps;  
            sortedlistLaps.sort(new Lap.LapComparator());
            this.setBestLap(sortedlistLaps.get(0));
        }
        return bestLap;
    }


    public void setBestLap(Lap bestLap) {
        this.bestLap = bestLap;
    }


    public float getMidLap() {
        return midLap;
    }


    public void setMidLap(float midLap) {
        this.midLap = midLap;
    }
    
    public float getTotalTime(List<Lap> listLaps){
        float aux = 0;
        for (Lap lap : listLaps) {
            aux += lap.getTotalTime();
        }
        return aux;
    }


    public float getTotalTime() {
        return totalTime;
    }


    public void setTotalTime(float totalTime) {
        this.totalTime = totalTime;
    }

    public static class DriverComparator implements Comparator<Driver> {
        @Override
        public int compare(Driver driver1, Driver driver2) {
            double timeTotal1 = driver1.getTotalTime();
            double timeTotal2 = driver2.getTotalTime();
            return Double.compare(timeTotal1, timeTotal2);
        }
    }
    
}
