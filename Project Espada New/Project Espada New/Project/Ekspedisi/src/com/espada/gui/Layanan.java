package com.espada.gui;

import com.espada.model.qLayanan;
import com.espada.model.qTarif;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Layanan extends javax.swing.JFrame {
    qLayanan layanan = new qLayanan();
    private int tempDelete=-1;
    qTarif tarif = new qTarif();
    /**
     * Creates new form Layanan
     */
    public Layanan() {
        initComponents();
        this.setTitle("Layanan Setting");
        this.setLocationRelativeTo(null);
        ImageIcon ico = new ImageIcon("logo.png");
        this.setIconImage(ico.getImage());
        fillLayanan();
    }
    
            public void fillLayanan(){
         DefaultTableModel model = (DefaultTableModel) tableLayanan.getModel();
        model.getDataVector().removeAllElements();
        revalidate();
        for(int i=0;i<layanan.getLayanan().size();i++){
            String idLayanan = (String) layanan.getLayanan().get(i).get(0);
            String namaLayanan = (String) layanan.getLayanan().get(i).get(1);
            String kodeLayanan = (String) layanan.getLayanan().get(i).get(2);
            model.addRow(new Object[]{idLayanan, namaLayanan, kodeLayanan});
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelLayanan = new javax.swing.JLabel();
        textLayanan = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        labelViewLayanan = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        textKodeLayanan = new javax.swing.JTextField();
        labelKodeLayanan = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLayanan = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        labelLayanan.setText("Nama Layanan:");

        btnAdd.setText("Tambah");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        labelViewLayanan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelViewLayanan.setText("Layanan");

        btnDelete.setText("Hapus");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        labelKodeLayanan.setText("Kode Layanan:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelLayanan)
                            .addComponent(labelKodeLayanan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textKodeLayanan)
                            .addComponent(textLayanan, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelViewLayanan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLayanan)
                    .addComponent(textLayanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelKodeLayanan)
                    .addComponent(textKodeLayanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd)
                .addContainerGap(189, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(109, 109, 109)
                    .addComponent(labelViewLayanan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnDelete)
                    .addContainerGap(109, Short.MAX_VALUE)))
        );

        tableLayanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Layanan", "Kode Layanan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableLayanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableLayananMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableLayanan);
        if (tableLayanan.getColumnModel().getColumnCount() > 0) {
            tableLayanan.getColumnModel().getColumn(0).setMinWidth(30);
            tableLayanan.getColumnModel().getColumn(0).setMaxWidth(30);
            tableLayanan.getColumnModel().getColumn(1).setResizable(false);
            tableLayanan.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if(layanan.setLayanan(textLayanan.getText(), textKodeLayanan.getText())==true){
            JOptionPane.showMessageDialog(this, "Kurir berhasil ditambahkan");
        }
        fillLayanan();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        
        if(tempDelete==-1){
            JOptionPane.showMessageDialog(this, "Pilih layanan untuk menghapus");
        }else{
            if(tarif.checkLayanan(Integer.toString(tempDelete))==false){
                if(layanan.deleteLayanan(tempDelete)){
                    JOptionPane.showMessageDialog(this, "Berhasil menghapus layanan");
                }else{
                    JOptionPane.showMessageDialog(this, "Gagal menghapus layanan");
                }
            }else{
                JOptionPane.showMessageDialog(this, "Layanan tidak dapat dihapus, layanan masih digunakan dalam tarif");
            }
        }
        fillLayanan();
        tempDelete=-1;
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tableLayananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableLayananMouseClicked
        // TODO add your handling code here:
        tempDelete=Integer.parseInt((String)tableLayanan.getValueAt(tableLayanan.getSelectedRow(),0));
        labelViewLayanan.setText((String) tableLayanan.getValueAt(tableLayanan.getSelectedRow(), 1));
    }//GEN-LAST:event_tableLayananMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Layanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Layanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Layanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Layanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Layanan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelKodeLayanan;
    private javax.swing.JLabel labelLayanan;
    private javax.swing.JLabel labelViewLayanan;
    private javax.swing.JTable tableLayanan;
    private javax.swing.JTextField textKodeLayanan;
    private javax.swing.JTextField textLayanan;
    // End of variables declaration//GEN-END:variables
}
