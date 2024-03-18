package com.group14.webkarting.utils;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class MailTest {
    
    @Test
    public void correoCorrect(){
        final String correoCadena = "dljksdflk@gmail.com";
        Mail correo = new Mail(correoCadena);
        assertTrue(correo.getCorreo() == correoCadena);
    }

    @Test
    public void telefonoInCorrect(){
        final String correoCadena = "dljksdflkgmail.com";
        try {
            Mail correo = new Mail(correoCadena);
            fail("Se esperaba que lanzara una excepción IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().equals("El correo introducido no es correcto"));
        }
    }
}
