 /**
  *
  * Beschreibung
  * FS63
  * Aufgabe 3
  * @version 1.0 vom 21.04.2017
  * @Eric Richling
  */

public class Wohnung {
  
  public static void outallflats(double wohnung[][], int WOHNANZ){
    int i=0;
    
    for (i=0; i<WOHNANZ; i++) {
      if (i < 9) {
        System.out.println(i+1 +".  Wohnung | Preis: " + wohnung[i][0] + " Euro | Größe: " + wohnung[i][1]+ " m²");
      } // end of if
      else {
        System.out.println(i+1 +". Wohnung | Preis: " + wohnung[i][0] + " Euro | Größe: " + wohnung[i][1]+ " m²"); 
      } // end of if-else
    } // end of for
  }
  
  public static void outoneflat(double wohnung[][], int WOHNANZ){
    int i=0;  
    do {
      System.out.println("Welche Wohnung soll ausgegeben werden? (1 - 10)");
      i=Tastatur.liesInt();
      i=i-1;
    } while (i<0 || i>WOHNANZ); // end of do-while
    System.out.println("Preis: " + wohnung[i][0] + " Euro | Größe: " + wohnung[i][1]+ " m²");
  }
  
  public static void changeflat(double wohnung[][], int WOHNANZ){
    int i=0;  
    do {
      System.out.println("Welche Wohnung soll geändert werden? (1 - 10)");
      i=Tastatur.liesInt();
      i=i-1;
    } while (i<0 || i>WOHNANZ); // end of do-while                           //Eingabe darf nicht kleiner als 0 oder Größer als 10 sein
    System.out.print("Geben Sie den neuen Preis ein. \n");
    System.out.print("Preis: ");
    wohnung[i][0] = Tastatur.liesInt();
    System.out.print("Geben Sie die Größe ein. \n");
    System.out.print("Größe: ");
    wohnung[i][1] = Tastatur.liesInt();
    }
    
  public static void main(String[] args) {
      final int WOHNANZ = 10, WOHNATTR = 2;                                          //10 Wohnungen mit 2 Wohnattributen
      
      double wohnung[][] = new double[WOHNANZ][WOHNATTR];                            //Double wegen der m² und Euro
      int i=0, Case=0;                                                               //i ist immer eine ganze Zahl genauso wie Case
      
      for (i=0; i<WOHNANZ; i++) {                                                    //Voreinstellungen die jedoch geändert werden können
        if (i<3) {                                                                   //ersten drei Wohnungen 
          wohnung[i][0] = 20;
          wohnung[i][1] = 15;
        } // end of if
        else {
          if (i<5) {                                                                 //nächsten 2 Wohnung
            wohnung[i][0] = 30;
            wohnung[i][1] = 25;
          } // end of if
          else {                                                                    //die fehlenden 5 Wohnungen
            wohnung[i][0] = 40;
            wohnung[i][1] = 35;
          }
        }
      }
      
      while (Case!=5) {                                                             //while war nur zum testen ob die Werte übernommen werden
        System.out.println();
        System.out.println("Welche Aktion soll ausgeführt werden?");
        System.out.println("1. alle Wohnungen ausgeben");
        System.out.println("2. eine Wohnung ausgeben");
        System.out.println("3. eine Wohnung bearbeiten");
        System.out.println("Zum Beenden bitte 5 eingeben\n");
        Case = Tastatur.liesInt();
        
        
        switch (Case) {
          case 1:                                                                  //Ausgabe aller Wohnungen
          TerminplusWohnung.outallflats(wohnung, WOHNANZ);
          break;
          
          case 2:                                                                  //Ausgabe einer einzelnen Wohnung
          TerminplusWohnung.outoneflat(wohnung, WOHNANZ);
          break;
          
          case 3:                                                                  //Bearbeitung/Änderung einer Wohnung
          TerminplusWohnung.changeflat(wohnung, WOHNANZ); 
          break;
          default:                                                                  
        } // end of switch
      }
    }
  }