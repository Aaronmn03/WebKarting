package com.group14.webkarting.utils;

import java.util.List;

public class Driver extends Person{
    private List<Lap> listLaps;
    private Lap bestLap;
    private Lap midLap;
    private int nKart;


    public Driver(DNI dni, String name, String surname, List<Lap> listLaps,Lap bestLap, Lap midLap ,int nKart) {
        super(dni, name, surname);
        this.listLaps = listLaps;
        this.nKart = nKart;
        this.bestLap = bestLap;
        this.midLap = midLap;
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
    
    
}
