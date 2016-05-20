/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_logica3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class abb {

    private class nodoArbol {

        private abb ld;
        private abb li;
        private Deportista dato;

        private void nodoArbol() {
            ld = null;
            li = null;
            dato = null;
        }

    }

    public nodoArbol raiz;
    private List<Deportista> lstMaxpuntaje;

    public void abb() {
        nodoArbol raiz = new nodoArbol();
        lstMaxpuntaje = new ArrayList<Deportista>();
    }

    public boolean esVacio() { //comprueba si el arbol esta vacio
        return (raiz == null);
    }

    /**
     * inserta los objetos deportista al arbol binario de busqueda
     *
     * @param deportista
     *
     */
    public void insertar(Deportista deportista) { //metodo para insertar los objetos deportista al arbol binario de busqueda
        if (esVacio()) {
            nodoArbol nuevo = new nodoArbol();
            nuevo.dato = deportista;
            nuevo.ld = new abb();
            nuevo.li = new abb();
            raiz = nuevo;
        } else {
            if (deportista.getCedula() > raiz.dato.getCedula()) {
                (raiz.ld).insertar(deportista);
            }
            if (deportista.getCedula() < raiz.dato.getCedula()) {
                (raiz.li).insertar(deportista);
            }
        }
    }

    /**
     *
     * @param deportista
     * @return Arbol en cuya raiz se encuentra el dato qbuscado
     */
    public abb buscar(Deportista deportista) {  //encuentra el nodo donde se encuentra el deportista que busco
        abb arbolito = null;

        if (!esVacio()) {
            if (deportista.getCedula().equals(raiz.dato.getCedula())) {
                return this;
            } else if (deportista.getCedula() < raiz.dato.getCedula()) {
                arbolito = raiz.li.buscar(deportista);
            } else {
                arbolito = raiz.ld.buscar(deportista);
            }

        }

        return arbolito;
    }

    /**
     * organiza el arbol en preorder
     */
    public void preOrder() { //organiza el arbol en preorder
        if (!esVacio()) {
            System.out.print(raiz.dato.getCedula() + ", ");
            raiz.li.preOrder();
            raiz.ld.preOrder();
        }
    }

    /**
     * organiza el arbol en inorder
     */
    public void inOrder() { //organiza el arbol en inorder
        if (!esVacio()) {
            raiz.li.inOrder();
            //  System.out.print( raiz.dato.getCedula() + ", "  );
            raiz.ld.inOrder();
        }
    }

    /**
     * organiza el arbol en posorder
     */
    public void posOrder() { //organiza el arbol en posorder
        if (!esVacio()) {
            raiz.ld.posOrder();
            raiz.li.posOrder();
            System.out.print(raiz.dato.getCedula() + ", ");

        }
    }

    /**
     *
     * @param deportista
     * @return booleano que determina si el deportista existe o no.
     */
    public boolean existe(Deportista deportista) {
        if (!esVacio()) {
            if (deportista.getCedula() == raiz.dato.getCedula()) {
                return true;
            } else if (deportista.getCedula() < raiz.dato.getCedula()) {
                raiz.li.existe(deportista);
            } else {
                raiz.ld.existe(deportista);
            }
        }
        return false;
    }

    /**
     *
     * @return numero de deportistas que contiene el arbol
     */
    public int cantidad() { //regrsa el numero de deportistas que contiene el arbol
        if (esVacio()) {
            return 0;
        } else {
            return (1 + raiz.ld.cantidad() + raiz.li.cantidad());
        }
    }

    /**
     *
     * @return numero de niveles del arbol
     */
    public int altura() {
        if (esVacio()) {
            return 0;
        } else {
            return (1 + Math.max(((raiz.li).altura()), ((raiz.ld).altura())));
        }
    }

    /**
     *
     * @return deportista con el numero de cedula mas pequeno
     */
    public Deportista buscarMin() { // busca en el arbol al deportista con el numero de cedula mas pequeno
        abb arbolActual = this;
        while (!arbolActual.raiz.li.esVacio()) {
            arbolActual = arbolActual.raiz.li;
        }
        Deportista devuelvo = arbolActual.raiz.dato;
        arbolActual.raiz = null;
        return devuelvo;
    }

    /**
     *
     * @return deportista con el numero de cedula mas grande
     */
    public Deportista buscarMax() {// busca en el arbol al deportista con el numero de cedula mas grande
        abb arbolActual = this;
        while (!arbolActual.raiz.ld.esVacio()) {
            arbolActual = arbolActual.raiz.ld;
        }
        Deportista devuelvo = arbolActual.raiz.dato;
        arbolActual.raiz = null;
        return devuelvo;
    }

    /**
     *
     * @return booleano que determina si es hoja o no.
     */
    public boolean esHoja() {
        boolean hoja = false;
        if ((raiz.li).esVacio() && (raiz.ld).esVacio()) {
            hoja = true;
        }
        return hoja;
    }

    /**
     * elimina un deportista del arbol binario de busqueda
     *
     * @param a
     */
    public void eliminar(Deportista a) { //elimina un deportista del arbol binario de busqueda
        abb paraEliminar = buscar(a);
        if (!paraEliminar.esVacio()) {
            if (paraEliminar.esHoja()) {
                paraEliminar.raiz = null;
            } else if (!paraEliminar.raiz.li.esVacio() && !paraEliminar.raiz.ld.esVacio()) {
                paraEliminar.raiz.dato = paraEliminar.raiz.ld.buscarMin();
            } else if (paraEliminar.raiz.li.esVacio()) {
                paraEliminar.raiz = paraEliminar.raiz.ld.raiz;
            } else {
                paraEliminar.raiz = paraEliminar.raiz.li.raiz;
            }
        }
    }

    /**
     *
     * @return dato de tipo Deportista contenido en el arbol
     */
    public Deportista getDato() //regresa el dato de tipo Deportista
    {
        Deportista dep = new Deportista();
        dep = raiz.dato;
        return dep;
    }

    /**
     * Busca el maximo deportista usando un metodo recursivo
     * @return lista de deportistas con el puntaje maximo
     */
    public List<Deportista> buscarMaxDeportista() {
        lstMaxpuntaje = new ArrayList<Deportista>();
        searchmax(raiz);
        return lstMaxpuntaje;
    }

    /**
     * Metodo recursivo que busca el maximo puntaje en el arbol en un recorrido inorden
     * @param node nodo a evaluar 
     */
    private void searchmax(nodoArbol node) {
        if (node != null) {

            searchmax(node.li.raiz);
            
            if(lstMaxpuntaje.size()==0)
            {
            lstMaxpuntaje.add(node.dato);
            }
            else if ( node.dato.getPuntaje() > lstMaxpuntaje.get(0).getPuntaje()) {
                lstMaxpuntaje = new ArrayList<Deportista>();
                lstMaxpuntaje.add(node.dato);
            } else if (node.dato.getPuntaje() == lstMaxpuntaje.get(0).getPuntaje()) {
                lstMaxpuntaje.add(node.dato);
            }
            searchmax(node.ld.raiz);
          
        }
        
    }
    
    /**
     * Imprime en pantalla los deportistas con maximo puntaje
     * @param lst Lista de deportistas que se imprimen
     */
    public void MostrarDeportistas(List<Deportista> lst)
    {
        if(lst.size()>0)
        {
           System.out.println("\n El maximo puntaje es :  "+lst.get(0).getPuntaje());
           System.out.println(" Alcanzado por los siguientes deportistas : \n   ");
        for (Deportista item : lst) {
            System.out.println(" \n Nombre: "+item.getNombre()
                    +"\n Primer Apellido :"+ item.getPrimerApellido()
                    +"\n Segundo Apellido :"+ item.getSegundoApellido()
                    +"\n Cedula:  "+ item.getCedula()
                    +"\n");
        }
        
        }
      
    
    }
}
