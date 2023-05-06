

public class CreateInvoice extends javax.swing.JFrame {

    public CreateInvoice() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listOfAcccountLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        period = new com.toedter.calendar.JDateChooser();
        invoiceperiodLabel = new javax.swing.JLabel();
        clientIdLabel = new javax.swing.JLabel();
        clientId = new javax.swing.JLabel();
        clientNameLabel = new javax.swing.JLabel();
        clientName = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        rateclassLabel = new javax.swing.JLabel();
        rateclass = new javax.swing.JLabel();
        serviceInformationLabel = new javax.swing.JLabel();
        meterIdLabel = new javax.swing.JLabel();
        meterId = new javax.swing.JLabel();
        metereadingDateLabel = new javax.swing.JLabel();
        metereadingDate = new javax.swing.JLabel();
        previousreadingLabel = new javax.swing.JLabel();
        previousreading = new javax.swing.JLabel();
        presentreadingLabel = new javax.swing.JLabel();
        serviceInformationLabel1 = new javax.swing.JLabel();
        presentreading = new javax.swing.JPasswordField();
        presentreadingLabel1 = new javax.swing.JLabel();
        presentreading1 = new javax.swing.JPasswordField();
        serviceInformationLabel2 = new javax.swing.JLabel();
        invoicePeriod2 = new javax.swing.JLabel();
        period2 = new javax.swing.JLabel();
        invoicePeriod3 = new javax.swing.JLabel();
        period3 = new javax.swing.JLabel();
        invoicePeriod4 = new javax.swing.JLabel();
        period4 = new javax.swing.JLabel();
        invoicePeriod5 = new javax.swing.JLabel();
        period5 = new javax.swing.JLabel();
        invoicePeriod6 = new javax.swing.JLabel();
        period6 = new javax.swing.JLabel();
        invoicePeriod7 = new javax.swing.JLabel();
        period7 = new javax.swing.JLabel();
        invoicePeriod8 = new javax.swing.JLabel();
        period8 = new javax.swing.JLabel();
        period9 = new javax.swing.JLabel();
        isDiscounted = new javax.swing.JCheckBox();
        period10 = new javax.swing.JLabel();
        period11 = new javax.swing.JLabel();
        period12 = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        save = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(820, 540));
        setResizable(false);

        listOfAcccountLabel.setFont(new java.awt.Font("sansserif", 1, 28)); // NOI18N
        listOfAcccountLabel.setText("Create Invoice");

        idLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idLabel.setText("Invoice Id:");

        id.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        id.setText("Invoice Id");

        period.setDateFormatString("yyyy-MM-dd");

        invoiceperiodLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        invoiceperiodLabel.setText("Invoice Period:");

        clientIdLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        clientIdLabel.setText("Client Id:");

        clientId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        clientId.setText("Client Id");

        clientNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        clientNameLabel.setText("Client Name:");

        clientName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        clientName.setText("Client Name");

        addressLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addressLabel.setText("Address:");

        address.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        address.setText("Address");

        rateclassLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rateclassLabel.setText("Rate Class:");

        rateclass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rateclass.setText("Rate Class");

        serviceInformationLabel.setFont(new java.awt.Font("sansserif", 2, 18)); // NOI18N
        serviceInformationLabel.setText("Meter Information");

        meterIdLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        meterIdLabel.setText("Meter Id:");

        meterId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        meterId.setText("Meter Id");

        metereadingDateLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        metereadingDateLabel.setText("Meter Reading Date:");

        metereadingDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        metereadingDate.setText("Meter Reading Date");

        previousreadingLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        previousreadingLabel.setText("Previous Reading:");

        previousreading.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        previousreading.setText("Previous Reading");

        presentreadingLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        presentreadingLabel.setText("Present Reading:");

        serviceInformationLabel1.setFont(new java.awt.Font("sansserif", 2, 18)); // NOI18N
        serviceInformationLabel1.setText("Client Information");

        presentreadingLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        presentreadingLabel1.setText("Consumption (cu.m):");

        serviceInformationLabel2.setFont(new java.awt.Font("sansserif", 2, 18)); // NOI18N
        serviceInformationLabel2.setText("Invoice Summary");

        invoicePeriod2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        invoicePeriod2.setText("Invoice Period:");

        period2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        period2.setText("Invoice Period");

        invoicePeriod3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        invoicePeriod3.setText("Basic Charge:");

        period3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        period3.setText("Basic Charge");

        invoicePeriod4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        invoicePeriod4.setText("Transitory Charge:");

        period4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        period4.setText("Transitory Charge");

        invoicePeriod5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        invoicePeriod5.setText("Environmental Charge:");

        period5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        period5.setText("Environmental");

        invoicePeriod6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        invoicePeriod6.setText("Maintenance Charge:");

        period6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        period6.setText("Maintenance");

        invoicePeriod7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        period7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        period7.setText("Charges Before Tax:");

        invoicePeriod8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        invoicePeriod8.setText("Tax:");

        period8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        period8.setText("Tax");

        period9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        period9.setText("Discount");

        isDiscounted.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        isDiscounted.setText("Discount:");

        period10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        period10.setText("Before Tax");

        period11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        period11.setText("Total Amount:");

        period12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        period12.setText("Total Amount");

        cancel.setText("Cancel");

        save.setText("Save");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(idLabel)
                        .addGap(18, 18, 18)
                        .addComponent(id))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(invoicePeriod2)
                        .addGap(18, 18, 18)
                        .addComponent(period2))
                    .addComponent(serviceInformationLabel2)
                    .addComponent(serviceInformationLabel1)
                    .addComponent(serviceInformationLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(clientIdLabel)
                        .addGap(18, 18, 18)
                        .addComponent(clientId))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addressLabel)
                        .addGap(18, 18, 18)
                        .addComponent(address))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(meterIdLabel)
                        .addGap(18, 18, 18)
                        .addComponent(meterId))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(previousreadingLabel)
                            .addGap(18, 18, 18)
                            .addComponent(previousreading))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(invoicePeriod8)
                            .addGap(18, 18, 18)
                            .addComponent(period8)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(invoicePeriod5)
                        .addGap(18, 18, 18)
                        .addComponent(period5)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(invoiceperiodLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(period, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(metereadingDateLabel)
                        .addGap(18, 18, 18)
                        .addComponent(metereadingDate))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rateclassLabel)
                        .addGap(18, 18, 18)
                        .addComponent(rateclass))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(clientNameLabel)
                        .addGap(18, 18, 18)
                        .addComponent(clientName))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(presentreadingLabel)
                                .addGap(18, 18, 18)
                                .addComponent(presentreading, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(invoicePeriod3)
                                .addGap(18, 18, 18)
                                .addComponent(period3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(invoicePeriod6)
                                .addGap(18, 18, 18)
                                .addComponent(period6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(isDiscounted)
                                .addGap(36, 36, 36)
                                .addComponent(period9)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(period7)
                                .addGap(12, 12, 12)
                                .addComponent(period10))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(period11)
                                .addGap(12, 12, 12)
                                .addComponent(period12))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(presentreadingLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(presentreading1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(invoicePeriod4)
                                .addGap(18, 18, 18)
                                .addComponent(period4)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(invoicePeriod7)
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(listOfAcccountLabel)
                .addGap(302, 302, 302))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(listOfAcccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(period, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(idLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(invoiceperiodLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(2, 2, 2)
                .addComponent(serviceInformationLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clientIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clientId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clientNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clientName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(address)
                    .addComponent(rateclassLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rateclass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(serviceInformationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(meterIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(meterId)
                    .addComponent(metereadingDateLabel)
                    .addComponent(metereadingDate))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(previousreadingLabel)
                            .addComponent(previousreading)
                            .addComponent(presentreadingLabel)
                            .addComponent(presentreading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(presentreadingLabel1)
                            .addComponent(presentreading1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(serviceInformationLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(invoicePeriod2)
                            .addComponent(period2)
                            .addComponent(invoicePeriod3)
                            .addComponent(period3)
                            .addComponent(invoicePeriod4)
                            .addComponent(period4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(invoicePeriod5)
                                .addComponent(period5)
                                .addComponent(invoicePeriod6)
                                .addComponent(period6)
                                .addComponent(period7)
                                .addComponent(period10))
                            .addComponent(invoicePeriod7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(invoicePeriod8)
                            .addComponent(period8)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(period9)
                                    .addComponent(isDiscounted)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(period11)
                                    .addComponent(period12))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel clientId;
    private javax.swing.JLabel clientIdLabel;
    private javax.swing.JLabel clientName;
    private javax.swing.JLabel clientNameLabel;
    private javax.swing.JLabel id;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel invoicePeriod2;
    private javax.swing.JLabel invoicePeriod3;
    private javax.swing.JLabel invoicePeriod4;
    private javax.swing.JLabel invoicePeriod5;
    private javax.swing.JLabel invoicePeriod6;
    private javax.swing.JLabel invoicePeriod7;
    private javax.swing.JLabel invoicePeriod8;
    private javax.swing.JLabel invoiceperiodLabel;
    private javax.swing.JCheckBox isDiscounted;
    private javax.swing.JLabel listOfAcccountLabel;
    private javax.swing.JLabel meterId;
    private javax.swing.JLabel meterIdLabel;
    private javax.swing.JLabel metereadingDate;
    private javax.swing.JLabel metereadingDateLabel;
    private com.toedter.calendar.JDateChooser period;
    private javax.swing.JLabel period10;
    private javax.swing.JLabel period11;
    private javax.swing.JLabel period12;
    private javax.swing.JLabel period2;
    private javax.swing.JLabel period3;
    private javax.swing.JLabel period4;
    private javax.swing.JLabel period5;
    private javax.swing.JLabel period6;
    private javax.swing.JLabel period7;
    private javax.swing.JLabel period8;
    private javax.swing.JLabel period9;
    private javax.swing.JPasswordField presentreading;
    private javax.swing.JPasswordField presentreading1;
    private javax.swing.JLabel presentreadingLabel;
    private javax.swing.JLabel presentreadingLabel1;
    private javax.swing.JLabel previousreading;
    private javax.swing.JLabel previousreadingLabel;
    private javax.swing.JLabel rateclass;
    private javax.swing.JLabel rateclassLabel;
    private javax.swing.JButton save;
    private javax.swing.JLabel serviceInformationLabel;
    private javax.swing.JLabel serviceInformationLabel1;
    private javax.swing.JLabel serviceInformationLabel2;
    // End of variables declaration//GEN-END:variables
}
