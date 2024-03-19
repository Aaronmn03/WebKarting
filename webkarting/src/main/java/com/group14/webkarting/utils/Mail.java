package com.group14.webkarting.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mail {
    private String mail;

    public Mail(String mail) {
        if(!checkCorrectMail(mail)){
            throw new IllegalArgumentException("El mail introducido no es correcto");
        }
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    private boolean checkCorrectMail(String mail){
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mail);
        return matcher.matches();
    }
}
