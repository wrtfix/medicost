/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turnibook;


import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
    // Se crea el documento
    private Document documento;
    // Se crea el OutputStream para el fichero donde queremos dejar el pdf.
    private FileOutputStream ficheroPdf;

    public CrearPdf(String nombre, JTable agendaTabla) {
        try {
            documento = new Document();
            ficheroPdf = new FileOutputStream(nombre+".pdf");
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
                     tabla.addCell(agendaTabla.getValueAt(i,OS).toString());
                     tabla.addCell(""); 
                }             
            }
            documento.add(tabla);
            documento.close();
            ejecutarElemnto(nombre+".pdf");
            
        } catch (FileNotFoundException ex) {
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
