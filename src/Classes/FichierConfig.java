/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

/**
 *
 * @author vange
 */
public class FichierConfig {
    
    private static Properties config;
    public static String test;
    
    public FichierConfig () {
        loadConfig();
        test = "testtest";
    }

    /**
     * @return the config
     */
    public static Properties getConfig() {
        return config;
    }

    /**
     * @param aConfig the config to set
     */
    public static void setConfig(Properties aConfig) {
        config = aConfig;
    }
    

    public static String getNomsFichs(String str)
    {
        String fileName = new String();

        switch (str) {
            case "login":
                fileName = System.getProperty("user.dir") + System.getProperty("file.separator") + "login.properties";
                break;

            case "phare":
                fileName = System.getProperty("user.dir") + System.getProperty("file.separator") + "images" + System.getProperty("file.separator") + "phare.jpg";
        
            case "UK":
                fileName = System.getProperty("user.dir") + System.getProperty("file.separator") + "images" + System.getProperty("file.separator") + "UK.jpg";
                break;
            
            case "erreur":
                fileName = System.getProperty("user.dir") + System.getProperty("file.separator") + "images" + System.getProperty("file.separator") + "Err.jpg";
                break;

            case "bateau":
                fileName = System.getProperty("user.dir") + System.getProperty("file.separator") + "images" + System.getProperty("file.separator") + "BateauImage.jpg";
                break;
            
            case "logs":
                fileName = System.getProperty("user.dir") + System.getProperty("file.separator") + "logs.txt";
                break;
                
            case "bateauAmarre":
                fileName = System.getProperty("user.dir") + System.getProperty("file.separator") + "batAmarre.data";
                break;
                
            case "bateauArriver":
                fileName = System.getProperty("user.dir") + System.getProperty("file.separator") + "bateauArriver.data";
                break;
            
            case "config":
                fileName = System.getProperty("user.dir") + System.getProperty("file.separator")+ "Config.properties";
                break;
        }
        
        return fileName;
    }
    
    public static void creeConfig () throws FileNotFoundException, IOException {
               
        String login = getNomsFichs("login");
        String logs = getNomsFichs("logs");
        String port = "60001";
        String batPeche = "17";
        String batPlaisance = "7";
        String pause = "5";
        String dateFormat = "0"; 
        String pays = "0";
        String timeFormat = "0";
        
        
        config.setProperty("Login", login);
        config.setProperty("Logs", logs);
        config.setProperty("port", port);
        config.setProperty("batPeche", batPeche);
        config.setProperty("batPlaisance", batPlaisance);
        config.setProperty("pause", pause);
        config.setProperty("dateFormat", dateFormat);
        config.setProperty("pays", pays);
        config.setProperty("timeFormat", timeFormat);
        
        config.store(new FileOutputStream(getNomsFichs("config")), null);
        FichierLog.Writer("fichierConfig", "Création du fichier Config");
        
    }
    
    
     public static void loadConfig() {
        config = new Properties();
        
        
        try  {
            config.load(new FileInputStream(getNomsFichs("config")));
        } 
        catch(FileNotFoundException e) { 
            System.out.println("Fichier Config.properties non trouvé !");
            try {
                creeConfig ();
            } 
            catch (FileNotFoundException ex) { System.out.println("Fichier Config.properties non trouvé !"); } 
            catch (IOException ex) { System.out.println("Error: "+ ex.getMessage()); }
        }
        catch(IOException e) { System.out.println("Error: "+ e.getMessage()); }
    }
     
     public static void setDateFormat(String d, String t, String p) {
         getConfig().setProperty("dateFormat", d);
         getConfig().setProperty("timeFormat", t);
         getConfig().setProperty("pays", p);
         
         try {
             getConfig().store(new FileOutputStream(getNomsFichs("config")), null);
         }
         catch (FileNotFoundException e) { System.out.println("Fichier Config.properties non trouvé !"); } 
         catch (IOException e) { System.out.println("Error: "+ e.getMessage()); }
     }
    
}
