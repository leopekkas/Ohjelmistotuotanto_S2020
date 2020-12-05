package ohtu.kivipaperisakset;

import java.util.Scanner;

import java.util.Scanner;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends KPSPeli {

    // private static final Scanner scanner = new Scanner(System.in);
    private TekoalyParannettu p2 = new TekoalyParannettu(20);
    private Ihminen p1 = new Ihminen();
    
    public KPSParempiTekoaly() {
        super.KPSPeli(p1, p2);
    }
}
