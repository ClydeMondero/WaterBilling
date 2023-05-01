
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

class Client {

    private int id;
    private String lastName, firstName, middleName, address, phonenumber;
    private String rateclass;
    private double metersize;
    private int meternumber, meterreading;
    private String status;

    public Client(int id, String lastname, String firstname, String middlename, String address, String phonenumber, String rateclass, double metersize, int meternumber, int meterreading, String status) {
        this.id = id;
        this.lastName = lastname;
        this.firstName = firstname;
        this.middleName = middlename;
        this.address = address;
        this.phonenumber = phonenumber;
        this.rateclass = rateclass;
        this.metersize = metersize;
        this.meternumber = meternumber;
        this.meterreading = meterreading;
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
        return phonenumber;
    }

    public void setPhonNumber(String phonNumber) {
        this.phonenumber = phonNumber;
    }

    public String getRateclass() {
        return rateclass;
    }

    public void setRateclass(String rateclass) {
        this.rateclass = rateclass;
    }

    public double getMetersize() {
        return metersize;
    }

    public void setMetersize(double metersize) {
        this.metersize = metersize;
    }

    public int getMeternumber() {
        return meternumber;
    }

    public void setMeternumber(int meternumber) {
        this.meternumber = meternumber;
    }

    public int getMeterreading() {
        return meterreading;
    }

