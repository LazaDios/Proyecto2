package Practica;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeerArchivo {

    ArrayList<Integer> Aux = new ArrayList<>(); //ayuda hacer comportamientos internos dentro de mis funciones
    ArrayList<String> linea_txt = new ArrayList<>(); //Para Guardar Las Lineas en Generales 
    ArrayList<Query> query = new ArrayList<>();
    ArrayList<Datos> datos = new ArrayList<>();
    ArbolBinario Arbol = new ArbolBinario();

    public void LeerArchi() {
        String linea; //donde se guardara los datos salientes
        String BMPLINEA;
        Matcher BuscarString;
        File archivo;
        FileReader fr;
        BufferedReader br;

        try {

            archivo = new File("data.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            //Bucle para leer y guardar linea por linea la informacion encontrada en el archivo
            while ((linea = br.readLine()) != null) {
                linea_txt.add(linea);

            }
            //Bucle para convertir los datos que estan en string a int
            for (int j = 0; j < linea_txt.size(); j++) {
                if (linea_txt.get(j).equals("JUAN") == true) { //si en la posicion 1 es Juan hacer 

                    BuscarString = Pattern.compile("\\d+").matcher((String) linea_txt.get(j + 1)); //La linea siguiente tendra los Datos Dia , minI , minF
                    BMPLINEA = linea_txt.get(j + 2);
                    while (BuscarString.find()) {
                        Aux.add(Integer.parseInt(BuscarString.group())); //Guardaremos los Datos
                    }
                    //Lenamos Los Datos.
                    datos.add(new Datos(linea_txt.get(j), Aux.get(0), Aux.get(1), Aux.get(2), BMPLINEA));
                    Aux.clear();//Borrar Los Datos De mi Auxiliar , para Volver a Usar

                }
                if (linea_txt.get(j).equals("PEDRO") == true) {
                    BuscarString = Pattern.compile("\\d+").matcher((String) linea_txt.get(j + 1)); //La linea siguiente tendra los Datos Dia , minI , minF
                    BMPLINEA = linea_txt.get(j + 2);
                    while (BuscarString.find()) {
                        Aux.add(Integer.parseInt(BuscarString.group())); //Guardaremos los Datos
                    }
                    datos.add(new Datos(linea_txt.get(j), Aux.get(0), Aux.get(1), Aux.get(2), BMPLINEA));
                    Aux.clear();//Borrar Los Datos De mi Auxiliar , para Volver a Usar
                }

                //Meter Valores Al Query
                if (linea_txt.get(j).equals("QUERY") == true) {
                    for (int i = j + 1; i < linea_txt.size(); i++) {

                        if (linea_txt.get(i).charAt(0) == 'P') {
                            BuscarString = Pattern.compile("\\d+").matcher((String) linea_txt.get(i));
                            while (BuscarString.find()) {
                                Aux.add(Integer.parseInt(BuscarString.group())); //Guardaremos los Datos
                            }
                            query.add(new Query(linea_txt.get(i).substring(0, 5), Aux.get(0), Aux.get(1), Aux.get(2), Aux.get(3)));
                            Aux.clear(); //Para Borrar los Datos Transatorios.
                        }

                        if (linea_txt.get(i).charAt(0) == 'J') {
                            BuscarString = Pattern.compile("\\d+").matcher((String) linea_txt.get(i));
                            while (BuscarString.find()) {
                                Aux.add(Integer.parseInt(BuscarString.group())); //Guardaremos los Datos
                            }
                            query.add(new Query(linea_txt.get(i).substring(0, 5), Aux.get(0), Aux.get(1), Aux.get(2), Aux.get(3)));
                            Aux.clear();
                        }
                    }
                }

            }

            //Meter Los Valores en EL ARBOL BINARIO , 
            for (int i = 0; i < datos.size(); i++) {
                //o una condicional aqui conjunto con el queery , para solo añadir a Pedro y el campo de jUAN
                Arbol.agregarNodo(datos.get(i).dia, datos.get(i).nombre, datos.get(i).minI, datos.get(i).minF, datos.get(i).BMPVALORES);
            }

            //Busqueda de los los Datos Segun el QUERY
            for (int i = 0; i < query.size(); i++) { //Ciclo del uno al tres

                if (query.get(i).nombre.equals("PEDRO") == true) {
                    System.out.println("PEDRO:");

                    boolean en = false;

                    if (en == false) {
                        if (Arbol.buscarNodo(query.get(i).nombre, query.get(i).diaI, datos.get(3).minI) != null) {
                            System.out.print("[ " + Arbol.buscarNodo(query.get(i).nombre, query.get(i).diaI, datos.get(3).minI) + " ");

                        }
                        if (Arbol.buscarNodo(query.get(i).nombre, query.get(i).diaI + 1, datos.get(1).minI) != null) {
                            System.out.print(" " + Arbol.buscarNodo(query.get(i).nombre, query.get(i).diaI, datos.get(1).minI) + " ");

                        }
                        if (Arbol.buscarNodo(query.get(i).nombre, query.get(i).diaI + 1, datos.get(1).minI) != null) {
                            System.out.println("" + Arbol.buscarNodo(query.get(i).nombre, query.get(i).diaI + 1, datos.get(1).minI) + " ]");

                            en = true;
                        }
                        if (en == false) {
                            System.out.println("[ ]");
                        }

                    }

                } else { //si no es JUAN

                    System.out.println("JUAN: ");
                    int diaI = query.get(i).diaI;
                    int diaF = query.get(i).diaF;
                    boolean en = false;

                    for (int j = 0; j < datos.size(); j++) {
                        if (en == false) {

                            if (Arbol.buscarNodo("JUAN", diaI, datos.get(j).minI) != null) {
                                System.out.println("[" + Arbol.buscarNodo("JUAN", diaI, datos.get(j).minI) + "]");
                                en = true;
                            }
                            if (Arbol.buscarNodo("JUAN", diaF, datos.get(j).minI) != null) {
                                System.out.println("[ " + Arbol.buscarNodo("JUAN", diaF, datos.get(j).minI) + "]");
                                en = true;

                            } else {
                                System.out.println("[ ]");
                            }
                        }
                    }

                }

            }

            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Hubo un error en la lectura del archivo" + e);
        }
    }
}
