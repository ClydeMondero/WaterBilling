
import java.awt.Rectangle;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
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
    
    DefaultComboBoxModel<String> statuses = new DefaultComboBoxModel<>(new String[]{"Active", "Deactivated"});
    JComboBox<String> adminStatus = new JComboBox<>(statuses);
    DefaultCellEditor adminStatusEdittor = new DefaultCellEditor(adminStatus);
    MyTableModelListener adminTableListener = new MyTableModelListener();
    
    public Admin() {
        initComponents();

        connect = DatabaseConnection.connectDatabase();  
        
        new Login(usernameLabel);                

        adminTable.getColumnModel().getColumn(5).setCellEditor(adminStatusEdittor);
        adminTable.getModel().addTableModelListener(adminTableListener);
        
        showDataAdminTable();
        
        adminAccountId.setText(Integer.toString(adminDatas.get(adminDatas.size()-1).getId() + 1));
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
        adminStatusComboBox = new javax.swing.JComboBox<>();
        adminPasswordLabel1 = new javax.swing.JLabel();
        adminAccountId = new javax.swing.JLabel();
        myAccountPanel = new javax.swing.JPanel();
        logoutButton = new javax.swing.JButton();
        usernameLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(820, 680));
        setResizable(false);

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
        adminPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                adminPanelMousePressed(evt);
            }
        });

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
                "Id", "Name", "Address", "Phone Number", "Usename", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(adminTable);
        if (adminTable.getColumnModel().getColumnCount() > 0) {
            adminTable.getColumnModel().getColumn(0).setResizable(false);
            adminTable.getColumnModel().getColumn(4).setResizable(false);
            adminTable.getColumnModel().getColumn(5).setResizable(false);
        }

        adminUsernameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        adminUsernameLabel.setText("Username:");

        adminPasswordLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        adminPasswordLabel.setText("Password:");

        listOfAdminAccountLabel.setFont(new java.awt.Font("sansserif", 1, 28)); // NOI18N
        listOfAdminAccountLabel.setText("List of Admin Accounts");

        adminStatusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Deactivated", " " }));
        adminStatusComboBox.setMinimumSize(new java.awt.Dimension(60, 26));

        adminPasswordLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        adminPasswordLabel1.setText("Status: ");

        adminAccountId.setText("Id");

        javax.swing.GroupLayout adminPanelLayout = new javax.swing.GroupLayout(adminPanel);
        adminPanel.setLayout(adminPanelLayout);
        adminPanelLayout.setHorizontalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminPanelLayout.createSequentialGroup()
                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminPanelLayout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(listOfAdminAccountLabel))
                    .addGroup(adminPanelLayout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(createAdminAccountLabel)))
                .addContainerGap(265, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(adminPanelLayout.createSequentialGroup()
                        .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(adminPasswordLabel1)
                            .addComponent(adminAccountIdLabel)
                            .addComponent(adminLastNameLabel)
                            .addComponent(adminAddressLabel)
                            .addComponent(adminMiddleInitialLabel)
                            .addComponent(adminUsernameLabel))
                        .addGap(22, 22, 22)
                        .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(adminPanelLayout.createSequentialGroup()
                                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(adminLastNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                    .addComponent(adminMiddleNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                    .addComponent(adminAddressTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                    .addComponent(adminUsernameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                    .addComponent(adminStatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(58, 58, 58)
                                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(adminPanelLayout.createSequentialGroup()
                                        .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(adminPasswordLabel)
                                            .addComponent(adminFirstNameLabel)
                                            .addComponent(adminPhoneNumberLabel))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(adminFirstNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                            .addComponent(adminPhoneNumberTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                            .addComponent(adminPasswordTextField)))
                                    .addGroup(adminPanelLayout.createSequentialGroup()
                                        .addComponent(adminCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(adminSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(adminAccountId))))
                .addGap(45, 45, 45))
        );

        adminPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {adminAddressTextField, adminFirstNameTextField, adminLastNameTextField, adminMiddleNameTextField, adminPhoneNumberTextField});

        adminPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {adminPasswordTextField, adminUsernameTextField});

        adminPanelLayout.setVerticalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listOfAdminAccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createAdminAccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(adminPanelLayout.createSequentialGroup()
                        .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adminAccountIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(adminAccountId))
                        .addGap(13, 13, 13)
                        .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adminLastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adminLastNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adminMiddleNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adminMiddleInitialLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adminAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adminAddressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adminUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adminUsernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)))
                    .addGroup(adminPanelLayout.createSequentialGroup()
                        .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adminFirstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adminFirstNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addGap(59, 59, 59)
                        .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adminPhoneNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adminPhoneNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adminPasswordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(adminPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adminStatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adminPasswordLabel1)
                    .addComponent(adminCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adminSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
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

        usernameLabel.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        usernameLabel.setText("Username");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(adminTabbedPane)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(usernameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(adminTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
  
    
    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void adminCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminCancelButtonActionPerformed
        clearAdminTextFields();
    }//GEN-LAST:event_adminCancelButtonActionPerformed

    private void adminSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminSaveButtonActionPerformed
        String adminPassword = null;
        for(AdminData admin : adminDatas){
            if(usernameLabel.getText().equals(admin.getUsername())){
                adminPassword = admin.getPassword();
            }
        }
        String password = JOptionPane.showInputDialog(null, "Enter your password: ", "Save Account", JOptionPane.QUESTION_MESSAGE);
        if (password == null) {
            return;
        } else {
            if (!password.equals(adminPassword)) {
                JOptionPane.showMessageDialog(null, "Incorrect password", "Wrong Password", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                PreparedStatement preparedStatement = connect.prepareStatement("INSERT IGNORE INTO Admin VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
                preparedStatement.setInt(1, Integer.parseInt(adminAccountId.getText()));
                preparedStatement.setString(2, adminLastNameTextField.getText());
                preparedStatement.setString(3, adminFirstNameTextField.getText());
                preparedStatement.setString(4, adminMiddleNameTextField.getText());
                preparedStatement.setString(5, adminAddressTextField.getText());
                preparedStatement.setString(6, adminPhoneNumberTextField.getText());
                preparedStatement.setString(7, adminUsernameTextField.getText());
                preparedStatement.setString(8, adminPasswordTextField.getText());
                preparedStatement.setString(9, adminStatusComboBox.getSelectedItem().toString());

                preparedStatement.executeUpdate();

                showDataAdminTable();

                adminAccountId.setText(Integer.toString(adminDatas.get(adminDatas.size() - 1).getId() + 1));
                clearAdminTextFields();
            } catch (Exception ex) {
            }
        }
    }//GEN-LAST:event_adminSaveButtonActionPerformed

    private void adminPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminPanelMousePressed
        Rectangle tableBounds = adminTable.getBounds();        
        if (!tableBounds.contains(evt.getPoint())) {            
            adminTable.clearSelection();
        }
    }//GEN-LAST:event_adminPanelMousePressed
           
   
    public class MyTableModelListener implements TableModelListener {
        @Override
        public void tableChanged(TableModelEvent e) {
            if (e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();               
                PreparedStatement statement;
                try {
                    statement = connect.prepareStatement("UPDATE Admin SET admin_status = ? WHERE admin_id = ?");
                    statement.setString(1, adminTableModel.getValueAt(row, 5).toString());
                    statement.setString(2, adminTableModel.getValueAt(row, 0).toString());

                    statement.executeUpdate();
                    
                    updateAdminDatas(); 
                                        
                } catch (SQLException ex) {                    
                }               
            }
        }
    }
    
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
    
    public void updateAdminDatas(){
        try {
            Statement statement = connect.createStatement();

            ResultSet selectAdministrator = statement.executeQuery("SELECT * FROM Admin");

            adminDatas.clear();
            while (selectAdministrator.next()) {
                adminDatas.add(new AdminData(selectAdministrator.getInt("admin_id"), selectAdministrator.getString("admin_lastname"),
                        selectAdministrator.getString("admin_firstname"), selectAdministrator.getString("admin_middlename"), selectAdministrator.getString("admin_address"),
                        selectAdministrator.getString("admin_phonenumber"), selectAdministrator.getString("admin_username"), selectAdministrator.getString("admin_password"), 
                        selectAdministrator.getString("admin_status")
                ));
            }
        } catch (Exception ex) {
        }
    }
    
   DefaultTableModel adminTableModel;    
    public void showDataAdminTable(){
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
    private javax.swing.JLabel adminAccountId;
    private javax.swing.JLabel adminAccountIdLabel;
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
    private javax.swing.JLabel adminPasswordLabel1;
    private javax.swing.JPasswordField adminPasswordTextField;
    private javax.swing.JLabel adminPhoneNumberLabel;
    private javax.swing.JTextField adminPhoneNumberTextField;
    private javax.swing.JButton adminSaveButton;
    private javax.swing.JComboBox<String> adminStatusComboBox;
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
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
