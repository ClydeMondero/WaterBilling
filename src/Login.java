
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    static ArrayList<AdminData> adminDatas = new ArrayList<>();
    static ArrayList<StaffData> staffDatas = new ArrayList<>();

    Connection connect = null;

    private static String username;

    public static void setUsername(String username) {
        Login.username = username;
    }

    public Login(JLabel username) {
        username.setText(this.username);
    }

    public Login() {
        initComponents();
        connect = DatabaseConnection.connectDatabase();

        try {
            Statement statement = connect.createStatement();
            ResultSet selectAdmin = statement.executeQuery("SELECT admin_id, admin_username, admin_password, admin_status FROM Admin");

            adminDatas.clear();
            while (selectAdmin.next()) {
                adminDatas.add(new AdminData(selectAdmin.getInt("admin_id"), selectAdmin.getString("admin_username"), selectAdmin.getString("admin_password"),
                        selectAdmin.getString("admin_status")));
            }

            ResultSet selectStaff = statement.executeQuery("SELECT id, username, password FROM Staff");

            while (selectStaff.next()) {
                staffDatas.add(new StaffData(selectStaff.getInt("id"), selectStaff.getString("username"), selectStaff.getString("password")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usernameTextField = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        loginLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        passwordPasswordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        loginLabel.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        loginLabel.setText("Log In");

        titleLabel.setFont(new java.awt.Font("sansserif", 1, 30)); // NOI18N
        titleLabel.setText("Water Billing System");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(loginLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(titleLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(passwordPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {passwordPasswordField, usernameTextField});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(loginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(passwordPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {passwordPasswordField, usernameTextField});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    int loginCounter = 0;
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed

        for (int i = 0; i < adminDatas.size(); i++) {
            if (usernameTextField.getText().equals(adminDatas.get(i).getUsername())) {
                if (adminDatas.get(i).getStatus().equals("Active")) {
                    if (passwordPasswordField.getText().equals(adminDatas.get(i).getPassword())) {
                        this.dispose();
                        JOptionPane.showMessageDialog(null, "Login Success!", "Login", JOptionPane.INFORMATION_MESSAGE);
                        setUsername(usernameTextField.getText());
                        new Admin().setVisible(true);
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Login Failed!", "Login", JOptionPane.WARNING_MESSAGE);
                        usernameTextField.setText("");
                        passwordPasswordField.setText("");
                        ++loginCounter;
                        if (loginCounter == 3) {
                            JOptionPane.showMessageDialog(null, "Account deactivated!", "Login", JOptionPane.ERROR_MESSAGE);
                            usernameTextField.setText("");
                            passwordPasswordField.setText("");
                            try {
                                PreparedStatement statement = connect.prepareStatement("UPDATE Admin SET admin_status = ? WHERE admin_username = ?");
                                statement.setString(1, "Deactivated");
                                statement.setString(2, adminDatas.get(i).getUsername());

                                statement.executeUpdate();
                                adminDatas.get(i).setStatus("Deactivated");
                            } catch (SQLException ex) {
                                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Account deactivated!", "Login", JOptionPane.ERROR_MESSAGE);
                    usernameTextField.setText("");
                    passwordPasswordField.setText("");
                }

            }
        }
        for (int i = 0; i < staffDatas.size(); i++) {
            if (usernameTextField.getText().equals(staffDatas.get(i).getUsername()) && passwordPasswordField.getText().equals(staffDatas.get(i).getPassword())) {
                this.dispose();
                new Staff().setVisible(true);
            }
        }
    }//GEN-LAST:event_loginButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JPasswordField passwordPasswordField;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
