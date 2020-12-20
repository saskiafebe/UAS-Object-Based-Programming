package com.espada.gui.excel.exportz;

import com.espada.Excel;
import com.espada.model.qKabupaten;
import com.espada.model.qKecamatan;
import com.espada.model.qProvinsi;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

public class Wilayah extends javax.swing.JFrame {
    qProvinsi provinsi = new qProvinsi();
    qKabupaten kabupaten = new qKabupaten();
    qKecamatan kecamatan = new qKecamatan();
    /**
     * Creates new form Wilayah
     */
    public Wilayah() {
        initComponents();
        this.setTitle("Wilayah Export");
        this.setLocationRelativeTo(null);
        ImageIcon ico = new ImageIcon("logo.png");
        this.setIconImage(ico.getImage());
        fillWilayah();
    }
    
    public void searchWilayah(String keyword){
        DefaultTableModel model = (DefaultTableModel) tableWilayah.getModel();
        model.getDataVector().removeAllElements();
        revalidate();
        
        
        
        
        for(int i=0;i<provinsi.searchProvinsi(keyword).size();i++){
            String idProv = (String) provinsi.searchProvinsi(keyword).get(i).get(1);
            String prov = (String) provinsi.getProvinsiMe(idProv).get(0).get(0);
            
            if(kabupaten.getKota(idProv).size()==0){
                model.addRow(new Object[]{prov, "-", "-"});
                
            }else{
                for(int j=0;j<kabupaten.getKota(idProv).size();j++){
                    String idKota = (String) kabupaten.getKota(idProv).get(j).get(0);
                    String kota = (String) kabupaten.getKotaMe(idKota).get(0).get(2);
                
                    if(kecamatan.getKecamatan(idKota).size()==0){
                        model.addRow(new Object[]{prov, kota, "-"});

                    }else{
                        for(int k=0;k<kecamatan.getKecamatan(idKota).size();k++){
                            String idKec = (String) kecamatan.getKecamatan(idKota).get(k).get(0);
                            String kecamatans = (String) kecamatan.getKecamatanMe(idKec).get(0).get(2);
                            model.addRow(new Object[]{prov, kota, kecamatans});
                        }
                    }
                }
            }
        }
        
        for(int j=0;j<kabupaten.searchKota(keyword).size();j++){
                String idKota = (String) kabupaten.searchKota(keyword).get(j).get(0);
                String kota = (String) kabupaten.getKotaMe(idKota).get(0).get(2);
                String idProv = (String) kabupaten.getKotaMe(idKota).get(0).get(1);
                String prov = (String) provinsi.getProvinsiMe(idProv).get(0).get(0);
                
                
                if(kecamatan.getKecamatan(idKota).size()==0){
                    model.addRow(new Object[]{prov, kota, "-"});
                    
                }else{
                    for(int k=0;k<kecamatan.getKecamatan(idKota).size();k++){
                        String idKec = (String) kecamatan.getKecamatan(idKota).get(k).get(0);
                        String kecamatans = (String) kecamatan.getKecamatanMe(idKec).get(0).get(2);
                        model.addRow(new Object[]{prov, kota, kecamatans});
                        

                    }
                }
        }
        
        for(int k=0;k<kecamatan.searchKecamatan(keyword).size();k++){
                        String idKec = (String) kecamatan.searchKecamatan(keyword).get(k).get(0);
                        String kecamatans = (String) kecamatan.getKecamatanMe(idKec).get(0).get(2);
                        String idKota = (String) kecamatan.getKecamatanMe(idKec).get(0).get(1);
                        String kota = (String) kabupaten.getKotaMe(idKota).get(0).get(2);
                        String idProv = (String) kabupaten.getKotaMe(idKota).get(0).get(1);
                        String prov = (String) provinsi.getProvinsiMe(idProv).get(0).get(0);
                        model.addRow(new Object[]{prov, kota, kecamatans});
                        

        }
    }
    
    public void fillWilayah(){
        DefaultTableModel model = (DefaultTableModel) tableWilayah.getModel();
        model.getDataVector().removeAllElements();
        revalidate();
        for(int i=0;i<provinsi.getProvinsi().size();i++){
            String idProv = (String) provinsi.getProvinsi().get(i).get(1);
            String prov = (String) provinsi.getProvinsiMe(idProv).get(0).get(0);
            
            if(kabupaten.getKota(idProv).size()==0){
                model.addRow(new Object[]{prov, "-", "-"});
                
            }else{
                for(int j=0;j<kabupaten.getKota(idProv).size();j++){
                String idKota = (String) kabupaten.getKota(idProv).get(j).get(0);
                String kota = (String) kabupaten.getKotaMe(idKota).get(0).get(2);
                
                if(kecamatan.getKecamatan(idKota).size()==0){
                    model.addRow(new Object[]{prov, kota, "-"});
                    
                }else{
                    for(int k=0;k<kecamatan.getKecamatan(idKota).size();k++){
                        String idKec = (String) kecamatan.getKecamatan(idKota).get(k).get(0);
                        String kecamatans = (String) kecamatan.getKecamatanMe(idKec).get(0).get(2);
                        model.addRow(new Object[]{prov, kota, kecamatans});
                        

                    }
                }
                }
            }
            
           
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tableWilayah = new javax.swing.JTable();
        textSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tableWilayah.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Provinsi", "Kabupaten / Kota", "Kecamatan"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableWilayah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableWilayahMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableWilayah);

        btnSearch.setText("Cari");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnExport.setText("Export Table to Excel");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearch))
                            .addComponent(btnExport, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExport)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableWilayahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableWilayahMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableWilayahMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String keyword = textSearch.getText();
        if(keyword.equals("")){
            fillWilayah();   
        }else{
            searchWilayah(keyword);
        }
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        // TODO add your handling code here:
         Excel export = new Excel();
        JFileChooser fc = new JFileChooser();
                int option = fc.showSaveDialog(Wilayah.this);
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
					export.toExcel(tableWilayah, new File(file));
				}
    }//GEN-LAST:event_btnExportActionPerformed

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
            java.util.logging.Logger.getLogger(Wilayah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Wilayah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Wilayah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Wilayah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Wilayah().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableWilayah;
    private javax.swing.JTextField textSearch;
    // End of variables declaration//GEN-END:variables
}
