

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
        idLabel1 = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listOfAcccountLabel.setFont(new java.awt.Font("sansserif", 1, 28)); // NOI18N
        listOfAcccountLabel.setText("Create Invoice");

        idLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idLabel.setText("Invoice Id:");

        id.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        id.setText("Invoice Id");

        period.setDateFormatString("yyyy-MM-dd");

        idLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idLabel1.setText("Invoice Period:");

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
        serviceInformationLabel.setText("Service Information");

        meterIdLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        meterIdLabel.setText("Meter Id:");

        meterId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        meterId.setText("Meter Id");

        metereadingDateLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        metereadingDateLabel.setText("Meter Reading Date:");

        metereadingDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        metereadingDate.setText("Meter Reading Date");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(serviceInformationLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(listOfAcccountLabel)
                        .addGap(290, 290, 290))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(idLabel)
                                .addGap(18, 18, 18)
                                .addComponent(id)
                                .addGap(94, 94, 94)
                                .addComponent(idLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(period, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(clientIdLabel)
                                .addGap(18, 18, 18)
                                .addComponent(clientId)
                                .addGap(18, 18, 18)
                                .addComponent(clientNameLabel)
                                .addGap(18, 18, 18)
                                .addComponent(clientName)
                                .addGap(82, 82, 82)
                                .addComponent(addressLabel)
                                .addGap(18, 18, 18)
                                .addComponent(address)
                                .addGap(62, 62, 62)
                                .addComponent(rateclassLabel)
                                .addGap(18, 18, 18)
                                .addComponent(rateclass))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(meterIdLabel)
                                .addGap(18, 18, 18)
                                .addComponent(meterId)
                                .addGap(36, 36, 36)
                                .addComponent(metereadingDateLabel)
                                .addGap(18, 18, 18)
                                .addComponent(metereadingDate)
                                .addGap(357, 357, 357)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listOfAcccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(serviceInformationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(clientIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(clientId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(clientNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(clientName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(2, 2, 2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(period, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(address)
                            .addComponent(rateclassLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rateclass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(meterIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(meterId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(388, 388, 388))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(metereadingDateLabel)
                            .addComponent(metereadingDate))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel clientId;
    private javax.swing.JLabel clientIdLabel;
    private javax.swing.JLabel clientName;
    private javax.swing.JLabel clientNameLabel;
    private javax.swing.JLabel id;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel idLabel1;
    private javax.swing.JLabel listOfAcccountLabel;
    private javax.swing.JLabel meterId;
    private javax.swing.JLabel meterIdLabel;
    private javax.swing.JLabel metereadingDate;
    private javax.swing.JLabel metereadingDateLabel;
    private com.toedter.calendar.JDateChooser period;
    private javax.swing.JLabel rateclass;
    private javax.swing.JLabel rateclassLabel;
    private javax.swing.JLabel serviceInformationLabel;
    // End of variables declaration//GEN-END:variables
}
