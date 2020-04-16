/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;



public class Marin extends Humain implements AUnIdentifiant{
    String fonction;
    public final static String[] listeFonction = {"Capitaine", "Second", "Bosco", "Matelot", "Passager"};
    
    public Marin()
    {
        super();
        setFonction("fct inconnue");
    }

   
    
    public Marin(String name, String firstname, String birthdate, String fonct)
    {
        super(name,firstname,birthdate);
        setFonction(fonct);
    }
    
    public Marin(Marin m)
    {
        super(m);
        this.fonction = m.getFonction();
    }
    
    public final void setFonction(String fonct)
    {
        fonction = fonct;
    }
    
    public String getFonction()
    {
        return fonction;
    }
    
    @Override 
    public String getIdentifiant()
    {
        return getNom() + getPrenom() + getDateNaissance();
    } 

    @Override
    public String toString() { 
        return String.format(this.getFonction() + " " + this.getNom());
    } 
}
