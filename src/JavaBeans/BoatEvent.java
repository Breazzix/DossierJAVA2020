/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBeans;

import java.util.Date;
import java.util.EventObject;

/**
 *
 * @author ASUS7
 */
public class BoatEvent extends EventObject {
    
    String type;
    String pavillon;
    Date date;

    public BoatEvent(Object source,String t, String pav, Date d) {
        super(source);
        type = t;
        pavillon = pav;
        date = d;
    }
    
    public String getType()
    {
        return type;
    }
    
    public String getPavillon()
    {
        return pavillon;
    }
    
    public Date getDate()
    {
        return date;
    }
}
