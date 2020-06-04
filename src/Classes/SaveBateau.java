/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS7
 */
public class SaveBateau {
    
    public static void readAmarre(Vector<BateauAmarre> listBat) {
        String fileName = FichierConfig.getNomsFichs("bateauAmarre");
        
        read((Vector<Object>)(Object)listBat, fileName);
    }
    
    public static void readArriver(Vector<Bateau> listBat) {
        String fileName = FichierConfig.getNomsFichs("bateauArriver");
        
        read((Vector<Object>)(Object) listBat, fileName);
    }
    
    public static void read(Vector<Object> listBat, String fileName) {
        try {
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream oin = new ObjectInputStream(fin);
            
           
            while(true)  {
                listBat.add((Object)oin.readObject());
            }
        }
        catch (EOFException e){ }
        catch (FileNotFoundException e) {
            
            FichierLog.Writer("SaveBateau", "Fichier n'existe pas : " + e.getMessage());
            
            try {
                FileOutputStream fout = new FileOutputStream(fileName);
            }
            catch (FileNotFoundException ea)  {
                FichierLog.Writer("SaveBateau", "Fichier n'existe pas : " + ea.getMessage());
            }
            
        }
         catch (IOException e) {
             Logger.getLogger(SaveBateau.class.getName()).log(Level.SEVERE, null, e);
         }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(SaveBateau.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    
    
    
    public static void writeAmarre(Vector<BateauAmarre> listBat) {
        String fileName = FichierConfig.getNomsFichs("bateauAmarre");
        
        write((Vector<Object>) (Object) listBat, fileName);
    }
    
    public static void writeArriver(Vector<Bateau> listBat) {
        String fileName = FichierConfig.getNomsFichs("bateauArriver");
        
        write((Vector<Object>) (Object) listBat, fileName);
    }
    
    public static void write(Vector<Object> listBat, String fileName) {
        try {
            FileOutputStream fout = new FileOutputStream(fileName);
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            
            for(int i=0; i< listBat.size(); i++)
            {
                oout.writeObject(listBat.get(i));
            }
            oout.flush();
        }
        catch (FileNotFoundException e) {
            FichierLog.Writer("SaveBateau", "Fichier n'existe pas ! : " + e.getMessage());
        }
        catch (IOException ex) {
            Logger.getLogger(SaveBateau.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

}
