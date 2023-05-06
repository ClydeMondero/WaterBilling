package waterbilling;

import java.util.ArrayList;
import java.util.Date;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import static waterbilling.ClientPanel.clients;
import static waterbilling.ClientPanel.meters;

public class CreateInvoice extends javax.swing.JFrame {

    int client;
    String accountUsername, accountPassword;

    static ArrayList<Invoice> invoices = new ArrayList<>();

    Connection connect = null;        

    public CreateInvoice(int id, String username, String password) {
        initComponents();

        client = id;
        accountUsername = username;
        accountPassword = password;

        period.setDate(new Date());

        connect = DatabaseConnection.connectDatabase();

        updateDatas();

        this.id.setText(Integer.toString(invoices.get(invoices.size() - 1).getId() + 1));

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
                    }
                }
            }
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd yyyy");
        meterreadingDate.setText(dateFormat.format(period.getDate()));

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(period.getDate());
        calendar.add(Calendar.MONTH, -1);
        period2.setText(dateFormat.format(calendar.getTime()) + " TO " + dateFormat.format(period.getDate()));
        
        NumberFormat chargeFormat = NumberFormat.getCurrencyInstance();
        consumption.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                computeBasicCharge();
                basic.setText(chargeFormat.format(basiccharge));
                
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                computeBasicCharge();
                basic.setText(chargeFormat.format(basiccharge));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                computeBasicCharge();
                basic.setText(chargeFormat.format(basiccharge));
            }

        });

        this.setLayout(null);

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
        meterreadingDateLabel = new javax.swing.JLabel();
        meterreadingDate = new javax.swing.JLabel();
        previousreadingLabel = new javax.swing.JLabel();
        previousreading = new javax.swing.JLabel();
        presentreadingLabel = new javax.swing.JLabel();
        serviceInformationLabel1 = new javax.swing.JLabel();
        presentreading = new javax.swing.JTextField();
        consumptionLabel = new javax.swing.JLabel();
        consumption = new javax.swing.JTextField();
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
        discount = new javax.swing.JLabel();
        isDiscounted = new javax.swing.JCheckBox();
        beforeTax = new javax.swing.JLabel();
        totalamountLabel = new javax.swing.JLabel();
        totalamount = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        save = new javax.swing.JButton();
        clientinformationseparator = new javax.swing.JSeparator();
        meterinformationSeparator = new javax.swing.JSeparator();
        invoicesummarySeparator = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        listOfAcccountLabel.setFont(new java.awt.Font("sansserif", 1, 28)); // NOI18N
        listOfAcccountLabel.setText("Create Invoice");

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

        period2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        period2.setText("Invoice Period");

        basiclabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        basiclabel.setText("Basic Charge:");

        basic.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        basic.setText("Basic Charge");

        transitorylabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        transitorylabel.setText("Transitory Charge:");

        transitory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        transitory.setText("Transitory Charge");

        environmentalLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        environmentalLabel.setText("Environmental Charge:");

        environmental.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        environmental.setText("Environmental");

        maintenanceLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        maintenanceLabel.setText("Maintenance Charge:");

        maintenance.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        maintenance.setText("Maintenance");

        invoicePeriod7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        beforetaxLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        beforetaxLabel.setText("Charges Before Tax:");

        taxLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        taxLabel.setText("Tax:");

        tax.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tax.setText("Tax");

        discount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        discount.setText("Discount");

        isDiscounted.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        isDiscounted.setText("Discount:");

        beforeTax.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        beforeTax.setText("Before Tax");

        totalamountLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        totalamountLabel.setText("Total Amount:");

        totalamount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        totalamount.setText("Total Amount");

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        save.setText("Save");

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
                .addComponent(listOfAcccountLabel)
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
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(presentreadingLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(presentreading, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                        .addComponent(consumptionLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(consumption, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(idLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(id)
                                        .addGap(124, 124, 124)
                                        .addComponent(invoiceperiodLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(period, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(serviceInformationLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(clientinformationseparator)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(transitorylabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(transitory)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(environmental))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(invoicePeriod2)
                                        .addGap(18, 18, 18)
                                        .addComponent(period2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(maintenanceLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(maintenance))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(basiclabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(basic))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(totalamountLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(totalamount)))
                                .addGap(31, 31, 31)))
                        .addComponent(invoicePeriod7)
                        .addGap(0, 9, Short.MAX_VALUE))
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
                                .addComponent(beforeTax)
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(environmentalLabel)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(taxLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(tax)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(isDiscounted)
                                        .addGap(18, 18, 18)
                                        .addComponent(discount)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(listOfAcccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(maintenanceLabel)
                            .addComponent(maintenance)
                            .addComponent(environmentalLabel)
                            .addComponent(environmental)
                            .addComponent(transitorylabel)
                            .addComponent(transitory))
                        .addGap(27, 27, 27)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(beforetaxLabel)
                            .addComponent(beforeTax))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(discount)
                            .addComponent(isDiscounted)
                            .addComponent(taxLabel)
                            .addComponent(tax)))
                    .addComponent(totalamountLabel)
                    .addComponent(totalamount))
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

    DocumentFilter numbersFilter = new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("\\d*") || string.matches("^[\\\\d.]*$")) {
                    super.insertString(fb, offset, string, attr);
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter only numeric characters!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("\\d*") || string.matches("^[\\\\d.]*$")) {
                    super.replace(fb, offset, length, string, attr);
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter only numeric characters!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
    
    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        period.setDate(null);
        presentreading.setText("");
        consumption.setText("");
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
                invoices.add(new Invoice(selectStatementStaff.getInt("invoice_id"), selectStatementStaff.getDouble("invoice_amount"), selectStatementStaff.getString("invoice_period_date"),
                        selectStatementStaff.getDouble("invoice_payment"), selectStatementStaff.getString("invoice_payment_date"), selectStatementStaff.getString("invoice_status"),
                        selectStatementStaff.getInt("client_id"), selectStatementStaff.getInt("staff_id")));
            }
            while (selectStatementAdmin.next()) {
                invoices.add(new Invoice(selectStatementAdmin.getInt("invoice_id"), selectStatementAdmin.getDouble("invoice_amount"), selectStatementAdmin.getString("invoice_period_date"),
                        selectStatementAdmin.getDouble("invoice_payment"), selectStatementAdmin.getString("invoice_payment_date"), selectStatementAdmin.getString("invoice_status"),
                        selectStatementAdmin.getInt("client_id"), selectStatementAdmin.getInt("admin_id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    double basiccharge;

    public double computeBasicCharge() {
        try{
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
        }catch(NumberFormatException e){
            
        }
        return basiccharge;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address;
    private javax.swing.JLabel addressLabel;
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
    private javax.swing.JTextField consumption;
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
    private javax.swing.JCheckBox isDiscounted;
    private javax.swing.JLabel listOfAcccountLabel;
    private javax.swing.JLabel maintenance;
    private javax.swing.JLabel maintenanceLabel;
    private javax.swing.JLabel meterId;
    private javax.swing.JLabel meterIdLabel;
    private javax.swing.JSeparator meterinformationSeparator;
    private javax.swing.JLabel meterreadingDate;
    private javax.swing.JLabel meterreadingDateLabel;
    private com.toedter.calendar.JDateChooser period;
    private javax.swing.JLabel period2;
    private javax.swing.JTextField presentreading;
    private javax.swing.JLabel presentreadingLabel;
    private javax.swing.JLabel previousreading;
    private javax.swing.JLabel previousreadingLabel;
    private javax.swing.JLabel rateclass;
    private javax.swing.JLabel rateclassLabel;
    private javax.swing.JButton save;
    private javax.swing.JLabel serviceInformationLabel;
    private javax.swing.JLabel serviceInformationLabel1;
    private javax.swing.JLabel serviceInformationLabel2;
    private javax.swing.JLabel tax;
    private javax.swing.JLabel taxLabel;
    private javax.swing.JLabel totalamount;
    private javax.swing.JLabel totalamountLabel;
    private javax.swing.JLabel transitory;
    private javax.swing.JLabel transitorylabel;
    // End of variables declaration//GEN-END:variables
}
