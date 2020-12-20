package com.espada.gui;

import com.espada.Chart;
import com.espada.Excel;
import com.espada.gui.wilayah.Kabupaten;
import com.espada.gui.wilayah.Kecamatan;
import com.espada.gui.wilayah.Provinsi;
import javax.swing.ImageIcon;
import com.espada.model.qKabupaten;
import com.espada.model.qKecamatan;
import com.espada.model.qKurir;
import com.espada.model.qLayanan;
import com.espada.model.qPengiriman;
import com.espada.model.qProvinsi;
import com.espada.model.qTarif;
import com.espada.model.qUsaha;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFrame;

public class Pengiriman extends javax.swing.JFrame {
    qPengiriman pengiriman = new qPengiriman();
    qKecamatan kecamatan = new qKecamatan();
    qLayanan layanan = new qLayanan();
    qKurir kurir = new qKurir();
    qUsaha usaha = new qUsaha();
    private Chart chartz = new Chart();
    Pengiriman myWindows = this;
    private int tempDeletePengiriman=-1;
    private int tempDeleteBarang=-1;
    /**
     * Creates new form Test
     */
    public Pengiriman() {
        initComponents();
        this.setTitle(usaha.getNamaUsaha().get(0)+" - Pengiriman");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        ImageIcon ico = new ImageIcon("logo.png");
        this.setIconImage(ico.getImage());
        fillPengiriman();
        emptyBarang();
    }
    public void fillPengiriman(){
         DefaultTableModel model = (DefaultTableModel) tablePengiriman.getModel();
        model.getDataVector().removeAllElements();
        revalidate();
        for(int i=0;i<pengiriman.getPengiriman().size();i++){
            String idPengiriman = (String) pengiriman.getPengiriman().get(i).get(0);
            String namaPengirim = (String) pengiriman.getPengiriman().get(i).get(1);
            String namaPenerima = (String) pengiriman.getPengiriman().get(i).get(2);
            String idKecPengirim = (String) pengiriman.getPengiriman().get(i).get(3);
            String idKecPenerima = (String) pengiriman.getPengiriman().get(i).get(4);
            String alamatPenerima = (String) pengiriman.getPengiriman().get(i).get(5);
            String tanggalPengiriman = (String) pengiriman.getPengiriman().get(i).get(6);
            String tanggalKirimPengiriman = (String) pengiriman.getPengiriman().get(i).get(7);
            String tanggalTibaPengiriman = (String) pengiriman.getPengiriman().get(i).get(8);
            String totalBeratPengiriman = (String) pengiriman.getPengiriman().get(i).get(9);
            String kodeLayanan = (String) pengiriman.getPengiriman().get(i).get(10);
            String idKurir = (String) pengiriman.getPengiriman().get(i).get(11);
            String harga = (String) pengiriman.getPengiriman().get(i).get(12);
            String hari = (String) pengiriman.getPengiriman().get(i).get(13);
            String verifikasi = (String) pengiriman.getPengiriman().get(i).get(14);
            
            String kecPengirim = (String)kecamatan.getKecamatanMe(idKecPengirim).get(0).get(2);
            String kecPenerima = (String)kecamatan.getKecamatanMe(idKecPenerima).get(0).get(2);
            String myLayanan = (String)layanan.getLayananbyKode(kodeLayanan).get(0).get(2);
            String myKurir = (String) kurir.getKurir(idKurir).get(0).get(1);
            
            model.addRow(new Object[]{idPengiriman,
                namaPengirim,
                namaPenerima,
                kecPengirim,
                kecPenerima,
                alamatPenerima,
                tanggalKirimPengiriman,
                tanggalTibaPengiriman,
                totalBeratPengiriman,
                myLayanan,
                myKurir,
                harga,
                hari,
            verifikasi});
        }
    }
    
    public void emptyBarang(){
     
        DefaultTableModel model = (DefaultTableModel) tableBarang.getModel();
        model.getDataVector().removeAllElements();
        revalidate();   
    }
    
