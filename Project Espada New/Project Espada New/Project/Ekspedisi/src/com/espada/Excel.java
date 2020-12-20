package com.espada;

import java.io.File;    
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Excel {
    
    public String inputFile;
    
public void getTemplate(File source, File dest) throws IOException {
    InputStream is = null;
    OutputStream os = null;
    try {
        is = new FileInputStream(source);
        os = new FileOutputStream(dest);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = is.read(buffer)) > 0) {
            os.write(buffer, 0, length);
        }
    } finally {
        is.close();
        os.close();
    }
}
        
public void toExcel(JTable table, File file){
    try{
        TableModel model = table.getModel();
        FileWriter excel = new FileWriter(file);

        for(int i = 0; i < model.getColumnCount(); i++){
            excel.write(model.getColumnName(i) + "\t");
        }

        excel.write("\n");

        for(int i=0; i< model.getRowCount(); i++) {
            for(int j=0; j < model.getColumnCount(); j++) {
                excel.write(model.getValueAt(i,j).toString()+"\t");
            }
            excel.write("\n");
        }

        excel.close();

    }catch(IOException e){ System.out.println(e); }
}

public String[][] fromExcel() throws IOException{
 File inputWorkbook = new File(inputFile);
                Workbook w;
                try {
                        w = Workbook.getWorkbook(inputWorkbook);
                        // Get the first sheet
                        Sheet sheet = w.getSheet(0);
                        String[][] hasil = new String[sheet.getRows()][sheet.getColumns()];
                        // Loop over first 10 column and lines
                        
                        for (int j = 0; j < sheet.getRows(); j++) {
                            
                                for (int i = 0; i < sheet.getColumns(); i++) {
                                        Cell cell = sheet.getCell(i, j);
                                        CellType type = cell.getType();
                                        
                                        //MASUKAN KEDALAM ARRAY
                                        hasil[j][i]=(String)cell.getContents();
                                        
                                        
                                        if (type == CellType.LABEL) {
                                                //UNTUK LABEL
                                                //System.out.println("I got a label "+ cell.getContents());
                                        }

                                        if (type == CellType.NUMBER) {
                                                //UNTUK NUMBER
                                                //System.out.println("I got a number "+ cell.getContents());
                                        }

                                }
                        }
                        return hasil;
                } catch (BiffException e) {
                        JOptionPane.showMessageDialog(null, "Gagal Import");
                        System.out.println(e);
                        return null;
                }
}


}
