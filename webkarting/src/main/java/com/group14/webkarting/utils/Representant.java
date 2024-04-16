package com.group14.webkarting.utils;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Representant extends Person{

    @OneToOne
    @JoinColumn(name = "mail_id")
    private Mail mail;
    @OneToOne
    @JoinColumn(name = "phone_id")
    private Phone phone;

    public Representant(){
        super();
    }
    public Representant(DNI dni, String name, String surname,Mail mail, Phone phone){
        super(dni, name, surname);
        this.mail = mail;
        this.phone = phone;
        
    }

    public Representant(Person person, Mail mail, Phone phone){
        super(person);
        this.mail = mail;
        this.phone = phone;
    }

    public Mail getMail() {
        return mail;
    }

    public void setMail(Mail mail) {
        this.mail = mail;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
