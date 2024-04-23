package com.group14.webkarting.utils;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DNI {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dni_id;
    private String number;
    private char letter;

    public DNI(){}

    public DNI(String dni){
        String num = dni.substring(0,dni.length() - 1);
        char dniLetter = dni.charAt(dni.length() - 1);
        
        if(num.length() != 8){
            throw new IllegalArgumentException("The number of numbers on the DNI is incorrect");
        }
        if(!checkLetterDNI(num,dniLetter)){
            throw new IllegalArgumentException("The registered DNI does not exist");
        }
        this.number = num;
        this.letter = dniLetter;
    }

    public String getNumber(){
        return number;
    }

    public char getLetter(){
        return letter;
    }
    public boolean checkLetterDNI(String number, char letter){
        char[] dniLetters = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        int num = Integer.parseInt(number);
        int rest = num % 23;
        return dniLetters[rest] == letter;
    }

    public String toString(){
        return number + letter;
    }

    public Long getDni_id() {
        return dni_id;
    }

    public void setDni_id(Long dni_id) {
        this.dni_id = dni_id;
    }
}
