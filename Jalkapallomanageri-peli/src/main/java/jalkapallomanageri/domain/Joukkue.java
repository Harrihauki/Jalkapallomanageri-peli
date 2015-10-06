/*
 * 
 */
package jalkapallomanageri.domain;

import jalkapallomanageri.ottelulogiikka.Muodostelma;
import jalkapallomanageri.pelaajaGeneraattori.Pelaajageneraattori;
import java.util.HashMap;
import java.util.Map;

/**
 * Luokka määrittelee joukkueiden yleisen toiminnan, kuten pelaajien hallinnan,
 * riippumatta siitä, onko joukkue botti vai käyttäjän joukkue
 * 
 */
public abstract class Joukkue {
    
    private Map<String, Pelaaja> pelaajat;
    private String nimi;
    private Muodostelma muodostelma;
    
    /**
     *
     * @param nimi
     */
    public Joukkue(String nimi) {
        
        this.nimi = nimi;
        this.pelaajat = new HashMap<>();
        this.muodostelma = new Muodostelma();
    }
    
    /**
     *
     * @return
     */
    public String getNimi() {
        
        return this.nimi;
    }
    
    /**
     * Metodi generoi joukkueelle 18 pelaajaa
     *
     * @param generaattori Pelaajageneraattori pelaajien luomista varten
     */
    public void generoiPelaajat(Pelaajageneraattori generaattori) {
        
        for (int i = 0; i < 18; i++) {
            
            Pelaaja pelaaja = generaattori.luoPelaaja();
            
            if (pelaajat.containsKey(pelaaja.getNimi())) {
                i--;
            }
            
            this.pelaajat.put(pelaaja.getNimi(), pelaaja);
        }
    }
    
    /**
     *
     * @return
     */
    public Map<String, Pelaaja> getPelaajat() {
        
        return this.pelaajat;
    }
    
    /**
     *
     * @return
     */
    public Muodostelma getMuodostelma() {
        
        return this.muodostelma;
    }
    
    /**
     *
     */
    public void setMuodostelma() {
        
        
    }
    
}
