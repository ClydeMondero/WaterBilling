package waterbilling;

import java.util.ArrayList;
import java.util.Date;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import static waterbilling.ClientPanel.clients;
import static waterbilling.ClientPanel.meters;
import static waterbilling.AdminPanel.admins;
import static waterbilling.StaffPanel.staffs;
import static waterbilling.InvoicePanel.invoices;

public class CreateInvoice extends javax.swing.JFrame {

    int client;
    String accountUsername, accountPassword;

    Connection connect = null;

    SimpleDateFormat dateFormat;

    NumberFormat chargeFormat = NumberFormat.getCurrencyInstance();

    Calendar calendar = Calendar.getInstance();

    public CreateInvoice(int id, String username, String password) {
        initComponents();

        client = id;
        accountUsername = username;
        accountPassword = password;

        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, +1);
        period.setDate(calendar.getTime());

        connect = DatabaseConnection.connectDatabase();

        updateDatas();

        if (!invoices.isEmpty()) {
            this.id.setText(Integer.toString(invoices.get(invoices.size() - 1).getId() + 1));
        } else {
            this.id.setText("1001");
        }

        clientId.setText(Integer.toString(client));

        for (Client client : clients) {
            if (this.client == client.getId()) {
                clientName.setText(client.getFirstname() + " " + client.getMiddlename() + " " + client.getLastname() + " ");
                address.setText(client.getAddress());
                rateclass.setText(client.getRateclass());
                for (Meter meter : meters) {
                    if (client.getMeterId().equals(meter.getId())) {
                        meterId.setText(meter.getId());
                        previousreading.setText(Integer.toString(meter.getReading()));
                        metersize = meter.getSize();
                    }
                }
            }
        }

        dateFormat = new SimpleDateFormat("MMMM dd yyyy");
        meterreadingDate.setText(dateFormat.format(period.getDate()));

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(period.getDate());
        calendar.add(Calendar.MONTH, -1);
        period2.setText(dateFormat.format(calendar.getTime()) + " TO " + dateFormat.format(period.getDate()));

        consumption.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                computeBasicCharge();
                basic.setText(chargeFormat.format(basiccharge));

                computeTransitoryCharge();
                transitory.setText(chargeFormat.format(transitorycharge));

                computeEnvironmentalCharge();
                environmental.setText(chargeFormat.format(environmentalcharge));

                computeSewerageCharge();
                sewerage.setText(chargeFormat.format(seweragecharge));

                computeMaintenanceCharge();
                maintenance.setText(chargeFormat.format(maintenancecharge));

                computeTotalBeforeTax();
                beforeTax.setText(chargeFormat.format(totalbeforetax));

                computeTax();
                tax.setText(chargeFormat.format(taxcharge));

                computeTotalAmount();
                amount.setText(chargeFormat.format(total));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                basic.setText(chargeFormat.format(0));
                transitory.setText(chargeFormat.format(0));
                environmental.setText(chargeFormat.format(0));
                sewerage.setText(chargeFormat.format(0));
                maintenance.setText(chargeFormat.format(0));
                beforeTax.setText(chargeFormat.format(0));
                tax.setText(chargeFormat.format(0));
                amount.setText(chargeFormat.format(0));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                computeBasicCharge();
                basic.setText(chargeFormat.format(basiccharge));

                computeTransitoryCharge();
                transitory.setText(chargeFormat.format(transitorycharge));

                computeEnvironmentalCharge();
                environmental.setText(chargeFormat.format(environmentalcharge));

                computeSewerageCharge();
                sewerage.setText(chargeFormat.format(seweragecharge));

                computeMaintenanceCharge();
                maintenance.setText(chargeFormat.format(maintenancecharge));

                computeTotalBeforeTax();
                beforeTax.setText(chargeFormat.format(beforeTax));

                computeTax();
                tax.setText(chargeFormat.format(taxcharge));

