package waterbilling;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.PatternSyntaxException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

class Admin {

    private int id;
    private String lastName, firstName, middleName, address, phonNumber;
    private String username, password;
    private String status;

    public Admin(int id, String username, String password, String status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public Admin(int id, String lastName, String firstName, String middleName, String address,
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

public class AdminPanel extends javax.swing.JPanel {        
    
    static ArrayList<Admin> admins = new ArrayList<>();
    Connection connect = null;

    String accountUsername, accountPassword;

    TableRowSorter<TableModel> sorter;

    public AdminPanel(String username, String password) {               
        
        initComponents();
        
        connect = DatabaseConnection.connectDatabase();

        this.accountUsername = username;
        this.accountPassword = password;

        delete.setEnabled(false);

        sorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(sorter);

        search.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateFilter();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateFilter();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateFilter();
            }

        });

        showDataInTable();

        if (!admins.isEmpty()) {
            id.setText(Integer.toString(admins.get(admins.size() - 1).getId() + 1));
        } else {
            this.id.setText("1001");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listOfAcccountLabel = new javax.swing.JLabel();
        scrollpane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        createAccountLabel = new javax.swing.JLabel();
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
        delete = new javax.swing.JButton();
        search = new javax.swing.JTextField();
        refresh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(203, 243, 240));
        setPreferredSize(new java.awt.Dimension(820, 540));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        listOfAcccountLabel.setFont(new java.awt.Font("sansserif", 1, 28)); // NOI18N
        listOfAcccountLabel.setForeground(new java.awt.Color(46, 196, 182));
        listOfAcccountLabel.setText("List of Admin Accounts");

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        scrollpane.setViewportView(table);

        createAccountLabel.setFont(new java.awt.Font("sansserif", 1, 28)); // NOI18N
        createAccountLabel.setForeground(new java.awt.Color(46, 196, 182));
        createAccountLabel.setText("Create / Update Admin Account");

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

        cancel.setBackground(new java.awt.Color(255, 159, 28));
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/waterbilling/images/cancel.png"))); // NOI18N
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        save.setBackground(new java.awt.Color(255, 159, 28));
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/waterbilling/images/save.png"))); // NOI18N
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(255, 159, 28));
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/waterbilling/images/delete.png"))); // NOI18N
        delete.setText("Delete Rows");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        search.setToolTipText("Search");
        search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchFocusGained(evt);
            }
        });

        refresh.setBackground(new java.awt.Color(255, 159, 28));
        refresh.setForeground(new java.awt.Color(255, 255, 255));
        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/waterbilling/images/refresh.png"))); // NOI18N
        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/waterbilling/images/search.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollpane, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
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
                            .addComponent(username)
                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                            .addComponent(phonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(listOfAcccountLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(createAccountLabel)
                        .addGap(56, 56, 56)
                        .addComponent(refresh)))
                .addGap(32, 32, 32))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {address, firstname, lastname, middlename, password, phonenumber, status, username});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(delete)
                        .addComponent(listOfAcccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(scrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createAccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refresh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    int row;
    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        row = table.getSelectedRow();

        if (admins.get(row).getStatus().equals("Deleted")) {
            delete.setEnabled(false);
        } else {
            delete.setEnabled(true);
        }

        id.setText(Integer.toString(admins.get(row).getId()));
        lastname.setText(admins.get(row).getLastName());
        firstname.setText(admins.get(row).getFirstName());
        middlename.setText(admins.get(row).getMiddleName());
        address.setText(admins.get(row).getAddress());
        phonenumber.setText(admins.get(row).getPhonNumber());
        username.setText(admins.get(row).getUsername());
        password.setText(admins.get(row).getPassword());
        status.setSelectedItem(admins.get(row).getStatus());
    }//GEN-LAST:event_tableMouseClicked

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        clearTextFields();
        table.clearSelection();
        delete.setEnabled(false);
    }//GEN-LAST:event_cancelActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        if (checkTextFields() == false) {
            return;
        }

        String suffix = username.getText().toString().substring(username.getText().toString().indexOf("_") + 1);
        if (!suffix.equals("admin")) {
            JOptionPane.showMessageDialog(null, "Username should have a admin suffix!", "Invalid Username", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean isUsernameDuplicate = false;

        for (Admin admin : admins) {
            if (username.getText().equals(admin.getUsername())) {
                isUsernameDuplicate = true;
            }
        }
        if (isUsernameDuplicate && !model.getValueAt(row, 4).toString().equals(username.getText())) {
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
                    try {
                        if (Integer.parseInt(id.getText()) > admins.get(admins.size() - 1).getId()) {
                            PreparedStatement insertStatement;
                            insertStatement = connect.prepareStatement("INSERT IGNORE INTO Admin VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, 1001, 'Created')");
                            insertStatement.setInt(1, Integer.parseInt(id.getText()));
                            insertStatement.setString(2, lastname.getText());
                            insertStatement.setString(3, firstname.getText());
                            insertStatement.setString(4, middlename.getText());
                            insertStatement.setString(5, address.getText());
                            insertStatement.setString(6, phonenumber.getText());
                            insertStatement.setString(7, username.getText());
                            insertStatement.setString(8, this.password.getText());
                            insertStatement.setString(9, status.getSelectedItem().toString());

                            insertStatement.executeUpdate();

                            showDataInTable();

                            id.setText(Integer.toString(admins.get(admins.size() - 1).getId() + 1));
                            clearTextFields();

                            JOptionPane.showMessageDialog(null, "Account Created!", "Create", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            PreparedStatement updateStatement = connect.prepareStatement("UPDATE Admin SET admin_id = ?, admin_lastname = ?, admin_firstname = ?,"
                                    + " admin_middlename = ?, admin_address =  ?, admin_phonenumber = ?, admin_username =  ?, admin_password = ?, admin_status = ?, main_admin_action = 'Updated' WHERE admin_id = ?");
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

                            showDataInTable();

                            id.setText(Integer.toString(admins.get(admins.size() - 1).getId() + 1));

                            clearTextFields();
                            table.clearSelection();
                            delete.setEnabled(false);

                            JOptionPane.showMessageDialog(null, "Account Updated!", "Update", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect password!", "Wrong Password", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_saveActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if (table.getSelectedRowCount() > 0) {
            clearTextFields();
            table.clearSelection();
            delete.setEnabled(false);
        }
        this.requestFocus();
    }//GEN-LAST:event_formMouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        if (admins.get(table.getSelectedRow()).getUsername().equals("main_admin")) {
            JOptionPane.showMessageDialog(null, "Main Admin Account can't be deleted!", "Delete", JOptionPane.ERROR_MESSAGE);
            table.clearSelection();
            clearTextFields();
            delete.setEnabled(false);
            return;
        }

        JPasswordField passwordField = new JPasswordField();
        String password = null;
        int option = JOptionPane.showConfirmDialog(null, passwordField, "Enter your password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            password = passwordField.getText();
            if (password != null) {
                if (password.equals(accountPassword)) {
                    ListSelectionModel selectionModel = table.getSelectionModel();

                    if (selectionModel.getSelectionMode() == ListSelectionModel.MULTIPLE_INTERVAL_SELECTION) {
                        int[] selectedRows = table.getSelectedRows();

                        for (int row : selectedRows) {
                            int id = Integer.parseInt(table.getValueAt(row, 0).toString());
                            try {
                                PreparedStatement deleteStatement = connect.prepareStatement("UPDATE Admin SET admin_status = ? main_admin_action = 'Deleted' WHERE admin_id = ?");
                                deleteStatement.setString(1, "Deleted");
                                deleteStatement.setInt(2, id);

                                deleteStatement.executeUpdate();

                                showDataInTable();
                                clearTextFields();
                                table.clearSelection();
                                delete.setEnabled(false);
                            } catch (SQLException ex) {
                                Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            JOptionPane.showMessageDialog(null, "Account Deleted!", "Delete", JOptionPane.INFORMATION_MESSAGE);

                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect password!", "Wrong Password", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFocusGained
        table.clearSelection();
        delete.setEnabled(false);
    }//GEN-LAST:event_searchFocusGained

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        showDataInTable();
    }//GEN-LAST:event_refreshActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        showDataInTable();
    }//GEN-LAST:event_formComponentShown

    public void clearTextFields() {
        if (!admins.isEmpty()) {
            id.setText(Integer.toString(admins.get(admins.size() - 1).getId() + 1));
        } else {
            this.id.setText("1001");
        }
        lastname.setText("");
        firstname.setText("");
        middlename.setText("");
        address.setText("");
        phonenumber.setText("");
        username.setText("");
        password.setText("");
        status.setSelectedItem("Active");
    }

    public void updateFilter() {
        String text = search.getText();
        if (text.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            try {
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
            } catch (PatternSyntaxException pse) {
            }
        }
    }

    public void updateDatas() {
        try {
            Statement statement = connect.createStatement();

            ResultSet selectStatement = statement.executeQuery("SELECT * FROM Admin");

            admins.clear();
            while (selectStatement.next()) {
                admins.add(new Admin(selectStatement.getInt("admin_id"), selectStatement.getString("admin_lastname"),
                        selectStatement.getString("admin_firstname"), selectStatement.getString("admin_middlename"), selectStatement.getString("admin_address"),
                        selectStatement.getString("admin_phonenumber"), selectStatement.getString("admin_username"), selectStatement.getString("admin_password"),
                        selectStatement.getString("admin_status")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    DefaultTableModel model;

    public void showDataInTable() {
        updateDatas();

        model = (DefaultTableModel) table.getModel();
        Object[] row = new Object[6];

        model.setRowCount(0);

        for (int i = 0; i < admins.size(); i++) {
            row[0] = admins.get(i).getId();
            row[1] = admins.get(i).getFirstName() + " " + admins.get(i).getMiddleName() + " " + admins.get(i).getLastName();
            row[2] = admins.get(i).getAddress();
            row[3] = admins.get(i).getPhonNumber();
            row[4] = admins.get(i).getUsername();
            row[5] = admins.get(i).getStatus();
            model.addRow(row);
        }
    }

    public boolean checkTextFields() {       
        if (lastname.getText().equals("") && firstname.getText().equals("") && address.getText().equals("") && phonenumber.getText().equals("")
                && username.getText().equals("") && password.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Fill up the required fields!", "Admin", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (lastname.getText().equals("") && firstname.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Name is required!", "Name", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (address.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Address is required!", "Address", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (phonenumber.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Phone Number is required!", "Phone Number", JOptionPane.ERROR_MESSAGE);
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
    private javax.swing.JLabel createAccountLabel;
    private javax.swing.JButton delete;
    private javax.swing.JTextField firstname;
    private javax.swing.JLabel firstnameLabel;
    private javax.swing.JLabel id;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField lastname;
    private javax.swing.JLabel lastnameLabel;
    private javax.swing.JLabel listOfAcccountLabel;
    private javax.swing.JTextField middlename;
    private javax.swing.JLabel middlenameLabel;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField phonenumber;
    private javax.swing.JLabel phonenumberLabel;
    private javax.swing.JButton refresh;
    private javax.swing.JButton save;
    private javax.swing.JScrollPane scrollpane;
    private javax.swing.JTextField search;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JTable table;
    private javax.swing.JTextField username;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
