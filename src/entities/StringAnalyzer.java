package entities;

import java.util.HashMap;
import java.util.Map;

public class StringAnalyzer {

    private String cadena;
    private int cadenaLength;
    private HashMap<Character,Integer> charAmount = new HashMap<Character,Integer>();
    private HashMap<Character,Double> charPercentage = new HashMap<Character,Double>();

    public StringAnalyzer(String cadena){
        this.cadena = cadena.replace(" ","");
        this.cadenaLength = this.cadena.length();
        countChars();
        setCharsPercentage();
    }

    public HashMap<Character,Double> getCharPercentage(){
        return charPercentage;
    }

    private double getTruncatedDecimals(double value){
        value = value * Math.pow(10,3);
        value = Math.floor(value);
        value = value / Math.pow(10,3);
        return value;
    }

    private void setCharsPercentage(){
        for (Map.Entry<Character,Integer> entry : charAmount.entrySet()){
            char key = entry.getKey();
            int value = entry.getValue();
            charPercentage.put(key, getTruncatedDecimals((double) value/cadenaLength));
        }
    }

    private boolean charNotExistsAsHash(char letter){

        return charAmount.get(letter) == null;
    }

    public String getCadena(){
        return cadena;
    }

    private void countChars(){
        for (int i=0;i<cadenaLength;i++){
            if(charNotExistsAsHash(cadena.charAt(i))){
                charAmount.put(cadena.charAt(i),1);
            }else{
                int actualCharAmount = charAmount.get(cadena.charAt(i));
                charAmount.put(cadena.charAt(i),actualCharAmount + 1);
            }
        }
    }

    public double getEntropia(){

        double entropia = 0;

        for(Map.Entry<Character,Double> entry : charPercentage.entrySet()){

            char key = entry.getKey();
            double value = entry.getValue();
            int charCount = charAmount.get(key);

            entropia += value * (Math.log10(cadenaLength/charCount) / Math.log10(2));
        }

        return entropia;
    }

    public int getStringLength(){
        return cadenaLength;
    }

    public HashMap<Character,Integer> getCharAmount(){
        return charAmount;
    }
}
