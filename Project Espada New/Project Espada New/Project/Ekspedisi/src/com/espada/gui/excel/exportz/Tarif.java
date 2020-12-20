package com.espada.gui.excel.exportz;

import com.espada.Excel;
import com.espada.model.qKabupaten;
import com.espada.model.qKecamatan;
import com.espada.model.qLayanan;
import com.espada.model.qProvinsi;
import com.espada.model.qTarif;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

public class Tarif extends javax.swing.JFrame {
    private qKecamatan kecamatan = new qKecamatan();
    private qLayanan layanan = new qLayanan();
    private qTarif tarif = new qTarif();
    private String[] kecamatanPengirimArray = new String[kecamatan.getKecamatan().size()];
    private String[] kecamatanPenerimaArray = new String[kecamatan.getKecamatan().size()];
    private String[] kodeLayananArray = new String[layanan.getLayanan().size()];
    private String[] idLayananArray = new String[layanan.getLayanan().size()];
    /**
     * Creates new form Tarif
     */
    public Tarif() {
        initComponents();
        this.setTitle("Tarif Export");
        this.setLocationRelativeTo(null);
        ImageIcon ico = new ImageIcon("logo.png");
        this.setIconImage(ico.getImage());
        fillKecamatanPengirimCombo();
        fillKecamatanPenerimaCombo();
        fillLayananCombo();
        fillTarif();
    }
    
    public void fillTarif(){
         DefaultTableModel model = (DefaultTableModel) tableTarif.getModel();
        model.getDataVector().removeAllElements();
        revalidate();
    }
    
    public void searchTarif(
            String idKecAsal,
            String idKecTujuan,
            String idLayanan,
            String durasiAwal,
            String durasiAkhir,
            String hargaAwal,
            String hargaAkhir){
         DefaultTableModel model = (DefaultTableModel) tableTarif.getModel();
        model.getDataVector().removeAllElements();
        revalidate();
        for(int i=0;i<tarif.searchTarif(idKecAsal, idKecTujuan, idLayanan, durasiAwal, durasiAkhir, hargaAwal, hargaAkhir).size();i++){
            String idTarifNew = (String) tarif.searchTarif(idKecAsal, idKecTujuan, idLayanan, durasiAwal, durasiAkhir, hargaAwal, hargaAkhir).get(i).get(0);
            String idKecAsalNew = (String) tarif.searchTarif(idKecAsal, idKecTujuan, idLayanan, durasiAwal, durasiAkhir, hargaAwal, hargaAkhir).get(i).get(1);
            String idKecTujuanNew = (String) tarif.searchTarif(idKecAsal, idKecTujuan, idLayanan, durasiAwal, durasiAkhir, hargaAwal, hargaAkhir).get(i).get(2);
            String idLayananNew = (String) tarif.searchTarif(idKecAsal, idKecTujuan, idLayanan, durasiAwal, durasiAkhir, hargaAwal, hargaAkhir).get(i).get(3);
            String durasiNew = (String) tarif.searchTarif(idKecAsal, idKecTujuan, idLayanan, durasiAwal, durasiAkhir, hargaAwal, hargaAkhir).get(i).get(4);
            String hargaNew = (String) tarif.searchTarif(idKecAsal, idKecTujuan, idLayanan, durasiAwal, durasiAkhir, hargaAwal, hargaAkhir).get(i).get(5);
            String kecamatanAsal = (String) kecamatan.getKecamatanMe(idKecAsalNew).get(0).get(2);
            String kecamatanTujuan = (String) kecamatan.getKecamatanMe(idKecTujuanNew).get(0).get(2);
            String myLayanan = (String) layanan.getLayanan(idLayananNew).get(0).get(1);
            
            model.addRow(new Object[]{idTarifNew, kecamatanAsal, kecamatanTujuan, myLayanan, durasiNew+" hari", hargaNew});
        }
    }
    
    public void fillKecamatanPengirimCombo(){
        comboKecamatanPengirim.removeAllItems();
        comboKecamatanPengirim.addItem("All");
        if(kecamatan.getKecamatan().size()<=0){
            comboKecamatanPengirim.enable(false);
        }else{
            comboKecamatanPengirim.enable(true);
            for(int i=0;i<kecamatan.getKecamatan().size();i++){
                kecamatanPengirimArray[i]=(String)kecamatan.getKecamatan().get(i).get(0);
                comboKecamatanPengirim.addItem((String)kecamatan.getKecamatan().get(i).get(2));
            }
        }
    }
    
    public void fillKecamatanPenerimaCombo(){
        comboKecamatanPenerima.removeAllItems();
        comboKecamatanPenerima.addItem("All");
        if(kecamatan.getKecamatan().size()<=0){
            comboKecamatanPenerima.enable(false);
        }else{
            comboKecamatanPenerima.enable(true);
            for(int i=0;i<kecamatan.getKecamatan().size();i++){
                kecamatanPenerimaArray[i]=(String)kecamatan.getKecamatan().get(i).get(0);
                comboKecamatanPenerima.addItem((String)kecamatan.getKecamatan().get(i).get(2));
            }
        }
    }
    
