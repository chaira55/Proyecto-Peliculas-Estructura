package Pelicula;

public class Pelicula{
    public String nombrePelicula;
    public String nombreDirector;
    public String fecha;
    public float calificacion = -1;

    public Pelicula(String nombrePelicula, String nombreDirector, String fecha) {
        this.nombrePelicula = nombrePelicula;
        this.nombreDirector = nombreDirector;
        this.fecha = fecha;
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "[ PELICULA = " + nombrePelicula + " || " +
                "NOMBRE DEL DIRECTOR = " + nombreDirector + " || " +
                "FECHA = " + fecha + " || " +
                "CALIFICACION = " + calificacion + " ]";
    }
}