    public void fillBarang(){
        String idsPengiriman = (String)tablePengiriman.getValueAt(tablePengiriman.getSelectedRow(),0);
        DefaultTableModel model = (DefaultTableModel) tableBarang.getModel();
        model.getDataVector().removeAllElements();
        revalidate();
        for(int i=0;i<pengiriman.getBarang(idsPengiriman).size();i++){
            String idBarang = (String) pengiriman.getBarang(idsPengiriman).get(i).get(0);
            String idPengiriman = (String) pengiriman.getBarang(idsPengiriman).get(i).get(1);
            String keteranganBarang = (String) pengiriman.getBarang(idsPengiriman).get(i).get(2);
            String beratBarang = (String) pengiriman.getBarang(idsPengiriman).get(i).get(3);
            
            model.addRow(new Object[]{
                idBarang,
                idPengiriman,
                keteranganBarang,
                beratBarang});
        }
        
        System.out.println(pengiriman.getBarang(idsPengiriman).size());
        
        if(pengiriman.getBarang(idsPengiriman).size()==0){
           model.addRow(new Object[]{
                "",
                "",
                "",
                ""});
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
        tablePengiriman = new javax.swing.JTable();
        labelViewPengiriman = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableBarang = new javax.swing.JTable();
        labelViewBarang = new javax.swing.JLabel();
        btnDelete2 = new javax.swing.JButton();
        btnDelete1 = new javax.swing.JButton();
        btnVerif = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuPengiriman = new javax.swing.JMenuItem();
        menuKasir = new javax.swing.JMenuItem();
        menuTarif1 = new javax.swing.JMenuItem();
        menuWilayah = new javax.swing.JMenu();
        submenuProvinsi = new javax.swing.JMenuItem();
        submenuKabupaten = new javax.swing.JMenuItem();
        submenuKecamatan = new javax.swing.JMenuItem();
        menuLayanan = new javax.swing.JMenu();
        menuKurir = new javax.swing.JMenu();
        menuAlat = new javax.swing.JMenu();
        submenuExport = new javax.swing.JMenu();
        subsubmenuExportKurir = new javax.swing.JMenuItem();
        subsubmenuExportLayanan = new javax.swing.JMenuItem();
        subsubmenuExportPengiriman = new javax.swing.JMenuItem();
        subsubmenuExportTarif = new javax.swing.JMenuItem();
        subsubMenuWilayah = new javax.swing.JMenuItem();
        submenuImport = new javax.swing.JMenu();
        subsubmenuImportKurir = new javax.swing.JMenuItem();
        subsubmenuImportLayanan = new javax.swing.JMenuItem();
        subsubmenuImportPengiriman = new javax.swing.JMenuItem();
        submenuChart = new javax.swing.JMenu();
        subsubmenuChartVerPengiriman = new javax.swing.JMenuItem();
        subsubmenuChartLayanan = new javax.swing.JMenuItem();
        subsubmenuChartKurir = new javax.swing.JMenuItem();
        subsubmenuChartKecPenerima = new javax.swing.JMenuItem();
        subsubMenuKecPengirim = new javax.swing.JMenuItem();
        subsubmenuKabPengirim = new javax.swing.JMenuItem();
        subsubmenuCharKabPenerima = new javax.swing.JMenuItem();
        subsubmenuCharProvPenerima = new javax.swing.JMenuItem();
        subsubmenuChartProPengirim = new javax.swing.JMenuItem();
        subsubmenuChartPengiriman = new javax.swing.JMenuItem();
        submenuPengaturan = new javax.swing.JMenu();
        subsubmenuPengaturanUsaha = new javax.swing.JMenuItem();
        subsubmenuPengaturanAdministrator = new javax.swing.JMenuItem();
        menuBantuan = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablePengiriman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nama Pengirim", "Nama Penerima", "Kec Pengirim", "Kec Penerima", "Alamat Penerima", "Tanggal Kirim", "Tanggal Tiba", "Total Berat", "Layanan", "Kurir", "Harga", "Hari", "Verifikasi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePengiriman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePengirimanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePengiriman);

        labelViewPengiriman.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelViewPengiriman.setText("Pengiriman");

        tableBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "ID Pengiriman", "Keterangan Barang", "Bobot Barang"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableBarangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableBarang);

        labelViewBarang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelViewBarang.setText("Barang");

