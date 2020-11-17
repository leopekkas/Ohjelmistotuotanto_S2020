
package ohtu.intjoukkosovellus;

import java.util.stream.IntStream;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }
    
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 || kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kapasiteetti tai kasvatuskoko ei saa olla negatiivinen arvoltaan!");//heitin vaan jotain :D
        }
        ljono = new int[kapasiteetti];
        for (int i = 0; i < ljono.length; i++) {
            ljono[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    public boolean lisaa(int luku) {

        if (!kuuluu(luku)) {
            
            ljono[alkioidenLkm] = luku;
            alkioidenLkm++;

            if (alkioidenLkm % ljono.length == 0) {
                int[] taulukkoOld = new int[ljono.length];
                taulukkoOld = ljono;
                kopioiTaulukko(ljono, taulukkoOld);
                ljono = new int[alkioidenLkm + kasvatuskoko];
                kopioiTaulukko(taulukkoOld, ljono);
            }

            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        // Tarkistetaan kuuluuko parametrina oleva luku ljono listassa
        if (IntStream.of(ljono).anyMatch(x -> x == luku)) {
            return true;
        }
        
        return false;
    }

    public boolean poista(int luku) {
        if (kuuluu(luku)) {
            for (int i = 0; i < alkioidenLkm; i++) {
                if (luku == ljono[i]) {
                    ljono[i] = 0;
                    
                    for (int j = i; j < alkioidenLkm - 1; j++) {
                        int kopio = ljono[j];
                        ljono[j] = ljono[j + 1];
                        ljono[j + 1] = kopio;   
                    }
                    alkioidenLkm--;
                    return true;
                }
            }
        }
        return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        System.arraycopy(vanha, 0, uusi, 0, vanha.length);
    }

    public int getAlkioidenLkm() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        String tuotos = "{";

        for (int i = 0; i < alkioidenLkm; i++) {
            if (i > 0) {
                tuotos += ", ";
            }  
            tuotos += ljono[i];        
        }
        
        tuotos += "}";
        return tuotos;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        
        System.arraycopy(ljono, 0, taulu, 0, alkioidenLkm);
        
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdiste = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        
        int aPituus = aTaulu.length;
        int bPituus = bTaulu.length;
        
        // Tehdään uusi lista, johon kopioidaan a ja b taulujen arvot
        int[] yhdisteArray = new int[aPituus + bPituus];
        
        System.arraycopy(aTaulu, 0, yhdisteArray, 0, aPituus);
        System.arraycopy(bTaulu, 0, yhdisteArray, aPituus, bPituus);
        
        for (int i = 0; i < yhdisteArray.length; i++) {
            yhdiste.lisaa(yhdisteArray[i]);
        }
        
        return yhdiste;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaa(bTaulu[j]);
                }
            }
        }
        return y;

    }
    
    public static IntJoukko erotus (IntJoukko a, IntJoukko b) {
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < bTaulu.length; i++) {
            
            if (a.kuuluu(bTaulu[i])) {
                a.poista(bTaulu[i]);
            }
            
        }
        IntJoukko erotus = a;
        return erotus;
    }
        
}
