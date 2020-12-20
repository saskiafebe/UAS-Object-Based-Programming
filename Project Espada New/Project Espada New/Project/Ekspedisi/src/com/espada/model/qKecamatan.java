package com.espada.model;

import com.espada.Koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

public class qKecamatan {
    
        final private Koneksi kon = new Koneksi();
    
        public boolean setKecamatan(String namaKecamatan, String idKota){
        try {
            // TODO add your handling code here:
            
            Connection konektor = kon.Koneksi();
            Statement stat = konektor.createStatement();
            String Query = "INSERT INTO ms_kecamatan (id_kota, kecamatan, flag_active) VALUES ('"+idKota+"', '"+namaKecamatan+"', '1')";
            int rows = stat.executeUpdate(Query);
            if(rows==1){
                konektor.close();
            stat.close();
                return true;
            }else{
                System.out.println("ERR_QKEC_SETKEC_1");
                JOptionPane.showMessageDialog(null, "Gagal menambahkan Kecamatan! (ERR_QKEC_SETKEC_1)");
            }
            konektor.close();
            stat.close();
        } catch (SQLException ex) {
            System.out.println("ERR_QKEC_SETKEC_2: "+ex);
            JOptionPane.showMessageDialog(null, "Gagal menghapus Kecamatan! (ERR_QKEC_SETKEC_2)");
        }
     return false;
    }
        
        public boolean deleteKecamatan(int idKecamatan){
        try {
            // TODO add your handling code here:
            
            Connection konektor = kon.Koneksi();
            Statement stat = konektor.createStatement();
            String Query = "UPDATE ms_kecamatan SET flag_active='0' WHERE id='"+idKecamatan+"'";
            int rows = stat.executeUpdate(Query);
            if(rows==1){
                konektor.close();
            stat.close();
                return true;
            }else{
                System.out.println("ERR_QKEC_DELKEC_1");
                JOptionPane.showMessageDialog(null, "Gagal menghapus Kecamatan! (ERR_QKEC_DELKEC_1)");
            }
            konektor.close();
            stat.close();
        } catch (SQLException ex) {
            System.out.println("ERR_QKEC_DELKEC_2: "+ex);
            JOptionPane.showMessageDialog(null, "Gagal menghapus Kecamatan! (ERR_QKEC_DELKEC_2)");
        }
     return false;
    }
    
    public ArrayList<Vector> getKecamatan(){
        
        ArrayList<Vector> result = new ArrayList<>();
        try{
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT * FROM ms_kecamatan WHERE flag_active='1'";
            ResultSet rows = stat.executeQuery(Query);
            while(rows.next()){
                Vector temp = new Vector();
                temp.add(rows.getString("id"));
                temp.add(rows.getString("id_kota"));
                temp.add(rows.getString("kecamatan"));
                result.add(temp);
            }
            konektor.close();
            stat.close();
            rows.close();
            return result;
        } catch (SQLException ex) {
            System.out.println("ERR_QKEC_GETKEC: "+ex);
            JOptionPane.showMessageDialog(null, "Gagal mendapatkan Kecamatan! (ERR_QKEC_GETKEC)");
            return null;
        }
    }
    
    public ArrayList<Vector> getKecamatan(String idKota){
        
        ArrayList<Vector> result = new ArrayList<>();
        try {
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT * FROM ms_kecamatan WHERE flag_active='1' AND id_kota='"+idKota+"'";
            ResultSet rows = stat.executeQuery(Query);
            while(rows.next()){
                Vector temp = new Vector();
                temp.add(rows.getString("id"));
                temp.add(rows.getString("id_kota"));
                temp.add(rows.getString("kecamatan"));
                result.add(temp);
            }
            konektor.close();
            stat.close();
            rows.close();
            return result;
        } catch (SQLException ex) {
            System.out.println("ERR_QKEC_GETKEC_PARAM_IDKOTA: "+ex);
            JOptionPane.showMessageDialog(null, "Gagal mendapatkan Kecamatan! (ERR_QKEC_GETKEC_PARAM_IDKOTA)");
            return null;
        }
    }
    
    public ArrayList<Vector> getKecamatanMe(String idKecamatan){
        
        ArrayList<Vector> result = new ArrayList<>();
        try {
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT * FROM ms_kecamatan WHERE id='"+idKecamatan+"'";
            ResultSet rows = stat.executeQuery(Query);
            while(rows.next()){
                Vector temp = new Vector();
                temp.add(rows.getString("id"));
                temp.add(rows.getString("id_kota"));
                temp.add(rows.getString("kecamatan"));
                result.add(temp);
            }
            konektor.close();
            stat.close();
            rows.close();
            return result;
        } catch (SQLException ex) {
            System.out.println("ERR_QKEC_GETKECME: "+ex);
            JOptionPane.showMessageDialog(null, "Gagal mendapatkan Kecamatan! (ERR_QKEC_GETKECME)");
            return null;
        }
    }
    
    public ArrayList<Vector> searchKecamatan(String keyword){
        
        ArrayList<Vector> result = new ArrayList<>();
        try {
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT * FROM ms_kecamatan WHERE flag_active='1' AND kecamatan LIKE '%"+keyword+"%'";
            ResultSet rows = stat.executeQuery(Query);
            
            while(rows.next()){
                Vector temp = new Vector();
                temp.add(rows.getString("id"));
                temp.add(rows.getString("id_kota"));
                temp.add(rows.getString("kecamatan"));
                result.add(temp);
            }
            konektor.close();
            stat.close();
            rows.close();
            return result;
        } catch (SQLException ex) {
            System.out.println("ERR_QKEC_SEARCHKEC: "+ex);
            JOptionPane.showMessageDialog(null, "Gagal mencari Kecamatan! (ERR_QKEC_SEARCHKEC)");
            return null;
        }
    }
}
