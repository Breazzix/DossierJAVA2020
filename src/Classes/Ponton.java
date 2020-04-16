/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.List;

/**
 *
 * @author vange
 */
public class Ponton extends Amarrage {
    
    private List<MoyenDeTransportSurEau> liste;
    
    
    public List<MoyenDeTransportSurEau> getListe() {
        return liste;
    }
    // public addElement(MoyenDeTransportSurEau obj) {
    //     liste.ad
    // }

    @Override
    int getCapacite() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getIdentifiant() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*public MoyenDeTransportEau[] getListe(int cote)
    {
        
    }*/

    /**
     * @return the liste
     */
    
    
}
