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
    ThreadRandomGenerator tdrdg;
    
    public KindOfBoatBean ()
    {
        tdrdg = new ThreadRandomGenerator(this, 1, 500, 1, 2);
        tdrdg.start();
    }
    
    public void setInfo(String type)
    {
        info=type;
    }
    
    @Override
    public String getIdentifiant() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void traiteNombre(int n) {
        if (n%7==0)
        {
            setInfo("Plaisance");
            tdrdg.setEnMarche(false);
            System.out.println("plaisance trouvé");
        }
        else if (n%17==0)
        {
            setInfo("Peche");
            tdrdg.setEnMarche(false);
            System.out.println("peche trouvé");
        }
    }
    
}
