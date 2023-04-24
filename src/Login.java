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
            ResultSet selectAdmin = statement.executeQuery("SELECT id, username, password, status FROM Admin");
                        
            while(selectAdmin.next()){
                adminDatas.add(new AdminData(selectAdmin.getInt("id"), selectAdmin.getString("username"), selectAdmin.getString("password")
                , selectAdmin.getString("status")));
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        signInLabel.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        signInLabel.setText("Log In");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usernameTextField)
                            .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(signInLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(signInLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
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
                                PreparedStatement statement = connect.prepareStatement("UPDATE Admin SET status = ? WHERE username = ?");
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

    
    public static void main(String args[]) {
        
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton loginButton;
    private javax.swing.JTextField passwordTextField;
    private javax.swing.JLabel signInLabel;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
