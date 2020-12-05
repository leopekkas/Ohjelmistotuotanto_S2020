package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            KPSPeli valittuPeli;
            Pelitehdas pelivaihtoehdot = new Pelitehdas();
            
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            
            valittuPeli = pelivaihtoehdot.hae(vastaus);
            
            if (valittuPeli instanceof TuntematonPeli) {
                break;
            }
            
            valittuPeli.pelaa();

        }

    }
}
