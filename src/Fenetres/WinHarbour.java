/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fenetres;

import Classes.Bateau;
import Classes.BateauPeche;
import Classes.BateauPlaisance;
import Classes.Equipage;
import Classes.FichierConfig;
import Classes.Ponton;
import Classes.ShipWithoutIdentificationException;
import java.awt.Component;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import network.*;

/**
 *
 * @author ASUS7
 */
public class WinHarbour extends javax.swing.JFrame {

    private static boolean loggedIn = false;
    private NetworkBasicServer serv;
    private String BateauRecu = new String();
    private static Bateau bat;
    private Ponton ponton1 = new Ponton(1, 4); 
    private Ponton ponton2 = new Ponton(2, 4);
    private Ponton ponton3 = new Ponton(3, 4);
    private Vector<Ponton> listePontons = new Vector();
   
    private final static Locale[] contries = {Locale.FRANCE, Locale.UK, Locale.GERMANY, Locale.ITALY, Locale.US};
    private final static int[] dateFormat = {DateFormat.SHORT, DateFormat.LONG, DateFormat.FULL};
    private final static int[] timeFormat = {DateFormat.SHORT, DateFormat.MEDIUM, DateFormat.FULL};

    Bateau bateau = new Bateau("Black Pearl", "Caraibes", 30, 50, "Tortuga", new Equipage());

    /**
     * @return the loggedIn
     */
   

    /**
     * Creates new form WinHarbour
     */
    public WinHarbour() {
        initComponents();
        
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
        setTitle("Capitainerie d'Inpres-Harbour");
        mainPanelSetEnabled(false);
        AffichageDate();
        
        this.setLocationRelativeTo(null);
        setIcon();
        
       
        
        System.out.println(ponton1);
        
        listePontons.add(ponton1);
        listePontons.add(ponton2);
        listePontons.add(ponton3);
        
        System.out.println(listePontons);
        
    }
    
    public final void setIcon()
    {
        String NomFich = FichierConfig.getNomsFichs("bateau");
        ImageIcon image = new ImageIcon(NomFich);
        jLabelImage1.setText(null);
        jLabelImage1.setIcon(image);
    }
    

