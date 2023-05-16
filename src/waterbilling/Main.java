package waterbilling;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class Main extends javax.swing.JFrame {

    Image icon = Toolkit.getDefaultToolkit().getImage("images\\icon.png");
    String accountUsername, accountPassword;

    public Main(String username, String password) {
        this.setIconImage(icon);

        initComponents();

        this.getContentPane().setBackground(Color.decode("#2EC4B6"));

        this.accountUsername = username;
        this.accountPassword = password;

        usernameLabel.setText(accountUsername);

        String suffix = accountUsername.substring(accountUsername.indexOf("_") + 1);

        if (!suffix.equals("cashier")) {
            mainTabbedPane.add("Clients", new ClientPanel(accountUsername, accountPassword));
        }

        mainTabbedPane.add("Invoices", new InvoicePanel(accountUsername, accountPassword));

        if (suffix.equals("admin")) {
            mainTabbedPane.add("Cashier", new CashierPanel(accountUsername, accountPassword));
            mainTabbedPane.add("Staffs", new StaffPanel(accountUsername, accountPassword));
        }

        if (accountUsername.equals("main_admin")) {
            mainTabbedPane.add("Admins", new AdminPanel(accountUsername, accountPassword));
        }

        if (!accountUsername.equals("main_admin")) {
            mainTabbedPane.add("My Account", new MyAccount(accountUsername, accountPassword));
        }
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        mainTabbedPane = new javax.swing.JTabbedPane();
        homePanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        usernameLabel.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        usernameLabel.setText("Username");

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        mainTabbedPane.setBackground(new java.awt.Color(255, 255, 255));
        mainTabbedPane.setPreferredSize(new java.awt.Dimension(820, 560));

        homePanel.setBackground(new java.awt.Color(255, 191, 105));
        homePanel.setPreferredSize(new java.awt.Dimension(820, 540));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\PCB\\Documents\\Bachelor of Science in Information Technology\\2nd Year\\Object Oriented Programming\\WaterBilling\\images\\logo.png")); // NOI18N

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("JAC");

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Waterbilling System");

        javax.swing.GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
        homePanel.setLayout(homePanelLayout);
        homePanelLayout.setHorizontalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(homePanelLayout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(jLabel2))
                    .addGroup(homePanelLayout.createSequentialGroup()
                        .addGap(326, 326, 326)
                        .addComponent(jLabel1))
                    .addGroup(homePanelLayout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jLabel4)))
                .addContainerGap(192, Short.MAX_VALUE))
        );
        homePanelLayout.setVerticalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(35, 35, 35))
        );

        mainTabbedPane.addTab("Home", homePanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(usernameLabel)
                .addGap(18, 18, 18)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addComponent(mainTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel homePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton logoutButton;
    private javax.swing.JTabbedPane mainTabbedPane;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
