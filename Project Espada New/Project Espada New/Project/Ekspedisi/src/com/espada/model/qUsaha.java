package com.espada.model;

import com.espada.Koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;

public class qUsaha {
    final private Koneksi kon = new Koneksi();
    
    
    public ArrayList<String> getNamaUsaha(){
        ArrayList<String> result = new ArrayList<>();
        try {
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT * FROM ms_usaha WHERE flag_active='1'";
            ResultSet rows = stat.executeQuery(Query);
            if(rows.next()){
                result.add(rows.getString("nama_usaha"));
                result.add(rows.getString("alamat"));
                result.add(rows.getString("kode_pos"));
                result.add(rows.getString("id"));
            }
            konektor.close();
            stat.close();
            rows.close();
            return result;
        } catch (SQLException ex) {
                System.out.println("ERR_QTARIF_GETNAMAUSAHA: "+ex);
                JOptionPane.showMessageDialog(null, "Gagal mendapatkan Usaha! (ERR_QTARIF_GETNAMAUSAHA)");
            return null;
        }
    }      
    
    public boolean checkUsaha(){
        try {
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT * FROM ms_usaha WHERE flag_active='1'";
            ResultSet rows = stat.executeQuery(Query);
            if(rows.next()){
                return true;
            }
            konektor.close();
            stat.close();
            rows.close();
                return false;
        } catch (SQLException ex) {
                System.out.println("ERR_QTARIF_GETNAMAUSAHA: "+ex);
                JOptionPane.showMessageDialog(null, "Gagal mendapatkan Usaha! (ERR_QTARIF_GETNAMAUSAHA)");
            return false;
        }
    }
        
    
}
