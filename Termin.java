/*
  *
  * Beschreibung
  *
  * @version 1.0 vom 11.05.2017
  * @author 
*/

import java.util.*;

public class Termin {

  public static void buchung(int datum[][], int BATTR, int KT, String kunden[][]) {
    int neu = 0, rest, wonum = 0, jahr, monat, tag, kunum, schalt = 0;
    boolean date = true;
    int buchen[][] = new int[datum.length + 1][BATTR];
    for (int i = 0; i < datum.length; i++) {
      for (int j = 0; j < BATTR; j++) {
        buchen[i][j] = datum[i][j];
      } // end of for
      neu = i;
    } // end of for

    do {
      date = true;
      System.out.print("\nGeben Sie das Jahr ein: ");
      jahr = Tastatur.liesInt();
      if (jahr < KT || jahr > KT + 10) {
        System.out.println("Das Jahr ist ungültig!");
        date = false;
      } // end of if
      rest = jahr % 4;
      if (rest == 0) {
        schalt = 1;
      } // end of if
    } while (date == false);

    do {
      date = true;
      System.out.print("\nGeben Sie den Monat ein (1 - 12): ");
      monat = Tastatur.liesInt();
      if (monat > 12 || monat < 1) {
        System.out.println("Fehlerhafte Eingabe!");
        date = false;
      } // end of if
    } while (date == false);

    do {
      date = true;
      System.out.print("Geben Sie den Tag ein: ");
      tag = Tastatur.liesInt();
      switch (monat) {
        case 4:
        case 6:
        case 9:
        case 11:
          if (tag < 1 || tag > 30) {
            System.out.println("Fehlerhafte Eingabe!");
            date = false;
          } // end of if
          break;
        case 2:
          if (tag < 1 || tag > 28 + schalt) {
            System.out.println("Fehlerhafte Eingabe!");
            date = false;
          } // end of if
          break;
        default:
          if (tag < 1 || tag > 31) {
            System.out.println("Fehlerhafte Eingabe!");
            date = false;
          } // end of if
      } // end of switch
    } while (date == false);

    do {
      System.out.print("Geben Sie die Wohnungsnummer ein (1 - 10): ");
      wonum = Tastatur.liesInt();

      if (wonum < 1 || wonum > 10) {
        System.out.println("Fehlerhafte Eingabe!");
      }
    } while (wonum < 1 || wonum > 10);

    do {
      date = true;
      System.out.print("Geben Sie die Kundennummer ein: ");
      kunum = Tastatur.liesInt();

      if (kunum > kunden.length || kunum < 1) {
        System.out.println("Fehlerhafte Eingabe!");
        date = false;
      }
    } while (date == false);

    if (date == true) {
        buchen[neu][0] = jahr;
        buchen[neu][1] = monat;
        buchen[neu][2] = tag;
        buchen[neu][3] = wonum;
        buchen[neu][4] = kunum;
    }
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
