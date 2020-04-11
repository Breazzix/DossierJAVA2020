/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fenetres;

import java.awt.Component;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 *
 * @author ASUS7
 */
public class WinHarbour extends javax.swing.JFrame {

    private static boolean loggedIn = false;
    private static String formDate = "dd/MM/yyyy";
    private static String formTime = "HH mm";
    private static String formPays = "France";

    /**
     * @return the loggedIn
     */
   

    /**
     * Creates new form WinHarbour
     */
    public WinHarbour() {
        initComponents();
        setTitle("Capitainerie d'Inpres-Harbour");
        atStartUp();
    }
    
    public static boolean isLoggedIn() {
        return loggedIn;
    }

    /**
     * @param aLoggedIn the loggedIn to set
     */
    public static void setLoggedIn(boolean aLoggedIn) {
        loggedIn = aLoggedIn;
    }

    private void atStartUp() {
        mainPanelSetEnabled(false);
    }
    
    public static void setPays(String pays) {
        formPays = pays;
    }
    
    public static void setDate(String date) {
        formDate = date;
    }
    
    public static void setTime(String time) {
        formTime = time;
    }

    private void mainPanelSetEnabled(boolean val) {
        Component[] com = mainPanel.getComponents();

        for (Component c : com) {
            c.setEnabled(val);
        }

        if (val) {
            mItmLogin.getComponent().setEnabled(false);
            mItmLogout.getComponent().setEnabled(true);
            AffichageDate();
        }
        else {
            mItmLogin.getComponent().setEnabled(true);
            mItmLogout.getComponent().setEnabled(false);
        }
        
    }
    
   
    public static void AffichageDate()
    {
        Thread t_date = new Thread()
        {
            @Override
            public void run()
            {
                while(true)
                {
                    String datecur = getCurrentDate();
                    jLabel_DATE.setText(datecur);
                    try
                    {
                        sleep(1000);
                    }
                    catch(InterruptedException ex)
                    {
                        ex.getMessage();
                    }
                }
            }
        };
        t_date.start();
    }

