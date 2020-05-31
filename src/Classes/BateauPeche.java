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
    
    public BateauPeche(String name, String port,String typeBat, int tonnes, int lg, String nationalite, Equipage equip) {
        super(name, port, tonnes, lg, nationalite, equip);
        setType(typeBat);
        // TODO Auto-generated constructor stub
    }

    private String type;

    public BateauPeche(String pavillon) {
        super(pavillon);
    }
    
    public final void setType(String t)
    {
        type = t;
    }
    
    public String getType()
    {
        return type;
    }
    
    @Override
    public String toString() { 
        return String.format("Peche/"+this.getPavillon());
    }
   /* public String toString() { 
        return String.format(this.getNom()+ "--Peche" + "--"+this.getPavillon()+"-->");
    }*/
    
}
