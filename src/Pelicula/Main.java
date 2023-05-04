package Pelicula;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaDoble l1 = new ListaDoble();
        String referencia;
        boolean flag = true;
        System.out.println( "-----------------------------------------------" +
                            "\n|              B I E N V E N I D O            |" +
                            "\n-----------------------------------------------");

        while (flag){
            System.out.println( "\n---------------------MENÚ--.-------------------" +
                                "\n|     1. Agregar una nueva pelicula           |" +
                                "\n|     2. Eliminar una pelicula                |" +
                                "\n|     3. Actualizar datos de una pelicula     |" +
                                "\n|     4. Calificar las peliculas              |" +
                                "\n|     5. Mostrar el estado de las peliculas   |" +
                                "\n|     6. Ordenar las pelicualas               |" +
                                "\n|     7. Buscar una pelicula                  |" +
                                "\n|     8. TOP-N de peliculas                   |" +
                                "\n|     9. Guardar peliculas ingresadas         |" +
                                "\n|     10. Mostrar peliculas guardadas         |" +
                                "\n|     11. Salir.                              |" +
                                "\n-----------------------------------------------\n");

            int op = scanner.nextInt();

            switch (op) {
                case 1:
                    boolean bandera = true;
                    while (bandera) {
                        scanner.nextLine();
                        System.out.println("\nNOMBRE DE LA PELICULA");
                        String nombrePelicula = scanner.nextLine();
                        System.out.println("NOMBRE DEL DIRECTOR DE LA PELICULA");
                        String nombreDirector = scanner.nextLine();
                        System.out.println("AÑO DE ESTRENO DE LA PELICULA");
                        String fecha = scanner.nextLine();

                        Pelicula pelicula = new Pelicula(nombrePelicula, nombreDirector, fecha);

                        System.out.println("\n¿DONDE DESEA COLOCAR LA PELICULA?"+
                                "\n1. Al principio" +
                                "\n2. Al final" +
                                "\n3. Despues de una pelicula");

                        int posicion = scanner.nextInt();

                        if (posicion == 1){
                            l1.insertarPrincipio(pelicula);
                        } else if (posicion == 2){
                            l1.insertarFinal(pelicula);
                        } else if (posicion == 3){
                            scanner.nextLine();
                            System.out.println("NOMBRE DE LA PELICULA");
                            referencia = scanner.nextLine();
                            l1.insertarDespues(pelicula, referencia);
                        }

                        System.out.println("¿DESEA INGRESAR OTRA PELICULA?" +
                                "\n1.Si" +
                                "\n2.No");
                        int op1 = scanner.nextInt();

                        if (op1 == 2) {
                            bandera = false;
                        }
                    }
                    break;

                case 2:
                    scanner.nextLine();
                    System.out.println("\nNOMBRE DE LA PELICULA A ELIMINAR");
                    referencia = scanner.nextLine();
                    l1.eliminarDespues(referencia);
                    break;

                case 3:
                    scanner.nextLine();
                    System.out.println("\nNOMBRE DE LA PELICULA QUE DESEA MODIFICAR");
                    referencia = scanner.nextLine();
                    l1.actualizar(referencia);
                    break;

                case 4:
                    scanner.nextLine();
                    System.out.println("\nNOMBRE DE LA PELICULA A CALIFICAR");
                    referencia = scanner.nextLine();
                    l1.calificacion(referencia);
                    break;
                case 5:
                    l1.show();
                    break;

                case 6:
                    l1.Ordenar();
                    break;
                case 7:
                    scanner.nextLine();
                    System.out.println("\nNOMBRE DE LA PELICULA A BUSCAR");
                    referencia = scanner.nextLine();
                    l1.buscar(referencia);
                    break;

                case 8:
                    scanner.nextLine();
                    System.out.println("\nINGRESE EL NUMERO DEL TOP");
                    int n = scanner.nextInt();
                    l1.ordenarPorCalificacion();
                    l1.mostrarTopN(n);
                    break;

                case 9:
                    scanner.nextLine();
                    System.out.println("\nINGRESE EL NOMBRE DE COMO SE VA LLAMAR EL ARCHIVO");
                    String nombre = scanner.nextLine();
                    l1.guardarEnArchivo(nombre);
                    break;

                case 10:
                    scanner.nextLine();
                    System.out.println("\nINGRESE EL NOMBRE DEL ARCHIVO");
                    String nombreArchivo = scanner.nextLine();
                    l1.cargarArchivo(nombreArchivo);
                    break;

                case 11:
                    System.out.println( "-----------------------------------------------" +
                            "\n|    C E R R A N D O     P R O G R A M A      |" +
                            "\n-----------------------------------------------");
                    flag = false;
                    break;
            }
        }

    }
}
