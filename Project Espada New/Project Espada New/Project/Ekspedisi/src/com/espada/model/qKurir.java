package com.espada.model;

import com.espada.Koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

public class qKurir {
    final private Koneksi kon = new Koneksi();
    public ArrayList<Vector> getKurir(){
        
        ArrayList<Vector> result = new ArrayList<>();
        try {
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT * FROM ms_kurir WHERE flag_active='1'";
            ResultSet rows = stat.executeQuery(Query);
            while(rows.next()){
                Vector temp = new Vector();
                temp.add(rows.getString("id"));
                temp.add(rows.getString("nama_kurir"));
                result.add(temp);
            }
            konektor.close();
            stat.close();
            rows.close();
            return result;
        } catch (SQLException ex) {
            System.out.println("ERR_QKURIR_GETKURIR: "+ex);
            JOptionPane.showMessageDialog(null, "Gagal mendapatkan Kurir! (ERR_QKURIR_GETKURIR)");
            return null;
        }
    }
    
    public ArrayList<Vector> getKurir(String idKurir){
        
        ArrayList<Vector> result = new ArrayList<>();
        try {
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT * FROM ms_kurir WHERE id='"+idKurir+"'";
            ResultSet rows = stat.executeQuery(Query);
            while(rows.next()){
                Vector temp = new Vector();
                temp.add(rows.getString("id"));
                temp.add(rows.getString("nama_kurir"));
                result.add(temp);
            }
            konektor.close();
            stat.close();
            rows.close();
            return result;
        } catch (SQLException ex) {
            System.out.println("ERR_QKURIR_GETKURIR_PARAM_IDKURIR: "+ex);
            JOptionPane.showMessageDialog(null, "Gagal mendapatkan Kurir! (ERR_QKURIR_GETKURIR_PARAM_IDKURIR)");
            return null;
        }
    }
    
    
    
    public boolean checkKurirfromPengiriman(String idKurir){
        
        
        try {
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT * FROM tr_head_pengiriman WHERE flag_active='1' AND id_kurir='"+idKurir+"'";
            ResultSet rows = stat.executeQuery(Query);
            while(rows.next()){
                return true;
            }
            konektor.close();
            stat.close();
            rows.close();
            return false;
        } catch (SQLException ex) {
            System.out.println("ERR_QLAYANAN_CHECKKURIRFROMPENGIRIMAN: "+ex);
            JOptionPane.showMessageDialog(null, "Gagal check Kurir! (ERR_QLAYANAN_CHECKKURIRFROMPENGIRIMAN)");
            return false;
        }
    }
    
    public boolean setKurir(String namaKurir){
        try {
            // TODO add your handling code here:
            
            Connection konektor = kon.Koneksi();
            Statement stat = konektor.createStatement();
            String Query = "INSERT INTO ms_kurir (nama_kurir, flag_active) VALUES ('"+namaKurir+"', '1')";
            int rows = stat.executeUpdate(Query);
            if(rows==1){konektor.close();
            stat.close();
                return true;
            }else{
                System.out.println("ERR_QKURIR_SETKURIR_1");
                JOptionPane.showMessageDialog(null, "Gagal menambahkan Kurir! (ERR_QKURIR_SETKURIR_1)");
            }
            konektor.close();
            stat.close();
        } catch (SQLException ex) {
            System.out.println("ERR_QKURIR_SETKURIR_2: "+ex);
            JOptionPane.showMessageDialog(null, "Gagal mendapatkan Kurir! (ERR_QKURIR_GETKURIR_2)");
        }
     return false;
    }
    
    public boolean deleteKurir(int idKurir){
        try {
            // TODO add your handling code here:
            
            Connection konektor = kon.Koneksi();
            Statement stat = konektor.createStatement();
            String Query = "UPDATE ms_kurir SET flag_active='0' WHERE id='"+idKurir+"'";
            int rows = stat.executeUpdate(Query);
            if(rows==1){
                konektor.close();
            stat.close();
                return true;
            }else{
                System.out.println("ERR_QKURIR_DELKURIR_1");
                JOptionPane.showMessageDialog(null, "Gagal menghapus Kurir! (ERR_QKURIR_DELKURIR_1)");
            }
            konektor.close();
            stat.close();
        } catch (SQLException ex) {
            System.out.println("ERR_QKURIR_DELKURIR_2: "+ex);
            JOptionPane.showMessageDialog(null, "Gagal menghapus Kurir! (ERR_QKURIR_DELKURIR_2)");
        }
     return false;
    }
}
