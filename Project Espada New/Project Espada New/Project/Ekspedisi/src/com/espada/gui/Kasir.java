package com.espada.gui;

import com.espada.Chart;
import com.espada.Koneksi;
import com.espada.Tools;
import com.espada.datepicker.DatePickers;
import com.espada.gui.wilayah.*;
import com.espada.model.qKabupaten;
import com.espada.model.qKecamatan;
import com.espada.model.qKurir;
import com.espada.model.qLayanan;
import com.espada.model.qPengiriman;
import com.espada.model.qUsaha;
import com.espada.model.qProvinsi;
import com.espada.model.qTarif;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFrame;

public class Kasir extends javax.swing.JFrame {
    Login login = new Login();
    private Kasir myWindows = this;
    private Koneksi kon = new Koneksi();
    private Tools uti = new Tools();
    private qUsaha usaha = new qUsaha();
    private qLayanan layanan = new qLayanan();
    private qKurir kurir = new qKurir();
    private qProvinsi provinsi = new qProvinsi();
    private qKabupaten kabupaten = new qKabupaten();
    private qKecamatan kecamatan = new qKecamatan();
    private qPengiriman pengiriman = new qPengiriman();
    private qTarif tarif = new qTarif();
    private Chart chartz = new Chart();
    private String[] kodeLayananArray = new String[tarif.getTarif().size()];
    private String[] idKurirArray = new String[kurir.getKurir().size()];
    private String[] provinsiPengirimArray = new String[provinsi.getProvinsi().size()];
    private String[] provinsiPenerimaArray = new String[provinsi.getProvinsi().size()];
    private String[] kabupatenPengirimArray = new String[kabupaten.getKota().size()];
    private String[] kabupatenPenerimaArray = new String[kabupaten.getKota().size()];
    private String[] kecamatanPengirimArray = new String[kecamatan.getKecamatan().size()];
    private String[] kecamatanPenerimaArray = new String[kecamatan.getKecamatan().size()];
    
    
    public DefaultTableModel model;
    /**
     * Creates new form Main
     */
    
   
    
    
    public Kasir() {
        initComponents();
        this.setTitle(usaha.getNamaUsaha().get(0)+" - Kasir");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon ico = new ImageIcon("logo.png");
        this.setIconImage(ico.getImage());
        comboKabupatenPengirim.removeAllItems();
        comboKabupatenPenerima.removeAllItems();
        comboKecamatanPengirim.removeAllItems();
        comboKecamatanPenerima.removeAllItems();
        comboKecamatanPenerima.enable(false);
        comboKecamatanPengirim.enable(false);
        comboKabupatenPenerima.enable(false);
        comboKabupatenPengirim.enable(false);
        model = (DefaultTableModel) tableBarang.getModel();
        
        
        fillKurirCombo();
        fillProvinsiPengirimCombo();
        fillProvinsiPenerimaCombo();
        emptyBarang();
        checkMenuAdministrator();
    }
    
    public void checkMenuAdministrator(){
     if(!login.statLogin.equals("admin")){
            subsubmenuPengaturanAdministrator.setEnabled(false);
        }   
    }
    
    public void setBarang(String dateNow){
        String idPengiriman = (String) pengiriman.getPengirimanbyDatetime(dateNow).get(0).get(0);
        for(int i =0;i<tableBarang.getRowCount();i++){
           pengiriman.setBarang(idPengiriman, (String)tableBarang.getValueAt(i, 0), (String)tableBarang.getValueAt(i, 1));  
        }
    }
    
    public void emptyBarang(){
        model.getDataVector().removeAllElements();
        
    }
    
    public int beratBarang(){
        int total=0;
        for(int i =0;i<tableBarang.getRowCount();i++){
            total=total+Integer.parseInt((String)tableBarang.getValueAt(i, 1));
            
        }
        return total;
    }
    
