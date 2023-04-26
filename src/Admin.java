
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

    public Admin() {
        initComponents();

        connect = DatabaseConnection.connectDatabase();

        new Login(usernameLabel);

        showDataAdminTable();

        adminId.setText(Integer.toString(adminDatas.get(adminDatas.size() - 1).getId() + 1));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adminTabbedPane = new javax.swing.JTabbedPane();
        homePanel = new javax.swing.JPanel();
        billingPanel = new javax.swing.JPanel();
        clientPanel = new javax.swing.JPanel();
        listOfClientAccountLabel = new javax.swing.JLabel();
        staffPanel = new javax.swing.JPanel();
        listOfStaffAccountLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        staffTable = new javax.swing.JTable();
        createStaffAccountLabel = new javax.swing.JLabel();
        staffAccountIdLabel = new javax.swing.JLabel();
        staffLastNameLabel = new javax.swing.JLabel();
        staffFirstNameLabel = new javax.swing.JLabel();
        staffMiddleNameLabel = new javax.swing.JLabel();
        staffAddressLabel = new javax.swing.JLabel();
        staffUsernameLabel = new javax.swing.JLabel();
        staffStatusLabel = new javax.swing.JLabel();
        staffPhoneNumberLabel = new javax.swing.JLabel();
        staffPasswordLabel = new javax.swing.JLabel();
        staffCancelButton = new javax.swing.JButton();
        staffSaveButton = new javax.swing.JButton();
        staffLastNameTextField = new javax.swing.JTextField();
        staffMiddleNameTextField = new javax.swing.JTextField();
        staffAddressTextField = new javax.swing.JTextField();
        staffUsernameTextField = new javax.swing.JTextField();
        staffFirstNameTextField = new javax.swing.JTextField();
        staffPhoneNumberTextField = new javax.swing.JTextField();
        staffPasswordTextField = new javax.swing.JTextField();
        staffId = new javax.swing.JLabel();
        staffStatusComboBox = new javax.swing.JComboBox<>();
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
        adminId = new javax.swing.JLabel();
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
            .addGap(0, 569, Short.MAX_VALUE)
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
            .addGap(0, 569, Short.MAX_VALUE)
        );

        adminTabbedPane.addTab("Billing", billingPanel);

        listOfClientAccountLabel.setFont(new java.awt.Font("sansserif", 1, 28)); // NOI18N
        listOfClientAccountLabel.setText("List of Client Accounts");

        javax.swing.GroupLayout clientPanelLayout = new javax.swing.GroupLayout(clientPanel);
        clientPanel.setLayout(clientPanelLayout);
        clientPanelLayout.setHorizontalGroup(
            clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientPanelLayout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(listOfClientAccountLabel)
                .addContainerGap(267, Short.MAX_VALUE))
        );
        clientPanelLayout.setVerticalGroup(
            clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listOfClientAccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(514, Short.MAX_VALUE))
        );

        adminTabbedPane.addTab("Client", clientPanel);

        listOfStaffAccountLabel.setFont(new java.awt.Font("sansserif", 1, 28)); // NOI18N
        listOfStaffAccountLabel.setText("List of Staff Accounts");

        staffTable.setModel(new javax.swing.table.DefaultTableModel(
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
        staffTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                staffTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(staffTable);
        if (staffTable.getColumnModel().getColumnCount() > 0) {
            staffTable.getColumnModel().getColumn(0).setResizable(false);
            staffTable.getColumnModel().getColumn(4).setResizable(false);
            staffTable.getColumnModel().getColumn(5).setResizable(false);
        }

        createStaffAccountLabel.setFont(new java.awt.Font("sansserif", 1, 28)); // NOI18N
        createStaffAccountLabel.setText("Create Staff Account");

        staffAccountIdLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        staffAccountIdLabel.setText("Account Id");

        staffLastNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        staffLastNameLabel.setText("Last Name:");

        staffFirstNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        staffFirstNameLabel.setText("First Name:");

        staffMiddleNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        staffMiddleNameLabel.setText("Middle Name:");

        staffAddressLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        staffAddressLabel.setText("Address");

        staffUsernameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        staffUsernameLabel.setText("Username:");

        staffStatusLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        staffStatusLabel.setText("Status");

        staffPhoneNumberLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        staffPhoneNumberLabel.setText("Phone Number:");

        staffPasswordLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        staffPasswordLabel.setText("Password:");

        staffCancelButton.setText("Cancel");
        staffCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffCancelButtonActionPerformed(evt);
            }
        });

        staffSaveButton.setText("Save");
        staffSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffSaveButtonActionPerformed(evt);
            }
        });

        staffAddressTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffAddressTextFieldActionPerformed(evt);
            }
        });

        staffId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        staffId.setText("id");

        staffStatusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Deactivated"}));
        staffStatusComboBox.setMinimumSize(new java.awt.Dimension(60, 26));

        javax.swing.GroupLayout staffPanelLayout = new javax.swing.GroupLayout(staffPanel);
        staffPanel.setLayout(staffPanelLayout);
        staffPanelLayout.setHorizontalGroup(
            staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, staffPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(staffMiddleNameLabel)
                    .addComponent(staffAccountIdLabel)
                    .addComponent(staffStatusLabel)
                    .addComponent(staffLastNameLabel)
                    .addComponent(staffAddressLabel)
                    .addComponent(staffUsernameLabel))
                .addGap(33, 33, 33)
                .addGroup(staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(staffUsernameTextField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(staffId, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(staffAddressTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(staffMiddleNameTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(staffLastNameTextField, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addComponent(staffStatusComboBox, 0, 230, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, staffPanelLayout.createSequentialGroup()
                        .addGroup(staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(staffPanelLayout.createSequentialGroup()
                                .addGroup(staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(staffPanelLayout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addComponent(staffFirstNameLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, staffPanelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(staffCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addComponent(staffSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(staffPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(staffPhoneNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(staffFirstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(staffPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(19, 19, 19))
                    .addGroup(staffPanelLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(staffPasswordLabel)
                            .addComponent(staffPhoneNumberLabel))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, staffPanelLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, staffPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, staffPanelLayout.createSequentialGroup()
                        .addComponent(listOfStaffAccountLabel)
                        .addGap(265, 265, 265))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, staffPanelLayout.createSequentialGroup()
                        .addComponent(createStaffAccountLabel)
                        .addGap(245, 245, 245))))
        );
        staffPanelLayout.setVerticalGroup(
            staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staffPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listOfStaffAccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(createStaffAccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(staffPanelLayout.createSequentialGroup()
                        .addGroup(staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(staffFirstNameLabel)
                            .addComponent(staffFirstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(101, 101, 101)
                        .addGroup(staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(staffPasswordLabel)
                            .addComponent(staffPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(staffStatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(staffCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(staffSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(staffPanelLayout.createSequentialGroup()
                        .addGroup(staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(staffId)
                            .addComponent(staffAccountIdLabel))
                        .addGap(18, 18, 18)
                        .addGroup(staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(staffLastNameLabel)
                            .addComponent(staffLastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(staffMiddleNameLabel)
                            .addComponent(staffMiddleNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(staffAddressLabel)
                            .addComponent(staffAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(staffPhoneNumberLabel)
                            .addComponent(staffPhoneNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(staffUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(staffUsernameLabel))
                        .addGap(18, 18, 18)
                        .addComponent(staffStatusLabel)
                        .addGap(13, 13, 13)))
                .addContainerGap(45, Short.MAX_VALUE))
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

        adminStatusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Deactivated"}));
        adminStatusComboBox.setMinimumSize(new java.awt.Dimension(60, 26));

        adminPasswordLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        adminPasswordLabel1.setText("Status: ");

        adminId.setText("Id");

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
                            .addComponent(adminId))))
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
                            .addComponent(adminId))
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
            .addGap(0, 569, Short.MAX_VALUE)
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
        String currentAdminPassword = null;
        boolean isUsernameDuplicate = false;
                
       
        for (AdminData admin : adminDatas) {                        
             if(adminUsernameTextField.getText().equals(admin.getUsername())){
                isUsernameDuplicate = true;
            }
            if (usernameLabel.getText().equals(admin.getUsername())) {
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

    private void adminPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminPanelMousePressed
        Rectangle tableBounds = adminTable.getBounds();
        if (!tableBounds.contains(evt.getPoint())) {
            adminTable.clearSelection();
        }
    }//GEN-LAST:event_adminPanelMousePressed

     int adminRow;
    private void adminTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminTableMouseClicked
        adminRow = adminTable.getSelectedRow();               

        if (!usernameLabel.getText().equals("main_admin")) {
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

    private void staffSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffSaveButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_staffSaveButtonActionPerformed

    private void staffCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffCancelButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_staffCancelButtonActionPerformed

    private void staffTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_staffTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_staffTableMouseClicked

    private void staffAddressTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffAddressTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_staffAddressTextFieldActionPerformed

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
    private javax.swing.JLabel createStaffAccountLabel;
    private javax.swing.JPanel homePanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel listOfAdminAccountLabel;
    private javax.swing.JLabel listOfClientAccountLabel;
    private javax.swing.JLabel listOfStaffAccountLabel;
    private javax.swing.JButton logoutButton;
    private javax.swing.JPanel myAccountPanel;
    private javax.swing.JLabel staffAccountIdLabel;
    private javax.swing.JLabel staffAddressLabel;
    private javax.swing.JTextField staffAddressTextField;
    private javax.swing.JButton staffCancelButton;
    private javax.swing.JLabel staffFirstNameLabel;
    private javax.swing.JTextField staffFirstNameTextField;
    private javax.swing.JLabel staffId;
    private javax.swing.JLabel staffLastNameLabel;
    private javax.swing.JTextField staffLastNameTextField;
    private javax.swing.JLabel staffMiddleNameLabel;
    private javax.swing.JTextField staffMiddleNameTextField;
    private javax.swing.JPanel staffPanel;
    private javax.swing.JLabel staffPasswordLabel;
    private javax.swing.JTextField staffPasswordTextField;
    private javax.swing.JLabel staffPhoneNumberLabel;
    private javax.swing.JTextField staffPhoneNumberTextField;
    private javax.swing.JButton staffSaveButton;
    private javax.swing.JComboBox<String> staffStatusComboBox;
    private javax.swing.JLabel staffStatusLabel;
    private javax.swing.JTable staffTable;
    private javax.swing.JLabel staffUsernameLabel;
    private javax.swing.JTextField staffUsernameTextField;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
