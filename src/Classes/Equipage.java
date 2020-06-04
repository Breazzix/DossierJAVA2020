/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS7
 */
public class Equipage implements Serializable {
    private List<Marin> listMarins;
    private Marin capitaine;
    private Marin second;

    public Equipage() {
        setListMarins(new ArrayList<>());
        setCapitaine(new Marin());
        setSecond(new Marin());
    }

    public Equipage(List<Marin> list, Marin cap, Marin sec) {
        setListMarins(list);
        setCapitaine(cap);
        setSecond(sec);
    }

    public List<Marin> getLiMarins() {
        return listMarins;
    }

    public void setListMarins(List<Marin> list) {
        this.listMarins = list;
    }

    public Marin getCapitaine() {
        return this.capitaine;
        // return new Marin(this.capitaine.getNom(), this.capitaine.getPrenom(), this.capitaine.getDateNaissance(),
        //         this.capitaine.getFonction());
    }

    public void setCapitaine(Marin capitaine) {
        this.capitaine = capitaine;
        // this.capitaine = new Marin(capitaine.getNom(), capitaine.getPrenom(), capitaine.getDateNaissance(),
        //         capitaine.getFonction());
    }

    public Marin getSecond() {
        return this.second;
        // return new Marin(this.second.getNom(), this.second.getPrenom(), this.second.getDateNaissance(),
        //         this.second.getFonction());
    }

    public void setSecond(Marin second) {
        this.second = second;
        // this.second = new Marin(second.getNom(), second.getPrenom(), second.getDateNaissance(),
        //         second.getFonction());
    }

    @Override
    public String toString() { 
        return String.format(this.getLiMarins() + " | " + this.getCapitaine() + " | " + this.getSecond());
    }
}
