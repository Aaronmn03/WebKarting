package com.group14.webkarting.Models;

import com.group14.webkarting.utils.Mail;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "mail_id")
    private Mail mail;

    private String name;
    private String message;

    protected Contact(){
        
    }
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
    public String toString() {
        return mail.getMail();
    }

    public Mail getMail(){
        return mail;
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
