/*
  *
  * Beschreibung
  *
  * @version 1.0 vom 11.05.2017
  * @author 
*/

import java.util.*;

public class Termin {
  public static void kalendertag(int tag,int schalt,int monat)
  {
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
  
  public static void main(String[] args) {
    GregorianCalendar systemdatum = new GregorianCalendar();
    int jahr, rest, schalt = 0, kalendertag, tag, monat, KT;
    KT = systemdatum.get(Calendar.YEAR);
    kalendertag = 365 + schalt;
    
    System.out.print("Geben Sie den Tag ein (1 - 30/31): ");
    tag = Tastatur.liesInt();
    if (tag > 31) {
      System.out.println("Fehlerhafte Eingabe!");
      } // end of if
      
    System.out.print("\nGeben Sie den Monat ein (1 - 12): ");
    monat = Tastatur.liesInt();
      if (monat > 12) {
      System.out.println("Fehlerhafte Eingabe!");  
      } // end of if
    
    System.out.print("\nGeben Sie das Jahr ein : ");
    jahr = Tastatur.liesInt();
    if (jahr < KT) {
      System.out.println("Das Jahr liegt zu weit zurück!");
    } // end of if
    
    
    rest=jahr%4;
    System.out.println("Rest = " +rest);
    if (rest == 0) {
      schalt = 1;
    } // end of if
    
    Termin.kalendertag(tag, schalt, monat);
  } // end of main
}                      