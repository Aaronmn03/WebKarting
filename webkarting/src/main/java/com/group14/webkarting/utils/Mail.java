package com.group14.webkarting.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mail {
    private String correo;

    public Mail(String correo) {
        if(!checkCorrectCorreo(correo)){
            throw new IllegalArgumentException("El correo introducido no es correcto");
        }
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    private boolean checkCorrectCorreo(String correo){
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }
}
