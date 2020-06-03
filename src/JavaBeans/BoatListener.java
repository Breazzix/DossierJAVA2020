/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBeans;

import java.util.Calendar;
import java.util.Date;
import java.util.EventListener;

/**
 *
 * @author ASUS7
 */
public interface BoatListener extends EventListener{
    public void BoatDetected(BoatEvent e);
}