    private void mainPanelSetEnabled(boolean val) {
        Component[] com = mainPanel.getComponents();
        Component[] menBarCom = mainMenuBar.getComponents();

        for (Component c : com) {
            c.setEnabled(val);
        }

        for (int i = 0; i < menBarCom.length; i++) {
            if (i != 0 && i != menBarCom.length -1)
                menBarCom[i].setEnabled(val);
        }
        jCheckReqAtt.setEnabled(false);

        if (val) {
            mItmLogin.getComponent().setEnabled(false);
            mItmLogout.getComponent().setEnabled(true);
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
        

        madate = DateFormat.getDateTimeInstance(
            dateFormat[DateParam.selectedDateFormat],
            timeFormat[DateParam.selectedTimeFormat],
            contries[DateParam.selectedCountry]).format(cur_date);
        
        
        return madate;
    }
    
    public static void setmItmCbDate(boolean val)
    {
        mItmCbDate.setSelected(val);
    }
    public static void setBatLu(String n) throws ShipWithoutIdentificationException
    {
        StringTokenizer st = new StringTokenizer(n, "/");
        
        String nom = st.nextToken();
        String Port = st.nextToken();
        int tonnage = Integer.parseInt(st.nextToken());
        int longueur = Integer.parseInt(st.nextToken());
        String pav = st.nextToken();
       
        if ("Plaisance".equals(st.nextToken()))
            bat = new BateauPlaisance(nom,Port,tonnage,longueur,pav,null);
        else
        {
            String type = st.nextToken();
            bat = new BateauPeche(nom,Port,type,tonnage,longueur,pav,null);
        }
            

        jTextFieldBateauRecu.setText(bat.toString2());
        
       
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
        btnLire = new javax.swing.JButton();
        jTextFieldBateauRecu = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnChoisir = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        btnEnvoyerChoix = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        btnEnvoyerConfirm = new javax.swing.JButton();
        jLabelImage1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listBatEntree = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        btnBateauAmarre = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        datePanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel_DATE = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jCheckReqAtt = new javax.swing.JCheckBox();
        mainMenuBar = new javax.swing.JMenuBar();
        menuUtilisateur = new javax.swing.JMenu();
        mItmLogin = new javax.swing.JMenuItem();
        mItmLogout = new javax.swing.JMenuItem();
        mItmNouveau = new javax.swing.JMenuItem();
        menuAmarrages = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuBateaux = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        menuPersonnel = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        menuParametre = new javax.swing.JMenu();
        mItmDateFormat = new javax.swing.JMenuItem();
        mItmLogFile = new javax.swing.JMenuItem();
        mItmCbDate = new javax.swing.JCheckBoxMenuItem();
        menuApropos = new javax.swing.JMenu();
        mItmAuteur = new javax.swing.JMenuItem();
        mItmAide = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnServeur.setText("Démarrer le serveur");
        btnServeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServeurActionPerformed(evt);
            }
        });

        btnLire.setText("Lire");
        btnLire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLireActionPerformed(evt);
            }
        });

        jLabel1.setText("Amarrage possible : ");

        btnChoisir.setText("Choisir");
        btnChoisir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChoisirActionPerformed(evt);
            }
        });

        btnEnvoyerChoix.setText("Envoyer Choix");

        btnEnvoyerConfirm.setText("Envoyer confirmation");

        jLabelImage1.setText("jLabel2");

        jScrollPane1.setViewportView(listBatEntree);

        jLabel3.setText("Bateaux en entrée");

        btnBateauAmarre.setText("Bateau amarré");
        btnBateauAmarre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBateauAmarreActionPerformed(evt);
            }
        });

        jButton1.setText("Arrêter le serveur");

        jLabel4.setText("Nous sommes le :");

        jLabel_DATE.setText("date du jour");

        javax.swing.GroupLayout datePanelLayout = new javax.swing.GroupLayout(datePanel);
        datePanel.setLayout(datePanelLayout);
        datePanelLayout.setHorizontalGroup(
            datePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datePanelLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_DATE, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        datePanelLayout.setVerticalGroup(
            datePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datePanelLayout.createSequentialGroup()
                .addGroup(datePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_DATE)
                    .addComponent(jLabel4))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 133, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jCheckReqAtt.setText("Requête en attente");
        jCheckReqAtt.setEnabled(false);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jCheckReqAtt, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLire))
                    .addComponent(btnServeur)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(btnChoisir)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(datePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel3))
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnBateauAmarre, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1)))
                        .addGap(134, 134, 134))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldBateauRecu)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEnvoyerChoix)
                                .addGap(26, 26, 26)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnEnvoyerConfirm)
                                        .addGap(0, 106, Short.MAX_VALUE))
                                    .addComponent(jScrollPane1))))
                        .addContainerGap())))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnServeur)
                    .addComponent(datePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLire)
                    .addComponent(jTextFieldBateauRecu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckReqAtt))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBateauAmarre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addComponent(jLabelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
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

        jMenuItem1.setText("Plaisance");
        menuAmarrages.add(jMenuItem1);

        jMenuItem2.setText("Peche");
        menuAmarrages.add(jMenuItem2);

        mainMenuBar.add(menuAmarrages);

        menuBateaux.setText("Bateaux");

        jMenuItem3.setText("Liste complete");
        menuBateaux.add(jMenuItem3);

        jMenuItem4.setText("Rechercher un bateau");
        menuBateaux.add(jMenuItem4);

        mainMenuBar.add(menuBateaux);

        menuPersonnel.setText("Personnel");

        jMenuItem5.setText("Equipage d'un bateau");
        menuPersonnel.add(jMenuItem5);

        jMenuItem6.setText("Rechercher un marin");
        menuPersonnel.add(jMenuItem6);

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
        mItmCbDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItmCbDateActionPerformed(evt);
            }
        });
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
        DateParam dateparam = new DateParam(this, rootPaneCheckingEnabled);
        dateparam.setVisible(true);
    }//GEN-LAST:event_mItmDateFormatActionPerformed

    private void mItmCbDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItmCbDateActionPerformed
        if (mItmCbDate.isSelected() == true)
        {
            datePanel.setVisible(true);
            AffichageDate();
        }
        else
        {
            datePanel.setVisible(false);
        }
    }//GEN-LAST:event_mItmCbDateActionPerformed

    DefaultListModel listModel = new DefaultListModel<>();
    private void btnBateauAmarreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBateauAmarreActionPerformed
        WinBateauAmarre win = new WinBateauAmarre(this, true, bateau);
        win.setVisible(true);

        listModel.addElement(bateau);
        this.listBatEntree.setModel(listModel);

        

    }//GEN-LAST:event_btnBateauAmarreActionPerformed

    private void btnServeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServeurActionPerformed
        if(isLoggedIn() == true)
        {
            int port = 60001;
            serv = new NetworkBasicServer(port, jCheckReqAtt);
        }
    }//GEN-LAST:event_btnServeurActionPerformed

    private void btnLireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLireActionPerformed
        BateauRecu = serv.getMessage();
        try {
          setBatLu(BateauRecu);  
        } catch (ShipWithoutIdentificationException e) {
            System.out.println("Nom bateau inconnu");
        }
        
           /* if(!NewsRecue.equals("RIEN"))
            {
                newsevent.setNews(NewsRecue);
                newsevent.setLocalite("Charleroi");
                listenewsbean.newsDetected(newsevent);
                notificationNewsDetected(listenewsbean.getNotifyNewsEvent());
            }
            else
            {
                setNewsLue(NewsRecue);
            }*/
    }//GEN-LAST:event_btnLireActionPerformed

    private void btnChoisirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChoisirActionPerformed
        //if (!"".equals(jTextFieldBateauRecu.getText()))
        //{
             ListeAmarrages win = new ListeAmarrages(this, true, bat, listePontons);
             win.setVisible(true);
        //} 
    }//GEN-LAST:event_btnChoisirActionPerformed



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
    private javax.swing.JPanel datePanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckReqAtt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelImage1;
    private static javax.swing.JLabel jLabel_DATE;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private static javax.swing.JTextField jTextFieldBateauRecu;
    private javax.swing.JList listBatEntree;
    private javax.swing.JMenuItem mItmAide;
    private javax.swing.JMenuItem mItmAuteur;
    private static javax.swing.JCheckBoxMenuItem mItmCbDate;
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
