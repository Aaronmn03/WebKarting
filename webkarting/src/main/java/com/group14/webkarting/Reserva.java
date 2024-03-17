package com.group14.webkarting;

import java.time.LocalDateTime;
import java.util.List;

public class Reserva {

    private int numUsers;
    private LocalDateTime date_hour;
    private Representante representant;
    private List<Persona> listUsers;
    public Reserva(){}

    public Reserva(int n, LocalDateTime F_H, Representante representant,List<Persona> list){
        numUsers = n;
        date_hour = F_H;
        this.representant = representant;
        listUsers = list;
    }


    public int getNumUsers() {
        return numUsers;
    }



    public void setNumUsers(int numUsers) {
        this.numUsers = numUsers;
    }



    public LocalDateTime getDate_hour() {
        return date_hour;
    }



    public void setDate_hour(LocalDateTime date_hour) {
        this.date_hour = date_hour;
    }



    public List<Persona> getListUsers() {
        return listUsers;
    }



    public void setListUsers(List<Persona> listUsers) {
        this.listUsers = listUsers;
    }



    @Override
    public String toString() {
        return "Reserva [numUsers=" + numUsers + ", date_hour=" + date_hour + ", listUsers=" + listUsers + "]";
    }

    
}