    public int totalHarga(String idKecAsal, String idKecTujuan, String idLayanan){
        int totalHarga=0; 
        
        for(int i =0;i<tableBarang.getRowCount();i++){
            totalHarga=totalHarga+Integer.parseInt((String)tableBarang.getValueAt(i, 1))*Integer.parseInt((String)tarif.getTarif(idKecAsal, idKecTujuan, idLayanan).get(0).get(5));
            
        }
        return totalHarga;
    }
    
    
     public void fillLayananCombo(){
        comboLayanan.removeAllItems();
        String idLayanan;
        try{
            String idKecamatanPengirim = kecamatanPengirimArray[comboKecamatanPengirim.getSelectedIndex()];
            String idKecamatanPenerima = kecamatanPenerimaArray[comboKecamatanPenerima.getSelectedIndex()];
            int totRows = 0;
            if(!tarif.getLayananfromTarif(idKecamatanPengirim, idKecamatanPenerima).get(0).get(0).equals("")){
                totRows = tarif.getLayananfromTarif(idKecamatanPengirim, idKecamatanPenerima).size();
            }
            for(int i=0;i<totRows;i++){
                String currentIdLayanan = (String)tarif.getLayananfromTarif(idKecamatanPengirim, idKecamatanPenerima).get(i).get(0);
                kodeLayananArray[i]=(String) layanan.getLayanan(currentIdLayanan).get(0).get(2);
                String currentNamaLayanan = (String) layanan.getLayananbyKode(kodeLayananArray[i]).get(0).get(1);
                comboLayanan.addItem(currentNamaLayanan);
                
            }
            
        }catch(Exception e){
            
        }
        
    }
    
