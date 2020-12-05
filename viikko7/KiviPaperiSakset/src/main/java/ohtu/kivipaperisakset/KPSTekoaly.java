package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends KPSPeli {

    private Ihminen p1 = new Ihminen();
    private Tekoaly p2 = new Tekoaly();
    
    public KPSTekoaly() {
        super.KPSPeli(p1, p2);
    }
}