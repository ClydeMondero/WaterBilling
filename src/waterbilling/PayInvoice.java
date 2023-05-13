package waterbilling;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static waterbilling.ClientPanel.clients;
import static waterbilling.ClientPanel.meters;
import static waterbilling.AdminPanel.admins;
import static waterbilling.StaffPanel.staffs;
import static waterbilling.InvoicePanel.invoices;

public class PayInvoice extends javax.swing.JFrame {

    int invoiceId;
    String accountUsername, accountPassword;

    Connection connect = null;

    SimpleDateFormat dateFormat;

    NumberFormat chargeFormat = NumberFormat.getCurrencyInstance();

    public PayInvoice(int id, String username, String password) {
        initComponents();

        invoiceId = id;
        accountUsername = username;
        accountPassword = password;

        connect = DatabaseConnection.connectDatabase();

        updateDatas();

        this.id.setText(Integer.toString(invoiceId));

        for (Invoice invoice : invoices) {
            if (invoiceId == invoice.getId()) {
                invoiceId = invoices.indexOf(invoice);
            }
        }

        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date p = null;
        try {
            p = dateFormat.parse((invoices.get(invoiceId).getPeriod()));
        } catch (ParseException ex) {
            Logger.getLogger(PayInvoice.class.getName()).log(Level.SEVERE, null, ex);
        }

        dateFormat = new SimpleDateFormat("MMMM dd yyyy");
        period.setText(dateFormat.format(p));

        for (Client client : clients) {
            if (invoices.get(invoiceId).getClientId() == client.getId()) {
                clientId.setText(Integer.toString(client.getId()));
                clientName.setText(client.getFirstname() + " " + client.getMiddlename() + " " + client.getLastname());
                address.setText(client.getAddress());
                rateclass.setText(client.getRateclass());
                for (Meter meter : meters) {
                    if (client.getMeterId().equals(meter.getId())) {
                        meterId.setText(meter.getId());
                        meterreadingDate.setText(period.getText());
                    }
                }
            }
        }
        meterreading.setText(Integer.toString(invoices.get(invoiceId).getReading()));
        consumption.setText(Integer.toString(invoices.get(invoiceId).getConsumption()));

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(p);
        calendar.add(Calendar.MONTH, -1);

        period2.setText(dateFormat.format(calendar.getTime()) + " TO " + dateFormat.format(p));

        basic.setText(chargeFormat.format(invoices.get(invoiceId).getBasic()));

        transitory.setText(chargeFormat.format(invoices.get(invoiceId).getTransitory()));

        environmental.setText(chargeFormat.format(invoices.get(invoiceId).getEnvironmental()));

        sewerage.setText(chargeFormat.format(invoices.get(invoiceId).getSewerage()));

        maintenance.setText(chargeFormat.format(invoices.get(invoiceId).getMaintenance()));

        beforeTax.setText(chargeFormat.format(invoices.get(invoiceId).getBefore()));

        tax.setText(chargeFormat.format(invoices.get(invoiceId).getTax()));

        amount.setText(chargeFormat.format(invoices.get(invoiceId).getAmount()));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
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
        meterreadingLabel = new javax.swing.JLabel();
        meterreading = new javax.swing.JLabel();
        serviceInformationLabel1 = new javax.swing.JLabel();
        consumptionLabel = new javax.swing.JLabel();
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
        totalamountLabel = new javax.swing.JLabel();
        amount = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        payButton = new javax.swing.JButton();
        clientinformationseparator = new javax.swing.JSeparator();
        meterinformationSeparator = new javax.swing.JSeparator();
        invoicesummarySeparator = new javax.swing.JSeparator();
        sewerageLabel = new javax.swing.JLabel();
        sewerage = new javax.swing.JLabel();
        discount = new javax.swing.JLabel();
        period = new javax.swing.JLabel();
        consumption = new javax.swing.JLabel();
        taxLabel1 = new javax.swing.JLabel();
        payment = new javax.swing.JTextField();
        paymentLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("sansserif", 1, 28)); // NOI18N
        titleLabel.setText("Pay Invoice");

        idLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idLabel.setText("Invoice Id:");

        id.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        id.setText("Invoice Id");

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

        meterreadingLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        meterreadingLabel.setText("Meter Reading:");

        meterreading.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        meterreading.setText("Meter Reading");

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

        totalamountLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        totalamountLabel.setText("Total Amount:");

        amount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        amount.setText("₱0.0");

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        payButton.setText("Pay");

        sewerageLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sewerageLabel.setText("Sewerage Charge:");

        sewerage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sewerage.setText("₱0.0");

        discount.setText("₱0.0");

        period.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        period.setText("Invoice Period");

        consumption.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        consumption.setText("Consumption");

        taxLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        taxLabel1.setText("Discount:");

        payment.setText("₱0.0");

        paymentLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        paymentLabel.setText("Payment:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(transitorylabel)
                                                .addGap(18, 18, 18)
                                                .addComponent(transitory, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(meterIdLabel)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(meterId))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(meterreadingLabel)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(meterreading)))
                                                .addGap(65, 65, 65)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(meterreadingDateLabel)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(meterreadingDate, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(consumptionLabel)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(consumption))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(idLabel)
                                                .addGap(18, 18, 18)
                                                .addComponent(id)
                                                .addGap(124, 124, 124)
                                                .addComponent(invoiceperiodLabel)
                                                .addGap(18, 18, 18)
                                                .addComponent(period))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(invoicePeriod2)
                                                .addGap(18, 18, 18)
                                                .addComponent(period2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(basiclabel)
                                                .addGap(18, 18, 18)
                                                .addComponent(basic, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                                .addComponent(clientName, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(serviceInformationLabel)
                                                .addGap(5, 5, 5)
                                                .addComponent(meterinformationSeparator))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(serviceInformationLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(clientinformationseparator))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(serviceInformationLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(invoicesummarySeparator)))
                                        .addGap(17, 17, 17)))
                                .addComponent(invoicePeriod7))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(beforetaxLabel)
                                .addGap(18, 18, 18)
                                .addComponent(beforeTax, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(taxLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(tax, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(taxLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(47, 47, 47))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(environmentalLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(environmental, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(totalamountLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(maintenanceLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(maintenance, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(sewerageLabel)
                                        .addGap(22, 22, 22)
                                        .addComponent(sewerage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(payButton, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(paymentLabel)
                        .addGap(18, 18, 18)
                        .addComponent(payment, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(titleLabel)
                .addGap(327, 327, 327))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(invoiceperiodLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(period, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(meterreadingLabel)
                    .addComponent(meterreading)
                    .addComponent(consumptionLabel)
                    .addComponent(consumption))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
                                .addComponent(discount)
                                .addComponent(taxLabel1))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sewerageLabel)
                            .addComponent(sewerage))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(maintenanceLabel)
                            .addComponent(maintenance)
                            .addComponent(environmental))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalamountLabel)
                            .addComponent(amount))))
                .addGap(11, 11, 11)
                .addComponent(invoicePeriod7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(payButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(payment, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paymentLabel))
                .addGap(12, 12, 12))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

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
                        selectStatementStaff.getInt("invoice_reading"), selectStatementStaff.getInt("invoice_consumption"),
                        selectStatementStaff.getDouble("invoice_basic_charge"), selectStatementStaff.getDouble("invoice_transitory_charge"),
                        selectStatementStaff.getDouble("invoice_environmental_charge"), selectStatementStaff.getDouble("invoice_sewerage_charge"),
                        selectStatementStaff.getDouble("invoice_maintenance_charge"), selectStatementStaff.getDouble("invoice_before_tax"), selectStatementStaff.getDouble("invoice_tax"),
                        selectStatementStaff.getDouble("invoice_discount"), selectStatementStaff.getDouble("invoice_amount"),
                        selectStatementStaff.getDouble("invoice_payment"), selectStatementStaff.getString("invoice_payment_date"), selectStatementStaff.getString("invoice_status"),
                        selectStatementStaff.getInt("client_id"), selectStatementStaff.getInt("staff_id")));
            }
            while (selectStatementAdmin.next()) {
                invoices.add(new Invoice(selectStatementAdmin.getInt("invoice_id"), selectStatementAdmin.getString("invoice_period_date"),
                        selectStatementAdmin.getInt("invoice_reading"), selectStatementAdmin.getInt("invoice_consumption"),
                        selectStatementAdmin.getDouble("invoice_basic_charge"), selectStatementAdmin.getDouble("invoice_transitory_charge"),
                        selectStatementAdmin.getDouble("invoice_environmental_charge"), selectStatementAdmin.getDouble("invoice_sewerage_charge")
                        , selectStatementAdmin.getDouble("invoice_maintenance_charge"), selectStatementAdmin.getDouble("invoice_before_tax"), selectStatementAdmin.getDouble("invoice_tax"),
                        selectStatementAdmin.getDouble("invoice_discount"), selectStatementAdmin.getDouble("invoice_amount"),
                        selectStatementAdmin.getDouble("invoice_payment"), selectStatementAdmin.getString("invoice_payment_date"), selectStatementAdmin.getString("invoice_status"),
                        selectStatementAdmin.getInt("client_id"), selectStatementAdmin.getInt("admin_id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel amount;
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
    private javax.swing.JLabel consumption;
    private javax.swing.JLabel consumptionLabel;
    private javax.swing.JLabel discount;
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
    private javax.swing.JLabel meterreading;
    private javax.swing.JLabel meterreadingDate;
    private javax.swing.JLabel meterreadingDateLabel;
    private javax.swing.JLabel meterreadingLabel;
    private javax.swing.JButton payButton;
    private javax.swing.JTextField payment;
    private javax.swing.JLabel paymentLabel;
    private javax.swing.JLabel period;
    private javax.swing.JLabel period2;
    private javax.swing.JLabel rateclass;
    private javax.swing.JLabel rateclassLabel;
    private javax.swing.JLabel serviceInformationLabel;
    private javax.swing.JLabel serviceInformationLabel1;
    private javax.swing.JLabel serviceInformationLabel2;
    private javax.swing.JLabel sewerage;
    private javax.swing.JLabel sewerageLabel;
    private javax.swing.JLabel tax;
    private javax.swing.JLabel taxLabel;
    private javax.swing.JLabel taxLabel1;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel totalamountLabel;
    private javax.swing.JLabel transitory;
    private javax.swing.JLabel transitorylabel;
    // End of variables declaration//GEN-END:variables
}
