/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBeans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author vange
 */
public class BoatBean implements PropertyChangeListener{
    private KindOfBoatBean kob;
    private Vector boatListeners;
    private static String pavillon[] = {"UK","FR","BE","IT","USA","IND","CHIN"};
    
    
    public BoatBean() {
        kob = new KindOfBoatBean();
        kob.addPropertyChangeListener(this);
        boatListeners=new Vector();
    }
    
    public void addBoatListener(BoatListener bl)
    {
        if (!boatListeners.contains(bl)){ boatListeners.addElement(bl);}
    }
    
    protected void notifyBoatDetected()
    {
        int rand = (int)(Math.random() * 7);
        
       
        BoatEvent e = new BoatEvent(this,kob.getInfo(),pavillon[rand],Calendar.getInstance().getTime());
        int n = boatListeners.size();
        for (int i=0;i<n;i++)
        {
            BoatListener obj = (BoatListener)boatListeners.elementAt(i);
            obj.BoatDetected(e);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        notifyBoatDetected();
        System.out.println("okkkk");
    }
    
}
