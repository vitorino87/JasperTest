/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaspertest;
import java.util.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.*;
/**
 *
 * @author tiago.lucas
 */
public class JasperTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String fileName = "test.jasper";
        String outFileName = "test.pdf";
        HashMap hm = new HashMap();
        
        try{
            JasperPrint print = JasperFillManager.fillReport(fileName, hm, new JREmptyDataSource());
            JRExporter exporter =  new net.sf.jasperreports.engine.export.JRPdfExporter();
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, outFileName);
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
            exporter.exportReport();
            System.out.println("Created file: "+outFileName);
        }catch(JRException e){
            e.printStackTrace();
            System.exit(1);
        }
        catch(Exception e){
            e.printStackTrace();
            System.exit(1);
        }                
    }    
}
