package com.espada.gui.excel.exportz;

import com.espada.Chart;
import com.espada.Excel;
import com.espada.datepicker.DatePickers;
import com.espada.model.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;

public class Pengiriman extends javax.swing.JFrame {
    qPengiriman pengiriman = new qPengiriman();
    qKecamatan kecamatan = new qKecamatan();
    qKurir kurir = new qKurir();
    qLayanan layanan = new qLayanan();
    Chart chartz = new Chart();
    
    private String[] kecamatanPengirimArray = new String[kecamatan.getKecamatan().size()];
    private String[] kecamatanPenerimaArray = new String[kecamatan.getKecamatan().size()];
    private String[] kodeLayananArray = new String[layanan.getLayanan().size()];
    private String[] idLayananArray = new String[layanan.getLayanan().size()];
    private String[] idKurirArray = new String[kurir.getKurir().size()];
    
    /**
     * Creates new form Pengiriman
     */
    public Pengiriman() {
        initComponents();
        this.setTitle("Pengiriman Export");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon ico = new ImageIcon("logo.png");
        this.setIconImage(ico.getImage());
        fillPengiriman();
        fillKecamatanPengirimCombo();
        fillKecamatanPenerimaCombo();
        fillLayananCombo();
        fillKurirCombo();
    }
    