     public void fillLayananCombo(){
        comboLayanan.removeAllItems();
        comboLayanan.addItem("All");
        for(int i=0;i<layanan.getLayanan().size();i++){
            kodeLayananArray[i]=(String)layanan.getLayanan().get(i).get(2);
            idLayananArray[i]=(String)layanan.getLayanan().get(i).get(0);
            comboLayanan.addItem((String)layanan.getLayanan().get(i).get(1));
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

        labelKecPengirim = new javax.swing.JLabel();
        labelKecPenerima = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblDurasiAkhir = new javax.swing.JLabel();
        comboKecamatanPenerima = new javax.swing.JComboBox<String>();
        textHargaAkhir = new javax.swing.JTextField();
        textHargaAwal = new javax.swing.JTextField();
        textDurasiAkhir = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblDurasiAwal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboLayanan = new javax.swing.JComboBox();
        textDurasiAwal = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        comboKecamatanPengirim = new javax.swing.JComboBox<String>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTarif = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        labelKecPengirim.setText("Kecamatan Pengirim:");

        labelKecPenerima.setText("Kecamatan Penerima:");

        jLabel1.setText("Layanan:");

        lblDurasiAkhir.setText("Harga:");

        comboKecamatanPenerima.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboKecamatanPenerima.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboKecamatanPenerimaItemStateChanged(evt);
            }
        });
        comboKecamatanPenerima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboKecamatanPenerimaActionPerformed(evt);
            }
        });

        textHargaAkhir.setText("0");

        textHargaAwal.setText("0");

        textDurasiAkhir.setText("0");

        jLabel3.setText("-");

        lblDurasiAwal.setText("Durasi:");

        jLabel2.setText("-");

        comboLayanan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        textDurasiAwal.setText("0");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        comboKecamatanPengirim.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboKecamatanPengirim.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboKecamatanPengirimItemStateChanged(evt);
            }
        });

        tableTarif.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Kecamatan Asal", "Kecamatan Tujuan", "Layanan", "Durasi", "Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTarif.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTarifMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableTarif);

        jButton1.setText("Export Table to Excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(labelKecPengirim)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboKecamatanPengirim, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblDurasiAkhir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textHargaAwal, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textHargaAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboLayanan, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(labelKecPenerima)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(comboKecamatanPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lblDurasiAwal)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textDurasiAwal, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textDurasiAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelKecPengirim)
                    .addComponent(comboKecamatanPengirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboKecamatanPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelKecPenerima))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboLayanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(lblDurasiAwal)
                    .addComponent(textDurasiAwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(textDurasiAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDurasiAkhir)
                    .addComponent(textHargaAwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(textHargaAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboKecamatanPengirimItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboKecamatanPengirimItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_comboKecamatanPengirimItemStateChanged

    private void comboKecamatanPenerimaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboKecamatanPenerimaItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_comboKecamatanPenerimaItemStateChanged

    private void comboKecamatanPenerimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboKecamatanPenerimaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboKecamatanPenerimaActionPerformed

    private void tableTarifMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTarifMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableTarifMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String tempkecPengirim;
        String tempkecPenerima;
        String tempLayanan;
        
        if(comboKecamatanPengirim.getSelectedIndex()>0){
            tempkecPengirim=kecamatanPengirimArray[comboKecamatanPengirim.getSelectedIndex()-1];
        }else{
            tempkecPengirim="all";
        }
        
        if(comboKecamatanPenerima.getSelectedIndex()>0){
            tempkecPenerima=kecamatanPenerimaArray[comboKecamatanPenerima.getSelectedIndex()-1];
        }else{
            tempkecPenerima="all";
        }
        
        if(comboLayanan.getSelectedIndex()>0){
            tempLayanan=idLayananArray[comboLayanan.getSelectedIndex()-1];
        }else{
            tempLayanan="all";
        }
        
        searchTarif(
                tempkecPengirim,
                tempkecPenerima,
                tempLayanan,
                textDurasiAwal.getText(),
                textDurasiAkhir.getText(),
                textHargaAwal.getText(),
                textHargaAkhir.getText()
        );
    }//GEN-LAST:event_btnSearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Excel export = new Excel();
        JFileChooser fc = new JFileChooser();
                int option = fc.showSaveDialog(Tarif.this);
                if(option == JFileChooser.APPROVE_OPTION){
                    String filename = fc.getSelectedFile().getName(); 
                    String path = fc.getSelectedFile().getParentFile().getPath();

					int len = filename.length();
					String ext = "";
					String file = "";

					if(len > 4){
						ext = filename.substring(len-4, len);
					}

					if(ext.equals(".xls")){
						file = path + "\\" + filename; 
					}else{
						file = path + "\\" + filename + ".xls"; 
					}
					export.toExcel(tableTarif, new File(file));
				}
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Tarif.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tarif.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tarif.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tarif.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tarif().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> comboKecamatanPenerima;
    private javax.swing.JComboBox<String> comboKecamatanPengirim;
    private javax.swing.JComboBox comboLayanan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelKecPenerima;
    private javax.swing.JLabel labelKecPengirim;
    private javax.swing.JLabel lblDurasiAkhir;
    private javax.swing.JLabel lblDurasiAwal;
    private javax.swing.JTable tableTarif;
    private javax.swing.JTextField textDurasiAkhir;
    private javax.swing.JTextField textDurasiAwal;
    private javax.swing.JTextField textHargaAkhir;
    private javax.swing.JTextField textHargaAwal;
    // End of variables declaration//GEN-END:variables
}
