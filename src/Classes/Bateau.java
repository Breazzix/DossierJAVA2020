/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author vange
 */
public class Bateau extends MoyenDeTransportSurEau implements AUnIdentifiant, Serializable {
    private String nom;
    private String portAttache;
    private int tonnage;
    private int longueur;
    private String pavillon;
    private Equipage equipage;
    private Date dateArriver;

    public Bateau() {
        setNom("");
        setPortAttache("");
        setTonnage(0);
        setLongueur(0);
        setPavillon("");
        equipage = new Equipage();
    }

    public Bateau(String name, String port, int tonnes, int lg, String nationalite, Equipage equip) {
        setNom(name);
        setPortAttache(port);
        setTonnage(tonnes);
        setLongueur(lg);
        setPavillon(nationalite);
        setEquipage(equip);
    }
    
    public Bateau(String name, String port, int tonnes, int lg, String nationalite, Equipage equip, Date date) {
        setNom(name);
        setPortAttache(port);
        setTonnage(tonnes);
        setLongueur(lg);
        setPavillon(nationalite);
        setEquipage(equip);
        setDateArriver(date);
    }
    

    /*public Bateau(Bateau b) {
        this.nom = b.getNom();
        this.portAttache = b.getPortAttache();
        this.tonnage = b.getTonnage();
        this.longueur = b.getLongueur();
        this.pavillon = b.getPavillon();

    } */
    
    public Bateau (String pav, Date d)
    {
        setNom("");
        setPortAttache("");
        setTonnage(0);
        setLongueur(0);
        setPavillon(pav);
        setDateArriver(d);
        equipage = new Equipage();
    }

    public final void setNom(String name) {
            nom = name;
    }

    public final void setPortAttache(String port) {
            this.portAttache = port;
    }

    public final void setTonnage(int tonnes) {
        this.tonnage = tonnes;
    }

    public final void setLongueur(int lg) {
        this.longueur = lg;
    }

    public final void setPavillon(String nationalite) {
        this.pavillon = nationalite;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPortAttache() {
        return this.portAttache;
    }

    public int getTonnage() {
        return this.tonnage;
    }

    public int getLongueur() {
        return this.longueur;
    }

    public String getPavillon() {
        return this.pavillon;
    }

    public void Affiche() {
        System.out.println("Bateau: " + getNom() + " - " + getPortAttache() + " - " + getTonnage() + " - "
                + getLongueur() + " - " + getPavillon());
    }

    public Equipage getEquipage() {
        return this.equipage;
        // return new Equipage(this.equipage.getLiMarins(), this.equipage.getCapitaine(), this.equipage.getSecond());
    }

    public void setEquipage(Equipage equipage) {
        this.equipage = equipage;
        // this.equipage = new Equipage(equipage.getLiMarins(), equipage.getCapitaine(), equipage.getSecond());
    }

    @Override
    public String getIdentifiant() {
        return nom + portAttache;
    }

    @Override
    public int getNombreHumains() {
        return 0;
    }

    @Override
    public String toString() { 
        return String.format(this.getNom() + " | " + this.getEquipage());
    }
    
     public String toString2() { 
        return String.format(this.getNom() + " / " + this.getLongueur()+ "m");
    }

    /**
     * @return the dateArriver
     */
    public Date getDateArriver() {
        return dateArriver;
    }

    /**
     * @param dateArriver the dateArriver to set
     */
    public void setDateArriver(Date dateArriver) {
        this.dateArriver = dateArriver;
    }


}
