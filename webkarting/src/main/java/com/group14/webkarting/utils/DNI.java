package com.group14.webkarting.utils;

public class DNI {
    private String number;
    private char letter;

    public DNI(String dni){
        String num = dni.substring(0,dni.length() - 1);
        char letraDNI = dni.charAt(dni.length() - 1);
        
        if(num.length() != 8){
            throw new IllegalArgumentException("El numero de numeros del DNI es incorrecto");
        }
        if(!checkLetterDNI(num,letraDNI)){
            throw new IllegalArgumentException("El DNI inscrito no existe");
        }
        this.number = num;
        this.letter = letraDNI;
    }

    public String getNumber(){
        return number;
    }

    public char getLetter(){
        return letter;
    }
    public boolean checkLetterDNI(String number, char letter){
        char[] letrasDNI = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        int num = Integer.parseInt(number);
        int resto = num % 23;
        return letrasDNI[resto] == letter;
    }

    public String toString(){
        return number + letter;
    }
}