    public static String getCurrentDate()
    {
        Date cur_date = new Date();
        String madate = new String();
        
        String form = formDate + " " + formTime;
        
        
        if(form.equals("dd/MM/yyyy HH mm"))
        {
            if(formPays.equals("France"))      
                madate = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.FRANCE).format(cur_date);
            if(formPays.equals("Royaume Uni"))
                madate = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.UK).format(cur_date);
            if(formPays.equals("Allemagne"))
                madate = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.GERMANY).format(cur_date);  
            if(formPays.equals("Italie"))
                madate = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.ITALY).format(cur_date);
            if(formPays.equals("USA"))
                madate = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.US).format(cur_date);
        }
        if(form.equals("dd/MM/yyyy HH mm ss"))
        {
            if(formPays.equals("France"))
                madate = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM, Locale.FRANCE).format(cur_date);
            if(formPays.equals("Royaume Uni"))
                madate = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM, Locale.UK).format(cur_date); 
            if(formPays.equals("Allemagne"))
                madate = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM, Locale.GERMANY).format(cur_date);
            if(formPays.equals("Italie"))
                madate = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM, Locale.ITALY).format(cur_date);
            if(formPays.equals("USA"))
                madate = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM, Locale.US).format(cur_date);
        }
        if(form.equals("dd/MM/yyyy HH mm TimeZone"))
        {
            if(formPays.equals("France"))
                madate = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.FULL, Locale.FRANCE).format(cur_date);
            if(formPays.equals("Royaume Uni"))
                madate = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.FULL, Locale.UK).format(cur_date);
            if(formPays.equals("Allemagne"))
                madate = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.FULL, Locale.GERMANY).format(cur_date);
            if(formPays.equals("Italie"))
                madate = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.FULL, Locale.ITALY).format(cur_date);
            if(formPays.equals("USA"))
                madate = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.FULL, Locale.US).format(cur_date);
        }
        if(form.equals("dd month year HH mm"))
        {
            if(formPays.equals("France"))
                madate = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT, Locale.FRANCE).format(cur_date);
            if(formPays.equals("Royaume Uni"))
                madate = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT, Locale.UK).format(cur_date); 
            if(formPays.equals("Allemagne"))
                madate = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT, Locale.GERMANY).format(cur_date);
            if(formPays.equals("Italie"))
                madate = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT, Locale.ITALY).format(cur_date);
            if(formPays.equals("USA"))
                madate = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT, Locale.US).format(cur_date);
        }
        if(form.equals("dd month year HH mm ss"))
        {
            if(formPays.equals("France"))
                madate = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.MEDIUM, Locale.FRANCE).format(cur_date);
            if(formPays.equals("Royaume Uni"))
                madate = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.MEDIUM, Locale.UK).format(cur_date);
            if(formPays.equals("Allemagne"))
                madate = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.MEDIUM, Locale.GERMANY).format(cur_date);
            if(formPays.equals("Italie"))
                madate = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.MEDIUM, Locale.ITALY).format(cur_date);
            if(formPays.equals("USA"))
                madate = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.MEDIUM, Locale.US).format(cur_date);
        }
        if(form.equals("dd month year HH mm TimeZone"))
        {
            if(formPays.equals("France"))
                madate = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.FULL, Locale.FRANCE).format(cur_date);
            if(formPays.equals("Royaume Uni"))
                madate = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.FULL, Locale.UK).format(cur_date);
            if(formPays.equals("Allemagne"))
                madate = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.FULL, Locale.GERMANY).format(cur_date);
            if(formPays.equals("Italie"))
                madate = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.FULL, Locale.ITALY).format(cur_date);
            if(formPays.equals("USA"))
                madate = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.FULL, Locale.US).format(cur_date);
        }
        if(form.equals("weekday dd month year HH mm"))
        {
            if(formPays.equals("France"))
                madate = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.SHORT, Locale.FRANCE).format(cur_date);
            if(formPays.equals("Royaume Uni"))
                madate = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.SHORT, Locale.UK).format(cur_date); 
            if(formPays.equals("Allemagne"))
                madate = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.SHORT, Locale.GERMANY).format(cur_date);
            if(formPays.equals("Italie"))
                madate = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.SHORT, Locale.ITALY).format(cur_date);
            if(formPays.equals("USA"))
                madate = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.SHORT, Locale.US).format(cur_date);
        }
        if(form.equals("weekday dd month year HH mm ss"))
        {
            if(formPays.equals("France"))
                madate = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.MEDIUM, Locale.FRANCE).format(cur_date);
            if(formPays.equals("Royaume Uni"))
                madate = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.MEDIUM, Locale.UK).format(cur_date); 
            if(formPays.equals("Allemagne"))
                madate = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.MEDIUM, Locale.GERMANY).format(cur_date);
            if(formPays.equals("Italie"))
                madate = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.MEDIUM, Locale.ITALY).format(cur_date);
            if(formPays.equals("USA"))
                madate = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.MEDIUM, Locale.US).format(cur_date);
        }
        if(form.equals("weekday dd month year HH mm TimeZone"))
        {
            if(formPays.equals("France"))
                madate = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.FRANCE).format(cur_date);
            if(formPays.equals("Royaume Uni"))
                madate = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.UK).format(cur_date); 
            if(formPays.equals("Allemagne"))
                madate = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.GERMANY).format(cur_date);
            if(formPays.equals("Italie"))
                madate = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.ITALY).format(cur_date);
            if(formPays.equals("USA"))
                madate = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.US).format(cur_date);
        }
        return madate;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        btnServeur = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        btnLire = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnChoisir = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        btnEnvoyerChoix = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        btnEnvoyerConfirm = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listBatEntree = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        btnBateauAmarre = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel_DATE = new javax.swing.JLabel();
        mainMenuBar = new javax.swing.JMenuBar();
        menuUtilisateur = new javax.swing.JMenu();
        mItmLogin = new javax.swing.JMenuItem();
        mItmLogout = new javax.swing.JMenuItem();
        mItmNouveau = new javax.swing.JMenuItem();
        menuAmarrages = new javax.swing.JMenu();
        menuBateaux = new javax.swing.JMenu();
        menuPersonnel = new javax.swing.JMenu();
        menuParametre = new javax.swing.JMenu();
        mItmDateFormat = new javax.swing.JMenuItem();
        mItmLogFile = new javax.swing.JMenuItem();
        mItmCbDate = new javax.swing.JCheckBoxMenuItem();
        menuApropos = new javax.swing.JMenu();
        mItmAuteur = new javax.swing.JMenuItem();
        mItmAide = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnServeur.setText("Démarrer le serveur");

        jCheckBox1.setText("Requête en attente");

        btnLire.setText("Lire");

        jTextField1.setText("jTextField1");

        jLabel1.setText("Amarrage possible : ");

        btnChoisir.setText("Choisir");

        jTextField2.setText("jTextField2");

        btnEnvoyerChoix.setText("Envoyer Choix");

        jTextField3.setText("jTextField3");

        btnEnvoyerConfirm.setText("Envoyer confirmation");

        jLabel2.setText("jLabel2");

        listBatEntree.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listBatEntree);

        jLabel3.setText("Bateaux en entrée");

        btnBateauAmarre.setText("Bateau amarré");

        jButton1.setText("Arrêter le serveur");

        jLabel4.setText("Nous sommes le :");

        jLabel_DATE.setText("date du jour");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addGap(18, 18, 18)
                                .addComponent(btnLire))
                            .addComponent(btnServeur)
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnChoisir))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEnvoyerChoix)
                                .addGap(26, 26, 26)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(btnEnvoyerConfirm)
                                        .addGap(0, 130, Short.MAX_VALUE))
                                    .addComponent(jScrollPane1)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel_DATE, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel3))
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnBateauAmarre, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1)))
                        .addGap(134, 134, 134))))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnServeur)
                    .addComponent(jLabel4)
                    .addComponent(jLabel_DATE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(btnLire)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnChoisir)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnvoyerChoix)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnvoyerConfirm))
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnBateauAmarre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        menuUtilisateur.setText("Utilisateur");

        mItmLogin.setText("Login");
        mItmLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItmLoginActionPerformed(evt);
            }
        });
        menuUtilisateur.add(mItmLogin);

        mItmLogout.setText("Logout");
        mItmLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItmLogoutActionPerformed(evt);
            }
        });
        menuUtilisateur.add(mItmLogout);

        mItmNouveau.setText("Nouveau");
        mItmNouveau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItmNouveauActionPerformed(evt);
            }
        });
        menuUtilisateur.add(mItmNouveau);

        mainMenuBar.add(menuUtilisateur);

        menuAmarrages.setText("Amarrages");
        mainMenuBar.add(menuAmarrages);

        menuBateaux.setText("Bateaux");
        mainMenuBar.add(menuBateaux);

        menuPersonnel.setText("Personnel");
        mainMenuBar.add(menuPersonnel);

        menuParametre.setText("Parametre");

        mItmDateFormat.setText("Format date");
        mItmDateFormat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItmDateFormatActionPerformed(evt);
            }
        });
        menuParametre.add(mItmDateFormat);

        mItmLogFile.setText("Fichier log");
        menuParametre.add(mItmLogFile);

        mItmCbDate.setSelected(true);
        mItmCbDate.setText("Affichage date-heure courante");
        menuParametre.add(mItmCbDate);

        mainMenuBar.add(menuParametre);

        menuApropos.setText("A propos");

        mItmAuteur.setText("Auteurs");
        mItmAuteur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItmAuteurActionPerformed(evt);
            }
        });
        menuApropos.add(mItmAuteur);

        mItmAide.setText("Aide");
        mItmAide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItmAideActionPerformed(evt);
            }
        });
        menuApropos.add(mItmAide);

        mainMenuBar.add(menuApropos);

        setJMenuBar(mainMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    private void mItmLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItmLoginActionPerformed
        Login login = new Login(this, true, false);
        login.setVisible(true);

        if (isLoggedIn()) {
            mainPanelSetEnabled(true);
        }
    }//GEN-LAST:event_mItmLoginActionPerformed

    private void mItmLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItmLogoutActionPerformed
        setLoggedIn(false);
        mainPanelSetEnabled(false);
    }//GEN-LAST:event_mItmLogoutActionPerformed

    private void mItmNouveauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItmNouveauActionPerformed
        Login login = new Login(this, true, true);
        login.setVisible(true);
        
        if (isLoggedIn()) {
            mainPanelSetEnabled(true);
        }
    }//GEN-LAST:event_mItmNouveauActionPerformed

    private void mItmAuteurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItmAuteurActionPerformed
       Auteurs auteurs = new Auteurs(this, rootPaneCheckingEnabled);
       auteurs.setVisible(true);
    }//GEN-LAST:event_mItmAuteurActionPerformed

    private void mItmAideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItmAideActionPerformed
         Help aide = new Help(this, rootPaneCheckingEnabled);
         aide.setVisible(true);
    }//GEN-LAST:event_mItmAideActionPerformed

    private void mItmDateFormatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItmDateFormatActionPerformed
        DateParam dateparam = new DateParam(this, rootPaneCheckingEnabled, formPays, formDate, formTime);
        dateparam.setVisible(true);
    }//GEN-LAST:event_mItmDateFormatActionPerformed



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
            java.util.logging.Logger.getLogger(WinHarbour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WinHarbour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WinHarbour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WinHarbour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WinHarbour().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBateauAmarre;
    private javax.swing.JButton btnChoisir;
    private javax.swing.JButton btnEnvoyerChoix;
    private javax.swing.JButton btnEnvoyerConfirm;
    private javax.swing.JButton btnLire;
    private javax.swing.JButton btnServeur;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private static javax.swing.JLabel jLabel_DATE;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JList listBatEntree;
    private javax.swing.JMenuItem mItmAide;
    private javax.swing.JMenuItem mItmAuteur;
    private javax.swing.JCheckBoxMenuItem mItmCbDate;
    private javax.swing.JMenuItem mItmDateFormat;
    private javax.swing.JMenuItem mItmLogFile;
    private javax.swing.JMenuItem mItmLogin;
    private javax.swing.JMenuItem mItmLogout;
    private javax.swing.JMenuItem mItmNouveau;
    private javax.swing.JMenuBar mainMenuBar;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenu menuAmarrages;
    private javax.swing.JMenu menuApropos;
    private javax.swing.JMenu menuBateaux;
    private javax.swing.JMenu menuParametre;
    private javax.swing.JMenu menuPersonnel;
    private javax.swing.JMenu menuUtilisateur;
    // End of variables declaration//GEN-END:variables

  
}
