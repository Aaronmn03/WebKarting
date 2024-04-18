package com.group14.webkarting.utils;

import java.util.Comparator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Lap {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_lap;
    private float timeSect1;
    private float timeSect2;
    private float timeSect3;
    private float totalTime;

    public Lap(){

    }

    public Lap (float t1, float t2, float t3){
        this.timeSect1 = t1;
        this.timeSect2 = t2;
        this.timeSect3 = t3;
        this.totalTime = timeSect1 + timeSect2 + timeSect3;
    }

    public float getTimeSect1() {
        return timeSect1;
    }

    public void setTimeSect1(float timeSect1) {
        this.timeSect1 = timeSect1;
    }

    public float getTimeSect2() {
        return timeSect2;
    }

    public void setTimeSect2(float timeSect2) {
        this.timeSect2 = timeSect2;
    }

    public float getTimeSect3() {
        return timeSect3;
    }

    public void setTimeSect3(float timeSect3) {
        this.timeSect3 = timeSect3;
    }

    public float getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(float totalTime) {
        this.totalTime = totalTime;
    }

        public static class LapComparator implements Comparator<Lap> {
        @Override
        public int compare(Lap lap1, Lap lap2) {
            double timeTotal1 = lap1.getTotalTime();
            double timeTotal2 = lap2.getTotalTime();
            return Double.compare(timeTotal1, timeTotal2);
        }
    }

        public Long getId_lap() {
            return id_lap;
        }

        public void setId_lap(Long id_lap) {
            this.id_lap = id_lap;
        }
    
}
