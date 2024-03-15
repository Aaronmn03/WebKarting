package com.group14.webkarting.utils;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class TelefonoTest {

    @Test
    public void telefonoCorrect(){
        final int num = 965842315;
        Telefono tlf = new Telefono(num);
        assertTrue(tlf.getTelefono() == num);
    }

    @Test
    public void telefonoInCorrect(){
        final int num = 96584231;
        try {
            Telefono tlf = new Telefono(num);
            fail("Se esperaba que lanzara una excepción IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().equals("El numero introducido no existe"));
        }
    }
}
