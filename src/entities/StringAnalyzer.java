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

    private void setCharsPercentage(){
        for (Map.Entry<Character,Integer> entry : charAmount.entrySet()){
            char key = entry.getKey();
            int value = entry.getValue();
            charPercentage.put(key, (double) value/cadenaLength);
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

    public int getStringLength(){
        return cadenaLength;
    }

    public HashMap<Character,Integer> getCharAmount(){
        return charAmount;
    }
}
