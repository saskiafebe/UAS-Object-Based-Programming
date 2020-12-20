package com.espada.model;

import com.espada.Koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;

public class qPengiriman {
    final private Koneksi kon = new Koneksi();
    
    public ArrayList<Vector> getPengiriman(){
        
        ArrayList<Vector> result = new ArrayList<>();
        try {
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT * FROM tr_head_pengiriman WHERE flag_active='1'";
            ResultSet rows = stat.executeQuery(Query);
            while(rows.next()){
                Vector temp = new Vector();
                temp.add(rows.getString("id"));
                temp.add(rows.getString("nama_pengirim"));
                temp.add(rows.getString("nama_penerima"));
                temp.add(rows.getString("id_kecamatan_pengirim"));
                temp.add(rows.getString("id_kecamatan_penerima"));
                temp.add(rows.getString("alamat_penerima"));
                temp.add(rows.getString("tanggal"));
                temp.add(rows.getString("tanggal_kirim"));
                temp.add(rows.getString("tanggal_tiba"));
                temp.add(rows.getString("total_berat"));
                temp.add(rows.getString("kode_layanan"));
                temp.add(rows.getString("id_kurir"));
                temp.add(rows.getString("harga"));
                temp.add(rows.getString("hari"));
                temp.add(rows.getString("verifikasi"));
                result.add(temp);
            }
            konektor.close();
            stat.close();
            rows.close();
            return result;
        } catch (SQLException ex) {
            System.out.println("ERR_QPENGIRIMAN_GETPENGIRIMAN: "+ex);
            JOptionPane.showMessageDialog(null, "Gagal mendapatkan Pengiriman! (ERR_QPENGIRIMAN_GETPENGIRIMAN)");
            return null;
        }
        
    }
    
    public ArrayList<Vector> getPengirimanOrderByTglKirim(){
        
        ArrayList<Vector> result = new ArrayList<>();
        try {
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT * FROM tr_head_pengiriman WHERE flag_active='1' ORDER BY tanggal_kirim";
            ResultSet rows = stat.executeQuery(Query);
            while(rows.next()){
                Vector temp = new Vector();
                temp.add(rows.getString("id"));
                temp.add(rows.getString("nama_pengirim"));
                temp.add(rows.getString("nama_penerima"));
                temp.add(rows.getString("id_kecamatan_pengirim"));
                temp.add(rows.getString("id_kecamatan_penerima"));
                temp.add(rows.getString("alamat_penerima"));
                temp.add(rows.getString("tanggal"));
                temp.add(rows.getString("tanggal_kirim"));
                temp.add(rows.getString("tanggal_tiba"));
                temp.add(rows.getString("total_berat"));
                temp.add(rows.getString("kode_layanan"));
                temp.add(rows.getString("id_kurir"));
                temp.add(rows.getString("harga"));
                temp.add(rows.getString("hari"));
                temp.add(rows.getString("verifikasi"));
                result.add(temp);
            }
            konektor.close();
            stat.close();
            rows.close();
            return result;
        } catch (SQLException ex) {
            System.out.println("ERR_QPENGIRIMAN_GETPENGIRIMANORDERBYTGLKIRIM: "+ex);
            JOptionPane.showMessageDialog(null, "Gagal mendapatkan Pengiriman! (ERR_QPENGIRIMAN_GETPENGIRIMANORDERBYTGLKIRIM)");
            return null;
        }
        
    }
    
