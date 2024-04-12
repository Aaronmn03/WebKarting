package com.group14.webkarting.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Mail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mail_id;
    
    private String mail;

    protected Mail(){

    }

    public Mail(Mail mail){
        this.mail_id = mail.getMail_id();
        this.mail = mail.getMail();
    }

    
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


    public Long getMail_id() {
        return mail_id;
    }


    public void setMail_id(Long mail_id) {
        this.mail_id = mail_id;
    }
}
