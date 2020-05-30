/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.List;
import java.util.Vector;
import jdk.nashorn.internal.codegen.CompilerConstants;

/**
 *
 * @author vange
 */
public class Ponton extends Amarrage {
    
    private  MoyenDeTransportSurEau[] liste1;
    private MoyenDeTransportSurEau[] liste2;
    int nombreEmplacements;
    int numero;
    
    public Ponton ()
    {
        nombreEmplacements = 4;
        liste1 = new MoyenDeTransportSurEau[nombreEmplacements];
        liste2 = new MoyenDeTransportSurEau[nombreEmplacements];
        int numero = 1;
    }
    
    public Ponton (int num, int nb )
    {
        liste1 = new MoyenDeTransportSurEau[nb];
        liste2 = new MoyenDeTransportSurEau[nb];
        nombreEmplacements = nb;
        numero = num;
    }
    
    public MoyenDeTransportSurEau[] getListe(int side) {
        if (side == 1)
            return liste1;
        else
            return liste2;
    }
    
    public int getNombreEmplacements(){
        return nombreEmplacements;          
    }
    
    public int getNumero(){
        return numero;
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
    
     @Override
    public String toString() { 
        return String.format(this.getNumero() + "/" + this.getNombreEmplacements());
    }
    
    /*public MoyenDeTransportEau[] getListe(int cote)
    {
        
    }*/

    /**
     * @return the liste
     */
    
    
}
