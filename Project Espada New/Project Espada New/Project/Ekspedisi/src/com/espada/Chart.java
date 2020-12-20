package com.espada;

import com.espada.model.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class Chart {
    
    qPengiriman pengiriman = new qPengiriman();
    qKecamatan kecamatan = new qKecamatan();
    qKabupaten kabupaten = new qKabupaten();
    qProvinsi provinsi = new qProvinsi();
    qLayanan layanan = new qLayanan();
    qKurir kurir = new qKurir();
    
    public ChartFrame chartBarTest(){
       DefaultCategoryDataset bar = new DefaultCategoryDataset();

       bar.addValue((Integer)bar.getValue( "Marks", "Student1")+40, "Marks", "Student1");
       
       
       bar.setValue(90, "Zuck", "Student2");
       bar.setValue(70, "Nyanyang", "Student2");
       bar.setValue(60, "Vincent", "Student3");
       JFreeChart chart = ChartFactory.createBarChart("Student Score", "Student Name", "Marks", bar, PlotOrientation.VERTICAL, false, true, false);
       ChartFrame frame = new ChartFrame("Persentase Verifikasi Pengiriman", chart);
       return frame;
    }
    
    public ChartFrame chartLineTest(){
       DefaultCategoryDataset line = new DefaultCategoryDataset();
       
       for(int i=0;i<pengiriman.getPengirimanDistinctKecamatanPengirim().size();i++){
           
        }
       
       line.setValue(80, "schools", "1970");
       line.setValue(90, "schools", "1980");
       line.setValue(70, "schools", "1990");
       line.setValue(60, "schools", "2000");
       JFreeChart chart = ChartFactory.createLineChart("Student Score", "Student Name", "Marks", line, PlotOrientation.VERTICAL, false, true, false);
       ChartFrame frame = new ChartFrame("Persentase Verifikasi Pengiriman", chart);
       return frame;
    }
    
    private String bulan(String angkaBulan){
        String namaBulan="";
     if(angkaBulan.equals("01")){
                namaBulan="Januari";
            }else if(angkaBulan.equals("02")){
                namaBulan="Febuari";
            }else if(angkaBulan.equals("03")){
                namaBulan="Maret";
            }else if(angkaBulan.equals("04")){
                namaBulan="April";
            }else if(angkaBulan.equals("05")){
                namaBulan="Mei";
            }else if(angkaBulan.equals("06")){
                namaBulan="Juni";
            }else if(angkaBulan.equals("07")){
                namaBulan="Juli";
            }else if(angkaBulan.equals("08")){
                namaBulan="Agustus";
            }else if(angkaBulan.equals("09")){
                namaBulan="September";
            }else if(angkaBulan.equals("10")){
                namaBulan="Oktober";
            }else if(angkaBulan.equals("11")){
                namaBulan="November";
            }else if(angkaBulan.equals("12")){
                namaBulan="Desember";
            }   
     return namaBulan;
    }
    
    public ChartFrame chartLinePengiriman(){
        DefaultCategoryDataset line = new DefaultCategoryDataset();
        String checkTgl="";
        int tempCounter=0;
        for(int i=0;i<pengiriman.getPengiriman().size();i++){
            String tempTgl = (String)pengiriman.getPengirimanOrderByTglKirim().get(i).get(7);
            String tempTahun = tempTgl.substring(0,4);
            String tempBulan = tempTgl.substring(5,7);
            
            String namaBulan=this.bulan(tempBulan);
            
            if(!checkTgl.equals(tempTahun+"-"+tempBulan)){
                if(i!=0){
                if(tempCounter!=1){
                    tempCounter--;
                }
                String temptempTahun = checkTgl.substring(0,4);
                String temptempBulan = checkTgl.substring(5,7);
                line.setValue(tempCounter, temptempTahun, this.bulan(temptempBulan)+" "+temptempTahun);
                //System.out.println(tempCounter+"@"+temptempTahun+"-"+this.bulan(temptempBulan));
                }
                checkTgl=tempTahun+"-"+tempBulan;
                tempCounter=1;
            }else{
                tempCounter=tempCounter+1;
            }
            
            if(i==pengiriman.getPengiriman().size()-1){
                line.setValue(tempCounter,tempTahun, namaBulan+" "+tempTahun);
                //System.out.println(tempCounter+"@"+tempTahun+"-"+namaBulan);
            }
            
        }
        JFreeChart chart = ChartFactory.createLineChart("Grafik Pengiriman", "Waktu", "Jumlah Pengiriman", line, PlotOrientation.VERTICAL, false, true, false);
       ChartFrame frame = new ChartFrame("Persentase Verifikasi Pengiriman", chart);
       return frame;
    }
    
    public ChartFrame chartBarKecamatanPenerima(){
        DefaultCategoryDataset bar  =new DefaultCategoryDataset();
        
        float CURRENT_kecamatan[] = new float[pengiriman.getPengirimanDistinctKecamatanPenerima().size()];
        String EXIST_kecamatan[]= new String[pengiriman.getPengirimanDistinctKecamatanPenerima().size()];
        
        for(int j=0;j<CURRENT_kecamatan.length;j++){
                CURRENT_kecamatan[j]=0;
        }
        
        for(int i=0;i<pengiriman.getPengirimanDistinctKecamatanPenerima().size();i++){
            EXIST_kecamatan[i]=(String)pengiriman.getPengirimanDistinctKecamatanPenerima().get(i).get(0);
        }
        
        
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
            String kecPenerima = (String)kecamatan.getKecamatanMe(idKecPenerima).get(0).get(1);
            String myLayanan = (String)layanan.getLayananbyKode(kodeLayanan).get(0).get(2);
            String myKurir = (String) kurir.getKurir(idKurir).get(0).get(1);
            
            for(int j=0;j<EXIST_kecamatan.length;j++){
                if(EXIST_kecamatan[j].equals(idKecPenerima)){
                    CURRENT_kecamatan[j]=CURRENT_kecamatan[j]+1;
                }
            }
            
            
            
            
            for(int j=0;j<pengiriman.getBarang(idPengiriman).size();j++){
            }
            
            
        }
        
        for(int j=0;j<EXIST_kecamatan.length;j++){
            String namaKecamatan = (String) kecamatan.getKecamatanMe(EXIST_kecamatan[j]).get(0).get(2);
            bar.setValue(CURRENT_kecamatan[j], namaKecamatan, "Kecamatan");        
        }
        JFreeChart chart = ChartFactory.createBarChart("Pengiriman ke Kecamatan Tujuan", "Nama Kecamatan", "Jumlah Pengiriman", bar, PlotOrientation.VERTICAL, false, true, false);
        
        
        ChartFrame frame = new ChartFrame("Persentase Kecamatan Pengiriman", chart);
        
        return frame;
    }
    
    public ChartFrame chartBarKecamatanPengirim(){
        DefaultCategoryDataset bar  =new DefaultCategoryDataset();
        
        float CURRENT_kecamatan[] = new float[pengiriman.getPengirimanDistinctKecamatanPengirim().size()];
        String EXIST_kecamatan[]= new String[pengiriman.getPengirimanDistinctKecamatanPengirim().size()];
        
        for(int j=0;j<CURRENT_kecamatan.length;j++){
                CURRENT_kecamatan[j]=0;
        }
        
        for(int i=0;i<pengiriman.getPengirimanDistinctKecamatanPengirim().size();i++){
            EXIST_kecamatan[i]=(String)pengiriman.getPengirimanDistinctKecamatanPengirim().get(i).get(0);
        }
        
        
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
            String kecPenerima = (String)kecamatan.getKecamatanMe(idKecPenerima).get(0).get(1);
            String myLayanan = (String)layanan.getLayananbyKode(kodeLayanan).get(0).get(2);
            String myKurir = (String) kurir.getKurir(idKurir).get(0).get(1);
            
            for(int j=0;j<EXIST_kecamatan.length;j++){
                if(EXIST_kecamatan[j].equals(idKecPengirim)){
                    CURRENT_kecamatan[j]=CURRENT_kecamatan[j]+1;
                }
            }
            
            
            
            
            for(int j=0;j<pengiriman.getBarang(idPengiriman).size();j++){
            }
            
            
        }
        
        for(int j=0;j<EXIST_kecamatan.length;j++){
            String namaKecamatan = (String) kecamatan.getKecamatanMe(EXIST_kecamatan[j]).get(0).get(2);
            bar.setValue(CURRENT_kecamatan[j], namaKecamatan, "Kecamatan");        
        }
        JFreeChart chart = ChartFactory.createBarChart("Pengiriman dari Kecamatan Asal", "Nama Kecamatan", "Jumlah Pengiriman", bar, PlotOrientation.VERTICAL, false, true, false);
        
        
        ChartFrame frame = new ChartFrame("Persentase Kecamatan Pengiriman", chart);
        
        return frame;
    }
    
    public ChartFrame chartPieVerifikasi(){
        DefaultPieDataset pie  =new DefaultPieDataset();
        float YES_verifikasi=0;
        float NO_verifikasi=0;
        float TOT_verifikasi=0;
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
            String kecPenerima = (String)kecamatan.getKecamatanMe(idKecPenerima).get(0).get(1);
            String myLayanan = (String)layanan.getLayananbyKode(kodeLayanan).get(0).get(2);
            String myKurir = (String) kurir.getKurir(idKurir).get(0).get(1);
            
            
            if(verifikasi.equals("1")){
                YES_verifikasi++;
            }
            
            if(verifikasi.equals("0")){
                NO_verifikasi++;
            }
            
            
            for(int j=0;j<pengiriman.getBarang(idPengiriman).size();j++){
            }
            
            
        }
        TOT_verifikasi = YES_verifikasi + NO_verifikasi;
        
        pie.setValue("Belum Terverifikasi",NO_verifikasi);
        pie.setValue("Terverifikasi",YES_verifikasi);
        //pie.setValue("Terverifikasi",YES_verifikasi/TOT_verifikasi*100);
        //pie.setValue("Belum Terverifikasi",NO_verifikasi/TOT_verifikasi*100);
        JFreeChart chart = ChartFactory.createPieChart("Persentase Verifikasi Pengiriman", pie, true, true, true);
        PiePlot P = (PiePlot) chart.getPlot();
        
        ChartFrame frame = new ChartFrame("Persentase Verifikasi Pengiriman", chart);
        
        return frame;
    }
    
    public ChartFrame chartPieLayanan(){
        DefaultPieDataset pie  =new DefaultPieDataset();
        float TOT_layanan=0;
        float CURRENT_layanan[] = new float[pengiriman.getPengirimanDistinctLayanan().size()];
        String EXIST_layanan[]= new String[pengiriman.getPengirimanDistinctLayanan().size()];
        
        for(int j=0;j<CURRENT_layanan.length;j++){
                CURRENT_layanan[j]=0;
        }
        
        for(int i=0;i<pengiriman.getPengirimanDistinctLayanan().size();i++){
            EXIST_layanan[i]=(String)pengiriman.getPengirimanDistinctLayanan().get(i).get(0);
        }
        
        
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
            String kecPenerima = (String)kecamatan.getKecamatanMe(idKecPenerima).get(0).get(1);
            String myLayanan = (String)layanan.getLayananbyKode(kodeLayanan).get(0).get(2);
            String myKurir = (String) kurir.getKurir(idKurir).get(0).get(1);
            
            for(int j=0;j<EXIST_layanan.length;j++){
                if(EXIST_layanan[j].equals(kodeLayanan)){
                    CURRENT_layanan[j]=CURRENT_layanan[j]+1;
                }
            }
            TOT_layanan++;
            
            
            
            for(int j=0;j<pengiriman.getBarang(idPengiriman).size();j++){
            }
            
            
        }
        
        for(int j=0;j<EXIST_layanan.length;j++){
        pie.setValue(EXIST_layanan[j],CURRENT_layanan[j]);        
        }
        JFreeChart chart = ChartFactory.createPieChart("Persentase Verifikasi Pengiriman", pie, true, true, true);
        PiePlot P = (PiePlot) chart.getPlot();
        
        ChartFrame frame = new ChartFrame("Persentase Verifikasi Pengiriman", chart);
        
        return frame;
    }
     
    public ChartFrame chartPieKurir(){
        DefaultPieDataset pie  =new DefaultPieDataset();
        float TOT_kurir=0;
        float CURRENT_kurir[] = new float[pengiriman.getPengirimanDistinctKurir().size()];
        String EXIST_kurir[]= new String[pengiriman.getPengirimanDistinctKurir().size()];
        
        for(int j=0;j<CURRENT_kurir.length;j++){
                CURRENT_kurir[j]=0;
        }
        
        for(int i=0;i<pengiriman.getPengirimanDistinctKurir().size();i++){
            EXIST_kurir[i]=(String)pengiriman.getPengirimanDistinctKurir().get(i).get(0);
        }
        
        
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
            String kecPenerima = (String)kecamatan.getKecamatanMe(idKecPenerima).get(0).get(1);
            String myLayanan = (String)layanan.getLayananbyKode(kodeLayanan).get(0).get(2);
            String myKurir = (String) kurir.getKurir(idKurir).get(0).get(1);
            
            for(int j=0;j<EXIST_kurir.length;j++){
                if(EXIST_kurir[j].equals(idKurir)){
                    CURRENT_kurir[j]=CURRENT_kurir[j]+1;
                }
            }
            TOT_kurir++;
            
            
            
            for(int j=0;j<pengiriman.getBarang(idPengiriman).size();j++){
            }
            
            
        }
        
        for(int j=0;j<EXIST_kurir.length;j++){
            String namaKurir = (String) kurir.getKurir(EXIST_kurir[j]).get(0).get(1);
            pie.setValue(namaKurir,CURRENT_kurir[j]);        
        }
        JFreeChart chart = ChartFactory.createPieChart("Persentase Verifikasi Pengiriman", pie, true, true, true);
        PiePlot P = (PiePlot) chart.getPlot();
        
        ChartFrame frame = new ChartFrame("Persentase Verifikasi Pengiriman", chart);
        
        return frame;
    }
    
     public ChartFrame chartBarKotaPengirim(){
        DefaultCategoryDataset bar  =new DefaultCategoryDataset();
        
        
        List<String> DISTINCT_kota = new ArrayList<String>();
        List<Integer> VALUE_kota = new ArrayList<Integer>();
        String EXIST_kota[]= new String[pengiriman.getPengiriman().size()];
        
        for(int i=0;i<pengiriman.getPengiriman().size();i++){
            String idKota = (String) kecamatan.getKecamatanMe((String)pengiriman.getPengiriman().get(i).get(3)).get(0).get(1);
            EXIST_kota[i]=(String) kabupaten.getKotaMe(idKota).get(0).get(0);
        }
        
        for(int i=0;i<pengiriman.getPengiriman().size();i++){
            if(DISTINCT_kota.isEmpty()){
                DISTINCT_kota.add(EXIST_kota[i]);
                VALUE_kota.add(1);
            }else{
                if(DISTINCT_kota.contains(EXIST_kota[i])){
                   VALUE_kota.set(DISTINCT_kota.indexOf(EXIST_kota[i]),VALUE_kota.get(DISTINCT_kota.indexOf(EXIST_kota[i]))+1);
                    
                }else{
                   DISTINCT_kota.add(EXIST_kota[i]);
                   VALUE_kota.add(1);
                }
            }
        }
       
        
        for(int j=0;j<DISTINCT_kota.size();j++){
            String namaKota = (String) kabupaten.getKotaMe(DISTINCT_kota.get(j)).get(0).get(2);
            bar.setValue(VALUE_kota.get(j), namaKota, "Kabupaten / Kota");        
        }
        
        JFreeChart chart = ChartFactory.createBarChart("Pengiriman dari Kabupaten Asal", "Nama Kabupaten", "Jumlah Pengiriman", bar, PlotOrientation.VERTICAL, false, true, false);
        
        
        ChartFrame frame = new ChartFrame("Persentase Kabupaten Pengiriman", chart);
        
        return frame;
    }
     
     public ChartFrame chartBarKotaPenerima(){
        DefaultCategoryDataset bar  =new DefaultCategoryDataset();
        
        
        List<String> DISTINCT_kota = new ArrayList<String>();
        List<Integer> VALUE_kota = new ArrayList<Integer>();
        String EXIST_kota[]= new String[pengiriman.getPengiriman().size()];
        
        for(int i=0;i<pengiriman.getPengiriman().size();i++){
            String idKota = (String) kecamatan.getKecamatanMe((String)pengiriman.getPengiriman().get(i).get(4)).get(0).get(1);
            EXIST_kota[i]=(String) kabupaten.getKotaMe(idKota).get(0).get(0);
        }
        
        for(int i=0;i<pengiriman.getPengiriman().size();i++){
            if(DISTINCT_kota.isEmpty()){
                DISTINCT_kota.add(EXIST_kota[i]);
                VALUE_kota.add(1);
            }else{
                if(DISTINCT_kota.contains(EXIST_kota[i])){
                   VALUE_kota.set(DISTINCT_kota.indexOf(EXIST_kota[i]),VALUE_kota.get(DISTINCT_kota.indexOf(EXIST_kota[i]))+1);
                    
                }else{
                   DISTINCT_kota.add(EXIST_kota[i]);
                   VALUE_kota.add(1);
                }
            }
        }
       
        
        for(int j=0;j<DISTINCT_kota.size();j++){
            String namaKota = (String) kabupaten.getKotaMe(DISTINCT_kota.get(j)).get(0).get(2);
            bar.setValue(VALUE_kota.get(j), namaKota, "Kabupaten / Kota");        
        }
        
        JFreeChart chart = ChartFactory.createBarChart("Pengiriman ke Kabupaten Tujuan", "Nama Kabupaten", "Jumlah Pengiriman", bar, PlotOrientation.VERTICAL, false, true, false);
        
        
        ChartFrame frame = new ChartFrame("Persentase Kabupaten Pengiriman", chart);
        
        return frame;
    }
     
     public ChartFrame chartBarProvinsiPenerima(){
        DefaultCategoryDataset bar  =new DefaultCategoryDataset();
        
        
        List<String> DISTINCT_provinsi = new ArrayList<String>();
        List<Integer> VALUE_provinsi = new ArrayList<Integer>();
        String EXIST_provinsi[]= new String[pengiriman.getPengiriman().size()];
        
        for(int i=0;i<pengiriman.getPengiriman().size();i++){
            String idKota = (String) kecamatan.getKecamatanMe((String)pengiriman.getPengiriman().get(i).get(4)).get(0).get(1);
            String idProvinsi = (String) kabupaten.getKotaMe(idKota).get(0).get(1);
            EXIST_provinsi[i]=idProvinsi;
        }
        
        for(int i=0;i<pengiriman.getPengiriman().size();i++){
            if(DISTINCT_provinsi.isEmpty()){
                DISTINCT_provinsi.add(EXIST_provinsi[i]);
                VALUE_provinsi.add(1);
            }else{
                if(DISTINCT_provinsi.contains(EXIST_provinsi[i])){
                   VALUE_provinsi.set(DISTINCT_provinsi.indexOf(EXIST_provinsi[i]),VALUE_provinsi.get(DISTINCT_provinsi.indexOf(EXIST_provinsi[i]))+1);
                    
                }else{
                   DISTINCT_provinsi.add(EXIST_provinsi[i]);
                   VALUE_provinsi.add(1);
                }
            }
        }
       
        
        for(int j=0;j<DISTINCT_provinsi.size();j++){
            String namaKota = (String) provinsi.getProvinsi(DISTINCT_provinsi.get(j)).get(0).get(0);
            bar.setValue(VALUE_provinsi.get(j), namaKota, "Provinsi");        
        }
        
        JFreeChart chart = ChartFactory.createBarChart("Pengiriman ke Provinsi Tujuan", "Nama Provinsi", "Jumlah Pengiriman", bar, PlotOrientation.VERTICAL, false, true, false);
        
        
        ChartFrame frame = new ChartFrame("Persentase Provinsi Pengiriman", chart);
        
        return frame;
    }
     
     public ChartFrame chartBarProvinsiPengirim(){
        DefaultCategoryDataset bar  =new DefaultCategoryDataset();
        
        
        List<String> DISTINCT_provinsi = new ArrayList<String>();
        List<Integer> VALUE_provinsi = new ArrayList<Integer>();
        String EXIST_provinsi[]= new String[pengiriman.getPengiriman().size()];
        
        for(int i=0;i<pengiriman.getPengiriman().size();i++){
            String idKota = (String) kecamatan.getKecamatanMe((String)pengiriman.getPengiriman().get(i).get(3)).get(0).get(1);
            String idProvinsi = (String) kabupaten.getKotaMe(idKota).get(0).get(1);
            EXIST_provinsi[i]=idProvinsi;
        }
        
        for(int i=0;i<pengiriman.getPengiriman().size();i++){
            if(DISTINCT_provinsi.isEmpty()){
                DISTINCT_provinsi.add(EXIST_provinsi[i]);
                VALUE_provinsi.add(1);
            }else{
                if(DISTINCT_provinsi.contains(EXIST_provinsi[i])){
                   VALUE_provinsi.set(DISTINCT_provinsi.indexOf(EXIST_provinsi[i]),VALUE_provinsi.get(DISTINCT_provinsi.indexOf(EXIST_provinsi[i]))+1);
                    
                }else{
                   DISTINCT_provinsi.add(EXIST_provinsi[i]);
                   VALUE_provinsi.add(1);
                }
            }
        }
       
        
        for(int j=0;j<DISTINCT_provinsi.size();j++){
            String namaKota = (String) provinsi.getProvinsi(DISTINCT_provinsi.get(j)).get(0).get(0);
            bar.setValue(VALUE_provinsi.get(j), namaKota, "Provinsi");        
        }
        
        JFreeChart chart = ChartFactory.createBarChart("Pengiriman ke Provinsi Tujuan", "Nama Provinsi", "Jumlah Pengiriman", bar, PlotOrientation.VERTICAL, false, true, false);
        
        
        ChartFrame frame = new ChartFrame("Persentase Provinsi Pengiriman", chart);
        
        return frame;
    }
    
}
