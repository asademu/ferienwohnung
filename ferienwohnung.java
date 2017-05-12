import java.io.*;
/**
 * Created by jhasse on 26.04.2017.
 */
public class ferienwohnung {

    public static String[][] neukunde(String kunden[][], int u_KANZ, int u_KATTR) {
        String u_kunde[][] = new String[kunden.length+1][u_KATTR];
        if (kunden.length >= u_KANZ) {
            u_kunde = kunden;
            System.out.println("Maximale Kundenanzahl erreicht!");
        } // end of if
        else {
            for (int i = 0; i < kunden.length; i++) {
                for (int j = 0; j < u_KATTR; j++) {
                    u_kunde[i][j] = kunden[i][j];
                } // end of for
            } // end of for

            System.out.print("Nachname: ");
            u_kunde[kunden.length][0] = Tastatur.liesString();
            System.out.print("\nVorname:  ");
            u_kunde[kunden.length][1] = Tastatur.liesString();
            System.out.print("\nAdresse:  ");
            u_kunde[kunden.length][2] = Tastatur.liesString();
        } // end of if-else

        return u_kunde;
    }

    public static void allekunden(String u_kunden[][], int u_KATTR) {
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

    public static void kusuche(String u_kunden[][], int u_KATTR) {

        System.out.print("\nSuchbegriff: ");
        String suche = Tastatur.liesString();
        boolean erfolg = false, doppel;
        for (int i=0; i<u_kunden.length; i++) {
            doppel = false;
            if (u_kunden[i][0].contains(suche) == true) {
                System.out.println("\nKundennummer: " + (i+1));
                System.out.println(u_kunden[i][0] + ", " + u_kunden[i][1]);
                System.out.println(u_kunden[i][2]);
                erfolg = true;
                doppel = true;
            } //end of if

            if (u_kunden[i][1].contains(suche) == true && doppel == false) {
                System.out.println("\nKundennummer: " + (i+1));
                System.out.println(u_kunden[i][0] + ", " + u_kunden[i][1]);
                System.out.println(u_kunden[i][2]);
                erfolg = true;
            } //end of if
        } //end of for
        if (erfolg == false) {
            System.out.println("\nKeine passenden Eintraege gefunden");
        } //end of if
    } //end of method

    public static String[][] kuedit(String u_kunden[][], int u_KATTR) {
        boolean ex;
        do {
            System.out.print("Kundenummer: ");
            int wahl = Tastatur.liesInt();
            ex = true;

            if (wahl <= u_kunden.length && wahl != 0) {
                System.out.println(u_kunden[wahl-1][0]+", "+u_kunden[wahl-1][1]);
                System.out.println(u_kunden[wahl-1][2]+"\n");
                System.out.print("Nachname: ");
                u_kunden[wahl-1][0] = Tastatur.liesString();
                System.out.print("Vorname: ");
                u_kunden[wahl-1][1] = Tastatur.liesString();
                System.out.print("Adresse: ");
                u_kunden[wahl-1][2] = Tastatur.liesString();
            }
            else if (wahl == 0) {
                ex = true;
            }
            else    {
                System.out.println("Kundennummer existiert nicht");
                ex = false;
            }
        } while (ex == false);
        return u_kunden;
    }

    public static String[][] wohnung(String u_kategorie[][],int u_ANZ, int u_ATTR)  {
        for (int i=0; i<u_ANZ; i++) {
            if (i<3) {
                u_kategorie[i][0] = "20";
                u_kategorie[i][1] = "15";
            } // end of if
            else {
                if (i<5) {
                    u_kategorie[i][0] = "30";
                    u_kategorie[i][1] = "25";
                } // end of if
                else {
                    u_kategorie[i][0] = "40";
                    u_kategorie[i][1] = "35";
                } // end of if-else
            } // end of if-else
        } // end of for
        return u_kategorie;
    }

    public static int mainmenu(int wahl) {
        System.out.println("\nKundenkartei");
        System.out.println("Wohnungen");
        System.out.println("Termine");
        System.out.println("Statistiken");
        System.out.println("Beenden");

        wahl = Tastatur.liesInt();
        return wahl;
    }

    public static int kundenmenu(int wahl2)   {
        System.out.println("\nNeukunde (2)");
        System.out.println("Ausgabe (3)");
        System.out.println("Suche (4)");
        System.out.println("Hauptmenü (5)");

        wahl2 = Tastatur.liesInt();
        return wahl2;
    }

    public static void schreiben(String array[][], String d_name) {
        File datei = null;
        FileWriter fileWriter = null;
        BufferedWriter writer = null;

        try {
            datei = new File(d_name);
            fileWriter = new FileWriter(datei);
            writer = new BufferedWriter(fileWriter);

            writer.write(Integer.toString(array.));

            writer.write("\n");

            for (int h = 0; h < 2; h++) {
                for (int i = 0; i < 2; i++) {
                    if (array[h][i] != null) {
                        writer.write(array[h][i]);
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

    public static String[] lesen(String d_name) {
        File datei = null;
        FileReader fileReader = null;
        BufferedReader reader = null;

        String text[] = null;

        int i = 0;
        try {
            datei = new File(d_name);
            fileReader = new FileReader(d_name);
            reader = new BufferedReader(fileReader);

            String zeile;
            zeile = reader.readLine();
            final int ANZ = Integer.valueOf(zeile);
            text = new String[ANZ];

            for ( i = 0; i < 4; i++) {
                zeile = reader.readLine();
                if (zeile != null) {
                    text[i] = zeile;
                } // end of if
                else {
                    System.out.println("Keine Daten in Dateizeile: " + i);
                    text[i] = null;
                } // end of if-else
            } // end of for
            reader.close();
        } catch(Exception e) {
            System.out.println("Dateifehler: " + e);
        } finally {
            System.out.println("Lesen der Daten ist beendet");
        } // end of try

        return text;
    }

    public static void main(String[] args) {
        int wahl = 0, wahl2 = 0, i = 0;
        final int WOHNANZ = 10, WOHNATTR = 2, KANZ = 50, KATTR = 3;

        String kategorie[][] = new String[WOHNANZ][WOHNATTR];
        String kunden[][] = new String[0][KATTR];

        System.out.println("Arraysize: "+kunden.length);

        kategorie = ferienwohnung.wohnung(kategorie, WOHNANZ, WOHNATTR);
        do {
            wahl = ferienwohnung.mainmenu(wahl);

            switch (wahl) {
                case 1: //Kundenkarteimenü
                    do {
                        wahl2 = ferienwohnung.kundenmenu(wahl2);
                        switch (wahl2) {
                            case 1: //
                                kunden = ferienwohnung.neukunde(kunden, KANZ, KATTR);
                                System.out.println("Array size: " + kunden.length);
                                break;
                            case 2: //
                                ferienwohnung.allekunden(kunden, KATTR);
                                break;
                            case 3: //
                                ferienwohnung.kusuche(kunden, KATTR);
                                break;
                            case 4: //
                                kunden = ferienwohnung.kuedit(kunden, KATTR);
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Fehleingabe!");
                        }
                    } while (wahl2 != 5); // end of do-while
                    break;
                case 5: //Beenden
                    break;
                default:
                    System.out.print("Fehleingabe!");
            }
        } while (wahl != 5);

    } // end of main

} // end of class ferienwohnung