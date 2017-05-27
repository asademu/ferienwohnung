/*
  *
  * Beschreibung
  *
  * @version 1.0 vom 11.05.2017
  * @author 
*/

import java.util.*;

public class Termin {

  public static void buchung(int datum[][], String kunden[][], String wohnung[][], int BATTR) {
    int buchen[][] = new int[datum.length+1][BATTR];
    for (int i = 0; i < datum.length; i++) {
      for (int j = 0; j < BATTR; j++) {
        buchen[i][j] = datum[i][j];
      } // end of for
    } // end of for
  
    System.out.print("\nGeben Sie das Jahr ein : ");
    jahr = Tastatur.liesInt();
    if (jahr < KT || jahr > KT + 10) {
      System.out.println("Das Jahr ist ungültig!");
    } // end of if
    
    System.out.print("\nGeben Sie den Monat ein (1 - 12): ");
    monat = Tastatur.liesInt();
    if (monat > 12 || monat < 1) {
      System.out.println("Fehlerhafte Eingabe!");  
    } // end of if
    
    System.out.print("Geben Sie den Tag ein: ");
    tag = Tastatur.liesInt();
    switch (monat) {
      case 4  :
      case 6  :
      case 9  :
      case 11 : 
      if (tag < 1 || tag > 30) {
        System.out.println("Fehlerhafte Eingabe!");
      } // end of if
      
      break;
      case 2 : 
      if (tag < 1 || tag > 28 + schalt) {
        System.out.println("Fehlerhafte Eingabe!");
      } // end of if
      
      break;
      default: 
      if (tag < 1 || tag > 31) {
        System.out.println("Fehlerhafte Eingabe!");
      } // end of if
      
    } // end of switch
    
    rest = jahr % 4;
    if (rest == 0) {
      schalt = 1;
    } // end of if
    
    System.out.print("Geben sie die Wohnungsnummer ein (1 - 10: ");
    
  }  

  public static void kalendertag(int tag, int schalt, int monat) {
    int kalendertag = 0;
    switch (monat) {
      case 1 : 
        kalendertag=0+tag;        
        break;
      case 2 : 
        kalendertag=31+tag+schalt;        
        break;
      case 3 : 
        kalendertag=59+tag+schalt;   
        break;
      case 4 : 
        kalendertag=90+tag+schalt;        
        break;
      case 5 : 
        kalendertag=120+tag+schalt;        
        break;
      case 6 : 
        kalendertag=151+tag+schalt;        
        break;
      case 7 : 
        kalendertag=181+tag+schalt;        
        break;
      case 8 : 
        kalendertag=212+tag+schalt;        
        break;
      case 9 : 
        kalendertag=243+tag+schalt;       
        break;
      case 10 : 
        kalendertag=273+tag+schalt;       
        break;
      case 11 : 
        kalendertag=304+tag+schalt;        
        break;
      case 12 : 
        kalendertag=334+tag+schalt;
        break;
      default: 
        
    } // end of switch
  }
}  
