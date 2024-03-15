package com.group14.webkarting.utils;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class CorreoTest {
    
    @Test
    public void correoCorrect(){
        final String correoCadena = "dljksdflk@gmail.com";
        Correo correo = new Correo(correoCadena);
        assertTrue(correo.getCorreo() == correoCadena);
    }

    @Test
    public void telefonoInCorrect(){
        final String correoCadena = "dljksdflkgmail.com";
        try {
            Correo correo = new Correo(correoCadena);
            fail("Se esperaba que lanzara una excepción IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().equals("El correo introducido no es correcto"));
        }
    }
}
