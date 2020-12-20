package com.espada.model;

import com.espada.Koneksi;
import com.espada.gui.Login;
import com.espada.gui.SetUsaha;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class qProvinsi {
    final private Koneksi kon = new Koneksi();
    
    public boolean setProvinsi(String namaProvinsi){
     try {
            // TODO add your handling code here:
            
            Connection konektor = kon.Koneksi();
            Statement stat = konektor.createStatement();
            String Query = "INSERT INTO ms_provinsi (provinsi, flag_active) VALUES ('"+namaProvinsi+"', '1')";
            int rows = stat.executeUpdate(Query);
            if(rows==1){
                konektor.close();
            stat.close();
                return true;
            }else{
                System.out.println("ERR_QPROVINSI_SETPROVINSI_1");
                JOptionPane.showMessageDialog(null, "Gagal menambahkan Provinsi! (ERR_QPROVINSI_SETPROVINSI_1)");
            }
            konektor.close();
            stat.close();
        } catch (SQLException ex) {
                System.out.println("ERR_QPROVINSI_SETPROVINSI_2: "+ex);
                JOptionPane.showMessageDialog(null, "Gagal menambahkan Provinsi! (ERR_QPROVINSI_SETPROVINSI_2)");
        }
     return false;
    }
    
    public boolean deleteProvinsi(int idProvinsi){
        try {
            // TODO add your handling code here:
            
            Connection konektor = kon.Koneksi();
            Statement stat = konektor.createStatement();
            String Query = "UPDATE ms_provinsi SET flag_active='0' WHERE id='"+idProvinsi+"'";
            int rows = stat.executeUpdate(Query);
            if(rows==1){
                konektor.close();
            stat.close();
                return true;
            }else{
                System.out.println("ERR_QPROVINSI_DELPROVINSI_1");
                JOptionPane.showMessageDialog(null, "Gagal menghapus Provinsi! (ERR_QPROVINSI_DELPROVINSI_1)");
            }
            konektor.close();
            stat.close();
        } catch (SQLException ex) {
                System.out.println("ERR_QPROVINSI_DELPROVINSI_2: "+ex);
                JOptionPane.showMessageDialog(null, "Gagal menghapus Provinsi! (ERR_QPROVINSI_DELPROVINSI_2)");
        }
     return false;
    }
    
    public ArrayList<Vector> getProvinsi(){
        
        ArrayList<Vector> result = new ArrayList<>();
        try {
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT * FROM ms_provinsi WHERE flag_active='1'";
            ResultSet rows = stat.executeQuery(Query);
            while(rows.next()){
                Vector temp = new Vector();
                temp.add(rows.getString("provinsi"));
                temp.add(rows.getString("id"));
                result.add(temp);
            }
            konektor.close();
            stat.close();
            rows.close();
            return result;
        } catch (SQLException ex) {
                System.out.println("ERR_QPROVINSI_GETPROVINSI: "+ex);
                JOptionPane.showMessageDialog(null, "Gagal mendapatkan Provinsi! (ERR_QPROVINSI_GETPROVINSI)");
            return null;
        }
    }
    
        public ArrayList<Vector> getProvinsi(String idProvinsi){
        
        ArrayList<Vector> result = new ArrayList<>();
        try {
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT * FROM ms_provinsi WHERE id = '"+idProvinsi+"' AND flag_active='1'";
            ResultSet rows = stat.executeQuery(Query);
            while(rows.next()){
                Vector temp = new Vector();
                temp.add(rows.getString("provinsi"));
                temp.add(rows.getString("id"));
                result.add(temp);
            }
            konektor.close();
            stat.close();
            rows.close();
            return result;
        } catch (SQLException ex) {
                System.out.println("ERR_QPROVINSI_GETPROVINSI_PARAM_IDPROVINSI: "+ex);
                JOptionPane.showMessageDialog(null, "Gagal mendapatkan Provinsi! (ERR_QPROVINSI_GETPROVINSI_PARAM_IDPROVINSI)");
            return null;
        }
    }
       
        
        public ArrayList<Vector> getProvinsiMe(String idProvinsi){
        
        ArrayList<Vector> result = new ArrayList<>();
        try {
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT * FROM ms_provinsi WHERE id = '"+idProvinsi+"' AND flag_active='1'";
            ResultSet rows = stat.executeQuery(Query);
            while(rows.next()){
                Vector temp = new Vector();
                temp.add(rows.getString("provinsi"));
                temp.add(rows.getString("id"));
                result.add(temp);
            }
            konektor.close();
            stat.close();
            rows.close();
            return result;
        } catch (SQLException ex) {
                System.out.println("ERR_QPROVINSI_GETPROVINSIME: "+ex);
                JOptionPane.showMessageDialog(null, "Gagal mendapatkan Provinsi! (ERR_QPROVINSI_GETPROVINSIME)");
            return null;
        }
    }
        
        public ArrayList<Vector> searchProvinsi(String keyword){
        
        ArrayList<Vector> result = new ArrayList<>();
        try {
            Connection konektor = kon.Koneksi();  
            Statement stat = konektor.createStatement();
            String Query = "SELECT * FROM ms_provinsi WHERE flag_active='1' AND provinsi LIKE '%"+keyword+"%'";
            ResultSet rows = stat.executeQuery(Query);
            while(rows.next()){
                Vector temp = new Vector();
                temp.add(rows.getString("provinsi"));
                temp.add(rows.getString("id"));
                result.add(temp);
            }
            konektor.close();
            stat.close();
            rows.close();
            return result;
        } catch (SQLException ex) {
                System.out.println("ERR_QPROVINSI_SEARCHPROVINSI: "+ex);
                JOptionPane.showMessageDialog(null, "Gagal mencari Provinsi! (ERR_QPROVINSI_SEARCHPROVINSI)");
            return null;
        }
    }
    

    
 
}
