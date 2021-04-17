/*Aqui se Guardaran Los registro o Datos que ingresaremos
 En el Arbol*/
package Practica;

public class Datos {

    public String nombre;
    public int dia;
    public int minI;
    public int minF;
    public String BMPVALORES; //Guardaremos los BMP de cada quien en una cadena

    public Datos(String nombre, int dia, int minI, int minF, String BMPVALORES) {
        this.nombre = nombre;
        this.dia = dia;
        this.minI = minI;
        this.minF = minF;
        this.BMPVALORES = BMPVALORES;
    }

    @Override
    public String toString() {
        return   "Nombre: " + nombre + " Dia: " + dia + " [ " + minI + " - " + minF + "] BMP: " + BMPVALORES ;
    }
    

    
}
