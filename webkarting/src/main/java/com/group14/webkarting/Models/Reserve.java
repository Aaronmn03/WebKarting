package com.group14.webkarting.Models;

import java.time.LocalDateTime;
import java.util.List;

import com.group14.webkarting.utils.Person;
import com.group14.webkarting.utils.Representant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int numUsers;
    private LocalDateTime date_hour;
    @ManyToOne
    @JoinColumn(name = "person_id") 
    private Representant representant;
    @ManyToMany
    private List<Person> listUsers;
    public Reserve(){}

    public Reserve(int n, LocalDateTime F_H, Representant representant,List<Person> list){
        numUsers = n;
        date_hour = F_H;
        this.representant = representant;
        listUsers = list;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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



    public List<Person> getListUsers() {
        return listUsers;
    }



    public void setListUsers(List<Person> listUsers) {
        this.listUsers = listUsers;
    }



    @Override
    public String toString() {
        return "Reserve [numUsers=" + numUsers + ", date_hour=" + date_hour + ", listUsers=" + listUsers + "]";
    }

    public Representant getRepresentant() {
        return representant;
    }

    public void setRepresentant(Representant representant) {
        this.representant = representant;
    }

    
}
