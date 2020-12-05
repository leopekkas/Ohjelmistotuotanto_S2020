package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends KPSPeli {

    private Ihminen p2 = new Ihminen();
    private Ihminen p1 = new Ihminen();
    
    public KPSPelaajaVsPelaaja() {
        super.KPSPeli(p1, p2);
    }
}