/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.HashMap;
/**
 *
 * @author lbsarast
 */
public class Pelitehdas {

    private HashMap<String, KPSPeli> pelivaihtoehdot;
    private TuntematonPeli tuntematon;
    
    public Pelitehdas() {
        pelivaihtoehdot = new HashMap<String, KPSPeli>();
        pelivaihtoehdot.put("a", new KPSPelaajaVsPelaaja());
        pelivaihtoehdot.put("b", new KPSTekoaly());
        pelivaihtoehdot.put("c", new KPSParempiTekoaly());
        tuntematon = new TuntematonPeli();
    }
    
    public KPSPeli hae(String operaatio) {
        return pelivaihtoehdot.getOrDefault(operaatio, tuntematon);
    }
    
}
