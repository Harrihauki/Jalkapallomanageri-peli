/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalkapallomanageri.kello;

/**
 * Laskuri pelikelloa varten
 *
 * @author lallimyl
 */
public class YlhaaltaRajoitettuLaskuri {

    private int arvo;
    private int ylaraja;
    private int hyppy;

    public YlhaaltaRajoitettuLaskuri(int ylarajanAlkuarvo, int hyppy) {
        this.ylaraja = ylarajanAlkuarvo;
        this.arvo = 0;
        this.hyppy = hyppy;
    }
    
    /**
     * 
     * Kellon viisareiden etenemiseen tarkoitettu metodi
     */

    public void seuraava() {
        if (this.arvo == this.ylaraja) {
            this.arvo = 0;
        } else {
            this.arvo += this.hyppy;
        }
    }

    public int getArvo() {
        return this.arvo;
    }

    /**
     * Lisätään etunolla, jos kellon arvo on alle 10.
     * 
     * @return 
     */
    @Override
    public String toString() {
        String etunolla = "0";
        if (this.arvo > 9) {
            etunolla = "";
        }
        return etunolla + this.arvo;
    }
}