    public ArrayList<Vector> getPengirimanbyDatetime(String DateTime){
        
        ArrayList<Vector> result = new ArrayList<>();
        try {
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT * FROM tr_head_pengiriman WHERE flag_active='1' AND tanggal='"+DateTime+"'";
            ResultSet rows = stat.executeQuery(Query);
            while(rows.next()){
                Vector temp = new Vector();
                temp.add(rows.getString("id"));
                temp.add(rows.getString("nama_pengirim"));
                temp.add(rows.getString("nama_penerima"));
                temp.add(rows.getString("id_kecamatan_pengirim"));
                temp.add(rows.getString("id_kecamatan_penerima"));
                temp.add(rows.getString("alamat_penerima"));
                temp.add(rows.getString("tanggal"));
                temp.add(rows.getString("tanggal_kirim"));
                temp.add(rows.getString("tanggal_tiba"));
                temp.add(rows.getString("total_berat"));
                temp.add(rows.getString("kode_layanan"));
                temp.add(rows.getString("id_kurir"));
                temp.add(rows.getString("harga"));
                temp.add(rows.getString("hari"));
                temp.add(rows.getString("verifikasi"));
                result.add(temp);
            }
            konektor.close();
            stat.close();
            rows.close();
            return result;
        } catch (SQLException ex) {
            System.out.println("ERR_QPENGIRIMAN_GETPENGIRIMANBYDATEMTIME_PARAM_DATETIME: "+ex);
            JOptionPane.showMessageDialog(null, "Gagal mendapatkan Pengiriman! (ERR_QPENGIRIMAN_GETPENGIRIMANBYDATETIME_PARAM_DATETIME)");
            return null;
        }
        
    }
    
    public ArrayList<Vector> getBarang(String idPengiriman){
        
        ArrayList<Vector> result = new ArrayList<>();
        try {
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT * FROM tr_detail_pengiriman WHERE flag_active='1' AND id_pengiriman='"+idPengiriman+"'";
            ResultSet rows = stat.executeQuery(Query);
            while(rows.next()){
                Vector temp = new Vector();
                temp.add(rows.getString("id"));
                temp.add(rows.getString("id_pengiriman"));
                temp.add(rows.getString("keterangan_barang"));
                temp.add(rows.getString("berat_barang"));
                result.add(temp);
            }
            konektor.close();
            stat.close();
            rows.close();
            return result;
        } catch (SQLException ex) {
            System.out.println("ERR_QPENGIRIMAN_GETBARANG_PARAM_IDPENGIRIMAN: "+ex);
            JOptionPane.showMessageDialog(null, "Gagal mendapatkan Barang! (ERR_QPENGIRIMAN_GETPENGIRIMAN_PARAM_IDPENGIRIMAN)");
            return null;
        }
        
    }
    
     public boolean setPengiriman(
             String namaPengirim,
             String namaPenerima,
             String idKecPengirim,
             String idKecPenerima,
             String alamatPenerima,
             String tgl,
             String tglKirim,
             String tglTiba,
             int totBerat,
             String idLayanan,
             String idKurir,
             int harga,
             String hari){
        try {
            // TODO add your handling code here:
            tglTiba = "2012-01-01";
            Connection konektor = kon.Koneksi();
            Statement stat = konektor.createStatement();
            String Query = "INSERT INTO tr_head_pengiriman ("
                    + "nama_pengirim,"
                    + "nama_penerima,"
                    + "id_kecamatan_pengirim,"
                    + "id_kecamatan_penerima,"
                    + "alamat_penerima,"
                    + "tanggal,"
                    + "tanggal_kirim,"
                    + "tanggal_tiba,"
                    + "total_berat,"
                    + "kode_layanan,"
                    + "id_kurir,"
                    + "harga,"
                    + "hari,"
                    + "verifikasi,"
                    + "flag_active) VALUES ('"
                    +namaPengirim+"',"
                    + "'"+namaPenerima+"',"
                    + "'"+idKecPengirim+"',"
                    + "'"+idKecPenerima+"',"
                    + "'"+alamatPenerima+"',"
                    + "'"+tgl+"',"
                    + "'"+tglKirim+"',"
                    + "'"+tglTiba+"',"
                    + "'"+totBerat+"',"
                    + "'"+idLayanan+"',"
                    + "'"+idKurir+"',"
                    + "'"+harga+"',"
                    + "'"+hari+"', '0', '1')";
            int rows = stat.executeUpdate(Query);
            if(rows==1){
                konektor.close();
            stat.close();
                return true;
            }else{
                System.out.println("ERR_QPENGIRIMAN_SETPENGIRIMAN_1");
                JOptionPane.showMessageDialog(null, "Gagal menambahkan Pengiriman! (ERR_QPENGIRIMAN_SETPENGIRIMAN_1)");
            }
            konektor.close();
            stat.close();
        } catch (SQLException ex) {
            System.out.println("ERR_QPENGIRIMAN_SETPENGIRIMAN_2: "+ex);
            JOptionPane.showMessageDialog(null, "Gagal menambahkan Pengiriman! (ERR_QPENGIRIMAN_SETPENGIRIMAN_2)");
        }
     return false;
    }
     
