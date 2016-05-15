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
        private int dato;
 
        private void nodoArbol(){
            ld = null;
            li = null;
            dato = 0;
        }
    }
 
    public nodoArbol raiz;
 
    public void abb(){
        nodoArbol raiz = new nodoArbol();
    }
 
    public boolean esVacio(){
        return (raiz == null);
    }
 
    public void insertar(int a){
        if (esVacio()) {
            nodoArbol nuevo = new nodoArbol();
            nuevo.dato = a;
            nuevo.ld = new abb();
            nuevo.li = new abb();
            raiz = nuevo;
        }
        else {
            if (a > raiz.dato) {
                (raiz.ld).insertar(a);
            }
            if (a < raiz.dato){
                (raiz.li).insertar(a);
            }
        }
    }
 
    public void preOrder(){
        if (!esVacio()) {
            System.out.print( raiz.dato + ", "  );
            raiz.li.preOrder();
            raiz.ld.preOrder();
        }
    }
 
    public void inOrder(){
        if (!esVacio()) {
            raiz.li.inOrder();
            System.out.print( raiz.dato + ", "  );
            raiz.ld.inOrder();
        }
    }
 
    public void posOrder(){
        if (!esVacio()) {
            raiz.ld.posOrder();
            raiz.li.posOrder();
            System.out.print( raiz.dato + ", "  );
 
        }
    }
 
    public abb buscar(int a){
        abb arbolito = null;
        if (!esVacio()) {
            if (a == raiz.dato) {
            return this;
            }
            else {
                if (a < raiz.dato) {
                    arbolito = raiz.li.buscar(a);
                }
                else {
                    arbolito = raiz.ld.buscar(a);
                }
            }
        }
        return arbolito;
    }
 
    public boolean existe(int a){
    if (!esVacio()) {
            if (a == raiz.dato) {
            return true;
            }
            else {
                if (a < raiz.dato) {
                    raiz.li.existe(a);
                }
                else {
                    raiz.ld.existe(a);
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
 
    public int buscarMin() {
        abb arbolActual = this;
        while( !arbolActual.raiz.li.esVacio() ) {
            arbolActual = arbolActual.raiz.li;
        }
        int devuelvo= arbolActual.raiz.dato;
        arbolActual.raiz=null;
        return devuelvo;
    }
 
    public int buscarMan() {
        abb arbolActual = this;
        while( !arbolActual.raiz.ld.esVacio() ) {
            arbolActual = arbolActual.raiz.ld;
        }
        int devuelvo= arbolActual.raiz.dato;
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
 
    public void eliminar(int a) {
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