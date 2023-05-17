package waterbilling;

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
import static waterbilling.AdminPanel.admins;

class Staff {

    private int id;
    private String lastName, firstName, middleName, address, phonNumber;
    private String username, password;
    private String status;

    public Staff(int id, String username, String password, String status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public Staff(int id, String lastName, String firstName, String middleName, String address,
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

public class StaffPanel extends javax.swing.JPanel {

    static ArrayList<Staff> staffs = new ArrayList<>();
    Connection connect = null;

    String accountUsername, accountPassword;

    int accountId;

    TableRowSorter<TableModel> sorter;

    public StaffPanel(String username, String password) {
        initComponents();

        connect = DatabaseConnection.connectDatabase();

        this.accountUsername = username;
        this.accountPassword = password;

        for (Admin admin : admins) {
            if (accountUsername.equals(admin.getUsername())) {
                accountId = admin.getId();
            }
        }

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

        if (!staffs.isEmpty()) {
            id.setText(Integer.toString(staffs.get(staffs.size() - 1).getId() + 1));
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
        usernameLabel = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        statusLabel = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        cancel = new javax.swing.JButton();
        save = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        search = new javax.swing.JTextField();
        refresh = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        phonenumberLabel = new javax.swing.JLabel();
        phonenumber = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        passwordLabel2 = new javax.swing.JLabel();
        password2 = new javax.swing.JPasswordField();
        permission = new javax.swing.JCheckBox();
        show = new javax.swing.JToggleButton();
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
        listOfAcccountLabel.setText("List of Staff Accounts");

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
        createAccountLabel.setText("Create / Update Staff Account");

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

        usernameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        usernameLabel.setText("Username:");

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

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/waterbilling/images/search.png"))); // NOI18N

        phonenumberLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        phonenumberLabel.setText("Phone Number:");

        passwordLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        passwordLabel.setText("Password:");

        passwordLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        passwordLabel2.setText("Confirm Password:");

        permission.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        permission.setText("Update Passord Permission");
        permission.setEnabled(false);
        permission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                permissionActionPerformed(evt);
            }
        });

        show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/waterbilling/images/eye.png"))); // NOI18N
        show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showActionPerformed(evt);
            }
        });

        jLabel1.setText("Show Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(firstnameLabel)
                                        .addGap(33, 33, 33)
                                        .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(passwordLabel2)
                                                .addGap(2, 2, 2))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(passwordLabel)
                                                    .addComponent(phonenumberLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(password2)
                                            .addComponent(password)
                                            .addComponent(phonenumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(permission)
                                        .addGap(18, 18, 18)
                                        .addComponent(show, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1))))
                            .addComponent(scrollpane, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(228, 228, 228)
                                        .addComponent(listOfAcccountLabel))
                                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(createAccountLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refresh)))
                .addGap(32, 32, 32))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {address, firstname, lastname, middlename, status, username});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel2))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phonenumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(permission)
                            .addComponent(show, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(passwordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(passwordLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(password2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)))
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

        if (staffs.get(row).getStatus().equals("Deleted")) {
            delete.setEnabled(false);
        } else {
            delete.setEnabled(true);
        }

        id.setText(Integer.toString(staffs.get(row).getId()));
        lastname.setText(staffs.get(row).getLastName());
        firstname.setText(staffs.get(row).getFirstName());
        middlename.setText(staffs.get(row).getMiddleName());
        address.setText(staffs.get(row).getAddress());
        phonenumber.setText(staffs.get(row).getPhonNumber());
        username.setText(staffs.get(row).getUsername());

        permission.setEnabled(true);

        password.setText(staffs.get(row).getPassword());
        password.setEnabled(false);
        password2.setText(staffs.get(row).getPassword());
        password2.setEnabled(false);
        status.setSelectedItem(staffs.get(row).getStatus());

        System.out.println(password2.getText());

    }//GEN-LAST:event_tableMouseClicked

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        reset();
    }//GEN-LAST:event_cancelActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        if (checkTextFields() == false) {
            return;
        }

        if (!password.getText().equals(password2.getText())) {
            JOptionPane.showMessageDialog(null, "Password don't match!", "Password Mismatch", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String suffix = username.getText().toString().substring(username.getText().toString().indexOf("_") + 1);
        if (!suffix.equals("staff")) {
            JOptionPane.showMessageDialog(null, "Username should have a staff suffix!", "Invalid Username", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean isUsernameDuplicate = false;

        for (Staff staff : staffs) {
            if (username.getText().equals(staff.getUsername())) {
                isUsernameDuplicate = true;
            }
        }
        if (isUsernameDuplicate && !model.getValueAt(row, 4).toString().equals(username.getText())) {
            JOptionPane.showMessageDialog(null, "Username already exist!", "Invalid Username", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JPasswordField passwordField = new JPasswordField();
        String password = "";
        int option = JOptionPane.showConfirmDialog(null, passwordField, "Enter your password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            password = passwordField.getText();
            if (password != null) {
                if (password.equals(accountPassword)) {
                    try {
                        if (Integer.parseInt(id.getText()) > staffs.get(staffs.size() - 1).getId()) {
                            PreparedStatement insertStatement;
                            insertStatement = connect.prepareStatement("INSERT IGNORE INTO Staff VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
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

                            insertStatement = connect.prepareStatement("INSERT IGNORE INTO AdminsStaffs VALUES (?, ?, ?)");

                            insertStatement.setInt(1, Integer.parseInt(id.getText()));
                            insertStatement.setInt(2, accountId);
                            insertStatement.setString(3, "Created");

                            insertStatement.executeUpdate();

                            showDataInTable();

                            id.setText(Integer.toString(staffs.get(staffs.size() - 1).getId() + 1));
                            clearTextFields();

                            JOptionPane.showMessageDialog(null, "Account Created!", "Create", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            PreparedStatement updateStatement = connect.prepareStatement("UPDATE Staff SET staff_id = ?, staff_lastname = ?, staff_firstname = ?,"
                                    + " staff_middlename = ?, staff_address =  ?, staff_phonenumber = ?, staff_username =  ?, staff_password = ?, staff_status = ?"
                                    + " WHERE staff_id = ?");
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

                            updateStatement = connect.prepareStatement("INSERT IGNORE INTO AdminsStaffs VALUES (?, ?, ?)");

                            updateStatement.setInt(1, Integer.parseInt(id.getText()));
                            updateStatement.setInt(2, accountId);
                            updateStatement.setString(3, "Updated");

                            updateStatement.executeUpdate();

                            showDataInTable();

                            id.setText(Integer.toString(staffs.get(staffs.size() - 1).getId() + 1));

                            reset();

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
            reset();
        }
        this.requestFocus();
    }//GEN-LAST:event_formMouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
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
                                PreparedStatement deleteStatement = connect.prepareStatement("UPDATE Staff SET staff_status = ? WHERE staff_id = ?");
                                deleteStatement.setString(1, "Deleted");
                                deleteStatement.setInt(2, id);

                                deleteStatement.executeUpdate();

                                deleteStatement = connect.prepareStatement("INSERT IGNORE INTO AdminsStaffs VALUES (?, ?, ?)");

                                deleteStatement.setInt(1, Integer.parseInt(this.id.getText()));
                                deleteStatement.setInt(2, accountId);
                                deleteStatement.setString(3, "Deleted");

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

    private void permissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_permissionActionPerformed
        if (permission.isSelected()) {
            JPasswordField passwordField = new JPasswordField();
            String p = null;
            int option = JOptionPane.showConfirmDialog(null, passwordField, "Enter account password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

            String permissionPassword = "";

            for (Staff staff : staffs) {
                if (staff.getId() == Integer.parseInt(model.getValueAt(row, 0).toString())) {
                    permissionPassword = staff.getPassword();
                }
            }

            if (option == JOptionPane.OK_OPTION) {
                p = passwordField.getText();
                if (p != null) {
                    if (p.equals(permissionPassword)) {
                        permission.setSelected(true);
                        this.password.setEnabled(true);
                        password2.setEnabled(true);
                        JOptionPane.showMessageDialog(null, "Update password permitted!", "Update Password", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        permission.setSelected(false);
                        this.password.setEnabled(false);
                        password2.setEnabled(false);
                        JOptionPane.showMessageDialog(null, "Incorrect account password!", "Update Password", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        } else {
            permission.setSelected(false);
            this.password.setEnabled(false);
            password2.setEnabled(false);
        }
    }//GEN-LAST:event_permissionActionPerformed

    private void showActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showActionPerformed
        if (password.isEnabled() && password2.isEnabled()) {
            if (show.isSelected()) {
                password.setEchoChar((char) 0);
            } else {
                password.setEchoChar('*');
            }
        }
    }//GEN-LAST:event_showActionPerformed

    public void reset() {
        clearTextFields();
        table.clearSelection();
        delete.setEnabled(false);
        permission.setEnabled(false);
        permission.setSelected(false);
        password.setEnabled(true);
        password2.setEnabled(true);
    }

    public void clearTextFields() {
        if (!staffs.isEmpty()) {
            id.setText(Integer.toString(staffs.get(staffs.size() - 1).getId() + 1));
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
        password2.setText("");
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

            ResultSet selectStatement = statement.executeQuery("SELECT * FROM Staff");

            staffs.clear();
            while (selectStatement.next()) {
                staffs.add(new Staff(selectStatement.getInt("staff_id"), selectStatement.getString("staff_lastname"),
                        selectStatement.getString("staff_firstname"), selectStatement.getString("staff_middlename"), selectStatement.getString("staff_address"),
                        selectStatement.getString("staff_phonenumber"), selectStatement.getString("staff_username"), selectStatement.getString("staff_password"),
                        selectStatement.getString("staff_status")
                ));

            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminPanel.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    DefaultTableModel model;

    public void showDataInTable() {
        updateDatas();

        model = (DefaultTableModel) table.getModel();
        Object[] row = new Object[6];

        model.setRowCount(0);

        for (int i = 0; i < staffs.size(); i++) {
            row[0] = staffs.get(i).getId();
            row[1] = staffs.get(i).getFirstName() + " " + staffs.get(i).getMiddleName() + " " + staffs.get(i).getLastName();
            row[2] = staffs.get(i).getAddress();
            row[3] = staffs.get(i).getPhonNumber();
            row[4] = staffs.get(i).getUsername();
            row[5] = staffs.get(i).getStatus();
            model.addRow(row);
        }
    }

    public boolean checkTextFields() {
        if (lastname.getText().equals("") && firstname.getText().equals("") && address.getText().equals("") && phonenumber.getText().equals("")
                && username.getText().equals("") && password.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Fill up the required fields!", "Staff", JOptionPane.ERROR_MESSAGE);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField lastname;
    private javax.swing.JLabel lastnameLabel;
    private javax.swing.JLabel listOfAcccountLabel;
    private javax.swing.JTextField middlename;
    private javax.swing.JLabel middlenameLabel;
    private javax.swing.JPasswordField password;
    private javax.swing.JPasswordField password2;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel passwordLabel2;
    private javax.swing.JCheckBox permission;
    private javax.swing.JTextField phonenumber;
    private javax.swing.JLabel phonenumberLabel;
    private javax.swing.JButton refresh;
    private javax.swing.JButton save;
    private javax.swing.JScrollPane scrollpane;
    private javax.swing.JTextField search;
    private javax.swing.JToggleButton show;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JTable table;
    private javax.swing.JTextField username;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
