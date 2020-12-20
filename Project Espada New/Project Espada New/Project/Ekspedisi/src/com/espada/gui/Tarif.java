package com.espada.gui;

import com.espada.Chart;
import com.espada.gui.wilayah.Kabupaten;
import com.espada.gui.wilayah.Kecamatan;
import com.espada.gui.wilayah.Provinsi;
import com.espada.model.qKabupaten;
import com.espada.model.qKecamatan;
import com.espada.model.qLayanan;
import com.espada.model.qProvinsi;
import com.espada.model.qTarif;
import com.espada.model.qUsaha;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import org.jfree.chart.ChartFrame;

public class Tarif extends javax.swing.JFrame {
    private Tarif myWindows = this;
    private qTarif tarif = new qTarif();
    private qLayanan layanan = new qLayanan();
    private qProvinsi provinsi = new qProvinsi();
    private qKabupaten kabupaten = new qKabupaten();
    private qKecamatan kecamatan = new qKecamatan();
    private qUsaha usaha = new qUsaha();
    private Chart chartz = new Chart();
    private String[] kodeLayananArray = new String[layanan.getLayanan().size()];
    private String[] idLayananArray = new String[layanan.getLayanan().size()];
    private String[] provinsiPengirimArray = new String[provinsi.getProvinsi().size()];
    private String[] provinsiPenerimaArray = new String[provinsi.getProvinsi().size()];
    private String[] kabupatenPengirimArray = new String[kabupaten.getKota().size()];
    private String[] kabupatenPenerimaArray = new String[kabupaten.getKota().size()];
    private String[] kecamatanPengirimArray = new String[kecamatan.getKecamatan().size()];
    private String[] kecamatanPenerimaArray = new String[kecamatan.getKecamatan().size()];
    private String kecamatanPengirimFix;
    private String kecamatanPenerimaFix;
    private int tempDelete=-1;
    
    /**
     * Creates new form Tarif
     */
    public Tarif() {
        initComponents();
        this.setTitle(usaha.getNamaUsaha().get(0)+" - Tarif");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        ImageIcon ico = new ImageIcon("logo.png");
        this.setIconImage(ico.getImage());
        fillTarif();
        fillLayananCombo();
        fillProvinsiPengirimCombo();
        fillProvinsiPenerimaCombo();
    }
    
    public void fillTarif(){
         DefaultTableModel model = (DefaultTableModel) tableTarif.getModel();
        model.getDataVector().removeAllElements();
        revalidate();
        for(int i=0;i<tarif.getTarif().size();i++){
            String idTarif = (String) tarif.getTarif().get(i).get(0);
            String idKecAsal = (String) tarif.getTarif().get(i).get(1);
            String idKecTujuan = (String) tarif.getTarif().get(i).get(2);
            String idLayanan = (String) tarif.getTarif().get(i).get(3);
            String durasi = (String) tarif.getTarif().get(i).get(4);
            String harga = (String) tarif.getTarif().get(i).get(5);
            
            String kecamatanAsal = (String) kecamatan.getKecamatanMe(idKecAsal).get(0).get(2);
            String kecamatanTujuan = (String) kecamatan.getKecamatanMe(idKecTujuan).get(0).get(2);
            String myLayanan = (String) layanan.getLayanan(idLayanan).get(0).get(1);
            
            model.addRow(new Object[]{idTarif, kecamatanAsal, kecamatanTujuan, myLayanan, durasi+" hari", harga});
        }
    }
    
    public void fillLayananCombo(){
        comboLayanan.removeAllItems();
        for(int i=0;i<layanan.getLayanan().size();i++){
            kodeLayananArray[i]=(String)layanan.getLayanan().get(i).get(2);
            idLayananArray[i]=(String)layanan.getLayanan().get(i).get(0);
            comboLayanan.addItem((String)layanan.getLayanan().get(i).get(1));
        }
    }
    
    public void fillProvinsiPengirimCombo(){
        comboProvinsiPengirim.removeAllItems();
        for(int i=0;i<provinsi.getProvinsi().size();i++){
            provinsiPengirimArray[i]=(String)provinsi.getProvinsi().get(i).get(1);
            comboProvinsiPengirim.addItem((String)provinsi.getProvinsi().get(i).get(0));
        }
    }
    
    public void fillProvinsiPenerimaCombo(){
        comboProvinsiPenerima.removeAllItems();
        for(int i=0;i<provinsi.getProvinsi().size();i++){
            provinsiPenerimaArray[i]=(String)provinsi.getProvinsi().get(i).get(1);
            comboProvinsiPenerima.addItem((String)provinsi.getProvinsi().get(i).get(0));
        }
    }
    
