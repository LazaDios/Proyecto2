package Practica;

public class NodoArbol {

    int dato, minIx, minFx;
    String nombre, BMP;
    NodoArbol hijoIzquierdo, hijoDerecho;

    public NodoArbol(int dato, String nom, int minFx, int minIx, String BMP) {
        this.dato = dato;
        this.nombre = nom;
        this.hijoDerecho = null;
        this.hijoIzquierdo = null;
        this.minFx = minFx;
        this.minIx = minIx;
        this.BMP = BMP;

    }

    public String toString() {
        return nombre + " Dia: " + dato + " Rango de Busqueda :" + "[" + minIx + "-" + minFx + "]" + "BMP GENERADOS:" + BMP;
    }

}
