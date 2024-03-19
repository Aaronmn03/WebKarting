package com.group14.webkarting.utils;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class PhoneTest {

    @Test
    public void phoneCorrect(){
        final int num = 965842315;
        Phone tlf = new Phone(num);
        assertTrue(tlf.getPhone() == num);
    }

    @Test
    public void phoneIncorrect(){
        final int num = 96584231;
        try {
            new Phone(num);
            fail("Se esperaba que lanzara una excepción IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().equals("El numero introducido no existe"));
        }
    }
}
