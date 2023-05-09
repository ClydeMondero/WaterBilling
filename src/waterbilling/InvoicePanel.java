package waterbilling;

class Invoice{
    private int id;
    private double amount;
    private String period;
    private double payment;
    private String paymentDate;
    private String status;
    private int clientId, officerId;

    public Invoice(int id, double amount, String period, double payment, String paymentDate, String status, int clientId, int officerId) {
        this.id = id;
        this.amount = amount;
        this.period = period;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
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

    
    public InvoicePanel() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        save = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        createAccountLabel = new javax.swing.JLabel();
        scrollpane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        listOfAcccountLabel = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        paymentLabel = new javax.swing.JLabel();
        payment = new javax.swing.JTextField();
        invoicePeriod2 = new javax.swing.JLabel();
        period2 = new javax.swing.JLabel();
        basiclabel = new javax.swing.JLabel();
        basic = new javax.swing.JLabel();
        sewerageLabel = new javax.swing.JLabel();
        sewerage = new javax.swing.JLabel();
        transitorylabel = new javax.swing.JLabel();
        transitory = new javax.swing.JLabel();
        environmentalLabel = new javax.swing.JLabel();
        environmental = new javax.swing.JLabel();
        maintenanceLabel = new javax.swing.JLabel();
        maintenance = new javax.swing.JLabel();
        beforetaxLabel = new javax.swing.JLabel();
        beforeTax = new javax.swing.JLabel();
        taxLabel = new javax.swing.JLabel();
        tax = new javax.swing.JLabel();
        isDiscounted = new javax.swing.JCheckBox();
        discount = new javax.swing.JLabel();
        totalamountLabel = new javax.swing.JLabel();
        totalamount = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        save.setText("Save");

        cancel.setText("Cancel");

        createAccountLabel.setFont(new java.awt.Font("sansserif", 1, 28)); // NOI18N
        createAccountLabel.setText("Pay Invoice");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Client Name", "Invoice Id", "Invoice Date", "Due Date", "Amount", "Payment Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollpane.setViewportView(table);

        listOfAcccountLabel.setFont(new java.awt.Font("sansserif", 1, 28)); // NOI18N
        listOfAcccountLabel.setText("List of Invoices");

        search.setToolTipText("Search");

        paymentLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        paymentLabel.setText("Payment:");

        invoicePeriod2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        invoicePeriod2.setText("Invoice Period:");

        period2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        period2.setText("Invoice Period");

        basiclabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        basiclabel.setText("Basic Charge:");

        basic.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        basic.setText("₱0.0");

        sewerageLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sewerageLabel.setText("Sewerage Charge:");

        sewerage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sewerage.setText("₱0.0");

        transitorylabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        transitorylabel.setText("Transitory Charge:");

        transitory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        transitory.setText("₱0.0");

        environmentalLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        environmentalLabel.setText("Environmental Charge:");

        environmental.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        environmental.setText("₱0.0");

        maintenanceLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        maintenanceLabel.setText("Maintenance Charge:");

        maintenance.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        maintenance.setText("₱0.0");

        beforetaxLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        beforetaxLabel.setText("Charges Before Tax:");

        beforeTax.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        beforeTax.setText("₱0.0");

        taxLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        taxLabel.setText("Tax:");

        tax.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tax.setText("₱0.0");

        isDiscounted.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        isDiscounted.setText("Discount:");

        discount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        discount.setText("₱0.0");

        totalamountLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        totalamountLabel.setText("Total Amount:");

        totalamount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        totalamount.setText("₱0.0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(invoicePeriod2)
                        .addGap(18, 18, 18)
                        .addComponent(period2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(basiclabel)
                        .addGap(18, 18, 18)
                        .addComponent(basic, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(534, 534, 534)
                        .addComponent(sewerageLabel)
                        .addGap(22, 22, 22)
                        .addComponent(sewerage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(transitorylabel)
                        .addGap(18, 18, 18)
                        .addComponent(transitory, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addComponent(environmentalLabel)
                        .addGap(18, 18, 18)
                        .addComponent(environmental, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(maintenanceLabel)
                        .addGap(18, 18, 18)
                        .addComponent(maintenance, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(beforetaxLabel)
                        .addGap(18, 18, 18)
                        .addComponent(beforeTax, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(taxLabel)
                        .addGap(18, 18, 18)
                        .addComponent(tax, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(175, 175, 175)
                        .addComponent(totalamountLabel)
                        .addGap(18, 18, 18)
                        .addComponent(totalamount, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(paymentLabel)
                            .addGap(18, 18, 18)
                            .addComponent(payment, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(isDiscounted)
                            .addGap(18, 18, 18)
                            .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(createAccountLabel)
                        .addGap(29, 29, 29))
                    .addComponent(listOfAcccountLabel))
                .addGap(304, 304, 304))
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
                .addComponent(listOfAcccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158)
                .addComponent(createAccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sewerageLabel)
                        .addComponent(sewerage))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(invoicePeriod2)
                        .addComponent(period2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(basiclabel)
                        .addComponent(basic)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(environmentalLabel)
                        .addComponent(environmental)
                        .addComponent(transitorylabel)
                        .addComponent(transitory))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(maintenanceLabel)
                        .addComponent(maintenance)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(beforetaxLabel)
                            .addComponent(beforeTax))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(taxLabel)
                            .addComponent(tax)))
                    .addComponent(totalamountLabel)
                    .addComponent(totalamount))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paymentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(payment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(discount)
                    .addComponent(isDiscounted))
                .addGap(19, 19, 19))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(scrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(336, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel basic;
    private javax.swing.JLabel basiclabel;
    private javax.swing.JLabel beforeTax;
    private javax.swing.JLabel beforetaxLabel;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel createAccountLabel;
    private javax.swing.JLabel discount;
    private javax.swing.JLabel environmental;
    private javax.swing.JLabel environmentalLabel;
    private javax.swing.JLabel invoicePeriod2;
    private javax.swing.JCheckBox isDiscounted;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel listOfAcccountLabel;
    private javax.swing.JLabel maintenance;
    private javax.swing.JLabel maintenanceLabel;
    private javax.swing.JTextField payment;
    private javax.swing.JLabel paymentLabel;
    private javax.swing.JLabel period2;
    private javax.swing.JButton save;
    private javax.swing.JScrollPane scrollpane;
    private javax.swing.JTextField search;
    private javax.swing.JLabel sewerage;
    private javax.swing.JLabel sewerageLabel;
    private javax.swing.JTable table;
    private javax.swing.JLabel tax;
    private javax.swing.JLabel taxLabel;
    private javax.swing.JLabel totalamount;
    private javax.swing.JLabel totalamountLabel;
    private javax.swing.JLabel transitory;
    private javax.swing.JLabel transitorylabel;
    // End of variables declaration//GEN-END:variables
}
