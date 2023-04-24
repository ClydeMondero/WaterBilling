
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class Admin extends javax.swing.JFrame {

    static ArrayList<AdminData> adminDatas = new ArrayList<>();
    Connection connect = null;
    
    public Admin() {
        initComponents();

        connect = DatabaseConnection.connectDatabase();       
        
        showDataAdminTable();
        
        adminAccountIdTextField.setText(Integer.toString(adminDatas.get(adminDatas.size()-1).getId() + 1));
    }           
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adminTabbedPane = new javax.swing.JTabbedPane();
        homePanel = new javax.swing.JPanel();
        billingPanel = new javax.swing.JPanel();
        clientPanel = new javax.swing.JPanel();
        staffPanel = new javax.swing.JPanel();
        adminPanel = new javax.swing.JPanel();
        createAdminAccountLabel = new javax.swing.JLabel();
        adminAccountIdLabel = new javax.swing.JLabel();
        adminLastNameLabel = new javax.swing.JLabel();
        adminFirstNameLabel = new javax.swing.JLabel();
        adminMiddleInitialLabel = new javax.swing.JLabel();
        adminAddressLabel = new javax.swing.JLabel();
        adminPhoneNumberLabel = new javax.swing.JLabel();
        adminAccountIdTextField = new javax.swing.JTextField();
        adminLastNameTextField = new javax.swing.JTextField();
        adminFirstNameTextField = new javax.swing.JTextField();
        adminMiddleNameTextField = new javax.swing.JTextField();
        adminAddressTextField = new javax.swing.JTextField();
        adminPhoneNumberTextField = new javax.swing.JTextField();
        adminSaveButton = new javax.swing.JButton();
        adminCancelButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        adminTable = new javax.swing.JTable();
        adminUsernameLabel = new javax.swing.JLabel();
        adminUsernameTextField = new javax.swing.JTextField();
        adminPasswordLabel = new javax.swing.JLabel();
        listOfAdminAccountLabel = new javax.swing.JLabel();
        adminPasswordTextField = new javax.swing.JPasswordField();
        myAccountPanel = new javax.swing.JPanel();
        logoutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
        homePanel.setLayout(homePanelLayout);
        homePanelLayout.setHorizontalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
        );
        homePanelLayout.setVerticalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        adminTabbedPane.addTab("Home", homePanel);

        javax.swing.GroupLayout billingPanelLayout = new javax.swing.GroupLayout(billingPanel);
        billingPanel.setLayout(billingPanelLayout);
        billingPanelLayout.setHorizontalGroup(
            billingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
        );
        billingPanelLayout.setVerticalGroup(
            billingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        adminTabbedPane.addTab("Billing", billingPanel);

        javax.swing.GroupLayout clientPanelLayout = new javax.swing.GroupLayout(clientPanel);
        clientPanel.setLayout(clientPanelLayout);
        clientPanelLayout.setHorizontalGroup(
            clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
        );
        clientPanelLayout.setVerticalGroup(
            clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        adminTabbedPane.addTab("Client", clientPanel);

        javax.swing.GroupLayout staffPanelLayout = new javax.swing.GroupLayout(staffPanel);
        staffPanel.setLayout(staffPanelLayout);
        staffPanelLayout.setHorizontalGroup(
            staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
        );
        staffPanelLayout.setVerticalGroup(
            staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        adminTabbedPane.addTab("Staff", staffPanel);

        adminPanel.setPreferredSize(new java.awt.Dimension(820, 600));

        createAdminAccountLabel.setFont(new java.awt.Font("sansserif", 1, 28)); // NOI18N
        createAdminAccountLabel.setText("Create Admin Account");

        adminAccountIdLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        adminAccountIdLabel.setText("Account Id:");

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

        adminAccountIdTextField.setEditable(false);

        adminSaveButton.setText("Save");
        adminSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminSaveButtonActionPerformed(evt);
            }
        });

        adminCancelButton.setText("Cancel");
        adminCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminCancelButtonActionPerformed(evt);
            }
        });

        adminTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Usename", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(adminTable);
        if (adminTable.getColumnModel().getColumnCount() > 0) {
            adminTable.getColumnModel().getColumn(0).setResizable(false);
            adminTable.getColumnModel().getColumn(2).setResizable(false);
        }

        adminUsernameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        adminUsernameLabel.setText("Username:");

        adminPasswordLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        adminPasswordLabel.setText("Password:");

        listOfAdminAccountLabel.setFont(new java.awt.Font("sansserif", 1, 28)); // NOI18N
        listOfAdminAccountLabel.setText("List of Admin Accounts");

        javax.swing.GroupLayout adminPanelLayout = new javax.swing.GroupLayout(adminPanel);
        adminPanel.setLayout(adminPanelLayout);
        adminPanelLayout.setHorizontalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminPanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(createAdminAccountLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(listOfAdminAccountLabel)
                        .addGap(68, 68, 68))
                    .addGroup(adminPanelLayout.createSequentialGroup()
                        .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(adminPanelLayout.createSequentialGroup()
                                .addComponent(adminCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(adminSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(adminPanelLayout.createSequentialGroup()
                                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(adminAccountIdLabel)
                                    .addGroup(adminPanelLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(adminFirstNameLabel)
                                            .addComponent(adminLastNameLabel)
                                            .addComponent(adminMiddleInitialLabel)
                                            .addComponent(adminAddressLabel)
                                            .addComponent(adminPhoneNumberLabel)
                                            .addComponent(adminUsernameLabel)
                                            .addComponent(adminPasswordLabel))))
                                .addGap(22, 22, 22)
                                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(adminAccountIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(adminLastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(adminFirstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(adminMiddleNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(adminAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(adminPhoneNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(adminUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(adminPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
        );

        adminPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {adminAccountIdTextField, adminAddressTextField, adminFirstNameTextField, adminLastNameTextField, adminMiddleNameTextField, adminPhoneNumberTextField});

        adminPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {adminPasswordTextField, adminUsernameTextField});

        adminPanelLayout.setVerticalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createAdminAccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listOfAdminAccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminPanelLayout.createSequentialGroup()
                        .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adminAccountIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adminAccountIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adminLastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adminLastNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adminFirstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adminFirstNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adminMiddleNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adminMiddleInitialLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adminAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adminAddressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adminPhoneNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adminPhoneNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adminUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adminUsernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adminPasswordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(adminPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adminCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adminSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE))
                .addGap(33, 33, 33))
        );

        adminPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {adminPasswordTextField, adminUsernameTextField});

        adminTabbedPane.addTab("Admin", adminPanel);

        javax.swing.GroupLayout myAccountPanelLayout = new javax.swing.GroupLayout(myAccountPanel);
        myAccountPanel.setLayout(myAccountPanelLayout);
        myAccountPanelLayout.setHorizontalGroup(
            myAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
        );
        myAccountPanelLayout.setVerticalGroup(
            myAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        adminTabbedPane.addTab("My Account", myAccountPanel);

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(adminTabbedPane, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(adminTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
  
    
    private void adminCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminCancelButtonActionPerformed
        clearAdminTextFields();
    }//GEN-LAST:event_adminCancelButtonActionPerformed

    private void adminSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminSaveButtonActionPerformed
        try {
            PreparedStatement preparedStatement = connect.prepareStatement("INSERT IGNORE INTO Admin VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, Integer.parseInt(adminAccountIdTextField.getText()));
            preparedStatement.setString(2, adminLastNameTextField.getText());
            preparedStatement.setString(3, adminFirstNameTextField.getText());
            preparedStatement.setString(4, adminMiddleNameTextField.getText());
            preparedStatement.setString(5, adminAddressTextField.getText());
            preparedStatement.setString(6, adminPhoneNumberTextField.getText());
            preparedStatement.setString(7, adminUsernameTextField.getText());
            preparedStatement.setString(8, adminPasswordTextField.getText());
            preparedStatement.setString(9, "Active");

            preparedStatement.executeUpdate();

            showDataAdminTable();

            adminAccountIdTextField.setText(Integer.toString(adminDatas.get(adminDatas.size()-1).getId() + 1));
            clearAdminTextFields();
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_adminSaveButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed
           
   
    public void clearAdminTextFields(){
        adminLastNameTextField.setText("");
        adminFirstNameTextField.setText("");
        adminMiddleNameTextField.setText("");
        adminLastNameTextField.setText("");
        adminAddressTextField.setText("");
        adminPhoneNumberTextField.setText("");
        adminUsernameTextField.setText("");
        adminPasswordTextField.setText("");
    }
    
    public void showDataAdminTable(){
        try {
            Statement statement = connect.createStatement();

            ResultSet selectAdministrator = statement.executeQuery("SELECT * FROM Admin");

            adminDatas.clear();
            while (selectAdministrator.next()) {
                adminDatas.add(new AdminData(selectAdministrator.getInt("id"), selectAdministrator.getString("lastname"),
                        selectAdministrator.getString("firstname"), selectAdministrator.getString("middlename"), selectAdministrator.getString("address"),
                        selectAdministrator.getString("phonenumber"), selectAdministrator.getString("username"), selectAdministrator.getString("password"), 
                        selectAdministrator.getString("status")
                ));
            }
        } catch (Exception ex) {
        }
        DefaultTableModel model = (DefaultTableModel) adminTable.getModel();
        Object[] row = new Object[3];
        
        model.setRowCount(0);
        
        for (int i = 0; i < adminDatas.size(); i++) {
            row[0] = adminDatas.get(i).getId();
            row[1] = adminDatas.get(i).getUsername();
            row[2] = adminDatas.get(i).getStatus();
            model.addRow(row);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adminAccountIdLabel;
    private javax.swing.JTextField adminAccountIdTextField;
    private javax.swing.JLabel adminAddressLabel;
    private javax.swing.JTextField adminAddressTextField;
    private javax.swing.JButton adminCancelButton;
    private javax.swing.JLabel adminFirstNameLabel;
    private javax.swing.JTextField adminFirstNameTextField;
    private javax.swing.JLabel adminLastNameLabel;
    private javax.swing.JTextField adminLastNameTextField;
    private javax.swing.JLabel adminMiddleInitialLabel;
    private javax.swing.JTextField adminMiddleNameTextField;
    private javax.swing.JPanel adminPanel;
    private javax.swing.JLabel adminPasswordLabel;
    private javax.swing.JPasswordField adminPasswordTextField;
    private javax.swing.JLabel adminPhoneNumberLabel;
    private javax.swing.JTextField adminPhoneNumberTextField;
    private javax.swing.JButton adminSaveButton;
    private javax.swing.JTabbedPane adminTabbedPane;
    private javax.swing.JTable adminTable;
    private javax.swing.JLabel adminUsernameLabel;
    private javax.swing.JTextField adminUsernameTextField;
    private javax.swing.JPanel billingPanel;
    private javax.swing.JPanel clientPanel;
    private javax.swing.JLabel createAdminAccountLabel;
    private javax.swing.JPanel homePanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel listOfAdminAccountLabel;
    private javax.swing.JButton logoutButton;
    private javax.swing.JPanel myAccountPanel;
    private javax.swing.JPanel staffPanel;
    // End of variables declaration//GEN-END:variables
}
