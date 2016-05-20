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
import java.util.Scanner;


/**
 *
 * @author Ricardo Roldan Smirnov
 * @author Jhon David Ballesteros
 * @author Arley Hoyos Alzate
 * 
 */
public class torneo_bolos {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
             
       Scanner sc = new Scanner(System.in);
      
           
        int elec = 0;
        Long cedula = null;
        
        
        System.out.println("\n|||************|| BIENVENIDO ||************|||\n\n");
        
        String ruta_archivo = "";      //"./src/lab2_logica3/puntajes_bolos.txt";
        
            System.out.println("Por Favor digite la RUTA COMPLETA del archivo (.txt) que desea revisar: ");
            ruta_archivo  = sc.nextLine();     //pide la ruta completa del archivo incluyendo el nombre con la extension .txt
        
      
        List<Deportista> dp = new archivos().CrearDeportistas(ruta_archivo);
        abb arbol = new abb();
        for (Deportista item : dp) {
            arbol.insertar(item);
        }
        arbol.inOrder();

        System.out.println("||||||||MENU|||||||||\n 1. Mostrar la informacion de un Deportista. \n 2. Mostrar los Mayores puntajes de la lista.\n 3. Salir\n");

        while (elec != 3) {
            System.out.println("Ingrese el numero de la operacion que desea realizar: ");
            elec = sc.nextInt();
            switch (elec) {
                case 1:
                    System.out.println("Digite el Numero de Cedula del deportista que quiere consultar:");
                    cedula = sc.nextLong();
                        
                    //Codigo para buscar al deportista.
                    Deportista dep = new Deportista();
                    dep.setCedula(cedula);
                    abb depRaiz = arbol.buscar(dep);
                    System.out.println("\n Los datos del deportista son : \n Nombre: "+depRaiz.getDato().getNombre()
                    +"\n Primer Apellido :"+ depRaiz.getDato().getPrimerApellido()
                    +"\n Segundo Apellido :"+ depRaiz.getDato().getSegundoApellido()
                    +"\n Cedula:  "+ depRaiz.getDato().getCedula()
                    +"\n Puntaje: "+ depRaiz.getDato().getPuntaje()
                    +"\n");
                    break;
                case 2:
                    //Mayores puntajes
                  //archivos arc = new archivos();
                  //arc.mostrarMayor(ruta_archivo);
                    List<Deportista> dpo = arbol.buscarMaxDeportista();
                   arbol.MostrarDeportistas(dpo);
                    break;

                case 3:
                    System.err.println("Hasta la proxima.");  //salir del programa
                    break;
            }

    }
    
}
}
