/*
  *
  * Beschreibung
  *
  * @version 1.0 vom 11.05.2017
  * @author 
*/

import java.util.*;

public class Termin {

  public static int[][] buchung(int datum[][], int BATTR, int KT, String kunden[][], int KM, int KD) {
    int neu = 0, rest, wonum, jahr, monat, tag, kunum, schalt = 0, schalt2 = 0, jahr2, monat2, tag2, katag, katag2;
    boolean date;

    System.out.print("\n"+KD+"."+KM+"."+KT);

    do { //Eingabe des Startdatums
      date = true;
      System.out.println("Starttermin");
      System.out.print("Jahr: ");
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
        else {
          if (jahr == KT && monat < KM) {
              System.out.println("Fehlerhafte Eingabe!");
              date = false;
          }
      }
    } while (date == false);

    do {
      date = true;
      System.out.print("Geben Sie den Tag ein: ");
      tag = Tastatur.liesInt();

      if (jahr == KT && monat == KM && tag < KD) {
         tag = 32;
      }
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

    do { //Eingabe des Enddatums
      date = true;
      System.out.println("Endtermin");
      System.out.print("Jahr: ");
      jahr2 = Tastatur.liesInt();
      if (jahr2 < jahr || jahr2 > KT + 10) {
        System.out.println("Das Jahr ist ungültig!");
        date = false;
      } // end of if
      rest = jahr2 % 4;
      if (rest == 0) {
        schalt2 = 1;
      } // end of if
    } while (date == false);

    do {
      date = true;
      System.out.print("\nGeben Sie den Monat ein (1 - 12): ");
      monat2 = Tastatur.liesInt();
      if (monat2 > 12 || monat2 < 1 ) {
        System.out.println("Fehlerhafte Eingabe!");
        date = false;
      } // end of if
      else {
        if (monat2 < monat && jahr2 >= jahr) {
          System.out.println("Fehlerhafte Eingabe!");
          date = false;
        }
      }
    } while (date == false);

    do {
      date = true;
      System.out.print("Geben Sie den Tag ein: ");
      tag2 = Tastatur.liesInt();

      if (jahr2 >= jahr && monat2 >= monat && tag2 < tag) {
        tag = 32;
      }
      switch (monat2) {
        case 4:
        case 6:
        case 9:
        case 11:
          if (tag2 < 1 || tag2 > 30) {
            System.out.println("Fehlerhafte Eingabe!");
            date = false;
          } // end of if
          break;
        case 2:
          if (tag2 < 1 || tag2 > 28 + schalt2) {
            System.out.println("Fehlerhafte Eingabe!");
            date = false;
          } // end of if
          break;
        default:
          if (tag2 < 1 || tag2 > 31) {
            System.out.println("Fehlerhafte Eingabe!");
            date = false;
          } // end of if
      } // end of switch
    } while (date == false);

    do { //Eingabe der Wohnungsnummer
      date = true;
      System.out.print("Geben Sie die Wohnungsnummer ein (1 - 10): ");
      wonum = Tastatur.liesInt();

      if (wonum < 1 || wonum > 10) {
        System.out.println("Fehlerhafte Eingabe!");
        date = false;
      }
      else {
        for (int i = 0; i < datum.length; i++) {
          if (datum[i][3] == wonum && datum[i][2] == tag && datum[i][1] == tag && datum[i][0] == tag) {
            System.out.println("Die gewählte Wohnung ist an diesem Termin bereits belegt.");
            date = false;
          } else {
            System.out.println("Die gewählte Wohnung ist verfügbar.");
          }
        }
      }

    } while (date == false);

    do {
      date = true;
      System.out.print("Geben Sie die Kundennummer ein: ");
      kunum = Tastatur.liesInt();

      if (kunum > kunden.length || kunum < 1) {
        System.out.println("Fehlerhafte Eingabe!");
        date = false;
      }
    } while (date == false);

    katag = Termin.kalendertag(tag, schalt, monat);
    katag2 = Termin.kalendertag(tag2, schalt2, monat2);

    return buchen;
  }

  public static void verfuegbar(int datum[][], int jahr, int monat, int tag) {
    for (int i = 0; i < datum.length; i++) {

    }
  }

  public static int kalendertag(int tag, int schalt, int monat) {
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
    return kalendertag;
  }
}  
