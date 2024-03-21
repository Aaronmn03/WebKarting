package com.group14.webkarting.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LapTest {

    @Test
    public void checkSumLapTest(){
        Lap l = new Lap(1, 2, 3);
        assertEquals(6, l.getTotalTime());
    }
}