    public void fillKurirCombo(){
        comboKurir.removeAllItems();
        for(int i=0;i<kurir.getKurir().size();i++){
            idKurirArray[i]=(String)kurir.getKurir().get(i).get(0);
            comboKurir.addItem((String)kurir.getKurir().get(i).get(1));
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

        jPanel1 = new javax.swing.JPanel();
        textNamaPenerima = new javax.swing.JTextField();
        labelNamaPengirim = new javax.swing.JLabel();
        textNamaPengirim = new javax.swing.JTextField();
        comboKecamatanPenerima = new javax.swing.JComboBox<String>();
        labelNamaPenerima = new javax.swing.JLabel();
        textAlamatPenerima = new javax.swing.JTextField();
        labelKecPengirim = new javax.swing.JLabel();
        labelKecPenerima = new javax.swing.JLabel();
        labelAlamatPenerima = new javax.swing.JLabel();
        comboKecamatanPengirim = new javax.swing.JComboBox<String>();
        comboKabupatenPenerima = new javax.swing.JComboBox<String>();
        comboProvinsiPenerima = new javax.swing.JComboBox<String>();
        labelKabupatenPenerima = new javax.swing.JLabel();
        labelProvinsiPenerima = new javax.swing.JLabel();
        comboProvinsiPengirim = new javax.swing.JComboBox<String>();
        comboKabupatenPengirim = new javax.swing.JComboBox<String>();
        labelKabupatenPengirim = new javax.swing.JLabel();
        labelProvinsiPengirim = new javax.swing.JLabel();
        btnDatePicker = new javax.swing.JButton();
        textDate = new javax.swing.JTextField();
        lblTglKirim = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        comboLayanan = new javax.swing.JComboBox<String>();
        comboKurir = new javax.swing.JComboBox<String>();
        labelLayanan = new javax.swing.JLabel();
        labelKurir = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBarang = new javax.swing.JTable();
        textKetBarang = new javax.swing.JTextField();
        labelKetBarang = new javax.swing.JLabel();
        textBeratBarang = new javax.swing.JTextField();
        labelBeratBarang = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        labelViewBarang = new javax.swing.JLabel();
        btnDelete1 = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuPengiriman = new javax.swing.JMenuItem();
        menuKasir = new javax.swing.JMenuItem();
        menuTarif = new javax.swing.JMenuItem();
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

        labelNamaPengirim.setText("Nama Pengirim:");

        textNamaPengirim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNamaPengirimActionPerformed(evt);
            }
        });

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

        labelNamaPenerima.setText("Nama Penerima:");

        textAlamatPenerima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textAlamatPenerimaActionPerformed(evt);
            }
        });

        labelKecPengirim.setText("Kecamatan Pengirim:");

        labelKecPenerima.setText("Kecamatan Penerima:");

        labelAlamatPenerima.setText("Alamat Penerima:");

        comboKecamatanPengirim.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboKecamatanPengirim.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboKecamatanPengirimItemStateChanged(evt);
            }
        });

        comboKabupatenPenerima.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboKabupatenPenerima.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboKabupatenPenerimaItemStateChanged(evt);
            }
        });

        comboProvinsiPenerima.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboProvinsiPenerima.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboProvinsiPenerimaItemStateChanged(evt);
            }
        });

        labelKabupatenPenerima.setText("Kabupaten / Kota Penerima:");

        labelProvinsiPenerima.setText("Provinsi Penerima:");

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

        labelKabupatenPengirim.setText("Kabupaten / Kota Pengirim:");

        labelProvinsiPengirim.setText("Provinsi Pengirim:");

        btnDatePicker.setText("▼");
        btnDatePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatePickerActionPerformed(evt);
            }
        });

        lblTglKirim.setText("Tanggal Kirim:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelProvinsiPenerima)
                            .addComponent(labelNamaPenerima))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textNamaPenerima)
                            .addComponent(comboProvinsiPenerima, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(labelKecPengirim))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(47, 47, 47)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(labelProvinsiPengirim)
                                                .addComponent(labelNamaPengirim)))
                                        .addComponent(labelKabupatenPengirim)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboKecamatanPengirim, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboKabupatenPengirim, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboProvinsiPengirim, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textNamaPengirim)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelKecPenerima)
                                        .addComponent(labelAlamatPenerima, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(labelKabupatenPenerima)
                                    .addComponent(lblTglKirim))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboKecamatanPenerima, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textAlamatPenerima, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(comboKabupatenPenerima, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnDatePicker, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(textDate, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNamaPengirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNamaPengirim))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboProvinsiPengirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelProvinsiPengirim))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboKabupatenPengirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelKabupatenPengirim))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboKecamatanPengirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelKecPengirim))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNamaPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNamaPenerima))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboProvinsiPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelProvinsiPenerima))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboKabupatenPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelKabupatenPenerima))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboKecamatanPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelKecPenerima))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textAlamatPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAlamatPenerima))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDatePicker)
                    .addComponent(textDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTglKirim))
                .addGap(24, 24, 24))
        );

        comboLayanan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboKurir.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        labelLayanan.setText("Layanan:");

        labelKurir.setText("Kurir:");

        tableBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Keterangan Barang", "Bobot Barang"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
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
        jScrollPane1.setViewportView(tableBarang);

        labelKetBarang.setText("Keterangan Barang:");

        labelBeratBarang.setText("Bobot Barang [Volume / Berat]");

        btnAdd.setText("Tambah");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Hapus");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        labelViewBarang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelViewBarang.setText("Barang");

        btnDelete1.setText("Clear");
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelKetBarang)
                            .addComponent(labelBeratBarang))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textBeratBarang)
                            .addComponent(textKetBarang)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnDelete1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelViewBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAdd))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelKurir, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelLayanan, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboKurir, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboLayanan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboLayanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelLayanan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelKurir)
                    .addComponent(comboKurir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textKetBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelKetBarang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textBeratBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelBeratBarang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnDelete)
                    .addComponent(labelViewBarang)
                    .addComponent(btnDelete1))
                .addGap(18, 18, 18)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        menuKasir.setEnabled(false);
        menuKasir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuKasirActionPerformed(evt);
            }
        });
        jMenu1.add(menuKasir);

        menuTarif.setText("Tarif");
        menuTarif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTarifActionPerformed(evt);
            }
        });
        jMenu1.add(menuTarif);

        menuBar.add(jMenu1);

        menuWilayah.setText("Wilayah");
        menuWilayah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuWilayahMouseClicked(evt);
            }
        });

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
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        setBounds(0, 0, 1230, 520);
    }// </editor-fold>//GEN-END:initComponents

    private void menuKurirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKurirActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_menuKurirActionPerformed

    private void textAlamatPenerimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textAlamatPenerimaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textAlamatPenerimaActionPerformed

    private void comboKecamatanPenerimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboKecamatanPenerimaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboKecamatanPenerimaActionPerformed

    private void textNamaPengirimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNamaPengirimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNamaPengirimActionPerformed

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

    private void menuLayananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLayananActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_menuLayananActionPerformed

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

    private void menuWilayahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuWilayahMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_menuWilayahMouseClicked

    private void menuTarifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTarifActionPerformed
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
    }//GEN-LAST:event_menuTarifActionPerformed

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

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if(textKetBarang.getText().equals("") || textBeratBarang.getText().equals("")){
                JOptionPane.showMessageDialog(this,"Keterangan & Berat tidak boleh kosong");
        }else{
            if(uti.isInteger(textBeratBarang.getText()) && Integer.parseInt(textBeratBarang.getText())!=0){
            String keteranganBarang = textKetBarang.getText();
        String beratBarang = textBeratBarang.getText();
        model.addRow(new Object[]{keteranganBarang,
                beratBarang});
            }else{
                JOptionPane.showMessageDialog(this,"Berat harus angka dan harus lebih dari 0");
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        
        
        String namaPengirimNew = textNamaPengirim.getText();
        String namaPenerimaNew = textNamaPenerima.getText();
        String idProvinsiPengirimNew = provinsiPengirimArray[comboProvinsiPengirim.getSelectedIndex()];
        String idProvinsiPenerimaNew = provinsiPenerimaArray[comboProvinsiPengirim.getSelectedIndex()];
        String idKabupatenPengirimNew = kabupatenPengirimArray[comboKabupatenPengirim.getSelectedIndex()];
        String idKabupatenPenerimaNew = kabupatenPenerimaArray[comboKabupatenPenerima.getSelectedIndex()];
        String idKecamatanPengirimNew = kecamatanPengirimArray[comboKecamatanPengirim.getSelectedIndex()];
        String idKecamatanPenerimaNew = kecamatanPenerimaArray[comboKecamatanPenerima.getSelectedIndex()];
        String alamatPenerimaNew = textAlamatPenerima.getText();
        String tglKirim = (String)textDate.getText();
        String kodeLayanan = kodeLayananArray[comboLayanan.getSelectedIndex()];
        String hari = "";
        if(tarif.getTarif(idKecamatanPengirimNew, idKecamatanPenerimaNew, (String)layanan.getLayananbyKode(kodeLayanan).get(0).get(0)).get(0).get(0)==null){
           
        }else{
           hari = (String) tarif.getTarif(idKecamatanPengirimNew, idKecamatanPenerimaNew, (String)layanan.getLayananbyKode(kodeLayanan).get(0).get(0)).get(0).get(4);
        }
        int totBerat=beratBarang();
        int harga=totalHarga(idKecamatanPengirimNew, idKecamatanPenerimaNew, (String)layanan.getLayananbyKode(kodeLayanan).get(0).get(0));;
        
        String idKurir = idKurirArray[comboKurir.getSelectedIndex()];
        
        
            pengiriman.setPengiriman(namaPengirimNew,
                    namaPenerimaNew,
                    idKecamatanPengirimNew,
                    idKecamatanPenerimaNew,
                    alamatPenerimaNew,
                    dateFormat.format(date),
                    tglKirim,
                    "",
                    totBerat,
                    kodeLayanan,
                    idKurir,
                    harga,
                    hari);
            
            this.setBarang((String)dateFormat.format(date));
            JOptionPane.showMessageDialog(this, "Berhasil");
            
            
        
        
        
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        
        if(tableBarang.getSelectedRow()>=0){
        model.removeRow(tableBarang.getSelectedRow());
        }else{
            JOptionPane.showMessageDialog(this, "Pilih barang untuk menghapus!");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        // TODO add your handling code here:
        
       model.setRowCount(0);
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void tableBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBarangMouseClicked
        // TODO add your handling code here:
        labelViewBarang.setText((String) tableBarang.getValueAt(tableBarang.getSelectedRow(), 0)+" | "+(String) tableBarang.getValueAt(tableBarang.getSelectedRow(), 1));
    }//GEN-LAST:event_tableBarangMouseClicked

    private void btnDatePickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatePickerActionPerformed
        // TODO add your handling code here:
        
        
        
        textDate.setText(new DatePickers(this).setPickedDate());
    }//GEN-LAST:event_btnDatePickerActionPerformed

    private void comboKecamatanPengirimItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboKecamatanPengirimItemStateChanged
        // TODO add your handling code here:
        fillLayananCombo();
    }//GEN-LAST:event_comboKecamatanPengirimItemStateChanged

    private void comboKecamatanPenerimaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboKecamatanPenerimaItemStateChanged
        // TODO add your handling code here:
        fillLayananCombo();
    }//GEN-LAST:event_comboKecamatanPenerimaItemStateChanged

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        Espada copyright = new Espada();
        copyright.pack();
        copyright.setVisible(true);
          
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void subsubMenuWilayahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsubMenuWilayahActionPerformed
        // TODO add your handling code here:
        com.espada.gui.excel.exportz.Wilayah exportWilayah = new com.espada.gui.excel.exportz.Wilayah();
        exportWilayah.pack();
        exportWilayah.setVisible(true);
    }//GEN-LAST:event_subsubMenuWilayahActionPerformed

    private void subsubmenuExportTarifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsubmenuExportTarifActionPerformed
        // TODO add your handling code here:
        com.espada.gui.excel.exportz.Tarif exportTarif = new com.espada.gui.excel.exportz.Tarif();
        exportTarif.pack();
        exportTarif.setVisible(true);
    }//GEN-LAST:event_subsubmenuExportTarifActionPerformed

    private void subsubmenuExportPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsubmenuExportPengirimanActionPerformed
        // TODO add your handling code here:
        com.espada.gui.excel.exportz.Pengiriman exportPengiriman = new com.espada.gui.excel.exportz.Pengiriman();
        exportPengiriman.pack();
        exportPengiriman.setVisible(true);
    }//GEN-LAST:event_subsubmenuExportPengirimanActionPerformed

    private void subsubmenuExportLayananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsubmenuExportLayananActionPerformed
        // TODO add your handling code here:
        com.espada.gui.excel.exportz.Layanan exportLayanan = new com.espada.gui.excel.exportz.Layanan();
        exportLayanan.pack();
        exportLayanan.setVisible(true);
    }//GEN-LAST:event_subsubmenuExportLayananActionPerformed

    private void subsubmenuExportKurirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsubmenuExportKurirActionPerformed
        // TODO add your handling code here:
        com.espada.gui.excel.exportz.Kurir exportKurir = new com.espada.gui.excel.exportz.Kurir();
        exportKurir.pack();
        exportKurir.setVisible(true);
    }//GEN-LAST:event_subsubmenuExportKurirActionPerformed

    private void subsubmenuImportPengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsubmenuImportPengirimanActionPerformed
        // TODO add your handling code here:
        com.espada.gui.excel.importz.Pengiriman pengirimanImport = new com.espada.gui.excel.importz.Pengiriman();
        pengirimanImport.pack();
        pengirimanImport.setVisible(true);
    }//GEN-LAST:event_subsubmenuImportPengirimanActionPerformed

    private void subsubmenuImportLayananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsubmenuImportLayananActionPerformed
        // TODO add your handling code here:
        com.espada.gui.excel.importz.Layanan layananImport = new com.espada.gui.excel.importz.Layanan();
        layananImport.pack();
        layananImport.setVisible(true);
    }//GEN-LAST:event_subsubmenuImportLayananActionPerformed

    private void subsubmenuImportKurirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsubmenuImportKurirActionPerformed
        // TODO add your handling code here:
        com.espada.gui.excel.importz.Kurir kurirImport = new com.espada.gui.excel.importz.Kurir();
        kurirImport.pack();
        kurirImport.setVisible(true);
    }//GEN-LAST:event_subsubmenuImportKurirActionPerformed

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

    private void subsubmenuPengaturanUsahaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsubmenuPengaturanUsahaActionPerformed
        // TODO add your handling code here:
       
        
        SetUsaha windowSetUsaha = new SetUsaha();
        windowSetUsaha.pack();
        windowSetUsaha.setVisible(true);
        
    }//GEN-LAST:event_subsubmenuPengaturanUsahaActionPerformed

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
            java.util.logging.Logger.getLogger(Kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kasir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDatePicker;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> comboKabupatenPenerima;
    private javax.swing.JComboBox<String> comboKabupatenPengirim;
    private javax.swing.JComboBox<String> comboKecamatanPenerima;
    private javax.swing.JComboBox<String> comboKecamatanPengirim;
    private javax.swing.JComboBox<String> comboKurir;
    private javax.swing.JComboBox<String> comboLayanan;
    private javax.swing.JComboBox<String> comboProvinsiPenerima;
    private javax.swing.JComboBox<String> comboProvinsiPengirim;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAlamatPenerima;
    private javax.swing.JLabel labelBeratBarang;
    private javax.swing.JLabel labelKabupatenPenerima;
    private javax.swing.JLabel labelKabupatenPengirim;
    private javax.swing.JLabel labelKecPenerima;
    private javax.swing.JLabel labelKecPengirim;
    private javax.swing.JLabel labelKetBarang;
    private javax.swing.JLabel labelKurir;
    private javax.swing.JLabel labelLayanan;
    private javax.swing.JLabel labelNamaPenerima;
    private javax.swing.JLabel labelNamaPengirim;
    private javax.swing.JLabel labelProvinsiPenerima;
    private javax.swing.JLabel labelProvinsiPengirim;
    private javax.swing.JLabel labelViewBarang;
    private javax.swing.JLabel lblTglKirim;
    private javax.swing.JMenu menuAlat;
    private javax.swing.JMenu menuBantuan;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuKasir;
    private javax.swing.JMenu menuKurir;
    private javax.swing.JMenu menuLayanan;
    private javax.swing.JMenuItem menuPengiriman;
    private javax.swing.JMenuItem menuTarif;
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
    private javax.swing.JTextField textAlamatPenerima;
    private javax.swing.JTextField textBeratBarang;
    private javax.swing.JTextField textDate;
    private javax.swing.JTextField textKetBarang;
    private javax.swing.JTextField textNamaPenerima;
    private javax.swing.JTextField textNamaPengirim;
    // End of variables declaration//GEN-END:variables
}