     public boolean setBarang(
             String idPengiriman,
             String ketBarang,
             String beratBarang){
        try {
            // TODO add your handling code here:
            Connection konektor = kon.Koneksi();
            Statement stat = konektor.createStatement();
            String Query = "INSERT INTO tr_detail_pengiriman ("
                    + "id_pengiriman,"
                    + "keterangan_barang,"
                    + "berat_barang, flag_active) VALUES ('"
                    +idPengiriman+"',"
                    + "'"+ketBarang+"',"
                    + "'"+beratBarang+"', '1')";
            int rows = stat.executeUpdate(Query);
            if(rows==1){
                konektor.close();
            stat.close();
                return true;
            }else{
                System.out.println("ERR_QPENGIRIMAN_SETBARANG_1");
                JOptionPane.showMessageDialog(null, "Gagal menambahkan Barang! (ERR_QPENGIRIMAN_SETBARANG_1)");
            }
            konektor.close();
            stat.close();
        } catch (SQLException ex) {
                System.out.println("ERR_QPENGIRIMAN_SETBARANG_2: "+ex);
                JOptionPane.showMessageDialog(null, "Gagal menambahkan Barang! (ERR_QPENGIRIMAN_SETBARANG_2)");
        }
     return false;
    }
     
     public boolean deletePengiriman(int idPengiriman){
        try {
            // TODO add your handling code here:
            
            Connection konektor = kon.Koneksi();
            Statement stat = konektor.createStatement();
            String Query = "UPDATE tr_head_pengiriman SET flag_active='0' WHERE id='"+idPengiriman+"'";
            int rows = stat.executeUpdate(Query);
            if(rows==1){
                konektor.close();
            stat.close();
                return true;
            }else{
                System.out.println("ERR_QPENGIRIMAN_DELPENGIRIMAN_1");
                JOptionPane.showMessageDialog(null, "Gagal menghapus Pengiriman! (ERR_QPENGIRIMAN_DELPENGIRIMAN_1)");
            }
            konektor.close();
            stat.close();
        } catch (SQLException ex) {
            System.out.println("ERR_QPENGIRIMAN_DELPENGIRIMAN_2: "+ex);
                JOptionPane.showMessageDialog(null, "Gagal menghapus Pengiriman! (ERR_QPENGIRIMAN_DELPENGIRIMAN_2)");
        }
     return false;
    }
     
     public boolean verifikasiPengiriman(int idPengiriman){
        try {
            // TODO add your handling code here:
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            String tanggalUpdate = (String) dateFormat.format(date);
            Connection konektor = kon.Koneksi();
            Statement stat = konektor.createStatement();
            String Query = "UPDATE tr_head_pengiriman SET verifikasi='1' WHERE id='"+idPengiriman+"'";
            int rows = stat.executeUpdate(Query);
            if(rows==1){
                Query = "UPDATE tr_head_pengiriman SET tanggal_tiba='"+tanggalUpdate+"' WHERE id='"+idPengiriman+"'";
                rows = stat.executeUpdate(Query);
                if(rows==1){
                    konektor.close();
                    stat.close();
                }
                
                return true;
            }else{
                System.out.println("ERR_QPENGIRIMAN_VERPENGIRIMAN_1");
                JOptionPane.showMessageDialog(null, "Gagal verifikasi Pengiriman! (ERR_QPENGIRIMAN_VERPENGIRIMAN_1)");
            }
            konektor.close();
            stat.close();
        } catch (SQLException ex) {
                System.out.println("ERR_QPENGIRIMAN_VERPENGIRIMAN_2: "+ex);
                JOptionPane.showMessageDialog(null, "Gagal verifikasi Pengiriman! (ERR_QPENGIRIMAN_VERPENGIRIMAN_2)");
        }
     return false;
    }
     
     
     public boolean deleteBarang(int idBarang){
        try {
            // TODO add your handling code here:
            
            Connection konektor = kon.Koneksi();
            Statement stat = konektor.createStatement();
            String Query = "UPDATE tr_detail_pengiriman SET flag_active='0' WHERE id='"+idBarang+"'";
            int rows = stat.executeUpdate(Query);
            if(rows==1){
                konektor.close();
            stat.close();
                return true;
            }else{
                System.out.println("ERR_QPENGIRIMAN_DELBARANG_1");
                JOptionPane.showMessageDialog(null, "Gagal menghapus Barang! (ERR_QPENGIRIMAN_DELBARANG_1)");
            }
            konektor.close();
            stat.close();
        } catch (SQLException ex) {
                System.out.println("ERR_QPENGIRIMAN_DELBARANG_2: "+ex);
                JOptionPane.showMessageDialog(null, "Gagal menghapus Barang! (ERR_QPENGIRIMAN_DELBARANG_2)");
        }
     return false;
    }
     
