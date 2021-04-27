package ui;

import entities.StringAnalyzer;

import java.util.Scanner;

public class Menu {

    private String cadena = null;
    private Scanner input = new Scanner(System.in);
    private StringAnalyzer sra = null;

    private void showTitle(){
        System.out.println();
        System.out.println(ConsoleColors.BLUE_BOLD + "RESULTADOS");
        System.out.println("----------" + ConsoleColors.RESET);
        System.out.println();
    }

    public void init(){
        System.out.print(ConsoleColors.GREEN_BOLD + "Simbolos de emisión de la fuente: " + ConsoleColors.RESET);
        cadena = input.nextLine();
        sra = new StringAnalyzer(cadena);

        showTitle();
        System.out.print(ConsoleColors.BLUE_BOLD + "Cadena ingresada -> " + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE + sra.getCadena() + ConsoleColors.RESET);
        System.out.print(ConsoleColors.BLUE_BOLD +  "Contador de símbolos -> " + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE + sra.getCharAmount() + ConsoleColors.RESET);
        System.out.print(ConsoleColors.BLUE_BOLD +  "P(a) -> " + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE + sra.getCharPercentage() + ConsoleColors.RESET);
    }
}
