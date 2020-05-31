/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBeans;

import Classes.Bateau;
import Classes.BateauPeche;
import Classes.BateauPlaisance;
import Fenetres.Applic_Phare;
import Fenetres.BateauArrive;
import java.awt.Frame;
import javax.swing.JFrame;

/**
 *
 * @author vange
 */
public class NotifyBean implements BoatListener{
    JFrame applic;

    public NotifyBean(JFrame f) {
        applic = f;
    }
    
    @Override
    public void BoatDetected(BoatEvent e) {
        BateauArrive win = new BateauArrive(applic, true);
        win.setVisible(true);
        
        Bateau bat = null;
        
        if ("Peche".equals(e.getType()))
        {
            bat = new BateauPeche(e.getPavillon());
        }
        else
        {
            bat = new BateauPlaisance(e.getPavillon());
        }
        Applic_Phare.addList(bat);
    }
}
