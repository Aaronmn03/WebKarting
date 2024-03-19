package com.group14.webkarting.utils;

public class DNI {
    private String number;
    private char letter;

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
}
