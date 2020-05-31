/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBeans;

/**
 *
 * @author vange
 */
public class KindOfBoatBean implements UtilisateurNombre{
    
    String info;
    
    public KindOfBoatBean ()
    {
        ThreadRandomGenerator tdrdg = new ThreadRandomGenerator(this, 1, 500, 5, 2);
        tdrdg.start();
    }
    
    @Override
    public String getIdentifiant() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void traiteNombre(int n) {
        
    }
    
}