    public void setMetereading(int metereading) {
        this.meterreading = metereading;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

public class ClientPanel extends javax.swing.JPanel {

    static ArrayList<Client> clients = new ArrayList<>();
    Connection connect = null;

    String accountUsername, accountPassword;

    TableRowSorter<TableModel> sorter;

    public ClientPanel(String username, String password) {
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

        id.setText(Integer.toString(clients.get(clients.size() - 1).getId() + 1));
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
        metersizeLabel = new javax.swing.JLabel();
        metersize = new javax.swing.JTextField();
        meternoLabel = new javax.swing.JLabel();
        meternumber = new javax.swing.JTextField();
        statusLabel = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        cancel = new javax.swing.JButton();
        save = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        search = new javax.swing.JTextField();
        rateclassLabel = new javax.swing.JLabel();
        rateclass = new javax.swing.JComboBox<>();
        meterreadingLabel = new javax.swing.JLabel();
        meterreading = new javax.swing.JTextField();

        listOfAcccountLabel.setFont(new java.awt.Font("sansserif", 1, 28)); // NOI18N
        listOfAcccountLabel.setText("List of Clients ");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Address", "Meter Number", "Rate Class", "Status"
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
        createAccountLabel.setText("Create / Update a Client ");

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

        metersizeLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        metersizeLabel.setText("Meter Size:");

        meternoLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        meternoLabel.setText("Meter Number:");

        statusLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        statusLabel.setText("Status: ");

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Connected", "Disconnected"}));
        status.setMinimumSize(new java.awt.Dimension(60, 26));

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        delete.setText("Delete Selected Rows");
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

        rateclassLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rateclassLabel.setText("Rate Class:");

        rateclass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Residential", "Semi-Business", "Business Group"}));
        rateclass.setMinimumSize(new java.awt.Dimension(60, 26));
        rateclass.setPreferredSize(new java.awt.Dimension(25, 15));

        meterreadingLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        meterreadingLabel.setText("Meter Reading:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(createAccountLabel)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
                            .addComponent(metersizeLabel))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lastname, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(middlename, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(metersize)
                            .addComponent(address, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(id)
                            .addComponent(status, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(meterreadingLabel)
                                .addGap(18, 18, 18)
                                .addComponent(meterreading, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(meternoLabel)
                                    .addComponent(firstnameLabel)
                                    .addComponent(phonenumberLabel)
                                    .addComponent(rateclassLabel))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(meternumber, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(phonenumber)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(rateclass, 0, 214, Short.MAX_VALUE)
                                            .addComponent(firstname)))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111)
                        .addComponent(listOfAcccountLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {address, firstname, lastname, meternumber, meterreading, metersize, middlename, phonenumber, rateclass});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delete)
                    .addComponent(listOfAcccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createAccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(id)
                            .addComponent(rateclass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rateclassLabel))
                        .addGap(12, 12, 12)
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
                            .addComponent(metersize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(metersizeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(firstnameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(meterreadingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(meterreading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phonenumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(meternoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(meternumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusLabel)
                    .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    int row;
    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        row = table.getSelectedRow();

        if (clients.get(row).getStatus().equals("Deleted")) {
            delete.setEnabled(false);
        } else {
            delete.setEnabled(true);
        }

        id.setText(Integer.toString(clients.get(row).getId()));
        lastname.setText(clients.get(row).getLastName());
        firstname.setText(clients.get(row).getFirstName());
        middlename.setText(clients.get(row).getMiddleName());
        address.setText(clients.get(row).getAddress());
        phonenumber.setText(clients.get(row).getPhonNumber());
        rateclass.setSelectedItem(clients.get(row).getRateclass());
        metersize.setText(Double.toString(clients.get(row).getMetersize()));
        meternumber.setText(Integer.toString(clients.get(row).getMeternumber()));
        meterreading.setText(Integer.toString(clients.get(row).getMeterreading()));
        status.setSelectedItem(clients.get(row).getStatus());
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

        boolean isMeternumberDuplicate = false;

        for (Client client : clients) {
            if (meternumber.getText().equals(client.getMeternumber())) {
                isMeternumberDuplicate = true;
            }
        }
        if (isMeternumberDuplicate && !model.getValueAt(row, 3).toString().equals(meternumber.getText())) {
            JOptionPane.showMessageDialog(null, "Meter Number already exist!", "Invalid Meter Number", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JPasswordField passwordField = new JPasswordField();
        String password = null;
        int option = JOptionPane.showConfirmDialog(null, passwordField, "Enter your password:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            password = passwordField.getText();
            if (password != null) {
                if (password.equals(accountPassword)) {
                    try {
                        if (Integer.parseInt(id.getText()) > clients.get(clients.size() - 1).getId()) {
                            PreparedStatement insertStatement = connect.prepareStatement("INSERT IGNORE INTO Client VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                            insertStatement.setInt(1, Integer.parseInt(id.getText()));
                            insertStatement.setString(2, lastname.getText());
                            insertStatement.setString(3, firstname.getText());
                            insertStatement.setString(4, middlename.getText());
                            insertStatement.setString(5, address.getText());
                            insertStatement.setString(6, phonenumber.getText());
                            insertStatement.setString(7, rateclass.getSelectedItem().toString());
                            insertStatement.setDouble(8, Double.parseDouble(metersize.getText()));
                            insertStatement.setInt(9, Integer.parseInt(meternumber.getText()));
                            insertStatement.setInt(10, Integer.parseInt(meterreading.getText()));
                            insertStatement.setString(11, status.getSelectedItem().toString());

                            insertStatement.executeUpdate();

                            showDataInTable();

                            id.setText(Integer.toString(clients.get(clients.size() - 1).getId() + 1));
                            clearTextFields();

                            JOptionPane.showMessageDialog(null, "Client Created!", "Create", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            PreparedStatement updateStatement = connect.prepareStatement("UPDATE Client SET client_id = ?, client_lastname = ?, client_firstname = ?,"
                                    + " client_middlename = ?, client_address =  ?, client_phonenumber = ?, client_rateclass = ?,  client_metersize =  ?, client_meternumber = ?,"
                                    + "client_meterreading = ?, client_status = ? WHERE client_id = ?");                            
                            updateStatement.setInt(1, Integer.parseInt(id.getText()));
                            updateStatement.setString(2, lastname.getText());
                            updateStatement.setString(3, firstname.getText());
                            updateStatement.setString(4, middlename.getText());
                            updateStatement.setString(5, address.getText());
                            updateStatement.setString(6, phonenumber.getText());
                            updateStatement.setString(7, rateclass.getSelectedItem().toString());
                            updateStatement.setDouble(8, Double.parseDouble(metersize.getText()));
                            updateStatement.setInt(9, Integer.parseInt(meternumber.getText()));
                            updateStatement.setInt(10, Integer.parseInt(meterreading.getText()));
                            updateStatement.setString(11, status.getSelectedItem().toString());
                            updateStatement.setInt(12, Integer.parseInt(id.getText()));

                            updateStatement.executeUpdate();

                            showDataInTable();

                            id.setText(Integer.toString(clients.get(clients.size() - 1).getId() + 1));

                            clearTextFields();
                            table.clearSelection();
                            delete.setEnabled(false);

                            JOptionPane.showMessageDialog(null, "Client Updated!", "Update", JOptionPane.INFORMATION_MESSAGE);
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
                                PreparedStatement deleteStatement = connect.prepareStatement("UPDATE Client SET client_status = ? WHERE client_id = ?");
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
                            JOptionPane.showMessageDialog(null, "Client Deleted!", "Delete", JOptionPane.INFORMATION_MESSAGE);

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

    public boolean checkTextFields() {
        if (lastname.getText().equals("") && firstname.getText().equals("") && address.getText().equals("") && phonenumber.getText().equals("")
                && metersize.getText().equals("") && meternumber.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Fill up the required fields!", "Client", JOptionPane.ERROR_MESSAGE);
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
        } else if (metersize.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Meter Size is required!", "Meter Size", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (meternumber.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Meter Number is required!", "Meter Number", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public void updateDatas() {
        try {
            Statement statement = connect.createStatement();

            ResultSet selectStatement = statement.executeQuery("SELECT * FROM Client");

            clients.clear();
            while (selectStatement.next()) {
                clients.add(new Client(selectStatement.getInt("client_id"), selectStatement.getString("client_lastname"),
                        selectStatement.getString("client_firstname"), selectStatement.getString("client_middlename"), selectStatement.getString("client_address"),
                        selectStatement.getString("client_phonenumber"), selectStatement.getString("client_rateclass"), selectStatement.getDouble("client_metersize"), selectStatement.getInt("client_meternumber"),
                        selectStatement.getInt("client_meterreading"), selectStatement.getString("client_status")
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

        for (int i = 0; i < clients.size(); i++) {
            row[0] = clients.get(i).getId();
            row[1] = clients.get(i).getFirstName() + " " + clients.get(i).getMiddleName() + " " + clients.get(i).getLastName();
            row[2] = clients.get(i).getAddress();
            row[3] = clients.get(i).getMeternumber();
            row[4] = clients.get(i).getRateclass();
            row[5] = clients.get(i).getStatus();
            model.addRow(row);
        }
    }

    public void clearTextFields() {
        id.setText(Integer.toString(clients.get(clients.size() - 1).getId() + 1));
        lastname.setText("");
        firstname.setText("");
        middlename.setText("");
        address.setText("");
        phonenumber.setText("");
        rateclass.setSelectedItem("Connected");
        metersize.setText("");
        meternumber.setText("");
        meterreading.setText("");
        status.setSelectedItem("Active");
    }

    public void updateFilter() {
        String text = search.getText();
        if (text.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            try {
                sorter.setRowFilter(RowFilter.regexFilter(text));
            } catch (PatternSyntaxException pse) {
            }
        }
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
    private javax.swing.JTextField lastname;
    private javax.swing.JLabel lastnameLabel;
    private javax.swing.JLabel listOfAcccountLabel;
    private javax.swing.JLabel meternoLabel;
    private javax.swing.JTextField meternumber;
    private javax.swing.JTextField meterreading;
    private javax.swing.JLabel meterreadingLabel;
    private javax.swing.JTextField metersize;
    private javax.swing.JLabel metersizeLabel;
    private javax.swing.JTextField middlename;
    private javax.swing.JLabel middlenameLabel;
    private javax.swing.JTextField phonenumber;
    private javax.swing.JLabel phonenumberLabel;
    private javax.swing.JComboBox<String> rateclass;
    private javax.swing.JLabel rateclassLabel;
    private javax.swing.JButton save;
    private javax.swing.JScrollPane scrollpane;
    private javax.swing.JTextField search;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
