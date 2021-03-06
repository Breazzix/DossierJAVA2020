/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fenetres;

import Classes.Bateau;
import Classes.BateauPeche;
import Classes.BateauPlaisance;
import Classes.FichierLog;
import Classes.Ponton;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vange
 */
public class ListeAmarrages extends javax.swing.JDialog {

    /**
     * Creates new form ListeAmarrages
     * @param parent
     * @param modal
     * @param bat
     */
    
    Vector<Ponton> vpt;
    private Object[] col = { "ponton", "emplacement", "bateau", "port d'attache" };
    private DefaultTableModel modelTable = new DefaultTableModel(col, 0);
    int BatEnregistre=0;
    String pontonLibre;
    boolean isChoix;
    String typeBat;
    
    public ListeAmarrages(java.awt.Frame parent, boolean modal, String titre, Vector<Ponton> listePontons, boolean isAffiche) {
        super(parent, modal);
        initComponents();
        vpt = listePontons;
        typeBat = titre;
        
        System.out.println("Liste 1 = " +  vpt.get(0).getListe(1)[0]);
        System.out.println("Liste 11 = " +  vpt.get(0).getListe(1)[1]);
        System.out.println("Liste 20 = " +  vpt.get(0).getListe(2)[0]);
        System.out.println("Liste 21= " +  vpt.get(0).getListe(2)[1]);
        
        
        setTitle("Capitainerie-" +  titre + ": Liste des amarrages");
        
        isChoix = isAffiche;
        if (isAffiche) {
            jButtonChoisir.setText("OK");
            creeTabAffiche(listePontons);
        }
        else {
            AtStartUp();
            jLabelEmplacement.setText("Ponton "+pontonLibre);
        }
            
        
    }
    
    
    
    private void AtStartUp(){
        Ponton addPonton;
        Bateau bat;
        int i=0,j,x;
        String ponton;
        
        Enumeration enm = vpt.elements();
 
        
        while(enm.hasMoreElements()){
            addPonton = vpt.get(i);
            x=1;
            while (x <= 2) {
                ponton = String.valueOf(addPonton.getNumero()) + x;
                j=0;
                
                bat = (Bateau) addPonton.getListe(x)[j];
                
                insertTab(bat,j+1,ponton);
                j++;
                
                while (j<addPonton.getNombreEmplacements())
                {
                    bat = (Bateau) addPonton.getListe(x)[j];
                    insertTab(bat,j+1,"");
                    j++;
                }
                x++;
            }
            i++;
            enm.nextElement();
        }
        
        FichierLog.Writer("ListeAmarrages", "Affiche tab liste pontons");
    }
    
    private void creeTabAffiche(Vector<Ponton> list) {
        Enumeration enm = list.elements();
        Bateau bat;
        
        for (int i = 0; enm.hasMoreElements(); i++) {
            Ponton unPonton = (Ponton) enm.nextElement();
            for (int j = 0; j < 2; j++) {
                String numPonton = String.valueOf(unPonton.getNumero()) + (j + 1);
                
                int k = 0;
                bat = (Bateau) unPonton.getListe(j + 1)[k];
                insertBatDansTab(bat, k + 1, numPonton);
                k++;
                
                for (; k < unPonton.getNombreEmplacements(); k++) {
                    bat = (Bateau) unPonton.getListe(j + 1)[k];
                    insertBatDansTab(bat, k + 1, "");
                }
            }
        }
        
        FichierLog.Writer("ListeAmarrage", "Affiche tab bateau amarre");
    }
    
    private void insertBatDansTab(Bateau bateau, int emplacement, String ponton) {
        //System.out.println("Bat = " + bateau + " --Empl = " + emplacement + "--Ponton = " + ponton);
        if (bateau != null) {
            if ( isBateauPlaisance(bateau)) {
                Object[] data = {ponton,emplacement,bateau.getNom(),bateau.getPortAttache()};
                modelTable.insertRow(BatEnregistre,data);
                 jTableAmarrages.setModel(modelTable);
                BatEnregistre++;        
            }
        }
        
    }
    
    private boolean isBateauPlaisance(Bateau bateau) {
        boolean type = false;
        if ("Plaisance".equals(typeBat) && bateau instanceof BateauPlaisance)
            type = true;
        else if ("Peche".equals(typeBat) && bateau instanceof BateauPeche)
            type = true;
        
        return type;
    }
    
    private void insertTab(Bateau bateau, int emplacement, String ponton)
    {
        if (bateau == null)
        {
            Object[] data = {ponton,emplacement,"",""};
            modelTable.insertRow(BatEnregistre,data);
            
            if (pontonLibre == null) {
                pontonLibre =  ponton + "*" + emplacement;
            }
        }
        else
        {
            Object[] data = {ponton,emplacement,bateau.getNom(),bateau.getPortAttache()};
            modelTable.insertRow(BatEnregistre,data);
        }
        
        jTableAmarrages.setModel(modelTable);
        BatEnregistre++;
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
        jTableAmarrages = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabelEmplacement = new javax.swing.JLabel();
        jButtonChoisir = new javax.swing.JButton();
        jButtonAnnuler = new javax.swing.JButton();
        jLabelImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableAmarrages.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTableAmarrages.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ponton", "emplacement", "bateau", "port d'attache"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableAmarrages.setToolTipText("");
        jTableAmarrages.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAmarragesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableAmarrages);

        jLabel1.setText("Emplacement:");

        jButtonChoisir.setText("Choisir");
        jButtonChoisir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChoisirActionPerformed(evt);
            }
        });

        jButtonAnnuler.setText("Annuler");
        jButtonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnulerActionPerformed(evt);
            }
        });

        jLabelImage.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jButtonChoisir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelEmplacement, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAnnuler))
                .addGap(44, 44, 44))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabelEmplacement, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAnnuler)
                            .addComponent(jButtonChoisir))
                        .addGap(53, 53, 53))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(21, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnulerActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonAnnulerActionPerformed

    private void jTableAmarragesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAmarragesMouseClicked
        int index = jTableAmarrages.getSelectedRow();
        
        if (jTableAmarrages.getValueAt(index,2).equals(""))
        {
            Object empl =  jTableAmarrages.getValueAt(index,1);
            String ponton = (String) jTableAmarrages.getValueAt((index+1)-(int)empl,0);
        
            jLabelEmplacement.setText("Ponton "+ ponton + "* "+ empl.toString());
            pontonLibre = ponton + "*"+ empl.toString();
             System.out.println("ok");
        }
       
       
    }//GEN-LAST:event_jTableAmarragesMouseClicked

    private void jButtonChoisirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChoisirActionPerformed
               
        if (!isChoix) {
             if (jLabelEmplacement!=null)
                WinHarbour.setTextFieldEmplacement("P"+ pontonLibre);
        }
         this.dispose();
       
    }//GEN-LAST:event_jButtonChoisirActionPerformed

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
            java.util.logging.Logger.getLogger(ListeAmarrages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListeAmarrages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListeAmarrages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListeAmarrages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ListeAmarrages dialog = new ListeAmarrages(new javax.swing.JFrame(), true, null, null, false);
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
    private javax.swing.JButton jButtonAnnuler;
    private javax.swing.JButton jButtonChoisir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelEmplacement;
    private javax.swing.JLabel jLabelImage;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAmarrages;
    // End of variables declaration//GEN-END:variables
}
