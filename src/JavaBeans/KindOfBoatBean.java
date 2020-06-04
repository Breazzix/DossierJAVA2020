/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBeans;

import Fenetres.WinHarbour;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author vange
 */
public class KindOfBoatBean implements UtilisateurNombre{
    
    String info;
    ThreadRandomGenerator tdrdg;
    protected PropertyChangeSupport GestProp = new PropertyChangeSupport(this);
    
    public KindOfBoatBean ()
    {
        tdrdg = new ThreadRandomGenerator(this, 1, 500, 1, Integer.parseInt(WinHarbour.ConfigProperty.getConfig().getProperty("pause")));
        tdrdg.start();
    }
    
    public void setInfo(String type)
    {
        String ancienInfo = info;
        info=type;
        GestProp.firePropertyChange("info",ancienInfo,type);
    }
    
    public String getInfo() 
    {
        return this.info;
    }
    
    public void addPropertyChangeListener(PropertyChangeListener l) {
        GestProp.addPropertyChangeListener(l);
    }
    
    @Override
    public String getIdentifiant() {
        return this.getClass().getName();
    }

    @Override
    public void traiteNombre(int n) {
        int modPeche = Integer.parseInt(WinHarbour.ConfigProperty.getConfig().getProperty("batPeche"));
        int modPlaissance = Integer.parseInt(WinHarbour.ConfigProperty.getConfig().getProperty("batPlaisance"));
        
        if (n % modPlaissance == 0) {
            setInfo("Plaisance");
            tdrdg.setEnMarche(false);
            System.out.println("plaisance trouvé");
        }
        else if (n% modPeche == 0) {
            setInfo("Peche");
            tdrdg.setEnMarche(false);
            System.out.println("peche trouvé");
        }
    }
    
}