     public ArrayList<Vector> searchPengiriman(
             String idKecAsal,
            String idKecTujuan,
            String kodeLayanan,
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
         
         if(tanggalPengirimanAwal.equals("Click for set Date")){
          tanggalPengirimanAwal="0";   
         }
         
         if(tanggalPengirimanAkhir.equals("Click for set Date")){
          tanggalPengirimanAkhir="0";   
         }
         
         if(tanggalTibaAwal.equals("Click for set Date")){
          tanggalTibaAwal="0";   
         }
         
         if(tanggalTibaAkhir.equals("Click for set Date")){
          tanggalTibaAkhir="0";   
         }
        
        ArrayList<Vector> result = new ArrayList<>();
        
        String requirement="";
        
        if(!tanggalPengirimanAwal.equals("0")&&!tanggalPengirimanAkhir.equals("0")){
            requirement = requirement + "AND (tanggal_kirim BETWEEN "+tanggalPengirimanAwal+" AND "+tanggalPengirimanAkhir+") ";
        }
        
        if(!tanggalTibaAwal.equals("0")&&!tanggalTibaAkhir.equals("0")){
            requirement = requirement + "AND (tanggal_tiba BETWEEN "+tanggalTibaAwal+" AND "+tanggalTibaAkhir+") ";
        }
        
        
        if(idKurir.equals("all")){
            
        }else{
            requirement = requirement + "AND id_kurir='"+idKurir+"' ";
        }
        
        if(idKecAsal.equals("all")){
            
        }else{
            requirement = requirement + "AND id_kecamatan_pengirim='"+idKecAsal+"' ";
        }
        
        if(idKecTujuan.equals("all")){
            
        }else{
            requirement = requirement + "AND id_kecamatan_penerima='"+idKecTujuan+"' ";
        }
        
        if(kodeLayanan.equals("all")){
            
        }else{
            requirement = requirement + "AND kode_layanan='"+kodeLayanan+"' ";
        }
        
        if(!beratAwal.equals("0")&&!beratAkhir.equals("0")){
            requirement = requirement + "AND (total_berat BETWEEN "+beratAwal+" AND "+beratAkhir+") ";
        }
        
        if(!hargaAwal.equals("0")&&!hargaAkhir.equals("0")){
            requirement = requirement + "AND (harga BETWEEN "+hargaAwal+" AND "+hargaAkhir+") ";
        }
        
        if(!hariAwal.equals("0")&&!hariAkhir.equals("0")){
            requirement = requirement + "AND (hari BETWEEN "+hariAwal+" AND "+hariAkhir+") ";
        }
        
        try {
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT * FROM tr_head_pengiriman WHERE flag_active='1' "+requirement;
            ResultSet rows = stat.executeQuery(Query);
            System.out.println(Query);
            while(rows.next()){
                Vector temp = new Vector();
                temp.add(rows.getString("id"));
                temp.add(rows.getString("nama_pengirim"));
                temp.add(rows.getString("nama_penerima"));
                temp.add(rows.getString("id_kecamatan_pengirim"));
                temp.add(rows.getString("id_kecamatan_penerima"));
                temp.add(rows.getString("alamat_penerima"));
                temp.add(rows.getString("tanggal"));
                temp.add(rows.getString("tanggal_kirim"));
                temp.add(rows.getString("tanggal_tiba"));
                temp.add(rows.getString("total_berat"));
                temp.add(rows.getString("kode_layanan"));
                temp.add(rows.getString("id_kurir"));
                temp.add(rows.getString("harga"));
                temp.add(rows.getString("hari"));
                temp.add(rows.getString("verifikasi"));
                result.add(temp);
            }
            konektor.close();
            stat.close();
            rows.close();
            return result;
        } catch (SQLException ex) {
                System.out.println("ERR_QPENGIRIMAN_SEARCHPENGIRIMAN: "+ex);
                JOptionPane.showMessageDialog(null, "Gagal mencari Pengiriman! (ERR_QPENGIRIMAN_SEARCHPENGIRIMAN)");
            return null;
        }
        
    }
     
