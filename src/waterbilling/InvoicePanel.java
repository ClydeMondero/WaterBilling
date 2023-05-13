package waterbilling;

import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.PatternSyntaxException;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import static waterbilling.ClientPanel.clients;
import static waterbilling.ClientPanel.meters;
import static waterbilling.AdminPanel.admins;
import static waterbilling.StaffPanel.staffs;

class Invoice {

    private int id;
    private String period;
    private double basic, transitory, environmental, maintenance, before, tax, discount, amount;
    private double payment;
    private String paymentDate;
    private String status;
    private int clientId, officerId;

    public Invoice(int id, String period, double basic, double transitory, double environmental, double maintenance, double before, double tax, double discount, double amount, double payment, String paymentDate, String status, int clientId, int officerId) {
        this.id = id;
        this.period = period;
        this.basic = basic;
        this.transitory = transitory;
        this.environmental = environmental;
        this.maintenance = maintenance;
        this.before = before;
        this.tax = tax;
        this.discount = discount;
        this.amount = amount;
        this.payment = payment;
        this.paymentDate = paymentDate;
        this.status = status;
        this.clientId = clientId;
        this.officerId = officerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public double getBasic() {
        return basic;
    }

    public void setBasic(double basic) {
        this.basic = basic;
    }

    public double getTransitory() {
        return transitory;
    }

    public void setTransitory(double transitory) {
        this.transitory = transitory;
    }

    public double getEnvironmental() {
        return environmental;
    }

    public void setEnvironmental(double environmental) {
        this.environmental = environmental;
    }

    public double getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(double maintenance) {
        this.maintenance = maintenance;
    }

    public double getBefore() {
        return before;
    }

    public void setBefore(double before) {
        this.before = before;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getOfficerId() {
        return officerId;
    }

    public void setOfficerId(int officerId) {
        this.officerId = officerId;
    }

}

public class InvoicePanel extends javax.swing.JPanel {

    Connection connect = null;

    static ArrayList<Invoice> invoices = new ArrayList<>();

    String accountUsername, accountPassword;

    GroupLayout layout = new javax.swing.GroupLayout(this);

    TableRowSorter<TableModel> sorter;

    public InvoicePanel(String username, String password) {
        initComponents();

        accountUsername = username;
        accountPassword = password;

        connect = DatabaseConnection.connectDatabase();

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

        String suffix = accountUsername.substring(accountUsername.indexOf("_") + 1);
        if (suffix.equals("cashier")) {
            createInvoice.setEnabled(false);
            createInvoice.setText("Cancel");
        }

        showDataInTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollpane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        listOfAcccountLabel = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        createInvoice = new javax.swing.JButton();
        payInvoice = new javax.swing.JButton();
        refresh = new javax.swing.JButton();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Client Name", "Invoice Id", "Due Date", "Amount", "Payment Date", "Status"
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

        listOfAcccountLabel.setFont(new java.awt.Font("sansserif", 1, 28)); // NOI18N
        listOfAcccountLabel.setText("List of Invoices");

        search.setToolTipText("Search");

        createInvoice.setText("Create Invoice");
        createInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createInvoiceActionPerformed(evt);
            }
        });

