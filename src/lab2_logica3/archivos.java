package lab2_logica3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
                objDeportista.setCedula(Integer.parseInt(datos[3]));
                objDeportista.setEmail(datos[4]);
                objDeportista.setPuntaje(Double.parseDouble(datos[5]));
                lstDeportista.add(objDeportista);
            }

        } catch (Exception e) {
            System.err.println("No se encontro archivo");
        }

        return lstDeportista;

    }

}
