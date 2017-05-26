import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by jhasse on 26.04.2017.
 */
public class ferienwohnung {

    public static String[][] neukunde(String kunden[][], int u_KANZ, int u_KATTR) { //Eingabe eines neuen Kunden
        String u_kunde[][] = new String[kunden.length+1][u_KATTR]; //Kundenarray wird um 1 erweitert
        if (kunden.length >= u_KANZ) {  //Filter, falls maximale Kundenanzahl erreicht
            u_kunde = kunden;
            System.out.println("Maximale Kundenanzahl erreicht!");
        } // end of if
        else { //kopiert alle Werte in das neue erweiterte Array
            for (int i = 0; i < kunden.length; i++) {
                for (int j = 0; j < u_KATTR; j++) {
                    u_kunde[i][j] = kunden[i][j];
                } // end of for
            } // end of for

            System.out.print("Nachname: "); //Eingabe des Neukunden
            u_kunde[kunden.length][0] = Tastatur.liesString();
            System.out.print("\nVorname:  ");
            u_kunde[kunden.length][1] = Tastatur.liesString();
            System.out.print("\nAdresse:  ");
            u_kunde[kunden.length][2] = Tastatur.liesString();
        } // end of if-else

        return u_kunde;
    }

    public static void allekunden(String u_kunden[][], int u_KATTR) { //Ausgabe aller Kunden
        if (u_kunden.length > 0) {
            for (int i = 0; i < u_kunden.length; i++) {
                System.out.println("\nKundenummer: " + (i + 1));
                System.out.println(u_kunden[i][0] + ", " + u_kunden[i][1]);
                System.out.println(u_kunden[i][2]);
            } // end of for
        }
        else    {
            System.out.print("Keine Kunden vorhanden!");
        }
    }

    public static void kusuche(String u_kunden[][], int u_KATTR) {  //Suche nach Kunden durch Teilbegriffe (Vor- und Nachname)

        System.out.print("\nSuchbegriff: ");
        String suche = Tastatur.liesString();
        boolean erfolg = false, doppel;
        for (int i=0; i<u_kunden.length; i++) {
            doppel = false; //Reset, damit Ergebnisse nicht übergangen werden
            if (u_kunden[i][0].contains(suche) == true) {   //Suche, ob Nachname den gesuchten String enthält
                System.out.println("\nKundennummer: " + (i+1));
                System.out.println(u_kunden[i][0] + ", " + u_kunden[i][1]);
                System.out.println(u_kunden[i][2]);
                erfolg = true;  //Erfolgsvariable wird auf true gesetzt, um Errormessage zu übergehen
                doppel = true;  //Doppelvariable wird true, damit der Vorname desselben Kunden nicht durchsucht wird
            } //end of if

            if (u_kunden[i][1].contains(suche) == true && doppel == false) { //Suche, ob Vorname den gesuchten String enthält
                System.out.println("\nKundennummer: " + (i+1));
                System.out.println(u_kunden[i][0] + ", " + u_kunden[i][1]);
                System.out.println(u_kunden[i][2]);
                erfolg = true;
            } //end of if
        } //end of for
        if (erfolg == false) { //nur, wenn alle Einträge den String nicht enthalten
            System.out.println("\nKeine passenden Eintraege gefunden");
        } //end of if
    } //end of method

    public static String[][] kuedit(String u_kunden[][], int u_KATTR) {
        boolean ex; //Prüfungsvariable
        do {
            System.out.print("Kundenummer: ");  //Auswahl des Kunden
            int wahl = Tastatur.liesInt();
            ex = false; //Reset bei erneutem Durchlauf

            if (wahl <= u_kunden.length && wahl > 0) { //wird ausgeführt, falls Kundennummer existiert
                System.out.println(u_kunden[wahl-1][0]+", "+u_kunden[wahl-1][1]);
                System.out.println(u_kunden[wahl-1][2]+"\n");
                System.out.print("Nachname: "); //Aufforderung der Neueingabe
                u_kunden[wahl-1][0] = Tastatur.liesString();
                System.out.print("Vorname: ");
                u_kunden[wahl-1][1] = Tastatur.liesString();
                System.out.print("Adresse: ");
                u_kunden[wahl-1][2] = Tastatur.liesString();
                ex = true;  //Änderung der Prüfungsvariable um erneutes Durchlaufen zu verhindern
            }
            else    {
                System.out.println("Kundennummer existiert nicht");
            }
        } while (ex == false);
        return u_kunden;
    }

