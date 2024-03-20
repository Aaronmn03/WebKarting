package com.group14.webkarting.utils;

public class Lap {
    private float timeSect1;
    private float timeSect2;
    private float timeSect3;
    private float totalTime;

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
}
