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
public class Humain {
    private String nom;
    private String prenom;
    private String datenaissance;
    
    public Humain()
    {
        try 
        {
            setNom("inconnu");
            setPrenom("inconnu");
            setDateNaissance("01/01/2000");
        } 
        catch (SailorWithoutIdentificationException e)
        {
            System.out.println(e.getMessage());
        }
        
    }
    
    public Humain(String name, String firstname, String birthdate)
    {
        try 
        {
            setNom(name);
            setPrenom(firstname);
            setDateNaissance(birthdate);
        } 
        catch (SailorWithoutIdentificationException e) 
        {
            System.out.println(e.getMessage());
        }
       
    }
    
    public Humain(Humain h)
    {
        this.nom = h.getNom();
        this.prenom = h.getPrenom();
        this.datenaissance = h.getDateNaissance();

    }
    
    public final void setNom(String name)throws SailorWithoutIdentificationException
    {
        if (name == null)
            throw new SailorWithoutIdentificationException("Nom manquant !"); 
        else
            nom = name; 
    }
    
    public final void setPrenom(String firstname)throws SailorWithoutIdentificationException
    {
        if (firstname == null)
            throw new SailorWithoutIdentificationException("Prenom manquant !"); 
        else
            prenom = firstname; 
    }
    
    public final void setDateNaissance(String birthdate)
    {
        datenaissance = birthdate;
    }
     
    public String getNom()
    {
        return this.nom;
    }
    
    public String getPrenom()
    {
        return prenom;
    }
    
    public String getDateNaissance()
    {
        return datenaissance;
    }
    
}