    public static int mainmenu(int wahl) {
        System.out.println("\nKundenkartei      (1)");
        System.out.println("Wohnungen       (2)");
        System.out.println("Buchungen       (3)");
        System.out.println("Statistiken     (4)");
        System.out.println("Beenden         (5)");

        wahl = Tastatur.liesInt();
        return wahl;
    }

    public static void kundenmenu(String kunden[][], int KANZ, int KATTR, String kundenDateiname)   {
        int wahlKunden = 0;
        do {
            System.out.println("\nNeukunde      (1)");
            System.out.println("Ausgabe     (2)");
            System.out.println("Suche       (3)");
            System.out.println("Bearbeiten  (4)");
            System.out.println("Hauptmenü   (5)");
            wahlKunden = Tastatur.liesInt();

            switch (wahlKunden) {
                case 1: //
                    kunden = ferienwohnung.neukunde(kunden, KANZ, KATTR);
                    System.out.println("Array size: " + kunden.length);
                    ferienwohnung.schreiben(kunden, kundenDateiname);
                    break;
                case 2: //
                    ferienwohnung.allekunden(kunden, KATTR);
                    break;
                case 3: //
                    ferienwohnung.kusuche(kunden, KATTR);
                    break;
                case 4: //
                    kunden = ferienwohnung.kuedit(kunden, KATTR);
                    ferienwohnung.schreiben(kunden, kundenDateiname);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Fehleingabe!");
            }
        } while (wahlKunden != 5);
    }

    public static void schreiben(String array[][], String dname) { //Länge und Werte eines String-Arrays werden in einer Textdatei abgespeichert
        File datei = null;              //Objektdeklaration
        FileWriter fileWriter = null;
        BufferedWriter writer = null;

        try {
            datei = new File(dname);                   //Objekt zur Bereitstellung der Datei
            fileWriter = new FileWriter(datei);         //Öffnung der Datei für Schreiboperation
            writer = new BufferedWriter(fileWriter);    //Datenschreiben in einer Datei

            writer.write(Integer.toString(array.length));   //1. Zeile zur Speicherung der Arraygröße (1. Dimension)
            writer.write("\n");                         //Zeilensprung
            writer.write(Integer.toString(array[0].length));//2. Zeile Speicherung der 2. Dimensionsgröße
            writer.write("\n");

            for (int i = 0; i < array.length; i++) {    //Doppelschleife, da 2-dimensionales Array
                for (int j = 0; j < array[0].length; j++) {
                    if (array[i][j] != null) {  //falls ein Feld leer ist wird es durch einen Zeilenumbruch ersetzt
                        writer.write(array[i][j]);
                        writer.write("\n");
                    } // end of if
                    else {
                        writer.write("\n");
                    } // end of if-else
                } // end of for
            } // end of for
            writer.close();

        } catch(Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Schreiben der Daten ist beendet");
        } // end of try
    }

    public static String[][] lesen(String dname) {  //auslesen einer txt-Datei und abspeichern als String-Array
        File datei = null;
        FileReader fileReader = null;
        BufferedReader reader = null;
        String text[][] = null;

        try {
            datei = new File(dname);
            fileReader = new FileReader(dname);
            reader = new BufferedReader(fileReader);
            String zeile;

            zeile = reader.readLine();
            System.out.println("Zeile: "+zeile);
            final int ANZDIM1 = Integer.valueOf(zeile);
            System.out.println("anzdim: "+ANZDIM1);

            zeile = reader.readLine();
            System.out.println("Zeile: "+zeile);
            final int ANZDIM2 = Integer.valueOf(zeile);
            text = new String[ANZDIM1][ANZDIM2];

            for (int i = 0; i < ANZDIM1; i++) {
                for (int j = 0; j < ANZDIM2; j++) {
                    zeile = reader.readLine();
                    if (zeile != null) {
                        if (zeile.equals("") == true) {
                            System.out.println("Keine Daten in Dateizeile: " + i);
                            text[i][j] = null;
                        }
                        else {
                            text[i][j] = zeile;
                        }
                    }
                } // end of for
            }
            reader.close();

        } catch(Exception e) {
            System.out.println("Dateifehler: " + e);

        } finally {
            System.out.println("Lesen der Daten ist beendet");
        } // end of try

        return text;
    }

    public static String[][] doubleToString(double wohnung[][]) { //konvertiert Double-Arrays zu String-Arrays
        int ANZ1 = wohnung.length, ANZ2 = wohnung[0].length;
        String swohnung[][] = new String[ANZ1][ANZ2];
        for (int i = 0; i < ANZ1; i++) {
            for (int j = 0; j < ANZ2; j++) {
                swohnung[i][j] = String.valueOf(wohnung[i][j]);
            }
        }
        return swohnung;
    }

