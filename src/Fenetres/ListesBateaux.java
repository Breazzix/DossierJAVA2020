/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fenetres;

import Classes.Bateau;
import Classes.BateauAmarre;
import Classes.Ponton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS7
 */
public class ListesBateaux extends javax.swing.JDialog {
    
    private Object[] col = { "Nom", "port d'attache", "amarrage"};
    private DefaultTableModel modelTable = new DefaultTableModel(col, 0);
    int BatEnregistre=0;


    public ListesBateaux(java.awt.Frame parent, boolean modal, Vector<Ponton> listePontons) {
        super(parent, modal);
        initComponents();
       
        createListBatAmarre(listePontons);
    }
    
    private void createListBatAmarre(Vector<Ponton> list) {
        Enumeration enm = list.elements();
        Bateau bat;
        ArrayList<BateauAmarre> listBateaux = new ArrayList<BateauAmarre>();
        
        int a = 0;
        for (int i = 0; enm.hasMoreElements(); i++) {
            Ponton unPonton = (Ponton) enm.nextElement();
            for (int j = 0; i < 2; j++) {
                for (int k = 0; k < unPonton.getNombreEmplacements(); k++) {
                    bat = (Bateau) unPonton.getListe(i + 1)[k];
                    if (bat != null) {
                        String amarrage = "P" + String.valueOf(unPonton.getNumero()) + (j + 1) + "*" + (k + 1);
                        BateauAmarre ba = new BateauAmarre(bat, amarrage);
                        listBateaux.add(ba);
                    }
                        
                }
            }
        }
        Collections.sort(listBateaux);
        insertBatDansTab(listBateaux);
    }
    
    
    private void insertBatDansTab(ArrayList<BateauAmarre> list) {
        for (BateauAmarre bat : list) {
            Object[] data = {bat.getBateau().getNom(), bat.getBateau().getPortAttache(), bat.getAmarrage()};
            modelTable.insertRow(BatEnregistre,data);
             jTableBateaux.setModel(modelTable);
            BatEnregistre++;    
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBateaux = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableBateaux.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTableBateaux.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom", "port d'attache", "amarrage"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableBateaux.setToolTipText("");
        jScrollPane1.setViewportView(jTableBateaux);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1)
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(168, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListesBateaux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListesBateaux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListesBateaux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListesBateaux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ListesBateaux dialog = new ListesBateaux(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableBateaux;
    // End of variables declaration//GEN-END:variables
}