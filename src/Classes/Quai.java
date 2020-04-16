/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author vange
 */
public class Quai extends Amarrage {
    
    private MoyenDeTransportSurEau[] liste;
    
    public MoyenDeTransportSurEau[] getListe()
    {
         return liste;
    }

    @Override
    int getCapacite() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getIdentifiant() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
