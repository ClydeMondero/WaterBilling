package waterbilling;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicProgressBarUI;

public class Loading extends javax.swing.JFrame {
    
    Image icon = Toolkit.getDefaultToolkit().getImage("images\\icon.png");  
    
    public Loading() {
        setIconImage(icon);
        
        this.getContentPane().setBackground(Color.decode("#2EC4B6"));
        initComponents();
        loadingProgressBar.setUI(new BasicProgressBarUI() {
            protected Color getSelectionBackground() {
                return Color.decode("#FFBF69"); 
            }
        });        
        Thread thread = new Thread(() -> {
            run();
        });
        thread.start();  
        Connection connect = DatabaseConnection.runDatabase();
    }

    
    public void run() {
//        for (int i = 0; i <= 100; i++) {
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            int progress = i;
//            SwingUtilities.invokeLater(new Runnable() {
//                public void run() {
//                    loadingProgressBar.setValue(progress);
//                    loadingProgressBar.repaint();
//                }
//            });
//        }
        
        dispose();
        new Login().setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loadingProgressBar = new javax.swing.JProgressBar();
        runninDatabasesLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        loadingProgressBar.setBackground(new java.awt.Color(255, 255, 255));
        loadingProgressBar.setForeground(new java.awt.Color(203, 243, 240));
        loadingProgressBar.setStringPainted(true);

        runninDatabasesLabel.setForeground(new java.awt.Color(255, 255, 255));
        runninDatabasesLabel.setText("Running Databases..");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(loadingProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(runninDatabasesLabel)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(loadingProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(runninDatabasesLabel)
                .addContainerGap(164, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Loading().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar loadingProgressBar;
    private javax.swing.JLabel runninDatabasesLabel;
    // End of variables declaration//GEN-END:variables
}
