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
public class BateauPeche extends Bateau{
    
    public BateauPeche(String name, String port, int tonnes, int lg, String nationalite, Equipage equip) {
        super(name, port, tonnes, lg, nationalite, equip);
        // TODO Auto-generated constructor stub
    }

    private String type;
    
    public void setType(String t)
    {
        type = t;
    }
    
    public String getType()
    {
        return type;
    }
    
}
