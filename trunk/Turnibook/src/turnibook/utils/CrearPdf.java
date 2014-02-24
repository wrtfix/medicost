/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turnibook.utils;


import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;


/**
 *
 * @author Juli
 */
public class CrearPdf {
     
    private static int OS = 4;
    private static int NOMBRE = 1;
    private static int HORA = 0;
    
    private String dir;
    // Se crea el documento
    private Document documento;
    // Se crea el OutputStream para el fichero donde queremos dejar el pdf.
    private FileOutputStream ficheroPdf;

    public CrearPdf(String nombre, JTable agendaTabla) {
        try {
            documento = new Document(PageSize.A4, 50, 50, 50, 50);
            
            Properties properties = new Properties();
            FileInputStream file;
            String path = "C:\\configuration.properties";
            file = new FileInputStream(path);
            
            properties.load(file);
            
            dir = properties.getProperty("file.path");
            
            ficheroPdf = new FileOutputStream(dir+nombre+".pdf");
            // Se asocia el documento al OutputStream y se indica que el espaciado entre
            // lineas sera de 20. Esta llamada debe hacerse antes de abrir el documento
            PdfWriter.getInstance(documento, ficheroPdf);
            // Se abre el documento.
            
            documento.open();
            
            // Agregar a la tabla
            int max = agendaTabla.getRowCount();
            PdfPTable tabla = new PdfPTable(4);
            float[] medidaCeldas = {0.50f, 1.70f, 0.80f, 2.00f};
            tabla.setWidths(medidaCeldas);
            
            tabla.addCell("Hora");
            tabla.addCell("Nombre");          
            tabla.addCell("Obra Social");
            tabla.addCell("Descripción");
            
            for (int i = 0; i <max; i++)
            {            
                if (agendaTabla.getValueAt(i, 2) != null){
                     tabla.addCell(agendaTabla.getValueAt(i,HORA).toString());
                     tabla.addCell(agendaTabla.getValueAt(i,NOMBRE).toString());
                     tabla.addCell(agendaTabla.getValueAt(i,OS)!=null ?agendaTabla.getValueAt(i,OS).toString():"");
                     tabla.addCell(""); 
                }             
            }
            
            documento.add(new Paragraph("Tunibook", FontFactory.getFont("arial",22,Font.ITALIC,Color.RED)));             
            documento.add(new Paragraph("La agenda de los profesionales"));
            documento.add(new Paragraph(" "));
            documento.add(tabla);
            Paragraph p = new Paragraph("Desarrollado por J20 - catactenos via mail a wrtfix@gmail.com", FontFactory.getFont("arial",9,Font.ITALIC,Color.DARK_GRAY));
            p.setAlignment(Element.ALIGN_CENTER);
            documento.add(p);

           

            documento.close();
            ejecutarElemnto(dir+nombre+".pdf");
            
        } catch (IOException ex) {
            Logger.getLogger(CrearPdf.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(CrearPdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     private void ejecutarElemnto(String ruta){
      try {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                    if (desktop.isSupported(Desktop.Action.BROWSE))
                    {
                        desktop.open(new File(ruta));
                    }
                }
            } catch (Exception e) {
            e.printStackTrace();
            }
    }
 
}
