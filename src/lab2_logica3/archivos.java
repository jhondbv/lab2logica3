package lab2_logica3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class archivos {

    public String leerTxt(String direccion) { //direccion del archivo

        String texto = "";

        try {
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            while ((bfRead = bf.readLine()) != null) {
                //haz el ciclo, mientras bfRead tiene datos
                temp = temp + bfRead; //guardado el texto del archivo
            }

            texto = temp;

        } catch (Exception e) {
            System.err.println("No se encontro archivo");
        }

        return texto;

    }

  
         Vector <Double> puntajes = new Vector <Double>();  //vectores usados para hallar los puntajes mayores
         Vector <Long> cedulas = new Vector <Long>();       
         Vector <String> nombres = new Vector <String>();
         Vector <String> apellidos = new Vector <String>();
  /**
     * Crea los objetos deportistas a partir de un archivo de texto
     * @param direccion ruta del archivo de texto 
     * @return Lista de deportistas 
     */
    public List<Deportista> CrearDeportistas(String direccion) {
        
        List<Deportista> lstDeportista = new ArrayList<Deportista>();

        try {
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;

            while ((bfRead = bf.readLine()) != null) {

                temp = bfRead; //guardado el texto del archivo
                String[] datos = temp.split(";");
                
                Deportista objDeportista = new Deportista();
                objDeportista.setPrimerApellido(datos[0]);
                objDeportista.setSegundoApellido(datos[1]);
                objDeportista.setNombre(datos[2]);
                objDeportista.setCedula(Long.parseLong(datos[3]));
                objDeportista.setEmail(datos[4]);
                objDeportista.setPuntaje(Double.parseDouble(datos[5]));
                puntajes.add(Double.parseDouble(datos[5]));
                cedulas.add(Long.parseLong(datos[3]));
                nombres.add(datos[2]);
                apellidos.add(datos[0]);
                
                lstDeportista.add(objDeportista); //agrega lodos los objetos Deportista a un lista
               
            }       
        
                                      
        } catch (Exception e) {
            System.err.println("Error consultando los datos de los deportistas");
        }
        return lstDeportista;

    }
    
    /**
     * muestra el/los deportistas con mayor puntaje.
     * @param direc 
     */
      public void mostrarMayor(String direc) //metodo que muestra el/los deportistas con mayor puntaje.
      {
           CrearDeportistas(direc);
           double resultado = puntajes.elementAt(0);
           Long cedulaResul = null;
           String nom   = " ";
           String ape   = " ";
           
             for(int i=0; i<puntajes.size(); i++) 
                    { 
               if(puntajes.elementAt(i) > resultado) 
                { 
                resultado = puntajes.elementAt(i);            
                } 
                }
             double resul = resultado;
             System.out.println("MAYOR PUNTAJE: "+resultado+"\n");
             int j=0;
               while( j<puntajes.size()) 
                    { 
                 if(resul == puntajes.elementAt(j))
               {
                           cedulaResul = cedulas.elementAt(j);
                           nom = nombres.elementAt(j);
                           ape = apellidos.elementAt(j);
                          System.out.println("==> " + nom +" "+ape+" con Cédula " + cedulaResul);
                         
               }  j++;
                    }  
      }
    
}
