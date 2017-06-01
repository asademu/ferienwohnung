/*
  *
  * Beschreibung
  *
  * @version 1.0 vom 11.05.2017
  * @author 
*/
import java.text.SimpleDateFormat;
import java.time.MonthDay;
import java.util.Calendar;
import java.util.*;

public class Termin {

  public static int[][] buchung(int datum[][], int KT, String kunden[][], int KM, int KD, double wohnung[][]) {
    int rest, wonum, jahr, monat, tag, kunum, schalt = 0, schalt2 = 0, jahr2, monat2, tag2, katag, katag2;
    boolean date;
    //teilweise doppelte Variablen, da Start- und Enddatum gefordert werden
    System.out.println("\nheutiges Datum: "+KD+"."+KM+"."+KT); //Ausgabe des aktuellen Systemdatums zum optischen Vergleich

    //System.out.println("\n"+datum.length+" "+datum[0].length);
    do { //Eingabe des Startdatums (Jahr)
      date = true;  //wird am Anfang der Schleife zurückgesetzt, um Endlosschleife zu verhindern
      System.out.println("\nEingabe des Starttermins");
      System.out.print("Jahr: ");
      jahr = Tastatur.liesInt();
      if (jahr < KT || jahr > KT) {  //kann nicht in der Vergangenheit gebucht werden und nur in naher Zukunft (selbes Jahr wie System)
        System.out.println("Das Jahr ist ungültig!");
        date = false;
      } // end of if
      rest = jahr % 4;  //Berechnung, ob es ein Schaltjahr ist
      if (rest == 0) {
        schalt = 1;
      } // end of if
    } while (date == false);

    do {    //Eingabeaufforderung des Monats
      date = true;
      System.out.print("Monat (1 - 12): ");
      monat = Tastatur.liesInt();
      if (monat > 12 || monat < 1) {
        System.out.println("Fehlerhafte Eingabe!");
        date = false;
      } // end of if
        else {
          if (jahr == KT && monat < KM) { //Filter für vergangene Monate
              System.out.println("Fehlerhafte Eingabe!");
              date = false;
          }
      }
    } while (date == false);

    do {            //Eingabeaufforderung des Tages des Monats
      date = true;
      System.out.print("Tag: ");
      tag = Tastatur.liesInt();

      if (jahr == KT && monat == KM && tag < KD) { //kann nicht in der Vergangenheit liegen
         tag = 32;
      }
      switch (monat) {  //Fallauswahl, um Länge des gewählten Monats zu verifizieren
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
      System.out.println("\nEingabe des Endtermins");
      System.out.print("Jahr: ");
      jahr2 = Tastatur.liesInt();
      if (jahr2 < jahr || jahr2 > KT) { //darf nicht zu weit in der Zukunft oder vor dem Startjahr sein
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
      System.out.print("Geben Sie den Monat ein (1 - 12): ");
      monat2 = Tastatur.liesInt();
      if (monat2 > 12 || monat2 < 1 ) {                             //nicht vor Startmonat
        System.out.println("Fehlerhafte Eingabe!");
        date = false;
      } // end of if
      else {
        if (monat2 < monat && jahr2 == jahr) {
          System.out.println("Fehlerhafte Eingabe!");
          date = false;
        }
      }
    } while (date == false);

    do {
      date = true;
      System.out.print("Geben Sie den Tag ein: ");
      tag2 = Tastatur.liesInt();

      if (jahr2 == jahr && monat2 == monat && tag2 < tag) {       //nicht vor dem Starttermin
        tag2 = 32;                                                //löst nur aus, wenn sich beide Daten im selben Monat des selben Jahres befinden
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

    katag = Termin.kalendertag(tag, schalt, monat);       //Umrechnung des Startdatums in den Kalendertag
    katag2 = Termin.kalendertag(tag2, schalt2, monat2);   //Umrechnung des Enddatums in den Kalendertag

    do { //Eingabe der Wohnungsnummer                     //Eingabe der zu buchenden Wohnungsnummer
      date = true;
      System.out.print("Geben Sie die Wohnungsnummer ein (1 - 10): ");
      wonum = Tastatur.liesInt();

      if (wonum < 1 || wonum > 10) {
        System.out.println("Fehlerhafte Eingabe!");
        date = false;
      }
      else {
        for (int i = katag; i <= katag2; i++) {
          if (datum[wonum-1][i] != 0) {     //falls das Feld nicht leer ist, wurde die Wohnung bereits in diesem Zeitraum gebucht
            date = false;
          }
        }
      }
      if (date == false) {
        System.out.println("Die gewählte Wohnung ist an diesem Termin bereits belegt.");
      }
    } while (date == false);

    System.out.println("Die gewählte Wohnung ist verfügbar.");

    do {                              //Eingabe der Kundennummer zu Buchungszwecken
      date = true;
      System.out.print("Geben Sie die Kundennummer ein: ");
      kunum = Tastatur.liesInt();

      if (kunum > kunden.length || kunum < 1) {
        System.out.println("Fehlerhafte Eingabe!");
        date = false;
      }
    } while (date == false);

    for (int i = katag; i <= katag2; i++) {       //Kundennummer wird im Buchungsarray von Start- bis Enddatum abgespeichert
      datum[wonum-1][i] = kunum;                  //-1, da die eingegebene Nummer nicht dem Index entspricht
    }
    wonum = wonum - 1;
    Termin.kostenRechnung(wohnung, katag, katag2, wonum);   //Berechnung und Ausgabe der Kosten

    return datum;                                 //Rückgabe des Buchungsarrays
  }

  public static void kostenRechnung(double wohnung[][], int katag, int katag2, int wonum) {
    double kosten = 0;
    for (int i = katag; i < katag2; i++) {
      kosten = kosten + wohnung[wonum][0];  //für jeden Tag wird der Mietpreis erneut addiert
    }
    if (katag2 - katag >= 7) {  //wenn die Tagesspanne zwischen Start- und Enddatum 7 Tage oder länger ist, werden 10% Rabatt berechnet
      kosten = kosten * 90 / 100;
    }
    System.out.println("Die Kosten betragen " + kosten + " Euro");
  }

  public static void verfuegbarDatum(int belegung[][], int KT, int KM, int KD) {  //reine Verfügbarkeitsprüfung nach Datumeingabe
    int rest, jahr, monat, tag, schalt = 0, katag;
    boolean date;

    do {  //Eingabe des Jahres
      date = true;
      System.out.print("\nJahr: ");
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

    do {  //Eingabe des Monats
      date = true;
      System.out.print("Monat (1 - 12): ");
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

    do {  //Eingabe des Tages des Monats
      date = true;
      System.out.print("Tag: ");
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

    katag = Termin.kalendertag(tag, schalt, monat); //Umrechnung des Datums in den Kalendertag
    System.out.println("\n"+tag+"."+monat+"."+jahr+"\n");

    for (int i = 0; i < belegung.length; i++) {   //Ausgabe welche Wohnungen belegt bzw. frei sind
      if (belegung[i][katag] != 0) {
        System.out.println("Wohnung "+(i+1)+" ist belegt.");
      }
      else {
        System.out.println("Wohnung "+(i+1)+" ist verfügbar.");
      }
    }
  }

  public static void zeigBuchungWohnung(int belegung[][]) {   //Ausgabe der Termine nach Eingabe der Wohnungsnummer
    Calendar calendar = Calendar.getInstance();   //Deklarieren einer neuen Kalenderinstanz
    SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");  //Erstellen eines neuen Formats für das Datum
    String formatiert;
    int dayOfYear;
    boolean error = false;
    do {
      System.out.print("\nWohnungsnummer: ");
      int wonu = Tastatur.liesInt();

      if (wonu < 1 || wonu > belegung.length) {               //Prüfung der Eingabe auf Korrektheit
        System.out.println("Wohnungsnummer existiert nicht!");
        error = true;
      }
      else {
        for (int i = 0; i < belegung[0].length; i++) {
          if (belegung[wonu-1][i] != 0) {                   //wenn das Feld nicht leer ist, wurde zu diesem Datum gebucht
            dayOfYear = i;
            calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);  //setzt den Kalendertag als Datum
            formatiert = format1.format(calendar.getTime());  //formatiert das Datum in das oben deklarierte Format
            System.out.println("Gebucht am " + formatiert + " von Kundennummer " + belegung[wonu-1][i]);
          }
        }
      }
    } while (error == true);
  }

  public static int kalendertag(int tag, int schalt, int monat) { //zu Konvertierung eines Datums in den Kalendertag
    int kalendertag = 0;
    switch (monat) {
      case 1 :
        kalendertag = tag;
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
