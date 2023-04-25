import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {        
    
    static ArrayList<AdminData> adminDatas = new ArrayList<>();
    static ArrayList<StaffData> staffDatas = new ArrayList<>();
    
    Connection connect = null;
    
    public Login() {      
        initComponents();        
         connect = DatabaseConnection.connectDatabase();
                
        try {
            Statement statement = connect.createStatement();
            ResultSet selectAdmin = statement.executeQuery("SELECT admin_id, admin_username, admin_password, admin_status FROM Admin");
                        
            while(selectAdmin.next()){
                adminDatas.add(new AdminData(selectAdmin.getInt("admin_id"), selectAdmin.getString("admin_username"), selectAdmin.getString("admin_password")
                ,selectAdmin.getString("admin_status")));
            }
            
            ResultSet selectStaff = statement.executeQuery("SELECT id, username, password FROM Staff");
            
            while(selectStaff.next()){
                staffDatas.add(new StaffData(selectStaff.getInt("id"), selectStaff.getString("username"), selectStaff.getString("password")));
            }
        } catch (Exception ex) {           
        }
                
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        passwordTextField = new javax.swing.JTextField();
        usernameTextField = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        signInLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        signInLabel.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        signInLabel.setText("Log In");

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 30)); // NOI18N
        jLabel1.setText("Water Billing System");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(signInLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(signInLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    int loginCounter = 0;
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
             
        for (int i = 0; i < adminDatas.size(); i++) {
            if (usernameTextField.getText().equals(adminDatas.get(i).getUsername())) {
                if (adminDatas.get(i).getStatus().equals("Active")) {
                    if (passwordTextField.getText().equals(adminDatas.get(i).getPassword())) {                        
                        this.dispose();
                        JOptionPane.showMessageDialog(null, "Login Success!", "Login", JOptionPane.INFORMATION_MESSAGE);
                        new Admin().setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "Login Failed!", "Login", JOptionPane.WARNING_MESSAGE);
                        usernameTextField.setText("");
                        passwordTextField.setText("");
                        System.out.println(++loginCounter);
                        if(loginCounter == 3){
                            try {
                                PreparedStatement statement = connect.prepareStatement("UPDATE Admin SET admin_status = ? WHERE admin_username = ?");
                                statement.setString(1, "Deactivated");
                                statement.setString(2, adminDatas.get(i).getUsername());
                                
                                statement.executeUpdate();
                                adminDatas.get(i).setStatus("Deactivated");
                            } catch (Exception ex) {                                
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Account deactivated!", "Login", JOptionPane.ERROR_MESSAGE);
                    usernameTextField.setText("");
                    passwordTextField.setText("");
                }

            }            
        }
        for (int i = 0; i < staffDatas.size(); i++) {
            if(usernameTextField.getText().equals(staffDatas.get(i).getUsername()) && passwordTextField.getText().equals(staffDatas.get(i).getPassword())){                
                this.dispose();
                new Staff().setVisible(true);                
            }
        }              
    }//GEN-LAST:event_loginButtonActionPerformed
      

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton loginButton;
    private javax.swing.JTextField passwordTextField;
    private javax.swing.JLabel signInLabel;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
