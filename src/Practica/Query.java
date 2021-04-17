package Practica;
//Datos que se van a Tener en la Query
public class Query {

    public String nombre;
    public int diaI;
    public int minI;
    public int diaF;
    public int minF;

    public Query(String nombre, int diaI, int minI, int diaF, int minF) {
        this.nombre = nombre;
        this.diaI = diaI;
        this.minI = minI;
        this.diaF = diaF;
        this.minF = minF;
    }

    @Override
    public String toString() {
        return "[Nombre: " + nombre + " DiaI: " + diaI + " MinI: " + minI + " DiaF: " + diaF + " MinF: " + minF + "]";
    }

}