    public void fillKabupatenPengirimCombo(String idProvinsi){
        comboKabupatenPengirim.removeAllItems();
        if(kabupaten.getKota(idProvinsi).size()<=0){
            comboKabupatenPengirim.enable(false);
            comboKecamatanPengirim.enable(false);
            comboKecamatanPengirim.removeAllItems();
        }else{
            comboKabupatenPengirim.enable(true);
            comboKecamatanPengirim.enable(true);
            for(int i=0;i<kabupaten.getKota(idProvinsi).size();i++){
                kabupatenPengirimArray[i]=(String)kabupaten.getKota(idProvinsi).get(i).get(0);
                comboKabupatenPengirim.addItem((String)kabupaten.getKota(idProvinsi).get(i).get(2));
            }
        }
        for(int i=0;i<kabupaten.getKota(idProvinsi).size();i++){
                System.out.println(kabupatenPengirimArray[i]);
            }
    }
    
    public void fillKabupatenPenerimaCombo(String idProvinsi){
        comboKabupatenPenerima.removeAllItems();
        if(kabupaten.getKota(idProvinsi).size()<=0){
            comboKabupatenPenerima.enable(false);
             comboKecamatanPenerima.enable(false);
            comboKecamatanPenerima.removeAllItems();
        }else{
            comboKabupatenPenerima.enable(true);
            comboKecamatanPenerima.enable(true);
            for(int i=0;i<kabupaten.getKota(idProvinsi).size();i++){
                kabupatenPenerimaArray[i]=(String)kabupaten.getKota(idProvinsi).get(i).get(0);
                comboKabupatenPenerima.addItem((String)kabupaten.getKota(idProvinsi).get(i).get(2));
            }
        }
        
    }
    
     public void fillKecamatanPengirimCombo(String idKota){
        comboKecamatanPengirim.removeAllItems();
        if(kecamatan.getKecamatan(idKota).size()<=0){
            comboKecamatanPengirim.enable(false);
        }else{
            comboKecamatanPengirim.enable(true);
            for(int i=0;i<kecamatan.getKecamatan(idKota).size();i++){
                kecamatanPengirimArray[i]=(String)kecamatan.getKecamatan(idKota).get(i).get(0);
                comboKecamatanPengirim.addItem((String)kecamatan.getKecamatan(idKota).get(i).get(2));
            }
        }
    }
     
     public void fillKecamatanPenerimaCombo(String idKota){
        comboKecamatanPenerima.removeAllItems();
        if(kecamatan.getKecamatan(idKota).size()<=0){
            comboKecamatanPenerima.enable(false);
        }else{
            comboKecamatanPenerima.enable(true);
            for(int i=0;i<kecamatan.getKecamatan(idKota).size();i++){
                kecamatanPenerimaArray[i]=(String)kecamatan.getKecamatan(idKota).get(i).get(0);
                comboKecamatanPenerima.addItem((String)kecamatan.getKecamatan(idKota).get(i).get(2));
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
        tableTarif = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        labelProvinsiAsal = new javax.swing.JLabel();
        comboProvinsiPengirim = new javax.swing.JComboBox();
        comboKabupatenPengirim = new javax.swing.JComboBox();
        labelKabupatenAsal = new javax.swing.JLabel();
        comboKecamatanPengirim = new javax.swing.JComboBox();
        labelKecamatanAsal = new javax.swing.JLabel();
        comboProvinsiPenerima = new javax.swing.JComboBox();
        labelProvinsiTujuan = new javax.swing.JLabel();
        comboKabupatenPenerima = new javax.swing.JComboBox();
        labelKabupatenTujuan = new javax.swing.JLabel();
        comboKecamatanPenerima = new javax.swing.JComboBox();
        labelKecamatanTujuan = new javax.swing.JLabel();
        labelLayanan = new javax.swing.JLabel();
        comboLayanan = new javax.swing.JComboBox();
        labelDurasi = new javax.swing.JLabel();
        textDurasi = new javax.swing.JTextField();
        labelHarga = new javax.swing.JLabel();
        textHarga = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        labelViewTarif = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
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
        if (tableTarif.getColumnModel().getColumnCount() > 0) {
            tableTarif.getColumnModel().getColumn(0).setMinWidth(30);
            tableTarif.getColumnModel().getColumn(0).setMaxWidth(30);
            tableTarif.getColumnModel().getColumn(1).setResizable(false);
            tableTarif.getColumnModel().getColumn(2).setResizable(false);
            tableTarif.getColumnModel().getColumn(3).setResizable(false);
            tableTarif.getColumnModel().getColumn(4).setResizable(false);
            tableTarif.getColumnModel().getColumn(5).setResizable(false);
        }

        labelProvinsiAsal.setText("Provinsi Asal:");

        comboProvinsiPengirim.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboProvinsiPengirim.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboProvinsiPengirimItemStateChanged(evt);
            }
        });

