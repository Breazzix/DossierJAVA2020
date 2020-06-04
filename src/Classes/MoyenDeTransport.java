/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;

/**
 *
 * @author vange
 */
abstract class MoyenDeTransport implements AvecHumains, Serializable{
    private String formeEnergie;
    
    public void setFormeEnergie(String energie)
    {
        formeEnergie = energie;
    }
    
    public String getFormeEnergie()
    {
        return formeEnergie;
    }
}
