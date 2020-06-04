/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS7
 */
public class FichierLog {
    private static String nomFile;

    /**
     * @return the nomFile
     */
    public static String getNomFile() {
        return nomFile;
    }

    /**
     * @param aNomFile the nomFile to set
     */
    public static void setNomFile(String aNomFile) {
        nomFile = aNomFile;
    }
    
    public FichierLog() {
        setNomFile("fichierLog");
    }
    
    public FichierLog(String s) {
        setNomFile(s);
    }
    
    
    public static String Reader() {
        setNomFile(FichierConfig.getNomsFichs("logs"));
        String ligne;
        String logfich = "";
        
        try {
            FileReader fr = new FileReader(getNomFile());
            BufferedReader br = new BufferedReader(fr);
            
            while((ligne = br.readLine()) != null) {
                logfich += "\n" + ligne;
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Fichier non trouvé ! " + e.getMessage());
        }
        catch (IOException e) {
            //Logger.getLogger(NewsPersistantes.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return logfich; 
    }
    
    public static void Writer(String header, String ligne) {
        SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String date = form.format(new Date());
        String nomfich = FichierConfig.getNomsFichs("logs");
        try {
            FileWriter fw = new FileWriter(nomfich, true);
            BufferedWriter bf = new BufferedWriter(fw);
            bf.write("[" + date + "] : " + "<" + header + ">" +  ligne);
            bf.newLine();
            bf.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("Fichier non trouvé ! " + e.getMessage());
        } 
        catch (IOException e) {
            //Logger.getLogger(NewsPersistantes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

   
}