    public static double[][] stringToDouble(String swohnung[][]) { //konvertiert String-Arrays zu Double-Arrays
        int ANZ1 = swohnung.length, ANZ2 = swohnung[0].length;
        double wohnung[][] = new double[ANZ1][ANZ2];
        for (int i = 0; i < ANZ1; i++) {
            for (int j = 0; j < ANZ2; j++) {
                wohnung[i][j] = Double.parseDouble(swohnung[i][j]);
            }
        }
        return wohnung;
    }

    public static void verzeichnislesen() {
        File datei = new File(".\\");   //in demselben Verzeichnis wie die Programmdateien
        String dateienVerzeichnisse[] = datei.list();

        if (dateienVerzeichnisse != null) {
            for (int i = 0; i < dateienVerzeichnisse.length; i++) {
                System.out.println(dateienVerzeichnisse[i]);
            }
        }
    }

    public static boolean dateiNamenPruefung(String dname) {
        File datei = new File(".\\");
        boolean gefunden = false;
        String dateienVerzeichnisse[] = datei.list();

        if(dateienVerzeichnisse != null) {
            for (int i = 0; i < dateienVerzeichnisse.length; i++) {
                if (dateienVerzeichnisse[i].equals(dname) == true) {
                    gefunden = true;
                }
            }
        }
        return gefunden;
    }

    public static void main(String[] args) {
        String kundenDateiname = "Kundenkartei.txt";    //Variablendeklaration
        String wohnungDateiname = "Wohnungskartei.txt";
        int wahlMain = 0, i = 0, schalt = 0, rest, kalendertag, KT;
        final int KANZ = 50, KATTR = 3, WOHNANZ = 10, WOHNATTR = 2, BUCHATTR = 5;

        File kuka = new File(kundenDateiname);
        File woka = new File(wohnungDateiname);

        double wohnung[][] = new double[WOHNANZ][WOHNATTR]; //Deklaration der Wohnungsarrays
        String swohnung[][] = new String[WOHNANZ][WOHNATTR];    //double zur Weiterverwendung, String zum Abspeichern
        String kunden[][] = new String[0][KATTR];   //0 Kunden, falls noch keine vorhanden; Array wird mit jedem Kunden erweitert

        GregorianCalendar systemdatum = new GregorianCalendar();
        int datum[][] = new int[0][BUCHATTR]; //1. Dim.: Buchungsnummer, 2. Dim.: 1. Jahr, 2. Monat, 3. Tag, 4. Wohnung, 5. Kundennummer

        KT = systemdatum.get(Calendar.YEAR);

        if (woka.exists()) { //prüft, ob bereits eine Wohnungskartei besteht
          swohnung = ferienwohnung.lesen(wohnungDateiname); //liest die Werte der txtdatei aus
          wohnung = ferienwohnung.stringToDouble(swohnung); //konvertiert das Stringarray zu double
        }
        else {  //falls das Programm zum ersten Mal ausgeführt wird
          wohnung = Wohnung.initflat(wohnung, WOHNANZ); //initiale Werte der Wohnungen
          swohnung = ferienwohnung.doubleToString(wohnung); //konvertiert double zu String
          ferienwohnung.schreiben(swohnung, wohnungDateiname); //schreibt das String-Array in eine txtdatei
        }

        if (kuka.exists()) {    //Prüfung bei Programmstart, ob Kundenkartei bereits existiert
            kunden = ferienwohnung.lesen(kundenDateiname); //ersetzt Array, falls Datei existent
        }

        System.out.println("Kundenbestand: "+kunden.length);

        do {    //Start des Hauptmenüs
            wahlMain = ferienwohnung.mainmenu(wahlMain);

            switch (wahlMain) {
                case 1: //Kundenkarteimenü
                    ferienwohnung.kundenmenu(kunden, KANZ, KATTR, kundenDateiname);
                    break;
                case 2: //Wohnungsmenü
                    Wohnung.wohnungmenu(wohnung, swohnung, WOHNANZ, wohnungDateiname);
                    break;
                case 3: //Buchungsmenü
                    Termin.kalendertag();
                    break;
                case 4: //Statistiken
                    break;
                case 5: //Beenden
                    break;
                default:
                    System.out.print("Fehleingabe!");
            }
        } while (wahlMain != 5);
    } // end of main
} // end of class ferienwohnung