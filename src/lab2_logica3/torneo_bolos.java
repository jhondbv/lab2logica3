/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_logica3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Ricardo Roldan Smirnov
 */
public class torneo_bolos {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        
             /*   int numLineas=500;
                int contador=0;
                
                String ruta_archivo = "./src/lab2_logica3/puntajes_bolos.txt";
               
                String datos []=new String [numLineas];

                BufferedReader reader = new BufferedReader(new FileReader(ruta_archivo));
                String linea = reader.readLine();

                while (linea != null)
                {
                   datos[contador]=linea;
                   linea = reader.readLine();
                   contador++;
                }       
                
                System.out.print( "datos[2] == " + datos[2] + "\n\n\n" ); 
                
        //leer un TXT
        
        archivos a = new archivos();
        String s1 = a.leerTxt(ruta_archivo);*/
             String ruta_archivo = "./src/lab2_logica3/puntajes_bolos.txt";
        List<Deportista> dp = new archivos().CrearDeportistas(ruta_archivo);
        abb arbol = new abb();
        for (Deportista item : dp) {
            arbol.insertar(item);
        }
        
        arbol.inOrder();
     
        
        
        
        /*System.out.println("archivo completo == " + s1); 
        System.out.print( "\n\n\n" );*/
    }
    
}
