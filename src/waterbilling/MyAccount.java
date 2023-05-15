package waterbilling;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import static waterbilling.AdminPanel.admins;
import static waterbilling.StaffPanel.staffs;
import static waterbilling.CashierPanel.cashiers;

public class MyAccount extends javax.swing.JPanel {

    String accountUsername, accountPassword;

    Connection connect = null;

    public MyAccount(String username, String password) {
        initComponents();

        connect = DatabaseConnection.connectDatabase();

        accountUsername = username;
        accountPassword = password;

        updateDatas();

        setTextFields();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myAccountLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        lastnameLabel = new javax.swing.JLabel();
        lastname = new javax.swing.JTextField();
        firstnameLabel = new javax.swing.JLabel();
        firstname = new javax.swing.JTextField();
        middlenameLabel = new javax.swing.JLabel();
        middlename = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        phonenumberLabel = new javax.swing.JLabel();
        phonenumber = new javax.swing.JTextField();
        usernameLabel = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        statusLabel = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        cancel = new javax.swing.JButton();
        save = new javax.swing.JButton();

        setBackground(new java.awt.Color(203, 243, 240));

        myAccountLabel.setFont(new java.awt.Font("sansserif", 1, 28)); // NOI18N
        myAccountLabel.setForeground(new java.awt.Color(46, 196, 182));
        myAccountLabel.setText("My Account");

        idLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idLabel.setText("Account Id:");

        id.setText("Id");

        lastnameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lastnameLabel.setText("Last Name:");

        firstnameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        firstnameLabel.setText("First Name:");

        middlenameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        middlenameLabel.setText("Middle Name: ");

        addressLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addressLabel.setText("Address:");

        phonenumberLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        phonenumberLabel.setText("Phone Number:");

        usernameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        usernameLabel.setText("Username:");

        passwordLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        passwordLabel.setText("Password:");

        statusLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        statusLabel.setText("Status: ");

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Deactivated"}));
        status.setMinimumSize(new java.awt.Dimension(60, 26));

        cancel.setForeground(new java.awt.Color(255, 159, 28));
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        save.setBackground(new java.awt.Color(255, 159, 28));
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(324, 324, 324)
                .addComponent(myAccountLabel)
                .addContainerGap(336, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(statusLabel)
                        .addComponent(idLabel)
                        .addComponent(lastnameLabel)
                        .addComponent(addressLabel)
                        .addComponent(middlenameLabel)
                        .addComponent(usernameLabel))
                    .addGap(22, 22, 22)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(middlename, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(username, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(address, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(id))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(passwordLabel)
                                .addComponent(firstnameLabel)
                                .addComponent(phonenumberLabel))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(password)
                                        .addComponent(phonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGap(36, 36, 36)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(myAccountLabel)
                .addContainerGap(483, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(140, 140, 140)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(idLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(id))
                            .addGap(13, 13, 13)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lastnameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(middlename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(middlenameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(addressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(usernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(firstnameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                            .addGap(59, 59, 59)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(phonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(phonenumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(passwordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(statusLabel)
                        .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(141, 141, 141)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        setTextFields();
    }//GEN-LAST:event_cancelActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        if (checkUsernamePassword() == false) {
            return;
        }

        String suffix = username.getText().toString().substring(username.getText().toString().indexOf("_") + 1);
        if (suffix.equals("admin")) {
            if (!suffix.equals("admin")) {
                JOptionPane.showMessageDialog(null, "Username should have a admin suffix!", "Invalid Username", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else if (suffix.equals("staff")) {
            if (!suffix.equals("staff")) {
                JOptionPane.showMessageDialog(null, "Username should have a staff suffix!", "Invalid Username", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else if (suffix.equals("cashier")) {
            if (!suffix.equals("staff")) {
                JOptionPane.showMessageDialog(null, "Username should have a cashier suffix!", "Invalid Username", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        boolean isUsernameDuplicate = false;

        for (Admin admin : admins) {
            if (username.getText().equals(admin.getUsername())) {
                isUsernameDuplicate = true;
            }
        }

        for (Staff staff : staffs) {
            if (username.getText().equals(staff.getUsername())) {
                isUsernameDuplicate = true;
            }
        }

        for (Cashier cashier : cashiers) {
            if (username.getText().equals(cashier.getUsername())) {
                isUsernameDuplicate = true;
            }
        }

        if (isUsernameDuplicate && !username.getText().equals(accountUsername)) {
            JOptionPane.showMessageDialog(null, "Username already exist!", "Invalid Username", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JPasswordField passwordField = new JPasswordField();
        String password = null;
        int option = JOptionPane.showConfirmDialog(null, passwordField, "Enter your password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            password = passwordField.getText();
            if (password != null) {
                if (password.equals(accountPassword)) {
                    if (suffix.equals("admin")) {
                        try {
                            PreparedStatement updateStatement = connect.prepareStatement("UPDATE Admin SET admin_id = ?, admin_lastname = ?, admin_firstname = ?,"
                                    + " admin_middlename = ?, admin_address =  ?, admin_phonenumber = ?, admin_username =  ?, admin_password = ?, admin_status = ? WHERE admin_id = ?");
                            updateStatement.setInt(1, Integer.parseInt(id.getText()));
                            updateStatement.setString(2, lastname.getText());
                            updateStatement.setString(3, firstname.getText());
                            updateStatement.setString(4, middlename.getText());
                            updateStatement.setString(5, address.getText());
                            updateStatement.setString(6, phonenumber.getText());
                            updateStatement.setString(7, username.getText());
                            updateStatement.setString(8, this.password.getText());
                            updateStatement.setString(9, status.getSelectedItem().toString());
                            updateStatement.setInt(10, Integer.parseInt(id.getText()));

                            updateStatement.executeUpdate();

                            updateDatas();

                            setTextFields();

                            JOptionPane.showMessageDialog(null, "Account Updated!", "Update", JOptionPane.INFORMATION_MESSAGE);

                        } catch (SQLException ex) {
                            Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (suffix.equals("staff")) {
                        try {
                            PreparedStatement updateStatement = connect.prepareStatement("UPDATE Staff SET staff_id = ?, staff_lastname = ?, staff_firstname = ?,"
                                    + " staff_middlename = ?, staff_address =  ?, staff_phonenumber = ?, staff_username =  ?, staff_password = ?, staff_status = ? WHERE staff_id = ?");
                            updateStatement.setInt(1, Integer.parseInt(id.getText()));
                            updateStatement.setString(2, lastname.getText());
                            updateStatement.setString(3, firstname.getText());
                            updateStatement.setString(4, middlename.getText());
                            updateStatement.setString(5, address.getText());
                            updateStatement.setString(6, phonenumber.getText());
                            updateStatement.setString(7, username.getText());
                            updateStatement.setString(8, this.password.getText());
                            updateStatement.setString(9, status.getSelectedItem().toString());
                            updateStatement.setInt(10, Integer.parseInt(id.getText()));

                            updateStatement.executeUpdate();

                            updateDatas();

                            setTextFields();

                            JOptionPane.showMessageDialog(null, "Account Updated!", "Update", JOptionPane.INFORMATION_MESSAGE);

                        } catch (SQLException ex) {
                            Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (suffix.equals("cashier")) {
                        try {
                            PreparedStatement updateStatement = connect.prepareStatement("UPDATE Cashier SET cashier_id = ?, cashier_lastname = ?, cashier_firstname = ?,"
                                    + " cashier_middlename = ?, cashier_address =  ?, cashier_phonenumber = ?, cashier_username =  ?, cashier_password = ?, cashier_status = ? WHERE cashier_id = ?");
                            updateStatement.setInt(1, Integer.parseInt(id.getText()));
                            updateStatement.setString(2, lastname.getText());
                            updateStatement.setString(3, firstname.getText());
                            updateStatement.setString(4, middlename.getText());
                            updateStatement.setString(5, address.getText());
                            updateStatement.setString(6, phonenumber.getText());
                            updateStatement.setString(7, username.getText());
                            updateStatement.setString(8, this.password.getText());
                            updateStatement.setString(9, status.getSelectedItem().toString());
                            updateStatement.setInt(10, Integer.parseInt(id.getText()));

                            updateStatement.executeUpdate();

                            updateDatas();

                            setTextFields();

                            JOptionPane.showMessageDialog(null, "Account Updated!", "Update", JOptionPane.INFORMATION_MESSAGE);

                        } catch (SQLException ex) {
                            Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect password!", "Wrong Password", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_saveActionPerformed

    public void setTextFields() {
        String suffix = accountUsername.substring(accountUsername.indexOf("_") + 1);
        if (suffix.equals("admin")) {
            for (Admin admin : admins) {
                if (accountUsername.equals(admin.getUsername())) {
                    id.setText(Integer.toString(admin.getId()));
                    lastname.setText(admin.getLastName());
                    firstname.setText(admin.getFirstName());
                    middlename.setText(admin.getMiddleName());
                    address.setText(admin.getAddress());
                    phonenumber.setText(admin.getPhonNumber());
                    username.setText(admin.getUsername());
                    password.setText(admin.getPassword());
                    status.setSelectedItem(admin.getStatus());
                }
            }
        } else if (suffix.equals("staff")) {
            for (Staff staff: staffs) {
                if (accountUsername.equals(staff.getUsername())) {
                    id.setText(Integer.toString(staff.getId()));
                    lastname.setText(staff.getLastName());
                    firstname.setText(staff.getFirstName());
                    middlename.setText(staff.getMiddleName());
                    address.setText(staff.getAddress());
                    phonenumber.setText(staff.getPhonNumber());
                    username.setText(staff.getUsername());
                    password.setText(staff.getPassword());
                    status.setSelectedItem(staff.getStatus());
                }
            }
        }else if (suffix.equals("cashier")) {
            for (Cashier cashier : cashiers) {
                if (accountUsername.equals(cashier.getUsername())) {
                    id.setText(Integer.toString(cashier.getId()));
                    lastname.setText(cashier.getLastName());
                    firstname.setText(cashier.getFirstName());
                    middlename.setText(cashier.getMiddleName());
                    address.setText(cashier.getAddress());
                    phonenumber.setText(cashier.getPhonNumber());
                    username.setText(cashier.getUsername());
                    password.setText(cashier.getPassword());
                    status.setSelectedItem(cashier.getStatus());
                }
            }
        }
    }

    public void updateDatas() {
        try {
            Statement statement = connect.createStatement();
            ResultSet selectAdmin = statement.executeQuery("SELECT * FROM Admin WHERE admin_username = '" + accountUsername + "'");

            admins.clear();
            while (selectAdmin.next()) {
                admins.add(new Admin(selectAdmin.getInt("admin_id"), selectAdmin.getString("admin_lastname"),
                        selectAdmin.getString("admin_firstname"), selectAdmin.getString("admin_middlename"), selectAdmin.getString("admin_address"),
                        selectAdmin.getString("admin_phonenumber"), selectAdmin.getString("admin_username"), selectAdmin.getString("admin_password"),
                        selectAdmin.getString("admin_status")
                ));
            }

            ResultSet selectStaff = statement.executeQuery("SELECT * FROM Staff WHERE staff_username = '" + accountUsername + "'");

            staffs.clear();
            while (selectStaff.next()) {
                staffs.add(new Staff(selectStaff.getInt("staff_id"), selectStaff.getString("staff_lastname"),
                        selectStaff.getString("staff_firstname"), selectStaff.getString("staff_middlename"), selectStaff.getString("staff_address"),
                        selectStaff.getString("staff_phonenumber"), selectStaff.getString("staff_username"), selectStaff.getString("staff_password"),
                        selectStaff.getString("staff_status")
                ));
            }

            ResultSet selectCashier = statement.executeQuery("SELECT * FROM Cashier WHERE cashier_username = '" + accountUsername + "'");

            cashiers.clear();
            while (selectCashier.next()) {
                cashiers.add(new Cashier(selectCashier.getInt("cashier_id"), selectCashier.getString("cashier_lastname"),
                        selectCashier.getString("cashier_firstname"), selectCashier.getString("cashier_middlename"), selectCashier.getString("cashier_address"),
                        selectCashier.getString("cashier_phonenumber"), selectCashier.getString("cashier_username"), selectCashier.getString("cashier_password"),
                        selectCashier.getString("cashier_status")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   

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
    private javax.swing.JTextField address;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JButton cancel;
    private javax.swing.JTextField firstname;
    private javax.swing.JLabel firstnameLabel;
    private javax.swing.JLabel id;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField lastname;
    private javax.swing.JLabel lastnameLabel;
    private javax.swing.JTextField middlename;
    private javax.swing.JLabel middlenameLabel;
    private javax.swing.JLabel myAccountLabel;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField phonenumber;
    private javax.swing.JLabel phonenumberLabel;
    private javax.swing.JButton save;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JTextField username;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