    public void searchPengiriman(
            String idKecAsal,
            String idKecTujuan,
            String idLayanan,
            String idKurir,
            String beratAwal,
            String beratAkhir,
            String hargaAwal,
            String hargaAkhir,
            String tanggalPengirimanAwal,
            String tanggalPengirimanAkhir,
            String tanggalTibaAwal,
            String tanggalTibaAkhir,
            String hariAwal,
            String hariAkhir
    ){
        
         DefaultTableModel model = (DefaultTableModel) tablePengiriman.getModel();
        model.getDataVector().removeAllElements();
        revalidate();
        for(int i=0;i<pengiriman.searchPengiriman(
            idKecAsal,
            idKecTujuan,
            idLayanan,
            idKurir,
            beratAwal,
            beratAkhir,
            hargaAwal,
            hargaAkhir,
            tanggalPengirimanAwal,
            tanggalPengirimanAkhir,
            tanggalTibaAwal,
            tanggalTibaAkhir,
            hariAwal,
            hariAkhir
        ).size();i++){
            String idPengiriman = (String) pengiriman.searchPengiriman(idKecAsal,idKecTujuan,idLayanan,idKurir,beratAwal,beratAkhir,hargaAwal,hargaAkhir,tanggalPengirimanAwal,tanggalPengirimanAkhir,tanggalTibaAwal,tanggalTibaAkhir,hariAwal,hariAkhir).get(i).get(0);
            String namaPengirim = (String) pengiriman.searchPengiriman(idKecAsal,idKecTujuan,idLayanan,idKurir,beratAwal,beratAkhir,hargaAwal,hargaAkhir,tanggalPengirimanAwal,tanggalPengirimanAkhir,tanggalTibaAwal,tanggalTibaAkhir,hariAwal,hariAkhir).get(i).get(1);
            


            String namaPenerima = (String) pengiriman.searchPengiriman(idKecAsal,idKecTujuan,idLayanan,idKurir,beratAwal,beratAkhir,hargaAwal,hargaAkhir,tanggalPengirimanAwal,tanggalPengirimanAkhir,tanggalTibaAwal,tanggalTibaAkhir,hariAwal,hariAkhir).get(i).get(2);
            String idKecPengirim = (String) pengiriman.searchPengiriman(idKecAsal,idKecTujuan,idLayanan,idKurir,beratAwal,beratAkhir,hargaAwal,hargaAkhir,tanggalPengirimanAwal,tanggalPengirimanAkhir,tanggalTibaAwal,tanggalTibaAkhir,hariAwal,hariAkhir).get(i).get(3);
            String idKecPenerima = (String) pengiriman.searchPengiriman(idKecAsal,idKecTujuan,idLayanan,idKurir,beratAwal,beratAkhir,hargaAwal,hargaAkhir,tanggalPengirimanAwal,tanggalPengirimanAkhir,tanggalTibaAwal,tanggalTibaAkhir,hariAwal,hariAkhir).get(i).get(4);
            String alamatPenerima = (String) pengiriman.searchPengiriman(idKecAsal,idKecTujuan,idLayanan,idKurir,beratAwal,beratAkhir,hargaAwal,hargaAkhir,tanggalPengirimanAwal,tanggalPengirimanAkhir,tanggalTibaAwal,tanggalTibaAkhir,hariAwal,hariAkhir).get(i).get(5);
            String tanggalPengiriman = (String) pengiriman.searchPengiriman(idKecAsal,idKecTujuan,idLayanan,idKurir,beratAwal,beratAkhir,hargaAwal,hargaAkhir,tanggalPengirimanAwal,tanggalPengirimanAkhir,tanggalTibaAwal,tanggalTibaAkhir,hariAwal,hariAkhir).get(i).get(6);
            String tanggalKirimPengiriman = (String) pengiriman.searchPengiriman(idKecAsal,idKecTujuan,idLayanan,idKurir,beratAwal,beratAkhir,hargaAwal,hargaAkhir,tanggalPengirimanAwal,tanggalPengirimanAkhir,tanggalTibaAwal,tanggalTibaAkhir,hariAwal,hariAkhir).get(i).get(7);
            String tanggalTibaPengiriman = (String) pengiriman.searchPengiriman(idKecAsal,idKecTujuan,idLayanan,idKurir,beratAwal,beratAkhir,hargaAwal,hargaAkhir,tanggalPengirimanAwal,tanggalPengirimanAkhir,tanggalTibaAwal,tanggalTibaAkhir,hariAwal,hariAkhir).get(i).get(8);
            String totalBeratPengiriman = (String) pengiriman.searchPengiriman(idKecAsal,idKecTujuan,idLayanan,idKurir,beratAwal,beratAkhir,hargaAwal,hargaAkhir,tanggalPengirimanAwal,tanggalPengirimanAkhir,tanggalTibaAwal,tanggalTibaAkhir,hariAwal,hariAkhir).get(i).get(9);
            String kodeLayanan = (String) pengiriman.searchPengiriman(idKecAsal,idKecTujuan,idLayanan,idKurir,beratAwal,beratAkhir,hargaAwal,hargaAkhir,tanggalPengirimanAwal,tanggalPengirimanAkhir,tanggalTibaAwal,tanggalTibaAkhir,hariAwal,hariAkhir).get(i).get(10);
            String idKurirs = (String) pengiriman.searchPengiriman(idKecAsal,idKecTujuan,idLayanan,idKurir,beratAwal,beratAkhir,hargaAwal,hargaAkhir,tanggalPengirimanAwal,tanggalPengirimanAkhir,tanggalTibaAwal,tanggalTibaAkhir,hariAwal,hariAkhir).get(i).get(11);
            String harga = (String) pengiriman.searchPengiriman(idKecAsal,idKecTujuan,idLayanan,idKurir,beratAwal,beratAkhir,hargaAwal,hargaAkhir,tanggalPengirimanAwal,tanggalPengirimanAkhir,tanggalTibaAwal,tanggalTibaAkhir,hariAwal,hariAkhir).get(i).get(12);
            String hari = (String) pengiriman.searchPengiriman(idKecAsal,idKecTujuan,idLayanan,idKurir,beratAwal,beratAkhir,hargaAwal,hargaAkhir,tanggalPengirimanAwal,tanggalPengirimanAkhir,tanggalTibaAwal,tanggalTibaAkhir,hariAwal,hariAkhir).get(i).get(13);
            String verifikasi = (String) pengiriman.searchPengiriman(idKecAsal,idKecTujuan,idLayanan,idKurir,beratAwal,beratAkhir,hargaAwal,hargaAkhir,tanggalPengirimanAwal,tanggalPengirimanAkhir,tanggalTibaAwal,tanggalTibaAkhir,hariAwal,hariAkhir).get(i).get(14);
            
            String kecPengirim = (String)kecamatan.getKecamatanMe(idKecPengirim).get(0).get(2);
            String kecPenerima = (String)kecamatan.getKecamatanMe(idKecPenerima).get(0).get(1);
            String myLayanan = (String)layanan.getLayananbyKode(kodeLayanan).get(0).get(2);
            String myKurir = (String) kurir.getKurir(idKurirs).get(0).get(1);
            
            
            
            for(int j=0;j<pengiriman.getBarang(idPengiriman).size();j++){
                String ketBarang = (String) pengiriman.getBarang(idPengiriman).get(j).get(2);
                String beratBarang= (String) pengiriman.getBarang(idPengiriman).get(j).get(3);
                if(j==0){
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
                verifikasi,ketBarang,
                        beratBarang});
                }else{
                    model.addRow(new Object[]{idPengiriman,
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    ketBarang,
                    beratBarang});
                }
            }
            
            
        }
    
    }
    
    public void fillKurirCombo(){
        comboKurir.removeAllItems();
        comboKurir.addItem("All");
        for(int i=0;i<kurir.getKurir().size();i++){
            idKurirArray[i]=(String)kurir.getKurir().get(i).get(0);
            comboKurir.addItem((String)kurir.getKurir().get(i).get(1));
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
          
            
            
            for(int j=0;j<pengiriman.getBarang(idPengiriman).size();j++){
                String ketBarang = (String) pengiriman.getBarang(idPengiriman).get(j).get(2);
                String beratBarang= (String) pengiriman.getBarang(idPengiriman).get(j).get(3);
                if(j==0){
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
                verifikasi,ketBarang,
                        beratBarang});
                }else{
                    model.addRow(new Object[]{idPengiriman,
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                "",ketBarang,
                        beratBarang});
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
        tablePengiriman = new javax.swing.JTable();
        comboKecamatanPengirim = new javax.swing.JComboBox<String>();
        labelKecPengirim = new javax.swing.JLabel();
        labelKecPenerima = new javax.swing.JLabel();
        comboKecamatanPenerima = new javax.swing.JComboBox<String>();
        comboLayanan = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        textHargaAwal = new javax.swing.JTextField();
        textHargaAkhir = new javax.swing.JTextField();
        lblDurasiAkhir = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblDurasiAwal = new javax.swing.JLabel();
        textBeratAwal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textBeratAkhir = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        comboKurir = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textDateAwalKirim = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        textDateAkhirKirim = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        textDateAwalTiba = new javax.swing.JTextField();
        textDateAkhirTiba = new javax.swing.JTextField();
        textHariAkhir = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        textHariAwal = new javax.swing.JTextField();
        lblDurasiAkhir1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tablePengiriman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nama Pengirim", "Nama Penerima", "Kec Pengirim", "Kec Penerima", "Alamat Penerima", "Tanggal Kirim", "Tanggal Tiba", "Total Berat", "Layanan", "Kurir", "Harga", "Hari", "Verifikasi", "Ket Barang", "Bobot Barang"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false
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

        comboKecamatanPengirim.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboKecamatanPengirim.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboKecamatanPengirimItemStateChanged(evt);
            }
        });

        labelKecPengirim.setText("Kecamatan Pengirim:");

        labelKecPenerima.setText("Kecamatan Penerima:");

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

        comboLayanan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Layanan:");

        textHargaAwal.setText("0");

        textHargaAkhir.setText("0");

        lblDurasiAkhir.setText("Harga:");

        jLabel3.setText("-");

        lblDurasiAwal.setText("Total Berat:");

        textBeratAwal.setText("0");

        jLabel2.setText("-");

        textBeratAkhir.setText("0");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        comboKurir.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Kurir:");

        jLabel5.setText("Tanggal Pengiriman:");

        textDateAwalKirim.setText("Click for set Date");
        textDateAwalKirim.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textDateAwalKirimFocusGained(evt);
            }
        });
        textDateAwalKirim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textDateAwalKirimMouseClicked(evt);
            }
        });
        textDateAwalKirim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDateAwalKirimActionPerformed(evt);
            }
        });

        jLabel6.setText("-");

        textDateAkhirKirim.setText("Click for set Date");
        textDateAkhirKirim.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textDateAkhirKirimFocusGained(evt);
            }
        });
        textDateAkhirKirim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textDateAkhirKirimMouseClicked(evt);
            }
        });

        jLabel7.setText("Tanggal Tiba:");

        textDateAwalTiba.setText("Click for set Date");
        textDateAwalTiba.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textDateAwalTibaFocusGained(evt);
            }
        });
        textDateAwalTiba.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textDateAwalTibaMouseClicked(evt);
            }
        });
        textDateAwalTiba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDateAwalTibaActionPerformed(evt);
            }
        });

        textDateAkhirTiba.setText("Click for set Date");
        textDateAkhirTiba.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textDateAkhirTibaFocusGained(evt);
            }
        });
        textDateAkhirTiba.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textDateAkhirTibaMouseClicked(evt);
            }
        });

        textHariAkhir.setText("0");

        jLabel8.setText("-");

        textHariAwal.setText("0");

        lblDurasiAkhir1.setText("Hari:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jButton3.setText("Export Table to Excel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(labelKecPengirim)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboKecamatanPengirim, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboLayanan, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textDateAwalKirim, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblDurasiAkhir)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textHargaAwal, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textDateAkhirKirim, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textHargaAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblDurasiAkhir1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textHariAwal, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textHariAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(lblDurasiAwal))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboKurir, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(textBeratAwal, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textBeratAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textDateAwalTiba, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(textDateAkhirTiba, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(labelKecPenerima)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboKecamatanPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(301, 301, 301)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
                    .addComponent(comboKurir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDurasiAkhir)
                    .addComponent(textHargaAwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(textHargaAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDurasiAwal)
                    .addComponent(textBeratAwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(textBeratAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(textDateAkhirKirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textDateAwalKirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(textDateAkhirTiba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textDateAwalTiba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDurasiAkhir1)
                    .addComponent(textHariAwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(textHariAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablePengirimanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePengirimanMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tablePengirimanMouseClicked

    private void comboKecamatanPengirimItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboKecamatanPengirimItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_comboKecamatanPengirimItemStateChanged

    private void comboKecamatanPenerimaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboKecamatanPenerimaItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_comboKecamatanPenerimaItemStateChanged

    private void comboKecamatanPenerimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboKecamatanPenerimaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboKecamatanPenerimaActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        
        String idKecAsal;
        String idKecTujuan;
            String kodeLayanan;
            String idKurir;
            
            if(comboKecamatanPengirim.getSelectedIndex()>0){
                idKecAsal=kecamatanPengirimArray[comboKecamatanPengirim.getSelectedIndex()-1];
            }else{
                idKecAsal="all";
            }
            
            if(comboKecamatanPenerima.getSelectedIndex()>0){
                idKecTujuan=kecamatanPenerimaArray[comboKecamatanPenerima.getSelectedIndex()-1];
            }else{
                idKecTujuan="all";
            }

            if(comboLayanan.getSelectedIndex()>0){
                kodeLayanan=kodeLayananArray[comboLayanan.getSelectedIndex()-1];
            }else{
                kodeLayanan="all";
            }
            
            if(comboKurir.getSelectedIndex()>0){
                idKurir=idKurirArray[comboKurir.getSelectedIndex()-1];
            }else{
                idKurir="all";
            }
            String beratAwal = textBeratAwal.getText();
            String beratAkhir = textBeratAkhir.getText();
            String hargaAwal = textHargaAwal.getText();
            String hargaAkhir = textHargaAkhir.getText();
            String tanggalPengirimanAwal = textDateAwalKirim.getText();
            String tanggalPengirimanAkhir = textDateAkhirKirim.getText();
            String tanggalTibaAwal = textDateAwalTiba.getText();
            String tanggalTibaAkhir = textDateAkhirTiba.getText();
            String hariAwal = textHariAwal.getText();
            String hariAkhir = textHariAkhir.getText();
     searchPengiriman(idKecAsal,
idKecTujuan,
kodeLayanan,
idKurir,
beratAwal,
beratAkhir,
hargaAwal,
hargaAkhir,
tanggalPengirimanAwal,
tanggalPengirimanAkhir,
tanggalTibaAwal,
tanggalTibaAkhir,
hariAwal,
hariAkhir);
    }//GEN-LAST:event_btnSearchActionPerformed

    
        
    private void textDateAwalKirimFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textDateAwalKirimFocusGained
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_textDateAwalKirimFocusGained

    private void textDateAkhirKirimFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textDateAkhirKirimFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_textDateAkhirKirimFocusGained

    private void textDateAwalKirimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDateAwalKirimActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_textDateAwalKirimActionPerformed

    private void textDateAwalKirimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textDateAwalKirimMouseClicked
        // TODO add your handling code here:
        textDateAwalKirim.setText(new DatePickers(this).setPickedDate());
    }//GEN-LAST:event_textDateAwalKirimMouseClicked

    private void textDateAkhirKirimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textDateAkhirKirimMouseClicked
           // TODO add your handling code here:
         textDateAkhirKirim.setText(new DatePickers(this).setPickedDate());  
    }//GEN-LAST:event_textDateAkhirKirimMouseClicked

    private void textDateAwalTibaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textDateAwalTibaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_textDateAwalTibaFocusGained

    private void textDateAwalTibaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textDateAwalTibaMouseClicked
        // TODO add your handling code here:
        textDateAwalTiba.setText(new DatePickers(this).setPickedDate());
    }//GEN-LAST:event_textDateAwalTibaMouseClicked

    private void textDateAwalTibaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDateAwalTibaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDateAwalTibaActionPerformed

    private void textDateAkhirTibaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textDateAkhirTibaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_textDateAkhirTibaFocusGained

    private void textDateAkhirTibaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textDateAkhirTibaMouseClicked
        // TODO add your handling code here:
        textDateAkhirTiba.setText(new DatePickers(this).setPickedDate());
    }//GEN-LAST:event_textDateAkhirTibaMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Excel export = new Excel();
        JFileChooser fc = new JFileChooser();
                int option = fc.showSaveDialog(Pengiriman.this);
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
					export.toExcel(tablePengiriman, new File(file));
				}
    }//GEN-LAST:event_jButton3ActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pengiriman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> comboKecamatanPenerima;
    private javax.swing.JComboBox<String> comboKecamatanPengirim;
    private javax.swing.JComboBox comboKurir;
    private javax.swing.JComboBox comboLayanan;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelKecPenerima;
    private javax.swing.JLabel labelKecPengirim;
    private javax.swing.JLabel lblDurasiAkhir;
    private javax.swing.JLabel lblDurasiAkhir1;
    private javax.swing.JLabel lblDurasiAwal;
    private javax.swing.JTable tablePengiriman;
    private javax.swing.JTextField textBeratAkhir;
    private javax.swing.JTextField textBeratAwal;
    private javax.swing.JTextField textDateAkhirKirim;
    private javax.swing.JTextField textDateAkhirTiba;
    private javax.swing.JTextField textDateAwalKirim;
    private javax.swing.JTextField textDateAwalTiba;
    private javax.swing.JTextField textHargaAkhir;
    private javax.swing.JTextField textHargaAwal;
    private javax.swing.JTextField textHariAkhir;
    private javax.swing.JTextField textHariAwal;
    // End of variables declaration//GEN-END:variables
}
