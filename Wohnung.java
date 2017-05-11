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
        System.out.println(i+1 +".  Wohnung | Preis: " + wohnung[i][0] + " Euro | Gr��e: " + wohnung[i][1]+ " m�");
      } // end of if
      else {
        System.out.println(i+1 +". Wohnung | Preis: " + wohnung[i][0] + " Euro | Gr��e: " + wohnung[i][1]+ " m�"); 
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
    System.out.println("Preis: " + wohnung[i][0] + " Euro | Gr��e: " + wohnung[i][1]+ " m�");
  }
  
  public static void changeflat(double wohnung[][], int WOHNANZ){
    int i=0;  
    do {
      System.out.println("Welche Wohnung soll ge�ndert werden? (1 - 10)");
      i=Tastatur.liesInt();
      i=i-1;
    } while (i<0 || i>WOHNANZ); // end of do-while                           //Eingabe darf nicht kleiner als 0 oder Gr��er als 10 sein
    System.out.print("Geben Sie den neuen Preis ein. \n");
    System.out.print("Preis: ");
    wohnung[i][0] = Tastatur.liesInt();
    System.out.print("Geben Sie die Gr��e ein. \n");
    System.out.print("Gr��e: ");
    wohnung[i][1] = Tastatur.liesInt();
    }
    
  public static void main(String[] args) {
      final int WOHNANZ = 10, WOHNATTR = 2;                                          //10 Wohnungen mit 2 Wohnattributen
      
      double wohnung[][] = new double[WOHNANZ][WOHNATTR];                            //Double wegen der m� und Euro
      int i=0, Case=0;                                                               //i ist immer eine ganze Zahl genauso wie Case
      
      for (i=0; i<WOHNANZ; i++) {                                                    //Voreinstellungen die jedoch ge�ndert werden k�nnen
        if (i<3) {                                                                   //ersten drei Wohnungen 
          wohnung[i][0] = 20;
          wohnung[i][1] = 15;
        } // end of if
        else {
          if (i<5) {                                                                 //n�chsten 2 Wohnung
            wohnung[i][0] = 30;
            wohnung[i][1] = 25;
          } // end of if
          else {                                                                    //die fehlenden 5 Wohnungen
            wohnung[i][0] = 40;
            wohnung[i][1] = 35;
          }
        }
      }
      
      while (Case!=5) {                                                             //while war nur zum testen ob die Werte �bernommen werden
        System.out.println();
        System.out.println("Welche Aktion soll ausgef�hrt werden?");
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
          
          case 3:                                                                  //Bearbeitung/�nderung einer Wohnung
          TerminplusWohnung.changeflat(wohnung, WOHNANZ); 
          break;
          default:                                                                  
        } // end of switch
      }
    }
  }