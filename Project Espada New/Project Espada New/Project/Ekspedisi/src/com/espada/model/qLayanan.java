package com.espada.model;

import com.espada.Koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

public class qLayanan {
    final private Koneksi kon = new Koneksi();
    public ArrayList<Vector> getLayanan(){
        
        ArrayList<Vector> result = new ArrayList<>();
        try {
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT * FROM ms_layanan WHERE flag_active='1'";
            ResultSet rows = stat.executeQuery(Query);
            while(rows.next()){
                Vector temp = new Vector();
                temp.add(rows.getString("id"));
                temp.add(rows.getString("nama_layanan"));
                temp.add(rows.getString("kode_layanan"));
                result.add(temp);
            }
            konektor.close();
            stat.close();
            rows.close();
            return result;
        } catch (SQLException ex) {
            System.out.println("ERR_QLAYANAN_GETLAYANAN: "+ex);
            JOptionPane.showMessageDialog(null, "Gagal mendapatkan Layanan! (ERR_QLAYANAN_GETLAYANAN)");
            return null;
        }
    }
    
    public ArrayList<Vector> getLayanan(String idLayanan){
        
        ArrayList<Vector> result = new ArrayList<>();
        try {
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT * FROM ms_layanan WHERE flag_active='1' AND id='"+idLayanan+"'";
            ResultSet rows = stat.executeQuery(Query);
            while(rows.next()){
                Vector temp = new Vector();
                temp.add(rows.getString("id"));
                temp.add(rows.getString("nama_layanan"));
                temp.add(rows.getString("kode_layanan"));
                result.add(temp);
            }
            konektor.close();
            stat.close();
            rows.close();
            return result;
        } catch (SQLException ex) {
            System.out.println("ERR_QLAYANAN_GETLAYANAN_PARAM_IDLAYANAN: "+ex);
            JOptionPane.showMessageDialog(null, "Gagal mendapatkan Layanan! (ERR_QLAYANAN_GETLAYANAN_PARAM_IDLAYANAN)");
            return null;
        }
    }
    
    public boolean checkLayananfromPengiriman(String kodeLayanan){
        
        
        try {
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT * FROM tr_head_pengiriman WHERE flag_active='1' AND kode_layanan='"+kodeLayanan+"'";
            ResultSet rows = stat.executeQuery(Query);
            while(rows.next()){
                return true;
            }
            konektor.close();
            stat.close();
            rows.close();
            return false;
        } catch (SQLException ex) {
            System.out.println("ERR_QLAYANAN_CHECKLAYANANFROMPENGIRIMAN: "+ex);
            JOptionPane.showMessageDialog(null, "Gagal check Layanan! (ERR_QLAYANAN_CHECKLAYANANFROMPENGIRIMAN)");
            return false;
        }
    }
    
    public ArrayList<Vector> getLayananbyKode(String kodeLayanan){
        
        ArrayList<Vector> result = new ArrayList<>();
        try {
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT * FROM ms_layanan WHERE kode_layanan='"+kodeLayanan+"'";
            ResultSet rows = stat.executeQuery(Query);
            while(rows.next()){
                Vector temp = new Vector();
                temp.add(rows.getString("id"));
                temp.add(rows.getString("nama_layanan"));
                temp.add(rows.getString("kode_layanan"));
                result.add(temp);
            }
            konektor.close();
            stat.close();
            rows.close();
            return result;
        } catch (SQLException ex) {
            System.out.println("ERR_QLAYANAN_GETLAYANANBYKODE_PARAM_KODELAYANAN: "+ex);
            JOptionPane.showMessageDialog(null, "Gagal mendapatkan Layanan! (ERR_QLAYANAN_GETLAYANANBYKODE_PARAM_KODELAYANAN)");
            return null;
        }
    }
    
        public boolean setLayanan(String namaLayanan, String kodeLayanan){
        try {
            // TODO add your handling code here:
            
            Connection konektor = kon.Koneksi();
            Statement stat = konektor.createStatement();
            String Query = "INSERT INTO ms_layanan (nama_layanan, kode_layanan, flag_active) VALUES ('"+namaLayanan+"', '"+kodeLayanan+"', '1')";
            int rows = stat.executeUpdate(Query);
            if(rows==1){
                konektor.close();
            stat.close();
                return true;
            }else{
                System.out.println("ERR_QLAYANAN_SETLAYANAN_1");
                JOptionPane.showMessageDialog(null, "Gagal menambahkan Layanan! (ERR_QLAYANAN_SETLAYANAN_1)");
            }
            konektor.close();
            stat.close();
        } catch (SQLException ex) {
            System.out.println("ERR_QLAYANAN_SETLAYANAN_2: "+ex);
            JOptionPane.showMessageDialog(null, "Gagal menambahkan Layanan! (ERR_QLAYANAN_SETLAYANAN_2)");
        }
     return false;
    }
        
        public boolean deleteLayanan(int idLayanan){
        try {
            // TODO add your handling code here:
            
            Connection konektor = kon.Koneksi();
            Statement stat = konektor.createStatement();
            String Query = "UPDATE ms_layanan SET flag_active='0' WHERE id='"+idLayanan+"'";
            int rows = stat.executeUpdate(Query);
            if(rows==1){
                konektor.close();
            stat.close();
                return true;
            }else{
                System.out.println("ERR_QLAYANAN_DELLAYANAN_1");
                JOptionPane.showMessageDialog(null, "Gagal menghapus Layanan! (ERR_QLAYANAN_DELLAYANAN_1)");
            }
            konektor.close();
            stat.close();
        } catch (SQLException ex) {
            System.out.println("ERR_QLAYANAN_DELLAYANAN_2: "+ex);
            JOptionPane.showMessageDialog(null, "Gagal menghapus Layanan! (ERR_QLAYANAN_DELLAYANAN_2)");
        }
     return false;
    }
}
