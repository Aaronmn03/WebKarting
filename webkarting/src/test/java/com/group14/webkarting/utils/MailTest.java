package com.group14.webkarting.utils;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class MailTest {
    
    @Test
    public void mailCorrect(){
        final String correoCadena = "aaron.mn03@gmail.com";
        Mail correo = new Mail(correoCadena);
        assertTrue(correo.getMail() == correoCadena);
    }

    @Test
    public void mailIncorrect(){
        final String correoCadena = "dljksdflkgmail.com";
        try {
            new Mail(correoCadena);
            fail("Se esperaba que lanzara una excepción IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().equals("El mail introducido no es correcto"));
        }
    }
}
