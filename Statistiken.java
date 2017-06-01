/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 28.05.2017
  * @author 
  */

public class Statistiken {
  public static void auseinewohnung(int datum[][]) {    //Auslastung einer Wohnung wird prozentual berechnet
    int wohnungsnummer = 0, zaehler = 0;
    double ergebnis = 0;
    do {
        System.out.println("Bitte geben Sie die Wohnungsnummer an: ");
        wohnungsnummer = Tastatur.liesInt()-1;
    } while (wohnungsnummer < 0 || wohnungsnummer >= datum.length); //Probe, ob Wohnungsnummer existiert
    for (int i = 0; i < datum[0].length; i++) {
      if (datum[wohnungsnummer][i] != 0) {  //falls das Feld nicht leer ist, wird der Zähler jeweils um 1 erhöht
        zaehler = zaehler + 1;
      }
    }
    ergebnis = 100 * zaehler / 365; //Prozentrechnung
    System.out.println("Prozentuale Auslastung der Wohnung " + (wohnungsnummer + 1) + ": " + ergebnis + "%");
    }

  public static void ausallewohnungen(int datum[][]) {  //Auslastung aller Wohnung in Prozent
    int zaehler = 0;
    double ergebnis = 0;
    for (int i = 0; i < datum.length; i++) {    //Doppel-Zählschleife, um alle Objekte zu erfassen
      for (int j = 0; j < datum[0].length; j++) {
        if (datum[i][j] != 0) {                 //falls das Feld nicht leer ist, wird der Zähler erhöht
          zaehler = zaehler + 1;
          }
      }
    }
    ergebnis = 100 * zaehler / (365 * datum.length);    //mit datum.length, da die Ergebnisse von allen 10 Wohnungen addiert wurden
    System.out.println("Prozentuale Auslastung aller Wohnungen: " + ergebnis + "%");
  }

  public static void eineinewohnung(int datum[][], double wohnung[][]) { //Einnahmen einer Wohnung innerhalb von einem Jahr
    int wonu = 0;
    double einnahmen = 0;
    System.out.print("Wohnungsnummer: ");
    do {
        wonu = Tastatur.liesInt()-1;
    } while (wonu < 0 || wonu > 9);         //Probe, ob die Wohnungsnummer existiert
    for (int i = 0; i < datum[0].length; i++) {
        if (datum[wonu][i] != 0) {          //wenn das Feld nicht leer ist, wird der Wohnungspreis erneut hinzuaddiert
            einnahmen = einnahmen + wohnung[wonu][0];
        }
    }
    System.out.println("Die Einnahmen der Wohnung " + (wonu+1) + " betragen " + einnahmen + " Euro");
  }

  public static void einallewohnungen(int datum[][], double wohnung[][]) {  //Einnahmen aller Wohnungen
      double einnahmen = 0;
      for (int i = 0; i < datum[0].length; i++) {       //doppelte Zählschleife, um alle Inhalte zu erfassen
          for (int j = 0; j < datum.length; j++)
             if (datum[j][i] != 0) {
                einnahmen = einnahmen + wohnung[j][0];  //wenn der Inhalt nicht Null ist, wird der jeweilige Wohnungspreis addiert
          }
      }
      System.out.println("Gesamteinnahmen des Jahres: " + einnahmen + " Euro");
  }

  public static void statistikenmenu(int datum[][], double wohnung[][]) {   //Menüauswahl der Statistikoptionen
        int wahl = 0;
        do {
            System.out.println("\nAuslastung einer Ferienwohnung   (1)");
            System.out.println("Auslastung aller Ferienwohnungen (2)");
            System.out.println("Einnahmen einer Ferienwohnung    (3)");
            System.out.println("Einnahmen aller Ferienwohnungen  (4)");
            System.out.println("Hauptmenü                        (5)");
            wahl = Tastatur.liesInt();

            switch (wahl) {
                case 1: //
                    Statistiken.auseinewohnung(datum);
                    break;
                case 2: //
                    Statistiken.ausallewohnungen(datum);
                    break;
                case 3: //
                    Statistiken.eineinewohnung(datum, wohnung);
                    break;
                case 4: //
                    Statistiken.einallewohnungen(datum, wohnung);
                    break;
                case 5: //
                    break;
                default:
                    System.out.println("Fehleingabe!");
            }
        } while (wahl != 5);
  }       
} // end of class Statistiken