                computeTotalAmount();
                amount.setText(chargeFormat.format(total));
            }

        });

        this.setLayout(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
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
        meterreadingDateLabel = new javax.swing.JLabel();
        meterreadingDate = new javax.swing.JLabel();
        previousreadingLabel = new javax.swing.JLabel();
        previousreading = new javax.swing.JLabel();
        presentreadingLabel = new javax.swing.JLabel();
        serviceInformationLabel1 = new javax.swing.JLabel();
        presentreading = new javax.swing.JPasswordField();
        consumptionLabel = new javax.swing.JLabel();
        consumption = new javax.swing.JPasswordField();
        serviceInformationLabel2 = new javax.swing.JLabel();
        invoicePeriod2 = new javax.swing.JLabel();
        period2 = new javax.swing.JLabel();
        basiclabel = new javax.swing.JLabel();
        basic = new javax.swing.JLabel();
        transitorylabel = new javax.swing.JLabel();
        transitory = new javax.swing.JLabel();
        environmentalLabel = new javax.swing.JLabel();
        environmental = new javax.swing.JLabel();
        maintenanceLabel = new javax.swing.JLabel();
        maintenance = new javax.swing.JLabel();
        invoicePeriod7 = new javax.swing.JLabel();
        beforetaxLabel = new javax.swing.JLabel();
        taxLabel = new javax.swing.JLabel();
        tax = new javax.swing.JLabel();
        beforeTax = new javax.swing.JLabel();
        amountLabel = new javax.swing.JLabel();
        amount = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        save = new javax.swing.JButton();
        clientinformationseparator = new javax.swing.JSeparator();
        meterinformationSeparator = new javax.swing.JSeparator();
        invoicesummarySeparator = new javax.swing.JSeparator();
        sewerageLabel = new javax.swing.JLabel();
        sewerage = new javax.swing.JLabel();
        discountCheckBox = new javax.swing.JCheckBox();
        discount = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        titleLabel.setFont(new java.awt.Font("sansserif", 1, 28)); // NOI18N
        titleLabel.setText("Create Invoice");

        idLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idLabel.setText("Invoice Id:");

        id.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        id.setText("Invoice Id");

        period.setDateFormatString("MMMM dd yyyy");

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

        meterreadingDateLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        meterreadingDateLabel.setText("Meter Reading Date:");

        meterreadingDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        meterreadingDate.setText("Meter Reading Date");

        previousreadingLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        previousreadingLabel.setText("Previous Reading:");

        previousreading.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        previousreading.setText("Previous Reading");

        presentreadingLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        presentreadingLabel.setText("Present Reading:");

        serviceInformationLabel1.setFont(new java.awt.Font("sansserif", 2, 18)); // NOI18N
        serviceInformationLabel1.setText("Client Information");

        consumptionLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        consumptionLabel.setText("Consumption (cu.m):");

        serviceInformationLabel2.setFont(new java.awt.Font("sansserif", 2, 18)); // NOI18N
        serviceInformationLabel2.setText("Invoice Summary");

        invoicePeriod2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        invoicePeriod2.setText("Invoice Period:");

        period2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        period2.setText("Invoice Period");

        basiclabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        basiclabel.setText("Basic Charge:");

        basic.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        basic.setText("₱0.0");

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

        invoicePeriod7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        beforetaxLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        beforetaxLabel.setText("Charges Before Tax:");

        taxLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        taxLabel.setText("Tax:");

        tax.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tax.setText("₱0.0");

        beforeTax.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        beforeTax.setText("₱0.0");

        amountLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        amountLabel.setText("Total Amount:");

        amount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        amount.setText("₱0.0");

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

        sewerageLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sewerageLabel.setText("Sewerage Charge:");

        sewerage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sewerage.setText("₱0.0");

        discountCheckBox.setText("Discount:");
        discountCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discountCheckBoxActionPerformed(evt);
            }
        });

        discount.setText("₱0.0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titleLabel)
                .addGap(302, 302, 302))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(serviceInformationLabel)
                        .addGap(5, 5, 5)
                        .addComponent(meterinformationSeparator))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(serviceInformationLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(invoicesummarySeparator))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(transitorylabel)
                                .addGap(18, 18, 18)
                                .addComponent(transitory, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(188, 556, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(meterIdLabel)
                                                .addGap(18, 18, 18)
                                                .addComponent(meterId))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(previousreadingLabel)
                                                .addGap(18, 18, 18)
                                                .addComponent(previousreading)))
                                        .addGap(32, 32, 32)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(meterreadingDateLabel)
                                                .addGap(18, 18, 18)
                                                .addComponent(meterreadingDate, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(presentreadingLabel)
                                                .addGap(18, 18, 18)
                                                .addComponent(presentreading, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(consumptionLabel)
                                                .addGap(18, 18, 18)
                                                .addComponent(consumption, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(32, 32, 32))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(serviceInformationLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(clientinformationseparator))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(idLabel)
                                                .addGap(18, 18, 18)
                                                .addComponent(id)
                                                .addGap(124, 124, 124)
                                                .addComponent(invoiceperiodLabel)
                                                .addGap(18, 18, 18)
                                                .addComponent(period, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(invoicePeriod2)
                                                .addGap(18, 18, 18)
                                                .addComponent(period2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(basiclabel)
                                                .addGap(18, 18, 18)
                                                .addComponent(basic, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(invoicePeriod7))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(clientIdLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(clientId))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(addressLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rateclassLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(rateclass, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(clientNameLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(clientName, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(beforetaxLabel)
                                .addGap(18, 18, 18)
                                .addComponent(beforeTax, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(environmentalLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(environmental, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(taxLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(tax, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(discountCheckBox)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(amountLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(maintenanceLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(maintenance, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(sewerageLabel)
                                        .addGap(22, 22, 22)
                                        .addComponent(sewerage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(period, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(idLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(invoiceperiodLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(serviceInformationLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(invoicesummarySeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clientIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clientId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clientNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clientName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(address)
                    .addComponent(rateclassLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rateclass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(serviceInformationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(meterinformationSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(meterIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(meterId)
                            .addComponent(meterreadingDateLabel)
                            .addComponent(meterreadingDate))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(previousreadingLabel)
                            .addComponent(previousreading)
                            .addComponent(presentreadingLabel)
                            .addComponent(presentreading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(consumptionLabel)
                            .addComponent(consumption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(serviceInformationLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(clientinformationseparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(invoicePeriod2)
                                    .addComponent(period2))
                                .addGap(65, 65, 65))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(basiclabel)
                                    .addComponent(basic))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(environmentalLabel)
                                    .addComponent(environmental)
                                    .addComponent(transitorylabel)
                                    .addComponent(transitory))
                                .addGap(27, 27, 27)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(beforetaxLabel)
                                .addComponent(beforeTax))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(taxLabel)
                                .addComponent(tax)
                                .addComponent(discountCheckBox)
                                .addComponent(discount))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sewerageLabel)
                            .addComponent(sewerage))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(maintenanceLabel)
                            .addComponent(maintenance))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(amountLabel)
                            .addComponent(amount))))
                .addGap(11, 11, 11)
                .addComponent(invoicePeriod7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        period.setDate(null);
        presentreading.setText("");
        consumption.setText("");
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        boolean isInvoicePeriodDuplicate = false;

        for (Invoice invoice : invoices) {
            if (clientId.getText().equals(Integer.toString(invoice.getClientId())) && dateFormat.format(period.getDate()).equals(invoice.getPeriod())) {
                isInvoicePeriodDuplicate = true;
            }
        }
        if (isInvoicePeriodDuplicate == true) {
            JOptionPane.showMessageDialog(null, "Invoice already exist!", "Duplicate Invoice", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JPasswordField passwordField = new JPasswordField();
        String password = null;
        int option = JOptionPane.showConfirmDialog(null, passwordField, "Enter your password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            password = passwordField.getText();
            if (password != null && password.equals(accountPassword)) {
                String suffix = accountUsername.substring(accountUsername.indexOf("_") + 1);
                if (suffix.equals("admin")) {
                    PreparedStatement insertStatement;
                    PreparedStatement updateStatement;
                    try {
                        insertStatement = connect.prepareStatement("INSERT IGNORE INTO Invoice (invoice_id, "
                                + "invoice_period_date, invoice_reading, invoice_consumption, invoice_reconnection_charge, invoice_basic_charge, invoice_transitory_charge, invoice_environmental_charge, "
                                + "invoice_sewerage_charge, invoice_maintenance_charge, "
                                + "invoice_before_tax, invoice_tax, invoice_discount, invoice_amount, invoice_status, client_id, admin_id)"
                                + "VALUES (?, ?, ?, ?, 0, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

                        insertStatement.setInt(1, Integer.parseInt(id.getText()));

                        insertStatement.setString(2, dateFormat.format(period.getDate()));
                        insertStatement.setInt(3, Integer.parseInt(presentreading.getText()));
                        insertStatement.setInt(4, Integer.parseInt(consumption.getText()));
                        insertStatement.setDouble(5, Double.parseDouble(removeCurrency(basic.getText())));
                        insertStatement.setDouble(6, Double.parseDouble(removeCurrency(transitory.getText())));
                        insertStatement.setDouble(7, Double.parseDouble(removeCurrency(environmental.getText())));
                        insertStatement.setDouble(8, Double.parseDouble(removeCurrency(sewerage.getText())));
                        insertStatement.setDouble(9, Double.parseDouble(removeCurrency(maintenance.getText())));
                        insertStatement.setDouble(10, Double.parseDouble(removeCurrency(beforeTax.getText())));
                        insertStatement.setDouble(11, Double.parseDouble(removeCurrency(tax.getText())));
                        insertStatement.setDouble(12, Double.parseDouble(removeCurrency(discount.getText())));
                        insertStatement.setDouble(13, Double.parseDouble(removeCurrency(amount.getText())));
                        insertStatement.setString(14, "Unpaid");
                        insertStatement.setInt(15, client);

                        int adminId = 0;
                        for (Admin admin : admins) {
                            if (accountUsername.equals(admin.getUsername())) {
                                adminId = admin.getId();
                            }
                        }
                                                
                        insertStatement.setInt(16, adminId);

                        insertStatement.executeUpdate();

                        updateStatement = connect.prepareStatement("UPDATE Meter SET meter_reading_date = ?, meter_reading = ?, "
                                + "meter_consumption = ? WHERE meter_id = ?");

                        updateStatement.setString(1, dateFormat.format(period.getDate()));
                        updateStatement.setInt(2, Integer.parseInt(presentreading.getText()));
                        
                        
                        int meterIndex = 0;
                        for (Meter meter : meters) {
                            if(meter.getId().equals(meterId.getText())){
                                 meterIndex = meters.indexOf(meter);
                            }
                        }
                        
                        updateStatement.setInt(3, meters.get(meterIndex).getConsumption() + Integer.parseInt(consumption.getText()));
                        updateStatement.setString(4, meterId.getText());

                        updateStatement.executeUpdate();

                    } catch (SQLException ex) {
                        Logger.getLogger(CreateInvoice.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    updateDatas();                                                           
                    
                    this.dispose();

                    JOptionPane.showMessageDialog(null, "Invoice Created!", "Create Invoice", JOptionPane.INFORMATION_MESSAGE);
                } else if (suffix.equals("staff")) {
                    PreparedStatement insertStatement;
                    PreparedStatement updateStatement;
                    try {
                        insertStatement = connect.prepareStatement("INSERT IGNORE INTO Invoice (invoice_id, "
                                + "invoice_period_date, invoice_reading, invoice_consumption, invoice_reconnection_charge, invoice_basic_charge, invoice_transitory_charge, invoice_environmental_charge, "
                                + "invoice_sewerage_charge, invoice_maintenance_charge, "
                                + "invoice_before_tax, invoice_tax, invoice_discount, invoice_amount, invoice_status, client_id, staff_id)"
                                + "VALUES (?, ?, ?, ?, 0, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

                        insertStatement.setInt(1, Integer.parseInt(id.getText()));

                        insertStatement.setString(2, dateFormat.format(period.getDate()));
                        insertStatement.setInt(3, Integer.parseInt(presentreading.getText()));
                        insertStatement.setInt(4, Integer.parseInt(consumption.getText()));
                        insertStatement.setDouble(5, Double.parseDouble(removeCurrency(basic.getText())));
                        insertStatement.setDouble(6, Double.parseDouble(removeCurrency(transitory.getText())));
                        insertStatement.setDouble(7, Double.parseDouble(removeCurrency(environmental.getText())));
                        insertStatement.setDouble(8, Double.parseDouble(removeCurrency(sewerage.getText())));
                        insertStatement.setDouble(9, Double.parseDouble(removeCurrency(maintenance.getText())));
                        insertStatement.setDouble(10, Double.parseDouble(removeCurrency(beforeTax.getText())));
                        insertStatement.setDouble(11, Double.parseDouble(removeCurrency(tax.getText())));
                        insertStatement.setDouble(12, Double.parseDouble(removeCurrency(discount.getText())));
                        insertStatement.setDouble(13, Double.parseDouble(removeCurrency(amount.getText())));
                        insertStatement.setString(14, "Unpaid");
                        insertStatement.setInt(15, client);

                        int staffId = 0;
                        for (Staff staff : staffs) {
                            if (accountUsername.equals(staff.getUsername())) {
                                staffId = staff.getId();
                            }
                        }
                        insertStatement.setInt(15, staffId);

                        insertStatement.executeUpdate();

                        updateStatement = connect.prepareStatement("UPDATE Meter SET meter_reading_date = ?, meter_reading = ?, "
                                + "meter_consumption = ? WHERE meter_id = ?");

                        updateStatement.setString(1, dateFormat.format(period.getDate()));
                        updateStatement.setInt(2, Integer.parseInt(presentreading.getText()));
                        updateStatement.setInt(3, Integer.parseInt(consumption.getText()));
                        updateStatement.setString(4, meterId.getText());

                        updateStatement.executeUpdate();

                    } catch (SQLException ex) {
                        Logger.getLogger(CreateInvoice.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    updateDatas();                  

                    this.dispose();

                    JOptionPane.showMessageDialog(null, "Invoice Created!", "Create Invoice", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect password!", "Wrong Password", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_saveActionPerformed

    private void discountCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discountCheckBoxActionPerformed
        if (discountCheckBox.isSelected() == true) {
            computeDiscountCharge();
            discount.setText(chargeFormat.format(discountcharge));

            computeTotalAmount();
            amount.setText(chargeFormat.format(total));
        } else if (discountCheckBox.isSelected() == false) {
            discountcharge = 0;
            discount.setText("₱0.0");

            computeTotalAmount();
            amount.setText(chargeFormat.format(total));
        }
    }//GEN-LAST:event_discountCheckBoxActionPerformed

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
                        selectStatementStaff.getInt("invoice_reading"), selectStatementStaff.getInt("invoice_consumption"), selectStatementStaff.getDouble("invoice_reconnection_charge"),
                        selectStatementStaff.getDouble("invoice_basic_charge"), selectStatementStaff.getDouble("invoice_transitory_charge"),
                        selectStatementStaff.getDouble("invoice_environmental_charge"), selectStatementStaff.getDouble("invoice_sewerage_charge"),
                        selectStatementStaff.getDouble("invoice_maintenance_charge"), selectStatementStaff.getDouble("invoice_before_tax"), selectStatementStaff.getDouble("invoice_tax"),
                        selectStatementStaff.getDouble("invoice_discount"), selectStatementStaff.getDouble("invoice_amount"),
                        selectStatementStaff.getDouble("invoice_payment"), selectStatementStaff.getString("invoice_payment_date"), selectStatementStaff.getString("invoice_status"),
                        selectStatementStaff.getInt("client_id"), selectStatementStaff.getInt("staff_id")));
            }
            while (selectStatementAdmin.next()) {
                invoices.add(new Invoice(selectStatementAdmin.getInt("invoice_id"), selectStatementAdmin.getString("invoice_period_date"),
                        selectStatementAdmin.getInt("invoice_reading"), selectStatementAdmin.getInt("invoice_consumption"), selectStatementAdmin.getDouble("invoice_reconnection_charge"),
                        selectStatementAdmin.getDouble("invoice_basic_charge"), selectStatementAdmin.getDouble("invoice_transitory_charge"),
                        selectStatementAdmin.getDouble("invoice_environmental_charge"), selectStatementAdmin.getDouble("invoice_sewerage_charge"),
                        selectStatementAdmin.getDouble("invoice_maintenance_charge"), selectStatementAdmin.getDouble("invoice_before_tax"), selectStatementAdmin.getDouble("invoice_tax"),
                        selectStatementAdmin.getDouble("invoice_discount"), selectStatementAdmin.getDouble("invoice_amount"),
                        selectStatementAdmin.getDouble("invoice_payment"), selectStatementAdmin.getString("invoice_payment_date"), selectStatementAdmin.getString("invoice_status"),
                        selectStatementAdmin.getInt("client_id"), selectStatementAdmin.getInt("admin_id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    double basiccharge, discountcharge, transitorycharge, environmentalcharge, seweragecharge, maintenancecharge, totalbeforetax, taxcharge, total;

    public double computeBasicCharge() {
        try {
            if (rateclass.getText().equals("Residential")) {
                if (Integer.parseInt(consumption.getText()) <= 10) {
                    basiccharge = 96.32;
                } else if (Integer.parseInt(consumption.getText()) > 10 && Integer.parseInt(consumption.getText()) <= 20) {
                    basiccharge = 184.19;
                    for (int i = 11; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 20.03;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 20 && Integer.parseInt(consumption.getText()) <= 40) {
                    basiccharge = 402.55;
                    for (int i = 21; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 38.09;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 40 && Integer.parseInt(consumption.getText()) <= 60) {
                    basiccharge = 1176.29;
                    for (int i = 41; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 50.03;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 60 && Integer.parseInt(consumption.getText()) <= 80) {
                    basiccharge = 2185.31;
                    for (int i = 61; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 58.45;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 80 && Integer.parseInt(consumption.getText()) <= 100) {
                    basiccharge = 3356.99;
                    for (int i = 81; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 61.13;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 100 && Integer.parseInt(consumption.getText()) <= 150) {
                    basiccharge = 4582.39;
                    for (int i = 101; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 63.93;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 150 && Integer.parseInt(consumption.getText()) <= 200) {
                    basiccharge = 7781.74;
                    for (int i = 151; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 66.78;
                    }
                } else {
                    basiccharge = 11123.56;
                    for (int i = 201; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 69.60;
                    }
                }
            } else if (rateclass.getText().equals("Semi-Business")) {
                if (Integer.parseInt(consumption.getText()) <= 10) {
                    basiccharge = 164.16;
                } else if (Integer.parseInt(consumption.getText()) > 10 && Integer.parseInt(consumption.getText()) <= 20) {
                    basiccharge = 197.78;
                    for (int i = 11; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 33.62;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 20 && Integer.parseInt(consumption.getText()) <= 40) {
                    basiccharge = 541.81;
                    for (int i = 21; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 41.45;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 40 && Integer.parseInt(consumption.getText()) <= 60) {
                    basiccharge = 1381.93;
                    for (int i = 41; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 52.57;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 60 && Integer.parseInt(consumption.getText()) <= 80) {
                    basiccharge = 2441.89;
                    for (int i = 61; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 61.13;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 80 && Integer.parseInt(consumption.getText()) <= 100) {
                    basiccharge = 3667.32;
                    for (int i = 81; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 63.96;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 100 && Integer.parseInt(consumption.getText()) <= 150) {
                    basiccharge = 4949.34;
                    for (int i = 101; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 66.78;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 150 && Integer.parseInt(consumption.getText()) <= 200) {
                    basiccharge = 8291.16;
                    for (int i = 151; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 69.60;
                    }
                } else {
                    basiccharge = 11773.90;
                    for (int i = 201; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 72.34;
                    }
                }
            } else if (rateclass.getText().equals("Business")) {
                if (Integer.parseInt(consumption.getText()) <= 10) {
                    basiccharge = 746.05;
                } else if (Integer.parseInt(consumption.getText()) > 10 && Integer.parseInt(consumption.getText()) <= 100) {
                    basiccharge = 821;
                    for (int i = 11; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 74.95;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 100 && Integer.parseInt(consumption.getText()) <= 200) {
                    basiccharge = 7566.70;
                    for (int i = 101; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 75.15;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 200 && Integer.parseInt(consumption.getText()) <= 300) {
                    basiccharge = 15081.93;
                    for (int i = 201; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 75.38;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 300 && Integer.parseInt(consumption.getText()) <= 400) {
                    basiccharge = 22620.18;
                    for (int i = 301; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 75.63;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 400 && Integer.parseInt(consumption.getText()) <= 500) {
                    basiccharge = 30183.43;
                    for (int i = 401; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 75.88;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 500 && Integer.parseInt(consumption.getText()) <= 600) {
                    basiccharge = 37771.78;
                    for (int i = 501; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 76.23;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 600 && Integer.parseInt(consumption.getText()) <= 700) {
                    basiccharge = 45395.11;
                    for (int i = 601; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 76.56;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 700 && Integer.parseInt(consumption.getText()) <= 800) {
                    basiccharge = 53051.37;
                    for (int i = 701; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 76.82;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 800 && Integer.parseInt(consumption.getText()) <= 900) {
                    basiccharge = 60733.62;
                    for (int i = 801; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 77.07;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 900 && Integer.parseInt(consumption.getText()) <= 1000) {
                    basiccharge = 68440.86;
                    for (int i = 901; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 77.31;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 1000 && Integer.parseInt(consumption.getText()) <= 1200) {
                    basiccharge = 76172.21;
                    for (int i = 1001; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 77.66;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 1200 && Integer.parseInt(consumption.getText()) <= 1400) {
                    basiccharge = 91704.44;
                    for (int i = 1201; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 77.89;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 1400 && Integer.parseInt(consumption.getText()) <= 1600) {
                    basiccharge = 107282.85;
                    for (int i = 1401; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 78.30;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 1600 && Integer.parseInt(consumption.getText()) <= 1800) {
                    basiccharge = 122943.06;
                    for (int i = 1601; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 78.51;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 1800 && Integer.parseInt(consumption.getText()) <= 2000) {
                    basiccharge = 138645.25;
                    for (int i = 1801; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 78.70;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 2000 && Integer.parseInt(consumption.getText()) <= 2500) {
                    basiccharge = 154285.48;
                    for (int i = 2001; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 78.93;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 2500 && Integer.parseInt(consumption.getText()) <= 3000) {
                    basiccharge = 193850.90;
                    for (int i = 2501; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 79.35;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 3000 && Integer.parseInt(consumption.getText()) <= 3500) {
                    basiccharge = 233526.17;
                    for (int i = 3001; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 79.62;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 3500 && Integer.parseInt(consumption.getText()) <= 4000) {
                    basiccharge = 273336.45;
                    for (int i = 3501; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 79.90;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 4000 && Integer.parseInt(consumption.getText()) <= 4500) {
                    basiccharge = 313286.60;
                    for (int i = 4001; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 80.05;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 4500 && Integer.parseInt(consumption.getText()) <= 5000) {
                    basiccharge = 353311.94;
                    for (int i = 4501; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 80.39;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 5000 && Integer.parseInt(consumption.getText()) <= 5500) {
                    basiccharge = 393507.28;
                    for (int i = 5001; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 80.73;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 5500 && Integer.parseInt(consumption.getText()) <= 6000) {
                    basiccharge = 433872.47;
                    for (int i = 5501; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 80.92;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 6000 && Integer.parseInt(consumption.getText()) <= 6500) {
                    basiccharge = 474332.80;
                    for (int i = 6001; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 81.25;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 6500 && Integer.parseInt(consumption.getText()) <= 7000) {
                    basiccharge = 514958.08;
                    for (int i = 6501; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 81.53;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 7000 && Integer.parseInt(consumption.getText()) <= 7500) {
                    basiccharge = 555723.29;
                    for (int i = 7001; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 81.74;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 7500 && Integer.parseInt(consumption.getText()) <= 8000) {
                    basiccharge = 596593.61;
                    for (int i = 7501; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 82.06;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 8000 && Integer.parseInt(consumption.getText()) <= 8500) {
                    basiccharge = 637623.95;
                    for (int i = 8001; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 82.40;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 8500 && Integer.parseInt(consumption.getText()) <= 9000) {
                    basiccharge = 678824.18;
                    for (int i = 8501; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 82.63;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 9000 && Integer.parseInt(consumption.getText()) <= 9500) {
                    basiccharge = 720139.47;
                    for (int i = 9001; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 82.92;
                    }
                } else if (Integer.parseInt(consumption.getText()) > 9500 && Integer.parseInt(consumption.getText()) <= 10000) {
                    basiccharge = 761599.76;
                    for (int i = 9501; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 83.21;
                    }
                } else {
                    basiccharge = 803205.01;
                    for (int i = 10001; i < Integer.parseInt(consumption.getText()); i++) {
                        basiccharge += 83.46;
                    }
                }
            }
        } catch (NumberFormatException e) {

        }
        return basiccharge;
    }

    public double computeDiscountCharge() {
        if (rateclass.getText().equals("Residential") || rateclass.getText().equals("Semi-Business")) {
            discountcharge = basiccharge * 0.05;
        } else {
            discountcharge = 0;
        }

        return discountcharge;
    }

    public double computeTransitoryCharge() {
        transitorycharge = -basiccharge * 0.0055;

        return transitorycharge;
    }

    public double computeEnvironmentalCharge() {
        environmentalcharge = basiccharge + transitorycharge;
        environmentalcharge = environmentalcharge * 0.20;

        return environmentalcharge;
    }

    public double computeSewerageCharge() {
        if (rateclass.getText().equals("Business")) {
            seweragecharge = basiccharge + transitorycharge;
            seweragecharge = seweragecharge * 0.20;
        }

        return seweragecharge;
    }

    double metersize;

    public double computeMaintenanceCharge() {
        switch (Double.toString(metersize)) {
            case "0.5":
                maintenancecharge = 1.50;
                break;
            case "0.75":
                maintenancecharge = 2.00;
                break;
            case "1":
                maintenancecharge = 3.00;
                break;
            case "1.25":
                maintenancecharge = 4.00;
                break;
            case "2":
                maintenancecharge = 6.00;
                break;
            case "3":
                maintenancecharge = 10.00;
                break;
            case "4":
                maintenancecharge = 20.00;
                break;
            case "6":
                maintenancecharge = 35.00;
                break;
            case "8":
                maintenancecharge = 50.00;
                break;

            default:

                maintenancecharge = 0;
                break;
        }
        return maintenancecharge;
    }

    public double computeTotalBeforeTax() {
        totalbeforetax = basiccharge + transitorycharge + environmentalcharge + seweragecharge
                + maintenancecharge;

        return totalbeforetax;
    }

    public double computeTax() {
        taxcharge = totalbeforetax * 0.02825;

        return taxcharge;
    }

    public double computeTotalAmount() {
        total = (totalbeforetax + taxcharge) - discountcharge;

        return total;
    }

    public String removeCurrency(String s) {
        s = s.replace("₱", "");

        s = s.replace(",", "");
        return s;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel amount;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JLabel basic;
    private javax.swing.JLabel basiclabel;
    private javax.swing.JLabel beforeTax;
    private javax.swing.JLabel beforetaxLabel;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel clientId;
    private javax.swing.JLabel clientIdLabel;
    private javax.swing.JLabel clientName;
    private javax.swing.JLabel clientNameLabel;
    private javax.swing.JSeparator clientinformationseparator;
    private javax.swing.JPasswordField consumption;
    private javax.swing.JLabel consumptionLabel;
    private javax.swing.JLabel discount;
    private javax.swing.JCheckBox discountCheckBox;
    private javax.swing.JLabel environmental;
    private javax.swing.JLabel environmentalLabel;
    private javax.swing.JLabel id;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel invoicePeriod2;
    private javax.swing.JLabel invoicePeriod7;
    private javax.swing.JLabel invoiceperiodLabel;
    private javax.swing.JSeparator invoicesummarySeparator;
    private javax.swing.JLabel maintenance;
    private javax.swing.JLabel maintenanceLabel;
    private javax.swing.JLabel meterId;
    private javax.swing.JLabel meterIdLabel;
    private javax.swing.JSeparator meterinformationSeparator;
    private javax.swing.JLabel meterreadingDate;
    private javax.swing.JLabel meterreadingDateLabel;
    private com.toedter.calendar.JDateChooser period;
    private javax.swing.JLabel period2;
    private javax.swing.JPasswordField presentreading;
    private javax.swing.JLabel presentreadingLabel;
    private javax.swing.JLabel previousreading;
    private javax.swing.JLabel previousreadingLabel;
    private javax.swing.JLabel rateclass;
    private javax.swing.JLabel rateclassLabel;
    private javax.swing.JButton save;
    private javax.swing.JLabel serviceInformationLabel;
    private javax.swing.JLabel serviceInformationLabel1;
    private javax.swing.JLabel serviceInformationLabel2;
    private javax.swing.JLabel sewerage;
    private javax.swing.JLabel sewerageLabel;
    private javax.swing.JLabel tax;
    private javax.swing.JLabel taxLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel transitory;
    private javax.swing.JLabel transitorylabel;
    // End of variables declaration//GEN-END:variables
}
