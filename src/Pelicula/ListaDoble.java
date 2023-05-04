package Pelicula;

import java.util.Scanner;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;

public class ListaDoble{
    Nodo cabeza;
    Nodo cola;
    Nodo anterior;
    Nodo siguiente;

    public ListaDoble(){
        Nodo cabeza = new Nodo();
        Nodo cola = new Nodo();
        this.cabeza = cabeza;
        this.cola = cola;
        cabeza.siguiente = cola;
        cola.anterior = cabeza;
    }

    public void insertarPrincipio(Pelicula pelicula){
        anterior = cabeza;
        siguiente = anterior.siguiente;
        Nodo nodo = new Nodo();
        nodo.informacion = pelicula;
        nodo.anterior = anterior;
        nodo.siguiente = siguiente;
        anterior.siguiente = nodo;
        siguiente.anterior = nodo;

        System.out.println("\nPELICULA INGRESADA!\n");
    }

    public void insertarFinal(Pelicula pelicula){
        siguiente = cola;
        anterior = siguiente.anterior;
        Nodo nodo = new Nodo();
        nodo.informacion = pelicula;
        nodo.siguiente = siguiente;
        nodo.anterior = anterior;
        anterior.siguiente = nodo;
        siguiente.anterior = nodo;

        System.out.println("\nPELICULA INGRESADA!\n");
    }

    public void insertarDespues (Pelicula pelicula, String referencia){
        if (this.cabeza.siguiente != cola){
            Nodo actual = cabeza.siguiente;
            boolean flag = true;
            while (actual != cola){
                if (actual.informacion.nombrePelicula.equals(referencia)){
                    Nodo nodo = new Nodo();
                    nodo.informacion = pelicula;
                    nodo.siguiente = actual.siguiente;
                    nodo.anterior = actual;
                    actual.siguiente.anterior = nodo;
                    actual.siguiente = nodo;
                    flag = true;
                    break;
                } else {
                    flag = false;
                }
                actual = actual.siguiente;
            }
            if (!flag){
                System.out.println("PELICULA " + referencia + " NO ENCONTRADA");
            }

            System.out.println("\nPELICULA INGRESADA!\n");

        } else {
            System.out.println("Error!, la lista esta vacia");
        }
    }

    public void eliminarDespues(String referencia){
        if (this.cabeza.siguiente != cola){
            Nodo actual = cabeza.siguiente;
            boolean op = true;

            while (actual != cola){
                if (actual.informacion.nombrePelicula.equals(referencia)){
                    actual.siguiente.anterior = actual.anterior;
                    actual.anterior.siguiente = actual.siguiente;
                    op = true;
                    break;
                } else {
                    op = false;
                }
                actual = actual.siguiente;
            }
            if (!op){
                System.out.println("Nodo " + referencia + " no encontrado.");
            }

            System.out.println("\nPELICULA ELIMINADA!\n");

        } else{
            System.out.println("ERROR!!, la lista esta vacia.");
        }
    }

    public void actualizar(String referencia){
        if (this.cabeza.siguiente != cola){
            Nodo actual = cabeza.siguiente;
            Scanner scanner = new Scanner(System.in);
            boolean flag = true;
            while (actual != cola){
                if (actual.informacion.nombrePelicula.equals(referencia)){
                    System.out.println("NOMBRE DE LA PELICULA");
                    actual.informacion.nombrePelicula = scanner.nextLine();
                    System.out.println("NOMBRE DEL DIRECTOR DE LA PELICULA");
                    actual.informacion.nombreDirector = scanner.nextLine();
                    System.out.println("AÑO DE ESTRENO DE LA PELICULA");
                    actual.informacion.fecha  = scanner.nextLine();
                    flag = true;
                    break;
                } else{
                    flag = false;
                }
                actual = actual.siguiente;
            }
            if (!flag){
                System.out.println("Pelicula " + referencia + " no encontrado");
            }

            System.out.println("\nPELICULA ACTUALIZADA!\n");

        } else {
            System.out.println("Error!, la lista esta vacia");
        }
    }

    public void buscar(String referencia){
        if (this.cabeza.siguiente != cola){
            Nodo actual = cabeza.siguiente;
            boolean flag = true;
            while (actual != cola){
                if (actual.informacion.nombrePelicula.equals(referencia)){

                    if (actual.informacion.calificacion >= 0) {
                        System.out.println("\n[ PELICULA = " + actual.informacion.nombrePelicula + " || " +
                                "NOMBRE DEL DIRECTOR = " + actual.informacion.nombreDirector + " || " +
                                "FECHA = " + actual.informacion.fecha +
                                "CALIFICACION = " + actual.informacion.calificacion + " ]");
                    } else {
                        System.out.println("\n[ PELICULA = " + actual.informacion.nombrePelicula + " || " +
                                "NOMBRE DEL DIRECTOR = " + actual.informacion.nombreDirector + " || " +
                                "FECHA = " + actual.informacion.fecha + " ]");
                    }
                    flag = true;
                    break;
                } else{
                    flag = false;
                }
                actual = actual.siguiente;
            }
            if (!flag){
                System.out.println("Pelicula " + referencia + " no encontrado");
            }
        } else {
            System.out.println("ERROR!, la lista esta vacia");
        }
    }

