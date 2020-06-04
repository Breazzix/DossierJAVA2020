/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;

/**
 *
 * @author ASUS7
 */
public class BateauAmarre implements Comparable<BateauAmarre>, Serializable {
    private Bateau bateau;
    private String amarrage;
    
    
    public BateauAmarre(Bateau bat, String am) {
        setBateau(bat);
        setAmarrage(am);        
    }
    
    @Override
    public int compareTo(BateauAmarre o) {
        return toString().compareTo(o.toString());
    }

   @Override
    public String toString() { 
        return this.getBateau().getNom();
    }

    /**
     * @return the bateau
     */
    public Bateau getBateau() {
        return bateau;
    }

    /**
     * @param bateau the bateau to set
     */
    public void setBateau(Bateau bateau) {
        this.bateau = bateau;
    }

    /**
     * @return the amarrage
     */
    public String getAmarrage() {
        return amarrage;
    }

    /**
     * @param amarrage the amarrage to set
     */
    public void setAmarrage(String amarrage) {
        this.amarrage = amarrage;
    }

    
    
    
}