        payInvoice.setText("Pay Invoice");
        payInvoice.setEnabled(false);
        payInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payInvoiceActionPerformed(evt);
            }
        });

        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
    
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(refresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(listOfAcccountLabel)
                        .addGap(304, 304, 304))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(createInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(payInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(36, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addComponent(scrollpane, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(36, 36, 36)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listOfAcccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refresh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 410, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(payInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(scrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(92, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void updateDatas() {
        try {
            Statement statement = connect.createStatement();
            Statement statement2 = connect.createStatement();

            ResultSet selectStatementStaff = statement.executeQuery("SELECT * FROM Invoice\n"
                    + "JOIN Client ON Invoice.client_id = Client.client_id\n"
                    + "JOIN Staff ON Invoice.staff_id = Staff.staff_id ");

            ResultSet selectStatementAdmin = statement2.executeQuery("SELECT * FROM Invoice\n"
                    + "JOIN Client ON Invoice.client_id = Client.client_id\n"
                    + "JOIN Admin ON Invoice.admin_id = Admin.admin_id ");

            invoices.clear();
            while (selectStatementStaff.next()) {
                invoices.add(new Invoice(selectStatementStaff.getInt("invoice_id"), selectStatementStaff.getString("invoice_period_date"),
                        selectStatementStaff.getDouble("invoice_basic_charge"), selectStatementStaff.getDouble("invoice_transitory_charge"),
                        selectStatementStaff.getDouble("invoice_environmental_charge"), selectStatementStaff.getDouble("invoice_maintenance_charge"),
                        selectStatementStaff.getDouble("invoice_before_tax"), selectStatementStaff.getDouble("invoice_tax"),
                        selectStatementStaff.getDouble("invoice_discount"), selectStatementStaff.getDouble("invoice_amount"),
                        selectStatementStaff.getDouble("invoice_payment"), selectStatementStaff.getString("invoice_payment_date"), selectStatementStaff.getString("invoice_status"),
                        selectStatementStaff.getInt("client_id"), selectStatementStaff.getInt("staff_id")));
            }
            while (selectStatementAdmin.next()) {
                invoices.add(new Invoice(selectStatementAdmin.getInt("invoice_id"), selectStatementAdmin.getString("invoice_period_date"),
                        selectStatementAdmin.getDouble("invoice_basic_charge"), selectStatementAdmin.getDouble("invoice_transitory_charge"),
                        selectStatementAdmin.getDouble("invoice_environmental_charge"), selectStatementAdmin.getDouble("invoice_maintenance_charge"),
                        selectStatementAdmin.getDouble("invoice_before_tax"), selectStatementAdmin.getDouble("invoice_tax"),
                        selectStatementAdmin.getDouble("invoice_discount"), selectStatementAdmin.getDouble("invoice_amount"),
                        selectStatementAdmin.getDouble("invoice_payment"), selectStatementAdmin.getString("invoice_payment_date"), selectStatementAdmin.getString("invoice_status"),
                        selectStatementAdmin.getInt("client_id"), selectStatementAdmin.getInt("admin_id")));
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

        String clientName = "";
        for (int i = 0; i < invoices.size(); i++) {
            for (Client client : clients) {
                if (invoices.get(i).getClientId() == client.getId()) {
                    clientName = client.getFirstname() + " " + client.getMiddlename() + " " + client.getLastname();
                }
            }
            row[0] = clientName;
            row[1] = invoices.get(i).getId();
            row[2] = invoices.get(i).getPeriod();
            row[3] = invoices.get(i).getAmount();
            row[4] = invoices.get(i).getPaymentDate();
            row[5] = invoices.get(i).getStatus();
            model.addRow(row);
        }
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

    private void createInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createInvoiceActionPerformed
        String suffix = accountUsername.substring(accountUsername.indexOf("_") + 1);
        if (suffix.equals("cashier")) {
            if (table.getSelectedRowCount() > 0) {
                table.clearSelection();
                createInvoice.setEnabled(false);
                payInvoice.setEnabled(false);
            }
            this.requestFocus();
        } else {
            String clientName = JOptionPane.showInputDialog(null, "Enter client name: ", "Create Invoice");
            
            int id = 0;
            boolean isExisting = false;
            if (clientName != null ) {
                for (Client c : clients) {
                    if (clientName.equals(c.getFirstname() + " " + c.getMiddlename() + " " + c.getLastname())) {
                        isExisting = true;
                        id = c.getId();
                    }
                }

                if (isExisting == false) {
                    JOptionPane.showMessageDialog(null, "Client name not found!", "Create Invoice", JOptionPane.WARNING_MESSAGE);
                } else {
                    new CreateInvoice(id, accountUsername, accountPassword).setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Client name is required", "Create Invoice", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
    }//GEN-LAST:event_createInvoiceActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if (table.getSelectedRowCount() > 0) {
            table.clearSelection();
            String suffix = accountUsername.substring(accountUsername.indexOf("_") + 1);
            if (suffix.equals("cashier")) {
                createInvoice.setEnabled(false);
            } else {
                createInvoice.setEnabled(true);
            }
            payInvoice.setEnabled(false);
        }
        this.requestFocus();
    }//GEN-LAST:event_formMouseClicked

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        String suffix = accountUsername.substring(accountUsername.indexOf("_") + 1);
        if (suffix.equals("cashier")) {
            createInvoice.setEnabled(true);
        } else {
            createInvoice.setEnabled(false);
        }
        payInvoice.setEnabled(true);
    }//GEN-LAST:event_tableMouseClicked

    private void payInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payInvoiceActionPerformed
        int row = table.getSelectedRow();
        Object id = table.getValueAt(row, 1);

        new PayInvoice(Integer.parseInt(id.toString()), accountUsername, accountPassword).setVisible(true);

        createInvoice.setEnabled(true);
        payInvoice.setEnabled(false);

        showDataInTable();
    }//GEN-LAST:event_payInvoiceActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        showDataInTable();
    }//GEN-LAST:event_refreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createInvoice;
    private javax.swing.JLabel listOfAcccountLabel;
    private javax.swing.JButton payInvoice;
    private javax.swing.JButton refresh;
    private javax.swing.JScrollPane scrollpane;
    private javax.swing.JTextField search;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