     public ArrayList<Vector> getPengirimanDistinctLayanan(){
        
        ArrayList<Vector> result = new ArrayList<>();
        try {
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT DISTINCT kode_layanan FROM tr_head_pengiriman WHERE flag_active='1'";
            ResultSet rows = stat.executeQuery(Query);
            while(rows.next()){
                Vector temp = new Vector();
                temp.add(rows.getString("kode_layanan"));
                result.add(temp);
            }
            konektor.close();
            stat.close();
            rows.close();
            return result;
        } catch (SQLException ex) {
                System.out.println("ERR_QPENGIRIMAN_GETPENGIRIMANDISTINCTLAYANAN: "+ex);
                JOptionPane.showMessageDialog(null, "Gagal mendapatkan Pengiriman! (ERR_QPENGIRIMAN_GETPENGIRIMANDISTINCTLAYANAN)");
            return null;
        }
        
    }
     
    public ArrayList<Vector> getPengirimanDistinctKurir(){
        
        ArrayList<Vector> result = new ArrayList<>();
        try {
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT DISTINCT id_kurir FROM tr_head_pengiriman WHERE flag_active='1'";
            ResultSet rows = stat.executeQuery(Query);
            while(rows.next()){
                Vector temp = new Vector();
                temp.add(rows.getString("id_kurir"));
                result.add(temp);
            }
            konektor.close();
            stat.close();
            rows.close();
            return result;
        } catch (SQLException ex) {
            System.out.println("ERR_QPENGIRIMAN_GETPENGIRIMANDISTINCTKURIR: "+ex);
            JOptionPane.showMessageDialog(null, "Gagal mendapatkan Pengiriman! (ERR_QPENGIRIMAN_GETPENGIRIMANDISTINCTKURIR)");
            return null;
        }
        
    }
    
    public ArrayList<Vector> getPengirimanDistinctKecamatanPenerima(){
        
        ArrayList<Vector> result = new ArrayList<>();
        try {
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT DISTINCT id_kecamatan_penerima FROM tr_head_pengiriman WHERE flag_active='1'";
            ResultSet rows = stat.executeQuery(Query);
            while(rows.next()){
                Vector temp = new Vector();
                temp.add(rows.getString("id_kecamatan_penerima"));
                result.add(temp);
            }
            konektor.close();
            stat.close();
            rows.close();
            return result;
        } catch (SQLException ex) {
                System.out.println("ERR_QPENGIRIMAN_GETPENGIRIMANDISTINCTKECAMATANPENERIMA: "+ex);
                JOptionPane.showMessageDialog(null, "Gagal mendapatkan Pengiriman! (ERR_QPENGIRIMAN_GETPENGIRIMANDISTINCTKECAMATANPENERIMA)");
            return null;
        }
        
    }
    
    public ArrayList<Vector> getPengirimanDistinctKecamatanPengirim(){
        
        ArrayList<Vector> result = new ArrayList<>();
        try {
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT DISTINCT id_kecamatan_pengirim FROM tr_head_pengiriman WHERE flag_active='1'";
            ResultSet rows = stat.executeQuery(Query);
            while(rows.next()){
                Vector temp = new Vector();
                temp.add(rows.getString("id_kecamatan_pengirim"));
                result.add(temp);
            }
            konektor.close();
            stat.close();
            rows.close();
            return result;
        } catch (SQLException ex) {
            System.out.println("ERR_QPENGIRIMAN_GETPENGIRIMANDISTINCTKECAMATANPENGIRIM: "+ex);
                JOptionPane.showMessageDialog(null, "Gagal mendapatkan Pengiriman! (ERR_QPENGIRIMAN_GETPENGIRIMANDISTINCTKECAMATANPENGIRIM)");
            return null;
        }
        
    }
}
