package com.group14.webkarting.utils;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class DNITest {
    
    @Test
    public void checkWithoutZeroCorrectDNITest(){
        DNI dni = new DNI("12345678Z");
        assertTrue(dni.getNumber().equals("12345678"));
        assertTrue(dni.getLetter() == 'Z');
    }
    
    @Test
    public void checkWithOutZeroCorrectDNITest(){
        DNI dni = new DNI("00000001R");
        assertTrue(dni.getNumber().equals("00000001"));
        assertTrue(dni.getLetter() == 'R');
    }

    @Test
    public void checkIncorrectLengthDNITest(){
        try {
            // Intenta crear una instancia de DNI con un número de DNI de longitud incorrecta
            new DNI("123457A");
            fail("Se esperaba que lanzara una excepción IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().equals("The number of numbers on the DNI is incorrect"));
        }

    }

    @Test
    public void checkIncorrectLetterDNITest(){
        try {
            // Intenta crear una instancia de DNI con un número de DNI de longitud incorrecta
            new DNI("12345678Y");
            fail("Se esperaba que lanzara una excepción IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().equals("The registered DNI does not exist"));
        }
    }
}
