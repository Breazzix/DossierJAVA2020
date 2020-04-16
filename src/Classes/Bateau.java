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
public class Bateau extends MoyenDeTransportSurEau implements AUnIdentifiant {
    private String nom;
    private String portAttache;
    private int tonnage;
    private int longueur;
    private String pavillon;
    private Equipage equipage;

    public Bateau() {
        try {
            setNom("b0");
            setPortAttache("pa0");
            setTonnage(0);
            setLongueur(0);
            setPavillon("inconnu");
        } catch (ShipWithoutIdentificationException e) {
            System.out.println(e.getMessage());
        }

    }

    public Bateau(String name, String port, int tonnes, int lg, String nationalite, Equipage equip) {
        try {
            setNom(name);
            setPortAttache(port);
            setTonnage(tonnes);
            setLongueur(lg);
            setPavillon(nationalite);
            setEquipage(equip);
        } catch (ShipWithoutIdentificationException e) {
            System.out.println(e.getMessage());
        }

    }

    public Bateau(Bateau b) {
        this.nom = b.getNom();
        this.portAttache = b.getPortAttache();
        this.tonnage = b.getTonnage();
        this.longueur = b.getLongueur();
        this.pavillon = b.getPavillon();

    }

    public final void setNom(String name) throws ShipWithoutIdentificationException {
        if (name == null)
            throw new ShipWithoutIdentificationException("Nom manquant !");
        else
            nom = name;
    }

    public final void setPortAttache(String port) throws ShipWithoutIdentificationException {
        if (port == null)
            throw new ShipWithoutIdentificationException("Port d'attache manquant !");
        else
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


}