        btnDelete2.setText("Hapus");
        btnDelete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete2ActionPerformed(evt);
            }
        });

        btnDelete1.setText("Hapus");
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });

        btnVerif.setText("Verifikasi");
        btnVerif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerifActionPerformed(evt);
            }
        });

        jMenu1.setText("Order");

        menuPengiriman.setText("Pengiriman");
        menuPengiriman.setEnabled(false);
        menuPengiriman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPengirimanActionPerformed(evt);
            }
        });
        jMenu1.add(menuPengiriman);

        menuKasir.setText("Kasir");
        menuKasir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuKasirActionPerformed(evt);
            }
        });
        jMenu1.add(menuKasir);

        menuTarif1.setText("Tarif");
        menuTarif1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTarif1ActionPerformed(evt);
            }
        });
        jMenu1.add(menuTarif1);

        menuBar.add(jMenu1);

        menuWilayah.setText("Wilayah");

        submenuProvinsi.setText("Provinsi");
        submenuProvinsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuProvinsiActionPerformed(evt);
            }
        });
        menuWilayah.add(submenuProvinsi);

        submenuKabupaten.setText("Kabupaten / Kota");
        submenuKabupaten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuKabupatenActionPerformed(evt);
            }
        });
        menuWilayah.add(submenuKabupaten);

        submenuKecamatan.setText("Kecamatan");
        submenuKecamatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuKecamatanActionPerformed(evt);
            }
        });
        menuWilayah.add(submenuKecamatan);

        menuBar.add(menuWilayah);

        menuLayanan.setText("Layanan");
        menuLayanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuLayananMouseClicked(evt);
            }
        });
        menuLayanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLayananActionPerformed(evt);
            }
        });
        menuBar.add(menuLayanan);

        menuKurir.setText("Kurir");
        menuKurir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuKurirMouseClicked(evt);
            }
        });
        menuKurir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuKurirActionPerformed(evt);
            }
        });
        menuBar.add(menuKurir);

        menuAlat.setText("Alat");

        submenuExport.setText("Export");

        subsubmenuExportKurir.setText("Kurir");
        subsubmenuExportKurir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subsubmenuExportKurirActionPerformed(evt);
            }
        });
        submenuExport.add(subsubmenuExportKurir);

        subsubmenuExportLayanan.setText("Layanan");
        subsubmenuExportLayanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subsubmenuExportLayananActionPerformed(evt);
            }
        });
        submenuExport.add(subsubmenuExportLayanan);

        subsubmenuExportPengiriman.setText("Pengiriman");
        subsubmenuExportPengiriman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subsubmenuExportPengirimanActionPerformed(evt);
            }
        });
        submenuExport.add(subsubmenuExportPengiriman);

        subsubmenuExportTarif.setText("Tarif");
        subsubmenuExportTarif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subsubmenuExportTarifActionPerformed(evt);
            }
        });
        submenuExport.add(subsubmenuExportTarif);

        subsubMenuWilayah.setText("Wilayah");
        subsubMenuWilayah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subsubMenuWilayahActionPerformed(evt);
            }
        });
        submenuExport.add(subsubMenuWilayah);

        menuAlat.add(submenuExport);

        submenuImport.setText("Import");

        subsubmenuImportKurir.setText("Kurir");
        subsubmenuImportKurir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subsubmenuImportKurirActionPerformed(evt);
            }
        });
        submenuImport.add(subsubmenuImportKurir);

        subsubmenuImportLayanan.setText("Layanan");
        subsubmenuImportLayanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subsubmenuImportLayananActionPerformed(evt);
            }
        });
        submenuImport.add(subsubmenuImportLayanan);

        subsubmenuImportPengiriman.setText("Pengiriman");
        subsubmenuImportPengiriman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subsubmenuImportPengirimanActionPerformed(evt);
            }
        });
        submenuImport.add(subsubmenuImportPengiriman);

        menuAlat.add(submenuImport);

        submenuChart.setText("Chart");

        subsubmenuChartVerPengiriman.setText("Verifikasi Pengiriman");
        subsubmenuChartVerPengiriman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subsubmenuChartVerPengirimanActionPerformed(evt);
            }
        });
        submenuChart.add(subsubmenuChartVerPengiriman);

        subsubmenuChartLayanan.setText("Layanan");
        subsubmenuChartLayanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subsubmenuChartLayananActionPerformed(evt);
            }
        });
        submenuChart.add(subsubmenuChartLayanan);

        subsubmenuChartKurir.setText("Kurir");
        subsubmenuChartKurir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subsubmenuChartKurirActionPerformed(evt);
            }
        });
        submenuChart.add(subsubmenuChartKurir);

        subsubmenuChartKecPenerima.setText("Kecamatan Penerima");
        subsubmenuChartKecPenerima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subsubmenuChartKecPenerimaActionPerformed(evt);
            }
        });
        submenuChart.add(subsubmenuChartKecPenerima);

        subsubMenuKecPengirim.setText("Kecamatan Pengirim");
        subsubMenuKecPengirim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subsubMenuKecPengirimActionPerformed(evt);
            }
        });
        submenuChart.add(subsubMenuKecPengirim);

        subsubmenuKabPengirim.setText("Kabupaten Pengirim");
        subsubmenuKabPengirim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subsubmenuKabPengirimActionPerformed(evt);
            }
        });
        submenuChart.add(subsubmenuKabPengirim);

        subsubmenuCharKabPenerima.setText("Kabupaten Penerima");
        subsubmenuCharKabPenerima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subsubmenuCharKabPenerimaActionPerformed(evt);
            }
        });
        submenuChart.add(subsubmenuCharKabPenerima);

        subsubmenuCharProvPenerima.setText("Provinsi Penerima");
        subsubmenuCharProvPenerima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subsubmenuCharProvPenerimaActionPerformed(evt);
            }
        });
        submenuChart.add(subsubmenuCharProvPenerima);

        subsubmenuChartProPengirim.setText("Provinsi Pengirim");
        subsubmenuChartProPengirim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subsubmenuChartProPengirimActionPerformed(evt);
            }
        });
        submenuChart.add(subsubmenuChartProPengirim);

        subsubmenuChartPengiriman.setText("Pengiriman");
        subsubmenuChartPengiriman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subsubmenuChartPengirimanActionPerformed(evt);
            }
        });
        submenuChart.add(subsubmenuChartPengiriman);

        menuAlat.add(submenuChart);

        submenuPengaturan.setText("Pengaturan");

        subsubmenuPengaturanUsaha.setText("Usaha");
        subsubmenuPengaturanUsaha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subsubmenuPengaturanUsahaActionPerformed(evt);
            }
        });
        submenuPengaturan.add(subsubmenuPengaturanUsaha);

        subsubmenuPengaturanAdministrator.setText("Administartor");
        subsubmenuPengaturanAdministrator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subsubmenuPengaturanAdministratorActionPerformed(evt);
            }
        });
        submenuPengaturan.add(subsubmenuPengaturanAdministrator);

        menuAlat.add(submenuPengaturan);

        menuBar.add(menuAlat);

        menuBantuan.setText("Bantuan");

        jMenuItem1.setText("Espada");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuBantuan.add(jMenuItem1);

        menuBar.add(menuBantuan);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelViewBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelViewPengiriman, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVerif, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDelete1)
                        .addComponent(btnVerif, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelViewPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelViewBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablePengirimanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePengirimanMouseClicked
        // TODO add your handling code here:

        tempDeletePengiriman=Integer.parseInt((String)tablePengiriman.getValueAt(tablePengiriman.getSelectedRow(),0));

        labelViewPengiriman.setText(
            (String) tablePengiriman.getValueAt(tablePengiriman.getSelectedRow(), 1)+" | "
            +(String) tablePengiriman.getValueAt(tablePengiriman.getSelectedRow(), 2)+" | "
            +(String) tablePengiriman.getValueAt(tablePengiriman.getSelectedRow(), 3)+" | "
            +(String) tablePengiriman.getValueAt(tablePengiriman.getSelectedRow(), 4)+" | "
            +(String) tablePengiriman.getValueAt(tablePengiriman.getSelectedRow(), 5)+" | "
            +(String) tablePengiriman.getValueAt(tablePengiriman.getSelectedRow(), 6)+" | "
            +(String) tablePengiriman.getValueAt(tablePengiriman.getSelectedRow(), 7)+" | "
            +(String) tablePengiriman.getValueAt(tablePengiriman.getSelectedRow(), 8)+" | "
            +(String) tablePengiriman.getValueAt(tablePengiriman.getSelectedRow(), 9)+" | "
            +(String) tablePengiriman.getValueAt(tablePengiriman.getSelectedRow(), 10)+" | "
            +(String) tablePengiriman.getValueAt(tablePengiriman.getSelectedRow(), 11)+" | "
            +(String) tablePengiriman.getValueAt(tablePengiriman.getSelectedRow(), 12)+" | "
            +(String) tablePengiriman.getValueAt(tablePengiriman.getSelectedRow(), 13));
        fillBarang();
    }//GEN-LAST:event_tablePengirimanMouseClicked

    private void btnDelete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete2ActionPerformed
        // TODO add your handling code here:
        pengiriman.deleteBarang(tempDeleteBarang);
        fillBarang();
    }//GEN-LAST:event_btnDelete2ActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        // TODO add your handling code here:
        pengiriman.deletePengiriman(tempDeletePengiriman);
        fillPengiriman();
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void submenuProvinsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuProvinsiActionPerformed
        // TODO add your handling code here:
        Provinsi windowProvinsi = new Provinsi();
        windowProvinsi.pack();
        windowProvinsi.setVisible(true);
        this.setEnabled(false);
        windowProvinsi.addWindowListener(new WindowAdapter(){

            @Override
            public void windowClosing(WindowEvent e) {
                myWindows.setEnabled(true);
                myWindows.dispose();
                myWindows.setVisible(true);
            }
        });
    }//GEN-LAST:event_submenuProvinsiActionPerformed

    private void submenuKabupatenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuKabupatenActionPerformed
        // TODO add your handling code here:
        Kabupaten windowKabupaten = new Kabupaten();
        windowKabupaten.pack();
        windowKabupaten.setVisible(true);
        this.setEnabled(false);
        windowKabupaten.addWindowListener(new WindowAdapter(){

            @Override
            public void windowClosing(WindowEvent e) {
                myWindows.setEnabled(true);
                myWindows.dispose();
                myWindows.setVisible(true);
            }
        });
    }//GEN-LAST:event_submenuKabupatenActionPerformed

    private void submenuKecamatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuKecamatanActionPerformed
        // TODO add your handling code here:
        Kecamatan windowKecamatan = new Kecamatan();
        windowKecamatan.pack();
        windowKecamatan.setVisible(true);
        this.setEnabled(false);
        windowKecamatan.addWindowListener(new WindowAdapter(){

            @Override
            public void windowClosing(WindowEvent e) {
                myWindows.setEnabled(true);
                myWindows.dispose();
                myWindows.setVisible(true);
            }
        });
    }//GEN-LAST:event_submenuKecamatanActionPerformed

    private void menuLayananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLayananMouseClicked
        // TODO add your handling code here:
        Layanan windowLayanan = new Layanan();
        windowLayanan.pack();
        windowLayanan.setVisible(true);
        this.setEnabled(false);
        windowLayanan.addWindowListener(new WindowAdapter(){

            @Override
            public void windowClosing(WindowEvent e) {
                myWindows.setEnabled(true);
                myWindows.dispose();
                myWindows.setVisible(true);
            }
        });
    }//GEN-LAST:event_menuLayananMouseClicked

    private void menuLayananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLayananActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuLayananActionPerformed

    private void menuKurirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuKurirMouseClicked
        // TODO add your handling code here:
        Kurir windowKurir = new Kurir();
        windowKurir.pack();
        windowKurir.setVisible(true);
        this.setEnabled(false);
        windowKurir.addWindowListener(new WindowAdapter(){

            @Override
            public void windowClosing(WindowEvent e) {
                myWindows.setEnabled(true);
                myWindows.dispose();
                myWindows.setVisible(true);
            }
        });
    }//GEN-LAST:event_menuKurirMouseClicked

    private void menuKurirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKurirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuKurirActionPerformed

    private void menuPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPengirimanActionPerformed
        // TODO add your handling code here:
        Pengiriman windowPengiriman = new Pengiriman();
        windowPengiriman.pack();
        windowPengiriman.setVisible(true);
        this.dispose();
        windowPengiriman.addWindowListener(new WindowAdapter(){

            @Override
            public void windowClosing(WindowEvent e) {

            }
        });
    }//GEN-LAST:event_menuPengirimanActionPerformed

    private void menuKasirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKasirActionPerformed
        // TODO add your handling code here:
        Kasir windowKasir = new Kasir();
        windowKasir.pack();
        windowKasir.setVisible(true);
        this.dispose();
        windowKasir.addWindowListener(new WindowAdapter(){

            @Override
            public void windowClosing(WindowEvent e) {

            }
        });
    }//GEN-LAST:event_menuKasirActionPerformed

    private void menuTarif1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTarif1ActionPerformed
        // TODO add your handling code here:
        Tarif windowTarif = new Tarif();
        windowTarif.pack();
        windowTarif.setVisible(true);
        this.dispose();
        windowTarif.addWindowListener(new WindowAdapter(){

            @Override
            public void windowClosing(WindowEvent e) {
                //
            }
        });
    }//GEN-LAST:event_menuTarif1ActionPerformed

    private void tableBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBarangMouseClicked
        // TODO add your handling code here:
        
        if(((String)tableBarang.getValueAt(tableBarang.getSelectedRow(), 1)).equals("")){
            btnDelete2.setEnabled(false);
        }else{
            labelViewBarang.setText(
            (String) tableBarang.getValueAt(tableBarang.getSelectedRow(), 1)+" | "
            +(String) tableBarang.getValueAt(tableBarang.getSelectedRow(), 2)+" | "
            +(String) tableBarang.getValueAt(tableBarang.getSelectedRow(), 3));
        tempDeleteBarang=Integer.parseInt((String)tableBarang.getValueAt(tableBarang.getSelectedRow(), 0));
        btnDelete2.setEnabled(true);
        }
    }//GEN-LAST:event_tableBarangMouseClicked

    private void btnVerifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerifActionPerformed
        // TODO add your handling code here:
        pengiriman.verifikasiPengiriman(tempDeletePengiriman);
        fillPengiriman();
    }//GEN-LAST:event_btnVerifActionPerformed

    private void subsubmenuImportKurirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsubmenuImportKurirActionPerformed
        // TODO add your handling code here:
        com.espada.gui.excel.importz.Kurir kurirImport = new com.espada.gui.excel.importz.Kurir();
        kurirImport.pack();
        kurirImport.setVisible(true);
    }//GEN-LAST:event_subsubmenuImportKurirActionPerformed

    private void subsubmenuImportLayananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsubmenuImportLayananActionPerformed
        // TODO add your handling code here:
        com.espada.gui.excel.importz.Layanan layananImport = new com.espada.gui.excel.importz.Layanan();
        layananImport.pack();
        layananImport.setVisible(true);
    }//GEN-LAST:event_subsubmenuImportLayananActionPerformed

    private void subsubmenuImportPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsubmenuImportPengirimanActionPerformed
        // TODO add your handling code here:
        com.espada.gui.excel.importz.Pengiriman pengirimanImport = new com.espada.gui.excel.importz.Pengiriman();
        pengirimanImport.pack();
        pengirimanImport.setVisible(true);
    }//GEN-LAST:event_subsubmenuImportPengirimanActionPerformed

    private void subsubmenuExportKurirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsubmenuExportKurirActionPerformed
        // TODO add your handling code here:
        com.espada.gui.excel.exportz.Kurir exportKurir = new com.espada.gui.excel.exportz.Kurir();
        exportKurir.pack();
        exportKurir.setVisible(true);
    }//GEN-LAST:event_subsubmenuExportKurirActionPerformed

    private void subsubmenuExportLayananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsubmenuExportLayananActionPerformed
        // TODO add your handling code here:
        com.espada.gui.excel.exportz.Layanan exportLayanan = new com.espada.gui.excel.exportz.Layanan();
        exportLayanan.pack();
        exportLayanan.setVisible(true);
    }//GEN-LAST:event_subsubmenuExportLayananActionPerformed

    private void subsubmenuExportPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsubmenuExportPengirimanActionPerformed
        // TODO add your handling code here:
        com.espada.gui.excel.exportz.Pengiriman exportPengiriman = new com.espada.gui.excel.exportz.Pengiriman();
        exportPengiriman.pack();
        exportPengiriman.setVisible(true);
    }//GEN-LAST:event_subsubmenuExportPengirimanActionPerformed

    private void subsubmenuExportTarifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsubmenuExportTarifActionPerformed
        // TODO add your handling code here:
        com.espada.gui.excel.exportz.Tarif exportTarif = new com.espada.gui.excel.exportz.Tarif();
        exportTarif.pack();
        exportTarif.setVisible(true);
    }//GEN-LAST:event_subsubmenuExportTarifActionPerformed

    private void subsubMenuWilayahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsubMenuWilayahActionPerformed
        // TODO add your handling code here:
        com.espada.gui.excel.exportz.Wilayah exportWilayah = new com.espada.gui.excel.exportz.Wilayah();
        exportWilayah.pack();
        exportWilayah.setVisible(true);
    }//GEN-LAST:event_subsubMenuWilayahActionPerformed

    private void subsubmenuPengaturanUsahaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsubmenuPengaturanUsahaActionPerformed
        // TODO add your handling code here:
        SetUsaha windowSetUsaha = new SetUsaha();
        windowSetUsaha.pack();
        windowSetUsaha.setVisible(true);
        
    }//GEN-LAST:event_subsubmenuPengaturanUsahaActionPerformed

    private void subsubmenuChartVerPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsubmenuChartVerPengirimanActionPerformed
        // TODO add your handling code here:
        ChartFrame frame = chartz.chartPieVerifikasi();
        frame.setVisible(true);
        frame.setSize(450,500);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Chart Verifikasi Pengiriman");
        ImageIcon ico = new ImageIcon("logo.png");
        frame.setIconImage(ico.getImage());
    }//GEN-LAST:event_subsubmenuChartVerPengirimanActionPerformed

    private void subsubmenuChartLayananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsubmenuChartLayananActionPerformed
        // TODO add your handling code here:
        ChartFrame frame = chartz.chartPieLayanan();
        frame.setVisible(true);
        frame.setSize(450,500);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Chart Layanan Pengiriman");
        ImageIcon ico = new ImageIcon("logo.png");
        frame.setIconImage(ico.getImage());
    }//GEN-LAST:event_subsubmenuChartLayananActionPerformed

    private void subsubmenuChartKurirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsubmenuChartKurirActionPerformed
        // TODO add your handling code here:
        ChartFrame frame = chartz.chartPieKurir();
        frame.setVisible(true);
        frame.setSize(450,500);
        frame.setTitle("Chart Kurir Pengiriman");
        frame.setLocationRelativeTo(null);
        ImageIcon ico = new ImageIcon("logo.png");
        frame.setIconImage(ico.getImage());
    }//GEN-LAST:event_subsubmenuChartKurirActionPerformed

    private void subsubmenuChartKecPenerimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsubmenuChartKecPenerimaActionPerformed
        // TODO add your handling code here:
        ChartFrame frame = chartz.chartBarKecamatanPenerima();
        frame.setVisible(true);
        frame.setSize(450,500);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Chart Kecamatan Penerima Pengiriman");
        ImageIcon ico = new ImageIcon("logo.png");
        frame.setIconImage(ico.getImage());
    }//GEN-LAST:event_subsubmenuChartKecPenerimaActionPerformed

    private void subsubMenuKecPengirimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsubMenuKecPengirimActionPerformed
        // TODO add your handling code here:
        ChartFrame frame = chartz.chartBarKecamatanPengirim();
        frame.setVisible(true);
        frame.setSize(450,500);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Chart Kecamatan Pengirim Pengiriman");
        ImageIcon ico = new ImageIcon("logo.png");
        frame.setIconImage(ico.getImage());
    }//GEN-LAST:event_subsubMenuKecPengirimActionPerformed

    private void subsubmenuCharKabPenerimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsubmenuCharKabPenerimaActionPerformed
        // TODO add your handling code here:
        ChartFrame frame = chartz.chartBarKotaPenerima();
        frame.setVisible(true);
        frame.setSize(450,500);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Chart Kabupaten Penerima Pengiriman");
        ImageIcon ico = new ImageIcon("logo.png");
        frame.setIconImage(ico.getImage());
    }//GEN-LAST:event_subsubmenuCharKabPenerimaActionPerformed

    private void subsubmenuKabPengirimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsubmenuKabPengirimActionPerformed
        // TODO add your handling code here:
        ChartFrame frame = chartz.chartBarKotaPengirim();
        frame.setVisible(true);
        frame.setSize(450,500);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Chart Kabupaten Pengirim Pengiriman");
        ImageIcon ico = new ImageIcon("logo.png");
        frame.setIconImage(ico.getImage());
    }//GEN-LAST:event_subsubmenuKabPengirimActionPerformed

    private void subsubmenuCharProvPenerimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsubmenuCharProvPenerimaActionPerformed
        // TODO add your handling code here:
        ChartFrame frame = chartz.chartBarProvinsiPenerima();
        frame.setVisible(true);
        frame.setSize(450,500);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Chart Provinsi Penerima Pengiriman");
        ImageIcon ico = new ImageIcon("logo.png");
        frame.setIconImage(ico.getImage());
    }//GEN-LAST:event_subsubmenuCharProvPenerimaActionPerformed

    private void subsubmenuChartProPengirimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsubmenuChartProPengirimActionPerformed
        // TODO add your handling code here:
        ChartFrame frame = chartz.chartBarProvinsiPengirim();
        frame.setVisible(true);
        frame.setSize(450,500);
        frame.setTitle("Chart Provinsi Pengirim Pengiriman");
        ImageIcon ico = new ImageIcon("logo.png");
        frame.setIconImage(ico.getImage());
        frame.setLocationRelativeTo(null);
    }//GEN-LAST:event_subsubmenuChartProPengirimActionPerformed

    private void subsubmenuChartPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsubmenuChartPengirimanActionPerformed
        // TODO add your handling code here:
        ChartFrame frame = chartz.chartLinePengiriman();
        frame.setVisible(true);
        frame.setSize(450,500);
        frame.setTitle("Chart Pengiriman");
        frame.setLocationRelativeTo(null);
        ImageIcon ico = new ImageIcon("logo.png");
        frame.setIconImage(ico.getImage());
    }//GEN-LAST:event_subsubmenuChartPengirimanActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        Espada copyright = new Espada();
        copyright.pack();
        copyright.setVisible(true);

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void subsubmenuPengaturanAdministratorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsubmenuPengaturanAdministratorActionPerformed
        // TODO add your handling code here:
        Administrator windowAdmin = new Administrator();
        windowAdmin.pack();
        windowAdmin.setVisible(true);
    }//GEN-LAST:event_subsubmenuPengaturanAdministratorActionPerformed

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
            java.util.logging.Logger.getLogger(Pengiriman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pengiriman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pengiriman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pengiriman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pengiriman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnDelete2;
    private javax.swing.JButton btnVerif;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelViewBarang;
    private javax.swing.JLabel labelViewPengiriman;
    private javax.swing.JMenu menuAlat;
    private javax.swing.JMenu menuBantuan;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuKasir;
    private javax.swing.JMenu menuKurir;
    private javax.swing.JMenu menuLayanan;
    private javax.swing.JMenuItem menuPengiriman;
    private javax.swing.JMenuItem menuTarif1;
    private javax.swing.JMenu menuWilayah;
    private javax.swing.JMenu submenuChart;
    private javax.swing.JMenu submenuExport;
    private javax.swing.JMenu submenuImport;
    private javax.swing.JMenuItem submenuKabupaten;
    private javax.swing.JMenuItem submenuKecamatan;
    private javax.swing.JMenu submenuPengaturan;
    private javax.swing.JMenuItem submenuProvinsi;
    private javax.swing.JMenuItem subsubMenuKecPengirim;
    private javax.swing.JMenuItem subsubMenuWilayah;
    private javax.swing.JMenuItem subsubmenuCharKabPenerima;
    private javax.swing.JMenuItem subsubmenuCharProvPenerima;
    private javax.swing.JMenuItem subsubmenuChartKecPenerima;
    private javax.swing.JMenuItem subsubmenuChartKurir;
    private javax.swing.JMenuItem subsubmenuChartLayanan;
    private javax.swing.JMenuItem subsubmenuChartPengiriman;
    private javax.swing.JMenuItem subsubmenuChartProPengirim;
    private javax.swing.JMenuItem subsubmenuChartVerPengiriman;
    private javax.swing.JMenuItem subsubmenuExportKurir;
    private javax.swing.JMenuItem subsubmenuExportLayanan;
    private javax.swing.JMenuItem subsubmenuExportPengiriman;
    private javax.swing.JMenuItem subsubmenuExportTarif;
    private javax.swing.JMenuItem subsubmenuImportKurir;
    private javax.swing.JMenuItem subsubmenuImportLayanan;
    private javax.swing.JMenuItem subsubmenuImportPengiriman;
    private javax.swing.JMenuItem subsubmenuKabPengirim;
    private javax.swing.JMenuItem subsubmenuPengaturanAdministrator;
    private javax.swing.JMenuItem subsubmenuPengaturanUsaha;
    private javax.swing.JTable tableBarang;
    private javax.swing.JTable tablePengiriman;
    // End of variables declaration//GEN-END:variables
}
