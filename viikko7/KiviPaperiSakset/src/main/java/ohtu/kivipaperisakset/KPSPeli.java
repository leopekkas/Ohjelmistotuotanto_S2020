/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.Scanner;
/**
 *
 * @author lbsarast
 */
public abstract class KPSPeli {
    
    private Pelaaja p2;
    private Pelaaja p1;
    
    public void KPSPeli(Pelaaja p1, Pelaaja p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
    
    public void pelaa() {
        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
        
        Scanner scanner = new Scanner(System.in);
        Tuomari tuomari = new Tuomari();
        
        String ekanSiirto;
        String tokanSiirto;
        System.out.println("Ensimmäisen pelaajan siirto: ");
        ekanSiirto = p1.annaSiirto();
        System.out.println("Pelaaja 1 valitsi: " + ekanSiirto);

        System.out.println("Toisen pelaajan siirto: ");
        tokanSiirto = p2.annaSiirto();
        System.out.println("Pelaaja 2 valitsi: " + tokanSiirto);

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            System.out.println("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = p1.annaSiirto();
            System.out.println("Pelaaja 1 valitsi: " + ekanSiirto);

            System.out.println("Toisen pelaajan siirto: ");
            tokanSiirto = p2.annaSiirto();
            System.out.println("Pelaaja 2 valitsi: " + tokanSiirto);
            p2.asetaSiirto(ekanSiirto);
            p1.asetaSiirto(tokanSiirto);

        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
    
    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
    
}