        comboKabupatenPengirim.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboKabupatenPengirim.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboKabupatenPengirimItemStateChanged(evt);
            }
        });

        labelKabupatenAsal.setText("Kota/Kab Asal:");

        comboKecamatanPengirim.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboKecamatanPengirim.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboKecamatanPengirimItemStateChanged(evt);
            }
        });

        labelKecamatanAsal.setText("Kecamatan Asal:");

        comboProvinsiPenerima.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboProvinsiPenerima.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboProvinsiPenerimaItemStateChanged(evt);
            }
        });

        labelProvinsiTujuan.setText("Provinsi Tujuan:");

        comboKabupatenPenerima.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboKabupatenPenerima.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboKabupatenPenerimaItemStateChanged(evt);
            }
        });

        labelKabupatenTujuan.setText("Kota/Kab Tujuan:");

        comboKecamatanPenerima.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboKecamatanPenerima.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboKecamatanPenerimaItemStateChanged(evt);
            }
        });

        labelKecamatanTujuan.setText("Kecamatan Tujuan:");

        labelLayanan.setText("Layanan:");

        comboLayanan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        labelDurasi.setText("Durasi (hari):");

        textDurasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDurasiActionPerformed(evt);
            }
        });

        labelHarga.setText("Harga:");

        btnAdd.setText("Tambah");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        labelViewTarif.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelViewTarif.setText("Tarif");

        btnDelete.setText("Hapus");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelKecamatanAsal)
                            .addComponent(labelProvinsiAsal, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelKabupatenAsal, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboKabupatenPengirim, 0, 201, Short.MAX_VALUE)
                            .addComponent(comboProvinsiPengirim, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboKecamatanPengirim, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelKabupatenTujuan, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelKecamatanTujuan, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelProvinsiTujuan, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboKabupatenPenerima, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboProvinsiPenerima, 0, 200, Short.MAX_VALUE)
                            .addComponent(comboKecamatanPenerima, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelDurasi)
                            .addComponent(labelLayanan)
                            .addComponent(labelHarga))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textDurasi, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboLayanan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textHarga)))
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelViewTarif, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelProvinsiAsal)
                    .addComponent(comboProvinsiPengirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelProvinsiTujuan)
                    .addComponent(comboProvinsiPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelKabupatenAsal)
                    .addComponent(comboKabupatenPengirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelKabupatenTujuan)
                    .addComponent(comboKabupatenPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelKecamatanAsal)
                    .addComponent(comboKecamatanPengirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelKecamatanTujuan)
                    .addComponent(comboKecamatanPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboLayanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelLayanan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textDurasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDurasi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelHarga))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd)
                .addGap(18, 18, 18)
                .addComponent(labelViewTarif, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Order");

        menuPengiriman.setText("Pengiriman");
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
        menuTarif1.setEnabled(false);
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textDurasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDurasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDurasiActionPerformed

    private void comboProvinsiPengirimItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboProvinsiPengirimItemStateChanged
        // TODO add your handling code here:
        int indexArray = comboProvinsiPengirim.getSelectedIndex();
        if(indexArray<0){
            fillKabupatenPengirimCombo((String)provinsiPengirimArray[0]);
        }else{
            fillKabupatenPengirimCombo((String)provinsiPengirimArray[indexArray]);
        }
    }//GEN-LAST:event_comboProvinsiPengirimItemStateChanged

    private void comboProvinsiPenerimaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboProvinsiPenerimaItemStateChanged
        // TODO add your handling code here:
        int indexArray = comboProvinsiPenerima.getSelectedIndex();
        if(indexArray<0){   
            fillKabupatenPenerimaCombo((String)provinsiPenerimaArray[0]);
        }else{
            fillKabupatenPenerimaCombo((String)provinsiPenerimaArray[indexArray]);
        }
    }//GEN-LAST:event_comboProvinsiPenerimaItemStateChanged

    private void comboKabupatenPengirimItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboKabupatenPengirimItemStateChanged
        // TODO add your handling code here:
         int indexArray = comboKabupatenPengirim.getSelectedIndex();
        if(indexArray<0){   
            fillKecamatanPengirimCombo((String)kabupatenPengirimArray[0]);
        }else{
            fillKecamatanPengirimCombo((String)kabupatenPengirimArray[indexArray]);
        }
    }//GEN-LAST:event_comboKabupatenPengirimItemStateChanged

    private void comboKabupatenPenerimaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboKabupatenPenerimaItemStateChanged
        // TODO add your handling code here:
        int indexArray = comboKabupatenPenerima.getSelectedIndex();
        if(indexArray<0){   
            fillKecamatanPenerimaCombo((String)kabupatenPenerimaArray[0]);
        }else{
            fillKecamatanPenerimaCombo((String)kabupatenPenerimaArray[indexArray]);
        }
    }//GEN-LAST:event_comboKabupatenPenerimaItemStateChanged

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if(tarif.setTarif(kecamatanPengirimFix, kecamatanPenerimaFix, idLayananArray[comboLayanan.getSelectedIndex()], textDurasi.getText(), textHarga.getText() )==true){
            JOptionPane.showMessageDialog(this, "Tarif berhasil ditambahkan");
        }
        fillTarif();
    }//GEN-LAST:event_btnAddActionPerformed

    private void comboKecamatanPengirimItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboKecamatanPengirimItemStateChanged
        // TODO add your handling code here:
        int indexArray = comboKecamatanPengirim.getSelectedIndex();
        if (indexArray < 0){
            kecamatanPengirimFix = kecamatanPengirimArray[0];
        }else{
            kecamatanPengirimFix = kecamatanPengirimArray[indexArray];
        }
    }//GEN-LAST:event_comboKecamatanPengirimItemStateChanged

    private void comboKecamatanPenerimaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboKecamatanPenerimaItemStateChanged
        // TODO add your handling code here:
        int indexArray = comboKecamatanPenerima.getSelectedIndex();
        if (indexArray < 0){
            kecamatanPenerimaFix = kecamatanPenerimaArray[0];
        }else{
           kecamatanPenerimaFix = kecamatanPenerimaArray[indexArray]; 
        }
    }//GEN-LAST:event_comboKecamatanPenerimaItemStateChanged

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if(tempDelete==-1){
            JOptionPane.showMessageDialog(this, "Pilih tarif untuk menghapus");
        }else{
            if(tarif.deleteTarif(tempDelete)){
                JOptionPane.showMessageDialog(this, "Berhasil menghapus tarif");
            }else{
                JOptionPane.showMessageDialog(this, "Gagal menghapus tarif");
            }
        }
        tempDelete=-1;
        fillTarif();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tableTarifMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTarifMouseClicked
        // TODO add your handling code here:
        tempDelete=Integer.parseInt((String)tableTarif.getValueAt(tableTarif.getSelectedRow(),0));
        labelViewTarif.setText((String) tableTarif.getValueAt(tableTarif.getSelectedRow(), 1)+" | "+tableTarif.getValueAt(tableTarif.getSelectedRow(), 2)+" | "+tableTarif.getValueAt(tableTarif.getSelectedRow(), 3)+" | "+tableTarif.getValueAt(tableTarif.getSelectedRow(), 4)+" | "+tableTarif.getValueAt(tableTarif.getSelectedRow(), 5));
        
    }//GEN-LAST:event_tableTarifMouseClicked

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
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JComboBox comboKabupatenPenerima;
    private javax.swing.JComboBox comboKabupatenPengirim;
    private javax.swing.JComboBox comboKecamatanPenerima;
    private javax.swing.JComboBox comboKecamatanPengirim;
    private javax.swing.JComboBox comboLayanan;
    private javax.swing.JComboBox comboProvinsiPenerima;
    private javax.swing.JComboBox comboProvinsiPengirim;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDurasi;
    private javax.swing.JLabel labelHarga;
    private javax.swing.JLabel labelKabupatenAsal;
    private javax.swing.JLabel labelKabupatenTujuan;
    private javax.swing.JLabel labelKecamatanAsal;
    private javax.swing.JLabel labelKecamatanTujuan;
    private javax.swing.JLabel labelLayanan;
    private javax.swing.JLabel labelProvinsiAsal;
    private javax.swing.JLabel labelProvinsiTujuan;
    private javax.swing.JLabel labelViewTarif;
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
    private javax.swing.JTable tableTarif;
    private javax.swing.JTextField textDurasi;
    private javax.swing.JTextField textHarga;
    // End of variables declaration//GEN-END:variables
}
