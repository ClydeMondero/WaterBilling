
import javax.swing.JPanel;

public class Main extends javax.swing.JFrame {

    String accountUsername, accountPassword;

    public Main(String username, String password) {
        initComponents();

        this.accountUsername = username;
        this.accountPassword = password;

        usernameLabel.setText(accountUsername);

        int index = accountUsername.indexOf("_");
        if (!accountUsername.substring(index + 1).equals("staff")) {
            mainTabbedPane.add("Staff", new StaffPanel(accountUsername, accountPassword));
        }       

        if (accountUsername.equals("main_admin")) {
            mainTabbedPane.add("Admin", new AdminPanel(accountUsername, accountPassword));
        }

        if (!accountUsername.equals("main_admin")) {
            mainTabbedPane.add("My Account", new MyAccount(accountUsername, accountPassword));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usernameLabel = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        mainTabbedPane = new javax.swing.JTabbedPane();
        homePanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(820, 660));
        setResizable(false);

        usernameLabel.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        usernameLabel.setText("Username");

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        mainTabbedPane.setPreferredSize(new java.awt.Dimension(820, 560));

        homePanel.setPreferredSize(new java.awt.Dimension(820, 540));

        javax.swing.GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
        homePanel.setLayout(homePanelLayout);
        homePanelLayout.setHorizontalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
        );
        homePanelLayout.setVerticalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
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
    private javax.swing.JButton logoutButton;
    private javax.swing.JTabbedPane mainTabbedPane;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
