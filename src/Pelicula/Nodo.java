package Pelicula;

public class Nodo{
    Nodo siguiente;
    Nodo anterior;
    Pelicula informacion;

    public Nodo(){
        this.siguiente = null;
        this.anterior = null;
        this.informacion = null;
    }
}