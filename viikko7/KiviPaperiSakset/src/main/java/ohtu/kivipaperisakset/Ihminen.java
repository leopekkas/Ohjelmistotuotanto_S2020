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
public class Ihminen extends Pelaaja {
    
    @Override
    public String annaSiirto() {
        Scanner lukija = new Scanner(System.in);
        String siirto = lukija.nextLine();
        return siirto;
    }
    
    public void asetaSiirto(String siirto) {
        // Ei tapahdu mitään
    }
    
}
