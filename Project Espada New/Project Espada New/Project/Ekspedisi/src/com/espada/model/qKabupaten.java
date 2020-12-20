package com.espada.model;

import com.espada.Koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

public class qKabupaten {
    
    final private Koneksi kon = new Koneksi();
           public boolean setKota(String namaKota, String idProvinsi){
        try {
            // TODO add your handling code here:
            
            Connection konektor = kon.Koneksi();
            Statement stat = konektor.createStatement();
            String Query = "INSERT INTO ms_kota (id_provinsi, kota, flag_active) VALUES ('"+idProvinsi+"', '"+namaKota+"', '1')";
            int rows = stat.executeUpdate(Query);
            if(rows==1){
                konektor.close();
            stat.close();
                return true;
            }else{
                System.out.println("ERR_QKAB_SETKOTA_1");
                JOptionPane.showMessageDialog(null, "Gagal menambah Kabupaten/Kota! (ERR_QKAB_SETKOTA_1)");
            }
            konektor.close();
            stat.close();
        } catch (SQLException ex) {
            System.out.println("ERR_QKAB_SETKOTA_2: "+ex);
            JOptionPane.showMessageDialog(null, "Gagal menambah Kabupaten/Kota! (ERR_QKAB_SETKOTA_2)");
        }
     return false;
    }
        
   public boolean deleteKota(int idKota){
        try {
            // TODO add your handling code here:
            
            Connection konektor = kon.Koneksi();
            Statement stat = konektor.createStatement();
            String Query = "UPDATE ms_kota SET flag_active='0' WHERE id='"+idKota+"'";
            int rows = stat.executeUpdate(Query);
            if(rows==1){
                konektor.close();
            stat.close();
                return true;
            }else{
                System.out.println("ERR_QKAB_DELKOTA_1");
                JOptionPane.showMessageDialog(null, "Gagal menghapus Kabupaten/Kota! (ERR_QKAB_DELKOTA_1)");
            }
            konektor.close();
            stat.close();
        } catch (SQLException ex) {
            System.out.println("ERR_QKAB_DELKOTA_2: "+ex);
            JOptionPane.showMessageDialog(null, "Gagal menghapus Kabupaten/Kota! (ERR_QKAB_DELKOTA_2)");
        }
     return false;
    }
    
    public ArrayList<Vector> getKota(){
        
        ArrayList<Vector> result = new ArrayList<>();
        try {
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT * FROM ms_kota WHERE flag_active='1'";
            ResultSet rows = stat.executeQuery(Query);
            while(rows.next()){
                Vector temp = new Vector();
                temp.add(rows.getString("id"));
                temp.add(rows.getString("id_provinsi"));
                temp.add(rows.getString("kota"));
                result.add(temp);
            }
            konektor.close();
            stat.close();
            rows.close();
            return result;
        } catch (SQLException ex) {
            System.out.println("ERR_QKAB_GETKOTA: "+ex);
            JOptionPane.showMessageDialog(null, "Gagal mendapatkan Kabupaten/Kota! (ERR_QKAB_GETKOTA)");
            return null;
        }
    }
    
    public ArrayList<Vector> getKota(String idProvinsi){
        
        ArrayList<Vector> result = new ArrayList<>();
        try {
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT * FROM ms_kota WHERE flag_active='1' AND id_provinsi='"+idProvinsi+"'";
            ResultSet rows = stat.executeQuery(Query);
            while(rows.next()){
                Vector temp = new Vector();
                temp.add(rows.getString("id"));
                temp.add(rows.getString("id_provinsi"));
                temp.add(rows.getString("kota"));
                result.add(temp);
            }
            konektor.close();
            stat.close();
            rows.close();
            return result;
        } catch (SQLException ex) {
            System.out.println("ERR_QKAB_GETKOTA_PARAM_IDPROV: "+ex);
            JOptionPane.showMessageDialog(null, "Gagal mendapatkan Kabupaten/Kota! (ERR_QKAB_GETKOTA_PARAM_IDPROV)");
            return null;
        }
    }
    
    public ArrayList<Vector> getKotaMe(String idKota){
        
        ArrayList<Vector> result = new ArrayList<>();
        try {
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT * FROM ms_kota WHERE flag_active='1' AND id='"+idKota+"'";
            ResultSet rows = stat.executeQuery(Query);
            while(rows.next()){
                Vector temp = new Vector();
                temp.add(rows.getString("id"));
                temp.add(rows.getString("id_provinsi"));
                temp.add(rows.getString("kota"));
                result.add(temp);
            }
            konektor.close();
            stat.close();
            rows.close();
            return result;
        } catch (SQLException ex) {
            System.out.println("ERR_QKAB_GETKOTAME_PARAM_IDKOTA: "+ex);
            JOptionPane.showMessageDialog(null, "Gagal mendapatkan Kabupaten/Kota! (ERR_QKAB_GETKOTAME_PARAM_IDKOTA)");
            return null;
        }
    }
    
     public ArrayList<Vector> searchKota(String keyword){
        
        ArrayList<Vector> result = new ArrayList<>();
        try {
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT * FROM ms_kota WHERE flag_active='1' AND kota LIKE '%"+keyword+"%'";
            ResultSet rows = stat.executeQuery(Query);
            while(rows.next()){
                Vector temp = new Vector();
                temp.add(rows.getString("id"));
                temp.add(rows.getString("id_provinsi"));
                temp.add(rows.getString("kota"));
                result.add(temp);
            }
            konektor.close();
            stat.close();
            rows.close();
            return result;
        } catch (SQLException ex) {
            System.out.println("ERR_QKAB_SEARCHKOTA: "+ex);
            JOptionPane.showMessageDialog(null, "Gagal mencari Kabupaten/Kota! (ERR_QKAB_SEARCHKOTA)");
            return null;
        }
    }
}
