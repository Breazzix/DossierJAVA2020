/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBeans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author vange
 */
public class BoatBean implements PropertyChangeListener{
    private KindOfBoatBean kob;
    
    BoatBean() {
        kob = new KindOfBoatBean();
        kob.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println(kob.getInfo());
    }
    
}
