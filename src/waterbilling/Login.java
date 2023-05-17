package waterbilling;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import static waterbilling.AdminPanel.admins;
import static waterbilling.StaffPanel.staffs;
import static waterbilling.CashierPanel.cashiers;

public class Login extends javax.swing.JFrame {

    Connection connect = null;

    Image icon = Toolkit.getDefaultToolkit().getImage("src/waterbilling/images/icon.png");

    public Login() {       
        setIconImage(icon);
        
        initComponents();
        
        this.getContentPane().setBackground(Color.decode("#CBF3F0"));
        
        connect = DatabaseConnection.connectDatabase();

        try {
            Statement statement = connect.createStatement();
            ResultSet selectAdmin = statement.executeQuery("SELECT admin_id, admin_username, admin_password, admin_status FROM Admin WHERE admin_status != 'Deleted'");

            admins.clear();
            while (selectAdmin.next()) {
                admins.add(new Admin(selectAdmin.getInt("admin_id"), selectAdmin.getString("admin_username"), selectAdmin.getString("admin_password"),
                        selectAdmin.getString("admin_status")));
            }

            ResultSet selectStaff = statement.executeQuery("SELECT staff_id, staff_username, staff_password, staff_status FROM Staff WHERE staff_status != 'Deleted'");

            staffs.clear();
            while (selectStaff.next()) {
                staffs.add(new Staff(selectStaff.getInt("staff_id"), selectStaff.getString("staff_username"), selectStaff.getString("staff_password"),
                        selectStaff.getString("staff_status")));
            }

            ResultSet selectCashier = statement.executeQuery("SELECT cashier_id, cashier_username, cashier_password, cashier_status FROM Cashier WHERE cashier_status != 'Deleted'");

            cashiers.clear();
            while (selectCashier.next()) {
                cashiers.add(new Cashier(selectCashier.getInt("cashier_id"), selectCashier.getString("cashier_username"), selectCashier.getString("cashier_password"),
                        selectCashier.getString("cashier_status")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        username = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        loginLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        loginButton.setBackground(new java.awt.Color(255, 159, 28));
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/waterbilling/images/login.png"))); // NOI18N
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        loginLabel.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        loginLabel.setForeground(new java.awt.Color(46, 196, 182));
        loginLabel.setText("Log In");

        titleLabel.setFont(new java.awt.Font("sansserif", 1, 30)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(46, 196, 182));
        titleLabel.setText("JAC Water Billing System");

        password.setForeground(new java.awt.Color(102, 102, 102));

        usernameLabel.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(255, 159, 28));
        usernameLabel.setText("Username: ");

        passwordLabel.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(255, 159, 28));
        passwordLabel.setText("Password:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loginLabel)
                            .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(passwordLabel))
                                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(usernameLabel)))
                .addContainerGap(100, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(titleLabel)
                .addGap(26, 26, 26))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {password, username});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(titleLabel)
                .addGap(18, 18, 18)
                .addComponent(loginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(usernameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(passwordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {password, username});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    int loginCounter = 0;
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        if (checkUsernamePassword() == false) {
            return;
        }
        for (int i = 0; i < admins.size(); i++) {
            if (username.getText().equals(admins.get(i).getUsername())) {
                if (admins.get(i).getStatus().equals("Active")) {
                    if (password.getText().equals(admins.get(i).getPassword())) {
                        this.dispose();
                        JOptionPane.showMessageDialog(null, "Login Success!", "Login", JOptionPane.INFORMATION_MESSAGE);
                        new Main(username.getText(), password.getText()).setVisible(true);
                        return;
                    } else {
                        if (!admins.get(i).getUsername().equals("main_admin")) {
                            ++loginCounter;
                        }
                        JOptionPane.showMessageDialog(null, "Login Failed! \nAttempt  " + loginCounter + " out of 3", "Login", JOptionPane.WARNING_MESSAGE);
                        username.setText("");
                        password.setText("");
                        if (loginCounter == 3) {
                            JOptionPane.showMessageDialog(null, "Account deactivated!", "Login", JOptionPane.ERROR_MESSAGE);
                            username.setText("");
                            password.setText("");
                            try {
                                PreparedStatement statement = connect.prepareStatement("UPDATE Admin SET admin_status = ? WHERE admin_username = ?");
                                statement.setString(1, "Deactivated");
                                statement.setString(2, admins.get(i).getUsername());

                                statement.executeUpdate();
                                admins.get(i).setStatus("Deactivated");
                            } catch (SQLException ex) {
                                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Account deactivated!", "Login", JOptionPane.ERROR_MESSAGE);
                    username.setText("");
                    password.setText("");
                    return;
                }
            }
        }

        for (int i = 0; i < staffs.size(); i++) {
            if (username.getText().equals(staffs.get(i).getUsername())) {
                if (staffs.get(i).getStatus().equals("Active")) {
                    if (password.getText().equals(staffs.get(i).getPassword())) {
                        this.dispose();
                        JOptionPane.showMessageDialog(null, "Login Success!", "Login", JOptionPane.INFORMATION_MESSAGE);
                        new Main(username.getText(), password.getText()).setVisible(true);
                        return;
                    } else {
                        ++loginCounter;
                        JOptionPane.showMessageDialog(null, "Login Failed! \nAttempt  " + loginCounter + " out of 3", "Login", JOptionPane.WARNING_MESSAGE);
                        username.setText("");
                        password.setText("");
                        if (loginCounter == 3) {
                            JOptionPane.showMessageDialog(null, "Account deactivated!", "Login", JOptionPane.ERROR_MESSAGE);
                            username.setText("");
                            password.setText("");
                            try {
                                PreparedStatement statement = connect.prepareStatement("UPDATE Staff SET staff_status = ? WHERE staff_username = ?");
                                statement.setString(1, "Deactivated");
                                statement.setString(2, staffs.get(i).getUsername());

                                statement.executeUpdate();
                                staffs.get(i).setStatus("Deactivated");
                            } catch (SQLException ex) {
                                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Account deactivated!", "Login", JOptionPane.ERROR_MESSAGE);
                    username.setText("");
                    password.setText("");
                    return;
                }
            }
        }

        for (int i = 0; i < cashiers.size(); i++) {
            if (username.getText().equals(cashiers.get(i).getUsername())) {
                if (cashiers.get(i).getStatus().equals("Active")) {
                    if (password.getText().equals(cashiers.get(i).getPassword())) {
                        this.dispose();
                        JOptionPane.showMessageDialog(null, "Login Success!", "Login", JOptionPane.INFORMATION_MESSAGE);
                        new Main(username.getText(), password.getText()).setVisible(true);
                        return;
                    } else {
                        JOptionPane.showMessageDialog(null, "Login Failed!", "Login", JOptionPane.WARNING_MESSAGE);
                        username.setText("");
                        password.setText("");
                        ++loginCounter;
                        if (loginCounter == 3) {
                            JOptionPane.showMessageDialog(null, "Account deactivated!", "Login", JOptionPane.ERROR_MESSAGE);
                            username.setText("");
                            password.setText("");
                            try {
                                PreparedStatement statement = connect.prepareStatement("UPDATE Cashier SET cashier_status = ? WHERE cashier_username = ?");
                                statement.setString(1, "Deactivated");
                                statement.setString(2, cashiers.get(i).getUsername());

                                statement.executeUpdate();
                                cashiers.get(i).setStatus("Deactivated");
                            } catch (SQLException ex) {
                                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Account deactivated!", "Login", JOptionPane.ERROR_MESSAGE);
                    username.setText("");
                    password.setText("");
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Login Failed!", "Login", JOptionPane.WARNING_MESSAGE);
        username.setText("");
        password.setText("");
    }//GEN-LAST:event_loginButtonActionPerformed

    public boolean checkUsernamePassword() {
        if (username.getText().equals("") && password.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Username and Password is required!", "Username and Password", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (username.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Username is required!", "Username", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (password.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Password is required!", "Password", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField username;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
