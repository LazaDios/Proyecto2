package Practica;

public class ArbolBinario {

    NodoArbol raiz;

    //constructor
    public ArbolBinario() {
        raiz = null;
}
    
    //metodo para insertar un nodo en el arbol
    public void agregarNodo(int d, String nom, int minIx, int minFx, String BMP) {
        NodoArbol nuevo = new NodoArbol(d, nom, minFx, minIx, BMP);
        if (raiz == null) {
            raiz = nuevo;

        } else {
            NodoArbol auxiliar = raiz;//El nodo auxiliar se va a estar apuntando a la raiz
            NodoArbol padre; // no apunta a nada == null
            while (true) {
                padre = auxiliar; //en este momento apunta a la raiz
                if (d < auxiliar.dato) { //Condicional para comparar los dos valores dia , minuto inicial
                    auxiliar = auxiliar.hijoIzquierdo;
                    if (auxiliar == null) { // si aux es null , llego al final y se ciewrra el ciclo
                        padre.hijoIzquierdo = nuevo;
                        return; //Rompe la ejecucion , no importa lo que queda despues!
                    }
                } else {
                    auxiliar = auxiliar.hijoDerecho;
                    if (auxiliar == null) {
                        padre.hijoDerecho = nuevo;
                        return;
                    }
                }
            }
        }
    }

    //Metodo para saber si esta vacio
    public boolean estaVacio() {
        return raiz == null;
    }

    //metodo para Buscar Nodo
    public String buscarNodo(String nombre, int diaI, int minI) {
        NodoArbol aux = raiz;

        while ((aux.nombre.equals(nombre) == false) || ((diaI != aux.dato)) || (minI != aux.minIx)) {
            if (aux.nombre.charAt(0) < nombre.charAt(0) && diaI < aux.dato && minI > aux.minIx) {

                aux = aux.hijoIzquierdo;

            } else {

                aux = aux.hijoDerecho;

            }
            if (aux == null) {
                return null;
            }

        }
        return aux.BMP; // Nuestra Busqueda Retornara los BMP , ingresados.
    }

}
