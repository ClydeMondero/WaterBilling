
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

class AdminData {

    private int id;
    private String lastName, firstName, middleName, address, phonNumber;
    private String username, password;
    private String status;

    public AdminData(int id, String username, String password, String status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public AdminData(int id, String lastName, String firstName, String middleName, String address,
            String phonNumber, String username, String password, String status) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.phonNumber = phonNumber;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonNumber() {
        return phonNumber;
    }

    public void setPhonNumber(String phonNumber) {
        this.phonNumber = phonNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

public class Admin extends javax.swing.JPanel {

    
    static ArrayList<AdminData> adminDatas = new ArrayList<>();
    Connection connect = null;    
    
    String username;
    public Admin(String username) {
        initComponents();
        
        connect = DatabaseConnection.connectDatabase();
        
        this.username = username;
        
        showDataAdminTable();

        adminId.setText(Integer.toString(adminDatas.get(adminDatas.size() - 1).getId() + 1));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listOfAdminAccountLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        adminTable = new javax.swing.JTable();
        createAdminAccountLabel = new javax.swing.JLabel();
        adminAccountIdLabel = new javax.swing.JLabel();
        adminId = new javax.swing.JLabel();
        adminLastNameLabel = new javax.swing.JLabel();
        adminLastNameTextField = new javax.swing.JTextField();
        adminFirstNameLabel = new javax.swing.JLabel();
        adminFirstNameTextField = new javax.swing.JTextField();
        adminMiddleInitialLabel = new javax.swing.JLabel();
        adminMiddleNameTextField = new javax.swing.JTextField();
        adminAddressLabel = new javax.swing.JLabel();
        adminAddressTextField = new javax.swing.JTextField();
        adminPhoneNumberLabel = new javax.swing.JLabel();
        adminPhoneNumberTextField = new javax.swing.JTextField();
        adminUsernameLabel = new javax.swing.JLabel();
        adminUsernameTextField = new javax.swing.JTextField();
        adminPasswordLabel = new javax.swing.JLabel();
        adminPasswordTextField = new javax.swing.JPasswordField();
        adminPasswordLabel1 = new javax.swing.JLabel();
        adminStatusComboBox = new javax.swing.JComboBox<>();
        adminCancelButton = new javax.swing.JButton();
        adminSaveButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 520));
        setRequestFocusEnabled(false);

        listOfAdminAccountLabel.setFont(new java.awt.Font("sansserif", 1, 28)); // NOI18N
        listOfAdminAccountLabel.setText("List of Admin Accounts");

        adminTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Address", "Phone Number", "Usename", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        adminTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(adminTable);

        createAdminAccountLabel.setFont(new java.awt.Font("sansserif", 1, 28)); // NOI18N
        createAdminAccountLabel.setText("Create Admin Account");

        adminAccountIdLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        adminAccountIdLabel.setText("Account Id:");

        adminId.setText("Id");

        adminLastNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        adminLastNameLabel.setText("Last Name:");

        adminFirstNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        adminFirstNameLabel.setText("First Name:");

        adminMiddleInitialLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        adminMiddleInitialLabel.setText("Middle Name: ");

        adminAddressLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        adminAddressLabel.setText("Address:");

        adminPhoneNumberLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        adminPhoneNumberLabel.setText("Phone Number:");

        adminUsernameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        adminUsernameLabel.setText("Username:");

        adminPasswordLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        adminPasswordLabel.setText("Password:");

        adminPasswordLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        adminPasswordLabel1.setText("Status: ");

        adminStatusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Deactivated"}));
        adminStatusComboBox.setMinimumSize(new java.awt.Dimension(60, 26));

        adminCancelButton.setText("Cancel");
        adminCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminCancelButtonActionPerformed(evt);
            }
        });

        adminSaveButton.setText("Save");
        adminSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminSaveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(183, 183, 183)
                            .addComponent(createAdminAccountLabel))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(adminPasswordLabel1)
                                .addComponent(adminAccountIdLabel)
                                .addComponent(adminLastNameLabel)
                                .addComponent(adminAddressLabel)
                                .addComponent(adminMiddleInitialLabel)
                                .addComponent(adminUsernameLabel))
                            .addGap(22, 22, 22)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(adminStatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(adminLastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(adminMiddleNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(adminUsernameTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(adminAddressTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(adminId))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(adminCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(adminSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(adminPasswordLabel)
                                        .addComponent(adminFirstNameLabel)
                                        .addComponent(adminPhoneNumberLabel))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(adminFirstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(adminPasswordTextField)
                                                .addComponent(adminPhoneNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(listOfAdminAccountLabel))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listOfAdminAccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createAdminAccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adminAccountIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(adminId))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adminLastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adminLastNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adminMiddleNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adminMiddleInitialLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adminAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adminAddressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adminUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adminUsernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adminFirstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adminFirstNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adminPhoneNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adminPhoneNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adminPasswordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(adminPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adminStatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adminPasswordLabel1)
                    .addComponent(adminCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adminSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    int adminRow;
    private void adminTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminTableMouseClicked
        adminRow = adminTable.getSelectedRow();

        if (!username.equals("main_admin")) {
            JOptionPane.showMessageDialog(null, "Main Admin Account Only!", "Edit", JOptionPane.WARNING_MESSAGE);
            return;
        }

        adminId.setText(Integer.toString(adminDatas.get(adminRow).getId()));
        adminLastNameTextField.setText(adminDatas.get(adminRow).getLastName());
        adminFirstNameTextField.setText(adminDatas.get(adminRow).getFirstName());
        adminMiddleNameTextField.setText(adminDatas.get(adminRow).getMiddleName());
        adminAddressTextField.setText(adminDatas.get(adminRow).getAddress());
        adminPhoneNumberTextField.setText(adminDatas.get(adminRow).getPhonNumber());
        adminUsernameTextField.setText(adminDatas.get(adminRow).getUsername());
        adminPasswordTextField.setText(adminDatas.get(adminRow).getPassword());
        adminStatusComboBox.setSelectedItem(adminDatas.get(adminRow).getStatus());
    }//GEN-LAST:event_adminTableMouseClicked

    private void adminCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminCancelButtonActionPerformed
        clearAdminTextFields();
    }//GEN-LAST:event_adminCancelButtonActionPerformed

    private void adminSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminSaveButtonActionPerformed
        String currentAdminPassword = null;
        boolean isUsernameDuplicate = false;

        for (AdminData admin : adminDatas) {
            if(adminUsernameTextField.getText().equals(admin.getUsername())){
                isUsernameDuplicate = true;
            }
            if (username.equals(admin.getUsername())) {
                currentAdminPassword = admin.getPassword();
            }
        }
        if (isUsernameDuplicate && !adminTableModel.getValueAt(adminRow, 4).toString().equals(adminUsernameTextField.getText())) {
            JOptionPane.showMessageDialog(null, "Username already exist!", "Invalid Username", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String password = JOptionPane.showInputDialog(null, "Enter your password: ", "Save Account", JOptionPane.QUESTION_MESSAGE);
        if (password == null) {
            return;
        } else {
            if (!password.equals(currentAdminPassword)) {
                JOptionPane.showMessageDialog(null, "Incorrect password!", "Wrong Password", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                if (Integer.parseInt(adminId.getText()) > adminDatas.size()) {
                    PreparedStatement insertAdmin;
                    insertAdmin = connect.prepareStatement("INSERT IGNORE INTO Admin VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
                    insertAdmin.setInt(1, Integer.parseInt(adminId.getText()));
                    insertAdmin.setString(2, adminLastNameTextField.getText());
                    insertAdmin.setString(3, adminFirstNameTextField.getText());
                    insertAdmin.setString(4, adminMiddleNameTextField.getText());
                    insertAdmin.setString(5, adminAddressTextField.getText());
                    insertAdmin.setString(6, adminPhoneNumberTextField.getText());
                    insertAdmin.setString(7, adminUsernameTextField.getText());
                    insertAdmin.setString(8, adminPasswordTextField.getText());
                    insertAdmin.setString(9, adminStatusComboBox.getSelectedItem().toString());

                    insertAdmin.executeUpdate();

                    showDataAdminTable();

                    adminId.setText(Integer.toString(adminDatas.get(adminDatas.size() - 1).getId() + 1));
                    clearAdminTextFields();
                }else{
                    PreparedStatement updateAdmin = connect.prepareStatement("UPDATE Admin SET admin_id = ?, admin_lastname = ?, admin_firstname = ?,"
                        + " admin_middlename = ?, admin_address =  ?, admin_phonenumber = ?, admin_username =  ?, admin_password = ?, admin_status = ? WHERE admin_id = ?");
                    updateAdmin.setInt(1, Integer.parseInt(adminId.getText()));
                    updateAdmin.setString(2, adminLastNameTextField.getText());
                    updateAdmin.setString(3, adminFirstNameTextField.getText());
                    updateAdmin.setString(4, adminMiddleNameTextField.getText());
                    updateAdmin.setString(5, adminAddressTextField.getText());
                    updateAdmin.setString(6, adminPhoneNumberTextField.getText());
                    updateAdmin.setString(7, adminUsernameTextField.getText());
                    updateAdmin.setString(8, adminPasswordTextField.getText());
                    updateAdmin.setString(9, adminStatusComboBox.getSelectedItem().toString());
                    updateAdmin.setInt(10, Integer.parseInt(adminId.getText()));

                    updateAdmin.executeUpdate();

                    showDataAdminTable();

                    adminId.setText(Integer.toString(adminDatas.get(adminDatas.size() - 1).getId() + 1));
                    clearAdminTextFields();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_adminSaveButtonActionPerformed

    
    public void clearAdminTextFields() {
        adminId.setText(Integer.toString(adminDatas.get(adminDatas.size() - 1).getId() + 1));
        adminLastNameTextField.setText("");
        adminFirstNameTextField.setText("");
        adminMiddleNameTextField.setText("");
        adminAddressTextField.setText("");
        adminPhoneNumberTextField.setText("");
        adminUsernameTextField.setText("");
        adminPasswordTextField.setText("");
        adminStatusComboBox.setSelectedItem("Activate");
    }

    public void updateAdminDatas() {
        try {
            Statement statement = connect.createStatement();

            ResultSet selectAdmin = statement.executeQuery("SELECT * FROM Admin");

            adminDatas.clear();
            while (selectAdmin.next()) {
                adminDatas.add(new AdminData(selectAdmin.getInt("admin_id"), selectAdmin.getString("admin_lastname"),
                        selectAdmin.getString("admin_firstname"), selectAdmin.getString("admin_middlename"), selectAdmin.getString("admin_address"),
                        selectAdmin.getString("admin_phonenumber"), selectAdmin.getString("admin_username"), selectAdmin.getString("admin_password"),
                        selectAdmin.getString("admin_status")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    DefaultTableModel adminTableModel;

    public void showDataAdminTable() {
        updateAdminDatas();

        adminTableModel = (DefaultTableModel) adminTable.getModel();
        Object[] row = new Object[6];

        adminTableModel.setRowCount(0);

        for (int i = 0; i < adminDatas.size(); i++) {
            row[0] = adminDatas.get(i).getId();
            row[1] = adminDatas.get(i).getFirstName() + " " + adminDatas.get(i).getMiddleName() + " " + adminDatas.get(i).getLastName();
            row[2] = adminDatas.get(i).getAddress();
            row[3] = adminDatas.get(i).getPhonNumber();
            row[4] = adminDatas.get(i).getUsername();
            row[5] = adminDatas.get(i).getStatus();
            adminTableModel.addRow(row);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adminAccountIdLabel;
    private javax.swing.JLabel adminAddressLabel;
    private javax.swing.JTextField adminAddressTextField;
    private javax.swing.JButton adminCancelButton;
    private javax.swing.JLabel adminFirstNameLabel;
    private javax.swing.JTextField adminFirstNameTextField;
    private javax.swing.JLabel adminId;
    private javax.swing.JLabel adminLastNameLabel;
    private javax.swing.JTextField adminLastNameTextField;
    private javax.swing.JLabel adminMiddleInitialLabel;
    private javax.swing.JTextField adminMiddleNameTextField;
    private javax.swing.JLabel adminPasswordLabel;
    private javax.swing.JLabel adminPasswordLabel1;
    private javax.swing.JPasswordField adminPasswordTextField;
    private javax.swing.JLabel adminPhoneNumberLabel;
    private javax.swing.JTextField adminPhoneNumberTextField;
    private javax.swing.JButton adminSaveButton;
    private javax.swing.JComboBox<String> adminStatusComboBox;
    private javax.swing.JTable adminTable;
    private javax.swing.JLabel adminUsernameLabel;
    private javax.swing.JTextField adminUsernameTextField;
    private javax.swing.JLabel createAdminAccountLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel listOfAdminAccountLabel;
    // End of variables declaration//GEN-END:variables
}
