package com.group14.webkarting.utils;

import java.util.Comparator;
import java.util.List;

public class Driver extends Person{
    private List<Lap> listLaps;
    private Lap bestLap;
    private Lap midLap;
    private int nKart;
    private float totalTime;


    public Driver(DNI dni, String name, String surname, List<Lap> listLaps,Lap bestLap, Lap midLap ,int nKart) {
        super(dni, name, surname);
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


    public Lap getMidLap() {
        return midLap;
    }


    public void setMidLap(Lap midLap) {
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
