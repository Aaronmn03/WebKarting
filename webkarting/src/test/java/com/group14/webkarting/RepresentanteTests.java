package com.group14.webkarting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.group14.webkarting.utils.Mail;
import com.group14.webkarting.utils.DNI;
import com.group14.webkarting.utils.Representant;
import com.group14.webkarting.utils.Phone;

public class RepresentanteTests {

    @Test
    public void genRepresentantText(){
        Representant res = new Representant(new DNI("12345678Z"), "Perez", "Gonzalez",new Mail("dljksdflk@gmail.com"),new Phone(965842315));
        assertEquals("Gonzalez", res.getApellidos());
    }
}
