/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

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

/**
 *
 * @author Juli
 */
class Archivo {
    
     public Archivo(){
     
     }
     
     public void crearTxt(String texto,String nombre){
           File f;
           f = new File(nombre);
           //Escritura
            try{
                FileWriter w = new FileWriter(f);
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
                       
            File f = new File( "C:"+nombre );
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
