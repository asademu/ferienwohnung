/**
  *
  * Beschreibung
  * FS63
  * Aufgabe 3
  * @version 1.0 vom 21.04.2017
  * @Eric Richling
  */

public class Wohnung {

  public static void outallflats(double wohnung[][], int WOHNANZ) { //Ausgabe aller Wohnungsdetails
    for (int i = 0; i < WOHNANZ; i++) {
      if (i < 9) {  //if-else aus Formatierungsgründen
        System.out.println(i + 1 + ".  Wohnung | Preis: " + wohnung[i][0] + " Euro | Größe: " + wohnung[i][1] + " qm");
      } // end of if
      else {
        System.out.println(i + 1 + ". Wohnung | Preis: " + wohnung[i][0] + " Euro | Größe: " + wohnung[i][1] + " qm");
      } // end of if-else
    } // end of for
  }

  public static void outoneflat(double wohnung[][], int WOHNANZ) {  //Ausgabe einer Wohnung
    int i = 0;
    do {
      System.out.println("Welche Wohnung soll ausgegeben werden? (1 - 10)");
      i = Tastatur.liesInt();
      i = i - 1;
    } while (i < 0 || i >= WOHNANZ); // end of do-while
    System.out.println("Preis: " + wohnung[i][0] + " Euro | Größe: " + wohnung[i][1] + " qm");
  }

  public static void changeflat(double wohnung[][], int WOHNANZ) {  //Änderung einer Wohnung
    int i = 0;
    do {
      System.out.println("Welche Wohnung soll geändert werden? (1 - 10)");
      i = Tastatur.liesInt();
      i = i - 1;
    } while (i < 0 || i >= WOHNANZ); //Eingabe darf nicht kleiner als 0 oder größer-gleich 10 sein

    System.out.println("Geben Sie den neuen Preis ein.");
    System.out.print("Preis: ");
    wohnung[i][0] = Tastatur.liesDouble();
    System.out.println("Geben Sie die Größe ein.");
    System.out.print("Größe: ");
    wohnung[i][1] = Tastatur.liesDouble();
  }

  public static double[][] initflat(double u_wohnung[][], int u_WOHNANZ) {
    for (int i = 0; i < u_WOHNANZ; i++) {                                                    //Voreinstellungen die jedoch geändert werden können
      if (i < 3) {                                                                   //ersten drei Wohnungen, erste Preisklasse
        u_wohnung[i][0] = 20;
        u_wohnung[i][1] = 15;
      } // end of if
      else {
        if (i < 5) {                                                                 //nächsten 2 Wohnung, zweite Preisklasse
          u_wohnung[i][0] = 30;
          u_wohnung[i][1] = 25;
        } // end of if
        else {                                                                    //die fehlenden 5 Wohnungen, dritte Preisklasse
          u_wohnung[i][0] = 40;
          u_wohnung[i][1] = 35;
        }
      }
    }
    return u_wohnung;                                                         //Rückgabe an die Hauptfunktion
  }

  public static void wohnungmenu(double wohnung[][], String swohnung[][], int WOHNANZ, String wohnungDateiname) { //Menüauswahl der Wohnungsoptionen
    int wahl = 0;
    do {
    System.out.println("\nAlle Wohnungen ausgeben     (1)");
    System.out.println("Eine Wohnung ausgeben       (2)");
    System.out.println("Eine Wohnung bearbeiten     (3)");
    System.out.println("Hauptmenü                   (4)");

    wahl = Tastatur.liesInt();
    switch (wahl) {
      case 1:
        Wohnung.outallflats(wohnung, WOHNANZ);
        break;
      case 2:
        Wohnung.outoneflat(wohnung, WOHNANZ);
        break;
      case 3:
        Wohnung.changeflat(wohnung, WOHNANZ);
        swohnung = ferienwohnung.doubleToString(wohnung);     //Double-Array wird zu String-Array konvertiert, um in Textdatei zu schreiben
        ferienwohnung.schreiben(swohnung, wohnungDateiname);  //speichert die Wohnungs-Daten in einer Textdatei
        break;
      case 4:
        break;
      default:
        System.out.println("Fehleingabe");
      }
    } while (wahl != 4); //end of do-while
  }
}