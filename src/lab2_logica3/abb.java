/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_logica3;

/**
 *
 * @author Ricardo
 */
public class abb {
 
    private class nodoArbol {
        private abb ld;
        private abb li;
        private Deportista dato;
 
        private void nodoArbol(){
            ld = null;
            li = null;
            dato = null;
        }
    }
 
    public nodoArbol raiz;
 
    public void abb(){
        nodoArbol raiz = new nodoArbol();
    }
 
    public boolean esVacio(){
        return (raiz == null);
    }
 
    public void insertar(Deportista deportista){
        if (esVacio()) {
            nodoArbol nuevo = new nodoArbol();
            nuevo.dato = deportista;
            nuevo.ld = new abb();
            nuevo.li = new abb();
            raiz = nuevo;
        }
        else {
            if (deportista.getCedula() > raiz.dato.getCedula()) {
                (raiz.ld).insertar(deportista);
            }
            if (deportista.getCedula() < raiz.dato.getCedula()){
                (raiz.li).insertar(deportista);
            }
        }
    }
 
    public void preOrder(){
        if (!esVacio()) {
            System.out.print( raiz.dato.getCedula() + ", "  );
            raiz.li.preOrder();
            raiz.ld.preOrder();
        }
    }
 
    public void inOrder(){
        if (!esVacio()) {
            raiz.li.inOrder();
            System.out.print( raiz.dato.getCedula() + ", "  );
            raiz.ld.inOrder();
        }
    }
 
    public void posOrder(){
        if (!esVacio()) {
            raiz.ld.posOrder();
            raiz.li.posOrder();
            System.out.print( raiz.dato.getCedula() + ", "  );
 
        }
    }
 
    public abb buscar(Deportista deportista){
        abb arbolito = null;
        if (!esVacio()) {
            if (deportista.getCedula() == raiz.dato.getCedula()) {
            return this;
            }
            else {
                if (deportista.getCedula() < raiz.dato.getCedula()) {
                    arbolito = raiz.li.buscar(deportista);
                }
                else {
                    arbolito = raiz.ld.buscar(deportista);
                }
            }
        }
        return arbolito;
    }
 
    public boolean existe(Deportista deportista){
    if (!esVacio()) {
            if (deportista.getCedula() == raiz.dato.getCedula()) {
            return true;
            }
            else {
                if (deportista.getCedula() < raiz.dato.getCedula()) {
                    raiz.li.existe(deportista);
                }
                else {
                    raiz.ld.existe(deportista);
                }
            }
        }
        return false;
    }
 
    public int cantidad(){
        if (esVacio()) {
            return 0;
        }
        else {
            return (1 + raiz.ld.cantidad() + raiz.li.cantidad());
        }
    }
 
    public int altura() {
        if (esVacio()) {
            return 0;
        }
        else {
            return (1 + Math.max(((raiz.li).altura()), ((raiz.ld).altura())));
        }
    }
 
    public Deportista buscarMin() {
        abb arbolActual = this;
        while( !arbolActual.raiz.li.esVacio() ) {
            arbolActual = arbolActual.raiz.li;
        }
        Deportista devuelvo = arbolActual.raiz.dato;
        arbolActual.raiz=null;
        return devuelvo;
    }
 
    public Deportista buscarMax() {
        abb arbolActual = this;
        while( !arbolActual.raiz.ld.esVacio() ) {
            arbolActual = arbolActual.raiz.ld;
        }
        Deportista devuelvo= arbolActual.raiz.dato;
            arbolActual.raiz=null;
        return devuelvo;
    }
 
    public boolean esHoja() {
        boolean hoja = false;
        if( (raiz.li).esVacio() && (raiz.ld).esVacio() ) {
            hoja = true;
        }
        return hoja;
    }
 
    public void eliminar(Deportista a) {
        abb paraEliminar = buscar(a);
        if (!paraEliminar.esVacio()) {
            if (paraEliminar.esHoja()) {
                paraEliminar.raiz = null;
            }
            else {
                if (!paraEliminar.raiz.li.esVacio() && !paraEliminar.raiz.ld.esVacio()) {
                    paraEliminar.raiz.dato = paraEliminar.raiz.ld.buscarMin();
                }
                else {
                    if (paraEliminar.raiz.li.esVacio()) {
                        paraEliminar.raiz = paraEliminar.raiz.ld.raiz;
                    }else{
                        paraEliminar.raiz = paraEliminar.raiz.li.raiz;
                    }
                }
            }
        }
    }
}