package ohtu.intjoukkosovellus;

import java.util.Scanner;

public class Sovellus {

    private static IntJoukko A, B, C;

    private static String luku() {
        Scanner lukija = new Scanner(System.in);
        String luettu = lukija.nextLine();
        return luettu;
    }
    
    private static int lueTasaluku(String kysymys) {
        Scanner lukija = new Scanner(System.in);
        System.out.println(kysymys);
        
        return lukija.nextInt();
    }
    
    private static IntJoukko lueJoukko(String kysymys) {
        System.out.print(kysymys);
        return mikaJoukko();
    }

    private static IntJoukko mikaJoukko() {
        String luettu;
        Scanner lukija = new Scanner(System.in);
        luettu = luku();
        while (true) {
            if (luettu.equalsIgnoreCase("A")) {
                return A;
            } else if (luettu.equalsIgnoreCase("B")) {
                return B;
            } else if (luettu.equalsIgnoreCase("C")) {
                return C;
            } else {
                System.out.println("Virheellinen joukko! " + luettu + "\nYritä uudelleen!");
                luettu = luku();
            }
        }
    }

    private static void lisaa() {
        int lisLuku;
        IntJoukko joukko;
        Scanner lukija = new Scanner(System.in);
        joukko = lueJoukko("Mihin joukkoon? ");
        lisLuku = lueTasaluku("Mikä luku lisätään? ");
        joukko.lisaa(lisLuku);
        return;

    }

    private static void yhdiste() {
        IntJoukko aJoukko, bJoukko, c;
        
        aJoukko = lueJoukko("1. joukko? ");
        bJoukko = lueJoukko("2. joukko? ");
        
        c = IntJoukko.yhdiste(aJoukko, bJoukko);
        System.out.println("A yhdiste B = " + c.toString());
        return;
    }

    private static void leikkaus() {
        IntJoukko aJoukko, bJoukko, c;
        
        aJoukko = lueJoukko("1. joukko? ");
        bJoukko = lueJoukko("2. joukko? ");
        
        c = IntJoukko.leikkaus(aJoukko, bJoukko);
        System.out.println("A leikkaus B = " + c.toString());
        return;
    }

    private static void erotus() {
        IntJoukko aJoukko, bJoukko, c;
        
        aJoukko = lueJoukko("1. joukko? ");
        bJoukko = lueJoukko("2. joukko? ");
        
        c = IntJoukko.erotus(aJoukko, bJoukko);
        System.out.println("A erotus B = " + c.toString());
        return;
    }

    private static void poista() {
        IntJoukko joukko;
        
        System.out.print("Mistä joukosta? ");
        joukko = lueJoukko("Mistä joukosta? ");
        int lisLuku = lueTasaluku("Mikä luku poistetaan? ");
        joukko.poista(lisLuku);
        
        return;
    }

    private static void kuuluu() {
        IntJoukko joukko;
        
        joukko = lueJoukko("Mihin joukkoon? ");
        int kysLuku = lueTasaluku("Mikä luku? ");
        
        if (joukko.kuuluu(kysLuku)) {
            System.out.println(kysLuku + " kuuluu joukkoon ");
        } else {
            System.out.println(kysLuku + " ei kuulu joukkoon ");
        }
        return;
    }

    public static void main(String[] args) {
        A = new IntJoukko();
        B = new IntJoukko();
        C = new IntJoukko();
        String luettu;

        System.out.println("Tervetuloa joukkolaboratorioon!");
        System.out.println("Käytössäsi ovat joukot A, B ja C.");
        System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e), leikkaus(le) ja lopetus(quit)(q).");
        System.out.println("Joukon nimi komentona tarkoittaa pyyntöä tulostaa joukko.");

        Scanner lukija = new Scanner(System.in);
        while (true) {
            luettu = lukija.nextLine();
            if (luettu.equals("lisää") || luettu.equals("li")) {
                lisaa();
            } else if (luettu.equalsIgnoreCase("poista") || luettu.equalsIgnoreCase("p")) {
                poista();
            } else if (luettu.equalsIgnoreCase("kuuluu") || luettu.equalsIgnoreCase("k")) {
                kuuluu();
            } else if (luettu.equalsIgnoreCase("yhdiste") || luettu.equalsIgnoreCase("y")) {
                yhdiste();
            } else if (luettu.equalsIgnoreCase("leikkaus") || luettu.equalsIgnoreCase("le")) {
                leikkaus();
            } else if (luettu.equalsIgnoreCase("erotus") || luettu.equalsIgnoreCase("e")) {
                erotus();
            } else if (luettu.equalsIgnoreCase("A")) {
                System.out.println(A);
            } else if (luettu.equalsIgnoreCase("B")) {
                System.out.println(B);
            } else if (luettu.equalsIgnoreCase("C")) {
                System.out.println(C);
            } else if (luettu.equalsIgnoreCase("lopeta") || luettu.equalsIgnoreCase("quit") || luettu.equalsIgnoreCase("q")) {
                System.out.println("Lopetetaan, moikka!");
                break;
            } else {
                System.out.println("Virheellinen komento! " + luettu);
                System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
            }
            System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
        }
    }
}
