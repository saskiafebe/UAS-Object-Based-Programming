package com.espada.model;

import com.espada.Koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

public class qTarif {
    final private Koneksi kon = new Koneksi();
    public ArrayList<Vector> getTarif(){
        
        ArrayList<Vector> result = new ArrayList<>();
        try {
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT * FROM ms_tarif WHERE flag_active='1'";
            ResultSet rows = stat.executeQuery(Query);
            while(rows.next()){
                Vector temp = new Vector();
                temp.add(rows.getString("id"));
                temp.add(rows.getString("id_kecamatan_asal"));
                temp.add(rows.getString("id_kecamatan_tujuan"));
                temp.add(rows.getString("id_layanan"));
                temp.add(rows.getString("durasi_pengiriman"));
                temp.add(rows.getString("harga"));
                result.add(temp);
            }
            konektor.close();
            stat.close();
            rows.close();
            
            return result;
        } catch (SQLException ex) {
                System.out.println("ERR_QTARIF_GETTARIF: "+ex);
                JOptionPane.showMessageDialog(null, "Gagal mendapatkan Tarif! (ERR_QTARIF_GETTARIF)");
            return null;
        }
    }
    
    public ArrayList<Vector> getTarif(String idKecAsal, String idKecTujuan, String idLayanan){
        
        ArrayList<Vector> result = new ArrayList<>();
        try {
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT * FROM ms_tarif WHERE flag_active='1' AND id_kecamatan_asal='"+idKecAsal+"' AND id_kecamatan_tujuan='"+idKecTujuan+"' AND id_layanan='"+idLayanan+"'";
            ResultSet rows = stat.executeQuery(Query);
            while(rows.next()){
                Vector temp = new Vector();
                temp.add(rows.getString("id"));
                temp.add(rows.getString("id_kecamatan_asal"));
                temp.add(rows.getString("id_kecamatan_tujuan"));
                temp.add(rows.getString("id_layanan"));
                temp.add(rows.getString("durasi_pengiriman"));
                temp.add(rows.getString("harga"));
                result.add(temp);
            }
            konektor.close();
            stat.close();
            rows.close();
            return result;
        } catch (SQLException ex) {
            System.out.println("ERR_QTARIF_GETTARIF_PARAM_IDKECASAL_IDKECTUJUAN_IDLAYANAN: "+ex);
            JOptionPane.showMessageDialog(null, "Gagal mendapatkan Tarif! (ERR_QTARIF_GETTARIF_PARAM_IDKECASAL_IDKECTUJUAN_IDLAYANAN)");
            return null;
        }
    }
    
    
    public boolean checkLayanan(String idLayanan){
        
        ArrayList<Vector> result = new ArrayList<>();
        try {
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT * FROM ms_tarif WHERE flag_active='1' AND id_layanan='"+idLayanan+"'";
            ResultSet rows = stat.executeQuery(Query);
            while(rows.next()){
                return true;
            }
            konektor.close();
            stat.close();
            rows.close();
            return false;
        } catch (SQLException ex) {
            System.out.println("ERR_QTARIF_CHECKLAYANAN: "+ex);
            JOptionPane.showMessageDialog(null, "Gagal cek Layanan dari Tarif! (ERR_QTARIF_CHECKLAYANAN)");
            return false;
        }
    }
    
    public boolean checkKecamatan(String idKecamatan){
        
        ArrayList<Vector> result = new ArrayList<>();
        try {
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT * FROM ms_tarif WHERE flag_active='1' AND (id_kecamatan_asal='"+idKecamatan+"' OR id_kecamatan_tujuan='"+idKecamatan+"')";
            ResultSet rows = stat.executeQuery(Query);
            while(rows.next()){
                return true;
            }
            konektor.close();
            stat.close();
            rows.close();
            return false;
        } catch (SQLException ex) {
            System.out.println("ERR_QTARIF_CHECKKECAMATAN: "+ex);
            JOptionPane.showMessageDialog(null, "Gagal cek Layanan dari Tarif! (ERR_QTARIF_CHECKKECAMATAN)");
            return false;
        }
    }
    
    
    
     public ArrayList<Vector> getTarif(String idKecAsal, String idKecTujuan){
        
        ArrayList<Vector> result = new ArrayList<>();
        try {
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT * FROM ms_tarif WHERE flag_active='1' AND id_kecamatan_asal='"+idKecAsal+"' AND id_kecamatan_tujuan='"+idKecTujuan+"'";
            ResultSet rows = stat.executeQuery(Query);
            while(rows.next()){
                Vector temp = new Vector();
                temp.add(rows.getString("id"));
                temp.add(rows.getString("id_kecamatan_asal"));
                temp.add(rows.getString("id_kecamatan_tujuan"));
                temp.add(rows.getString("id_layanan"));
                temp.add(rows.getString("durasi_pengiriman"));
                temp.add(rows.getString("harga"));
                result.add(temp);
            }
            konektor.close();
            stat.close();
            rows.close();
            return result;
        } catch (SQLException ex) {
            System.out.println("ERR_QTARIF_GETTARIF_PARAM_IDKECASAL_IDKECTUJUAN: "+ex);
            JOptionPane.showMessageDialog(null, "Gagal mendapatkan Tarif! (ERR_QTARIF_GETTARIF_PARAM_IDKECASAL_IDKECTUJUAN)");
            return null;
        }
    }
     
