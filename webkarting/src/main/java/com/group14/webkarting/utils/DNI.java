package com.group14.webkarting.utils;

public class DNI {
    private int num;
    private char letter;

    public DNI(int num, char letter){
        if(longDNI(num) != 8){
            throw new RuntimeException("El numero de numeros del DNI es incorrecto");
        }
        if(checkLetterDNI(num,letter)){
            throw new RuntimeException("El DNI inscrito no existe");
        }
        this.num = num;
        this.letter = letter;
    }
    private boolean checkLetterDNI(int num, char letter){
        char[] letrasDNI = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        int resto = num % 23;
        return letrasDNI[resto] == letter;
    }

    private int longDNI(int num){
        String cadenaNumero = Integer.toString(num);
        return cadenaNumero.length();
    }
}
