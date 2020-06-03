/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fenetres;

import Classes.Bateau;
import Classes.BateauAmarre;
import Classes.Equipage;
import Classes.Marin;
import Classes.Ponton;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.DefaultListModel;

/**
 *
 * @author ASUS7
 */
public class RecherchePersonnel extends javax.swing.JDialog {
    Vector<Ponton> listesP;
    /**
     * Creates new form RecherchePersonnel
     */
    public RecherchePersonnel(java.awt.Frame parent, boolean modal, Vector<Ponton> listePontons) {
        super(parent, modal);
        initComponents();
        
        if (listePontons != null)
            listesP = listePontons;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTfNomBat = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTfPort = new javax.swing.JTextField();
        jBtnChercher = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListEquipage = new javax.swing.JList();
        jBtnOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Ecodez le nom du bateau");

        jLabel2.setText("Encodez le port d'attache");

        jBtnChercher.setText("Chercher");
        jBtnChercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnChercherActionPerformed(evt);
            }
        });

        jLabel3.setText("Listes des equipages");

        jListEquipage.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListEquipage);

        jBtnOk.setText("Ok");
        jBtnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jTfNomBat)
                    .addComponent(jTfPort)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBtnChercher))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(jBtnOk)
                .addContainerGap(234, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTfNomBat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTfPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnChercher)
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jBtnOk)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnChercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnChercherActionPerformed
        String nom = jTfNomBat.getText();
        String port = jTfPort.getText();
        if (!"".equals(nom) && !"".equals(port)) {
            Equipage equip = searchEquipBat(listesP, nom, port);
            if (equip != null)
                AfficheEquip(equip);
        }
    }//GEN-LAST:event_jBtnChercherActionPerformed

    private void jBtnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnOkActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBtnOkActionPerformed

    
    private Equipage searchEquipBat(Vector<Ponton> list, String nomBat, String port) {
        Enumeration enm = list.elements();
        Bateau bat;
        ArrayList<BateauAmarre> listBateaux = new ArrayList<BateauAmarre>();
        
        int a = 0;
        for (int i = 0; enm.hasMoreElements(); i++) {
            Ponton unPonton = (Ponton) enm.nextElement();
            for (int j = 0; i < 2; j++) {
                for (int k = 0; k < unPonton.getNombreEmplacements(); k++) {
                    bat = (Bateau) unPonton.getListe(i + 1)[k];
                    
                    if (bat.getNom().equals(nomBat) && bat.getPortAttache().equals(port))
                        return bat.getEquipage();
                }
            }
        }
        return null;
    }
    
    private void AfficheEquip (Equipage equip) {
        DefaultListModel dlm = new DefaultListModel<>();
        
        if (!"inconnu".equals(equip.getCapitaine().getNom())) 
            dlm.addElement(equip.getCapitaine());
        
        if (!"inconnu".equals(equip.getSecond().getNom())) 
            dlm.addElement(equip.getSecond());
        
        for (Marin m : equip.getLiMarins()) {
            dlm.addElement(m);
        }
        
        jListEquipage.setModel(dlm);
        
    }
    
    
    
    
    
    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(RecherchePersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecherchePersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecherchePersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecherchePersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RecherchePersonnel dialog = new RecherchePersonnel(new javax.swing.JFrame(), true, null);
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
    private javax.swing.JButton jBtnChercher;
    private javax.swing.JButton jBtnOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jListEquipage;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTfNomBat;
    private javax.swing.JTextField jTfPort;
    // End of variables declaration//GEN-END:variables
}