     public ArrayList<Vector> getLayananfromTarif(String idKecAsal, String idKecTujuan){
        
        ArrayList<Vector> result = new ArrayList<>();
        try {
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT DISTINCT id_layanan FROM ms_tarif WHERE flag_active='1' AND id_kecamatan_asal='"+idKecAsal+"' AND id_kecamatan_tujuan='"+idKecTujuan+"'";
            ResultSet rows = stat.executeQuery(Query);
            while(rows.next()){
                Vector temp = new Vector();
                temp.add(rows.getString("id_layanan"));
                result.add(temp);
            }
            konektor.close();
            stat.close();
            rows.close();
            return result;
        } catch (SQLException ex) {
            System.out.println("ERR_QTARIF_GETLAYANANFROMTARIF: "+ex);
            JOptionPane.showMessageDialog(null, "Gagal mendapatkan Tarif! (ERR_QTARIF_GETLAYANANFROMTARIF)");
             Vector temp = new Vector();
                temp.add("");
                result.add(temp);
                return result;
        }
    }
    
    public boolean setTarif(String idKecAsal, String idKecTujuan, String idLayanan, String durasi, String harga){
        try {
            // TODO add your handling code here:
            
            Connection konektor = kon.Koneksi();
            Statement stat = konektor.createStatement();
            String Query = "INSERT INTO ms_tarif (id_kecamatan_asal, id_kecamatan_tujuan, id_layanan, durasi_pengiriman, harga, flag_active) VALUES ("+ "'"+idKecAsal+"', '"+idKecTujuan+"', '"+idLayanan+"', '"+durasi+"', '"+harga+"', '1')";
            int rows = stat.executeUpdate(Query);
            if(rows==1){
                konektor.close();
            stat.close();
                return true;
            }else{
                System.out.println("ERR_QTARIF_SETTARIF_1");
                JOptionPane.showMessageDialog(null, "Gagal menambahkan Tarif! (ERR_QTARIF_SETTARIF_1)");
            }
            konektor.close();
            stat.close();
        } catch (SQLException ex) {
                System.out.println("ERR_QTARIF_SETTARIF_2: "+ex);
                JOptionPane.showMessageDialog(null, "Gagal menambahkan Tarif! (ERR_QTARIF_SETTARIF_2)");
        }
     return false;
    }
    
            public boolean deleteTarif(int idTarif){
        try {
            // TODO add your handling code here:
            
            Connection konektor = kon.Koneksi();
            Statement stat = konektor.createStatement();
            String Query = "UPDATE ms_tarif SET flag_active='0' WHERE id='"+idTarif+"'";
            int rows = stat.executeUpdate(Query);
            if(rows==1){
                konektor.close();
            stat.close();
                return true;
            }else{
                System.out.println("ERR_QTARIF_DELTARIF_1");
                JOptionPane.showMessageDialog(null, "Gagal menghapus Tarif! (ERR_QTARIF_DELTARIF_1)");
            }
            konektor.close();
            stat.close();
        } catch (SQLException ex) {
                System.out.println("ERR_QTARIF_DELTARIF_2: "+ex);
                JOptionPane.showMessageDialog(null, "Gagal menghapus Tarif! (ERR_QTARIF_DELTARIF_2)");
        }
     return false;
    }
            
    public ArrayList<Vector> searchTarif(
            String idKecAsal,
            String idKecTujuan,
            String idLayanan,
            String durasiAwal,
            String durasiAkhir,
            String hargaAwal,
            String hargaAkhir){
        
        String requirement="";
        if(idKecAsal.equals("all")){
            
        }else{
            requirement = requirement + "AND id_kecamatan_asal='"+idKecAsal+"' ";
        }
        
        if(idKecTujuan.equals("all")){
            
        }else{
            requirement = requirement + "AND id_kecamatan_tujuan='"+idKecTujuan+"' ";
        }
        
        if(idLayanan.equals("all")){
            
        }else{
            requirement = requirement + "AND id_layanan='"+idLayanan+"' ";
        }
        
        if(!durasiAwal.equals("0")&&!durasiAkhir.equals("0")){
            requirement = requirement + "AND (durasi_pengiriman BETWEEN "+durasiAwal+" AND "+durasiAkhir+") ";
        }
        
        if(!hargaAwal.equals("0")&&!hargaAkhir.equals("0")){
            requirement = requirement + "AND (harga BETWEEN "+hargaAwal+" AND "+hargaAkhir+") ";
        }
        
        ArrayList<Vector> result = new ArrayList<>();
        try {
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT * FROM ms_tarif WHERE flag_active='1' "+requirement+"";
            ResultSet rows = stat.executeQuery(Query);
            while(rows.next()){
                Vector temp = new Vector();
                temp.add(rows.getString("id"));
                temp.add(rows.getString("id_kecamatan_asal"));
                temp.add(rows.getString("id_kecamatan_tujuan"));
                temp.add(rows.getString("id_layanan"));
                temp.add(rows.getString("durasi_pengiriman"));
                temp.add(rows.getString("harga"));
                result.add(temp);
            }
            konektor.close();
            stat.close();
            rows.close();
            return result;
        } catch (SQLException ex) {
                System.out.println("ERR_QTARIF_SEARCHTARIF: "+ex);
                JOptionPane.showMessageDialog(null, "Gagal mencari Tarif! (ERR_QTARIF_SEARCHTARIF)");
            return null;
        }
    }
}
