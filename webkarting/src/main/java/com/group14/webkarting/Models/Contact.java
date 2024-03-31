package com.group14.webkarting.Models;

import com.group14.webkarting.utils.Mail;

public class Contact {
    private Long id;
    private Mail mail;
    private String name;
    private String message;
    public Contact(Mail mail, String name, String message) {
        this.mail = mail;
        this.name = name;
        this.message = message;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMail() {
        return mail.getMail();
    }
    public void setMail(Mail mail) {
        this.mail = mail;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    
}