    public void calificacion(String referencia){
        if (this.cabeza.siguiente != cola){
            Scanner scanner = new Scanner(System.in);
            Nodo actual = cabeza.siguiente;
            boolean flag = true;
            while (actual != cola){
                if (actual.informacion.nombrePelicula.equals(referencia)){
                    System.out.println("CALIFICACION");
                    actual.informacion.calificacion = scanner.nextFloat();
                    flag = true;
                    break;
                } else{
                    flag = false;
                }
                actual = actual.siguiente;
            }
            if (!flag){
                System.out.println("Pelicula " + referencia + " no encontrado");
            }

            System.out.println("\nPELICULA CALIFICADA!\n");

        } else {
            System.out.println("ERROR!, la lista esta vacia");
        }
    }

    public void Ordenar(){
        if(this.cabeza.siguiente!=cola && cola.anterior!=cabeza){
            if(this.cabeza.siguiente==cola.anterior)
                System.out.println("\nLA LISTA YA ESTA ORGANIZADA, SOLO TIENE UNA PELICULA!\n");
            else{
                boolean flag = true;
                Nodo actual;
                while(flag == true){
                    flag = false;
                    actual = cabeza.siguiente;
                    while(actual != cola){
                        if(actual.informacion.nombrePelicula.compareTo(siguiente.informacion.nombrePelicula) > 0){
                            String nombreauxiliar = actual.informacion.nombrePelicula;
                            actual.informacion.nombrePelicula = actual.siguiente.informacion.nombrePelicula;
                            actual.siguiente.informacion.nombrePelicula = nombreauxiliar;

                            String directorauxiliar = actual.informacion.nombreDirector;
                            actual.informacion.nombreDirector = actual.siguiente.informacion.nombreDirector;
                            actual.siguiente.informacion.nombreDirector = directorauxiliar;

                            String fechaauxiliar = actual.informacion.fecha;
                            actual.informacion.fecha = actual.siguiente.informacion.fecha;
                            actual.siguiente.informacion.fecha = fechaauxiliar;

                            float califiauxiliar = actual.informacion.calificacion;
                            actual.informacion.calificacion = actual.siguiente.informacion.calificacion;
                            actual.siguiente.informacion.calificacion = califiauxiliar;

                            flag=true;
                        } else {
                            flag = false;
                        }
                        actual = actual.siguiente;
                    }
                }
                System.out.println("\nPELICULAS ORGANIZADA!\n");
            }
        }
    }

    public void guardarEnArchivo(String nombre) {
        try {
            FileWriter archivo = new FileWriter(nombre);
            BufferedWriter escritor = new BufferedWriter(archivo);

            Nodo actual = cabeza.siguiente;
            while (actual != cola) {
                Pelicula pelicula = actual.informacion;
                escritor.write("[ PELICULA = " + pelicula.nombrePelicula + ", NOMBRE DEL DIRECTOR = " + pelicula.nombreDirector + ", FECHA = " + pelicula.fecha + ", CALIFICACION = " + pelicula.calificacion + " ]");
                escritor.newLine();
                actual = actual.siguiente;
            }

            escritor.close();
            System.out.println("\nPELICULAS GUARDADAS!\n");
        } catch (IOException e) {
            System.out.println("VAYA!, Ocurrió un error al guardar las peliculas en el archivo.");
            e.printStackTrace();
        }
    }

    public void cargarArchivo(String nombreArchivo) {
        try {
            File archivo = new File(nombreArchivo);
            Scanner scanner = new Scanner(archivo);
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                System.out.println(linea);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo: " + nombreArchivo);
            e.printStackTrace();
        }
    }

    public void ordenarPorCalificacion() {
        Nodo actual = cabeza.siguiente;
        while (actual != cola) {
            Nodo siguiente = actual.siguiente;
            while (siguiente != cola) {
                if (siguiente.informacion.calificacion > actual.informacion.calificacion) {
                    Pelicula temp = actual.informacion;
                    actual.informacion = siguiente.informacion;
                    siguiente.informacion = temp;
                }
                siguiente = siguiente.siguiente;
            }
            actual = actual.siguiente;
        }
    }

    public void mostrarTopN(int n) {
        ordenarPorCalificacion();

        Nodo actual = cabeza.siguiente;
        for (int i = 1; i <= n && actual != cola; i++) {
            Pelicula pelicula = actual.informacion;
            System.out.println("[" + i + "] " + pelicula.nombrePelicula + " (" + pelicula.nombreDirector + ", " + pelicula.fecha + ") - " + pelicula.calificacion);
            actual = actual.siguiente;
        }
    }

    public void show(){
        Nodo actual = cabeza.siguiente;

        while (actual != cola){
            System.out.println(actual.informacion);
            actual = actual.siguiente;
        }
    }
}
