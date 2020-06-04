/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Date;

/**
 *
 * @author vange
 */
public class BateauPlaisance extends Bateau{
    public BateauPlaisance(String name, String port, int tonnes, int lg, String nationalite, Equipage equip, Date d) {
        super(name, port, tonnes, lg, nationalite, equip, d);
        // TODO Auto-generated constructor stub
    }
    
    public BateauPlaisance(String name, String port, int tonnes, int lg, String nationalite, Equipage equip) {
        super(name, port, tonnes, lg, nationalite, equip);
    }

    private String typePermis;
    
    public void setTypePermis(String tp)
    {
        typePermis = tp;
    }
    
    public String getTypePermis()
    {
        return typePermis;
    }
    
    public BateauPlaisance(String pavillon, Date d) {
        super(pavillon, d);
    }
    
    @Override
    
    public String toString() { 
        return String.format("Plaisance/"+this.getPavillon());
    }
    /*public String toString() { 
        return String.format(this.getNom()+ "--Plaisance" + "--"+this.getPavillon()+"-->");
    }*/
    
}
