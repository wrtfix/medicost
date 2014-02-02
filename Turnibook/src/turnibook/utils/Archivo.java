/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turnibook.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author wrtfix
 */
public class Archivo {
    
     private String path = null;
     protected final Properties properties;
     public Archivo(){
         this.properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream("../resources/configuration.properties"));
            path = properties.getProperty("file.path");
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }
     
     public void crearTxt(String texto,String nombre){
           File f;
           f = new File(nombre);
           //Escritura
            try{
                FileWriter w = new FileWriter(path+f);
                BufferedWriter bw = new BufferedWriter(w);
                PrintWriter wr = new PrintWriter(bw);  
                wr.write(texto);//escribimos en el archivo
                //ahora cerramos los flujos de canales de datos, al cerrarlos el archivo quedará guardado con información escrita
                //de no hacerlo no se escribirá nada en el archivo
                wr.close();
                bw.close();
            }catch(IOException e){};
      }
     
     public String leerTxt(String nombre){
                       
            File f = new File(path+nombre);
            BufferedReader entrada;
            String r = "";
            try {
                entrada = new BufferedReader( new FileReader( f ) );
                String linea;
                while(entrada.ready()){
                    linea = entrada.readLine();
                    r=r+linea;
                }
            }catch (IOException e) {
            }
            return r;
    }

}
