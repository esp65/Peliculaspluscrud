/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pelisplus;

import java.util.Scanner;
import negocio.CatalogoPeliculas;
import negocio.CatalogoPeliculasslmp;

/**
 *
 * @author USUARIO
 */
public class PeliculasPlus {
    private static final Scanner scanner= new Scanner(System.in);
    private static int opcion=-1;
    private static final String nombreArchivo= "C:\\Users\\USUARIO\\Clase 10.csv";
    private static final CatalogoPeliculas catalogopeli=new CatalogoPeliculasslmp();
    
    public static void main(String[] args) {
       
          //Mientras la opcion elegida sea 0, preguntamos al usuario
        while (opcion != 0) {
            try {
                System.out.println("Elige opcion:\n1.- Iniciar catalogo peliculas"
                        + "\n2.- Agregar pelicula\n"
                        + "3.- Listar Peliculas\n"
                        + "4.- Buscar Pelicula\n"
                        + "0.- Salir");

                opcion = Integer.parseInt(scanner.nextLine());

                //Ejemplo de switch case en Java
                switch (opcion) {
                    case 1:
                       
                        catalogopeli.iniciarArchivo(nombreArchivo);
                        break;
                    case 2:
                        
                        System.out.println("Introduce el nombre de una pelicula a agregar,"+ "\ny el ano, separados por un <;> :");
                        String nombre = scanner.nextLine();
                        catalogopeli.agregarPeliculas(nombre, nombreArchivo);                       
                     
                        break;
                    case 3:
                        
                        catalogopeli.listarPeliculas(nombreArchivo);
                        
                        break;
                    case 4:
                           
                        
                        System.out.println("Introduce el nombre de una pelicula a buscar:");
                        String buscar = scanner.nextLine();
                        catalogopeli.buscarPeliculas(nombreArchivo, buscar);
                        break;
                    case 0:
                        System.out.println("!Hasta pronto!");
                        break;
                    default:
                        System.out.println("Opcion no reconocida");
                        break;
                }
                System.out.println("\n");

            } catch (Exception e) {
                System.out.println("Error!");
            }
        }

    }
    
    
}
