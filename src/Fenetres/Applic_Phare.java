/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fenetres;

import Classes.BaseException;
import Classes.Bateau;
import Classes.BateauPeche;
import Classes.BateauPlaisance;;
import Classes.FichierConfig;
import JavaBeans.BoatBean;
import JavaBeans.BoatEvent;
import JavaBeans.BoatListener;
import JavaBeans.KindOfBoatBean;
import JavaBeans.ThreadRandomGenerator;
import JavaBeans.UtilisateurNombre;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import network.*;import Classes.FichierConfig;
import JavaBeans.BoatBean;
import JavaBeans.BoatListener;
import JavaBeans.KindOfBoatBean;
import JavaBeans.ThreadRandomGenerator;
import JavaBeans.UtilisateurNombre;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import network.*;

/**
 *
 * @author vange
 */
public class Applic_Phare extends javax.swing.JFrame implements UtilisateurNombre, BoatListener{

    /**
     * Creates new form Applic_Phare
     */
    
    private static DefaultListModel modelBat = new DefaultListModel();
    private NetworkBasicClient client;
    
    public Applic_Phare() {
        initComponents();
        setIcon();
        start();
        
        ThreadRandomGenerator tdrdg = new ThreadRandomGenerator(this, 1, 500, 5, 2);
        tdrdg.start();
    }
    
    public final void setIcon()
    {
        String NomFich = FichierConfig.getNomsFichs("phare");
        ImageIcon image = new ImageIcon(NomFich);
        jLabeImage.setText(null);
        jLabeImage.setIcon(image);
    }
    
    public void start()
    {
        BateauPeche bateauP1 = new BateauPeche("Black Pearl", "Caraibes","thonier", 30, 50, "Tortuga", null);
        BateauPlaisance bateauPl1 = new BateauPlaisance("Warren", "Monaco", 50, 70, "UK", null);
        BateauPeche bateauP2 = new BateauPeche("RoYog", "Anvers","thonier",120, 80, "Anvers", null);
        
        jListBateau.setModel(modelBat);
        modelBat.addElement(bateauP1.getNom() + "/" + bateauP1.getPavillon());
        modelBat.addElement(bateauPl1.getNom() + "/" + bateauPl1.getPavillon());
        modelBat.addElement(bateauP2.getNom() + "/" + bateauP2.getPavillon());
    }
    
    public static void setjTextFieldBateauId(Bateau bat)
    {
        jTextFieldBateauid.setText(bat.toString2());
        modelBat.elementAt(0).equals(bat);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelEntre = new javax.swing.JLabel();
        jButtonBatEntre = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabelRep = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextFieldBateauid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListBateau = new javax.swing.JList();
        jButtonSuivant = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonConnect = new javax.swing.JButton();
        jLabeImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelEntre.setText("??");

        jButtonBatEntre.setText("Bateau entré dans la rade");
        jButtonBatEntre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBatEntreActionPerformed(evt);
            }
        });

        jButton3.setText("Se déconnecter du serveur");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("RAZ");

        jLabelRep.setText("nom bateau");

        jLabel3.setText("Réponse de la capitainerie:");

        jButton1.setText("Demander autorisation entrée");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextFieldBateauid.setBackground(new java.awt.Color(51, 255, 0));
        jTextFieldBateauid.setText("??");
        jTextFieldBateauid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBateauidActionPerformed(evt);
            }
        });

        jLabel2.setText("Bateau identifié:");

        jListBateau.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListBateau);

        jButtonSuivant.setText("Suivant");
        jButtonSuivant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuivantActionPerformed(evt);
            }
        });

        jLabel1.setText("Bateau en attente");

        jButtonConnect.setText("Se connecter au serveur");
        jButtonConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConnectActionPerformed(evt);
            }
        });

        jLabeImage.setText("image");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(49, 49, 49)
                        .addComponent(jTextFieldBateauid, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(33, 33, 33)
                        .addComponent(jLabelRep, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonBatEntre)
                        .addGap(55, 55, 55)
                        .addComponent(jLabelEntre, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(57, 57, 57))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabeImage, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonSuivant)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabeImage, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonConnect)
                            .addComponent(jLabel1))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSuivant))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldBateauid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addComponent(jButton1)
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabelRep)
                    .addComponent(jButton2))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBatEntre)
                    .addComponent(jLabelEntre))
                .addGap(12, 12, 12)
                .addComponent(jButton3)
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConnectActionPerformed
        int port = 60001;
        client = new NetworkBasicClient("localhost", port);
        
    }//GEN-LAST:event_jButtonConnectActionPerformed

    private void jTextFieldBateauidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBateauidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBateauidActionPerformed

    private void jButtonSuivantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuivantActionPerformed
        Bateau bateau = (Bateau) modelBat.elementAt(0);
        IdentificationBateau win = new IdentificationBateau(this, true, bateau);
        win.setVisible(true);
    }//GEN-LAST:event_jButtonSuivantActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
          Envoyer("demander");  
        } catch (BaseException e) {
            Logger.getLogger(Applic_Phare.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonBatEntreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBatEntreActionPerformed
        try {
          Envoyer("entre");  
        } catch (BaseException e) {
            Logger.getLogger(Applic_Phare.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_jButtonBatEntreActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        client.setEndSending();
        
    }//GEN-LAST:event_jButton3ActionPerformed
    
    public void Envoyer(String type) throws BaseException
    {
        
        if(client != null)
        {
            if ("??".equals(jTextFieldBateauid.getText()))
                throw new BaseException(this, "aucun bateau n'a été identifié");
            else
            {
                String tmp = null;
                if ("demander".equals(type))
                    demander();
                else
                    entrer();
            }
           
        }
        else
        {
           throw new BaseException(this, "Le client n'est pas connecté au serveur !");
        }
         
    }
    
    public void demander() {
        Bateau BatTmp = (Bateau) modelBat.elementAt(0);
        String tmp = null;
        tmp = BatTmp.getNom() + "/" + BatTmp.getPortAttache()+ "/" + BatTmp.getTonnage() + "/" + BatTmp.getLongueur() + "/" + BatTmp.getPavillon() + "/" + BatTmp.getEquipage() + "/";
        if (BatTmp instanceof BateauPlaisance)
            tmp = tmp + "Plaisance" ;
        else
        {
            BateauPeche BatPeche = (BateauPeche) BatTmp;
            tmp =  tmp + BatPeche.getType() + "Peche";
            
        }
        
        tmp = "demander/" + tmp;
        
        String reponse = client.sendString(tmp);
        jLabelRep.setText(reponse);
    }
    
    public void entrer() {
        
        String tmp=null;
        
        Bateau BatTmp = (Bateau) modelBat.elementAt(0);
        
        
        tmp = "entre/" + BatTmp.getNom();
       
        String reponse = client.sendString(tmp);
        jLabelEntre.setText(reponse);
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
            java.util.logging.Logger.getLogger(Applic_Phare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Applic_Phare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Applic_Phare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Applic_Phare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Applic_Phare().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonBatEntre;
    private javax.swing.JButton jButtonConnect;
    private javax.swing.JButton jButtonSuivant;
    private javax.swing.JLabel jLabeImage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelEntre;
    private javax.swing.JLabel jLabelRep;
    private javax.swing.JList jListBateau;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextField jTextFieldBateauid;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getIdentifiant() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void traiteNombre(int n) {
        BoatBean bb = new BoatBean();
        bb.addBoatListener(this);
    }

    @Override
    public void BoatDetected(BoatEvent e) {
        System.out.println("CA MARCHE!");
    }
}
