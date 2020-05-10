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
public class FichierConfig {
    public FichierConfig() {
    }

    public static String getNomsFichs(String str)
    {
        String nomF = new String();
        if(str.equals("login"))
            nomF = System.getProperty("user.dir") + System.getProperty("file.separator") + "login.properties";
        if(str.equals("phare"))
            nomF = System.getProperty("user.dir") + System.getProperty("file.separator") + "images" + System.getProperty("file.separator") + "phare.jpg";
        if(str.equals("En_flag"))
            nomF = System.getProperty("user.dir") + System.getProperty("file.separator") + "images" + System.getProperty("file.separator") + "En_flag.jpg";
        if(str.equals("erreur"))
            nomF = System.getProperty("user.dir") + System.getProperty("file.separator") + "images" + System.getProperty("file.separator") + "Err.jpg";
        if(str.equals("bateau"))
            nomF = System.getProperty("user.dir") + System.getProperty("file.separator") + "images" + System.getProperty("file.separator") + "BateauImage.jpg";
          
        
        return nomF;
    }
    
}
