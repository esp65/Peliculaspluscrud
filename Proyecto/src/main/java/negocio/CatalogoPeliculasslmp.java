/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import Excepciones.AccesoDatosEx;
import Excepciones.EscrituraDatosEx;
import datos.AccesoDatosAdicImpl;
import dominio.Pelicula;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class CatalogoPeliculasslmp  implements CatalogoPeliculas {

    
    // private final IAccesoDatos datos;
    
     private final datos.AccesoDatosAdicImpl datos; // nueva linea
     
     
     
    public CatalogoPeliculasslmp(){
       // this.datos=new AccesoDatosimpl();
       this.datos=new AccesoDatosAdicImpl(); //nueva linea
    }
    
    
    @Override
    public void agregarPeliculas(String nombrePelicula, String nombrearchivo) {
       Pelicula pelicula = new Pelicula ( nombrePelicula);
       boolean anexar=false;
       
        try {
          anexar =datos.existen(nombrearchivo);//si existe anexa informacion, si no va a crear el archivo
           datos.escribir(pelicula, nombrearchivo, anexar);
          
          
        } catch (AccesoDatosEx ex) {
            
            System.out.println("Error al acceder a los datos");
        }
       
    }

    @Override
    public void listarPeliculas(String nombreArchivo) {
        try {
            
          
            
           List<Pelicula> peliculas=datos.listar(nombreArchivo);
           System.out.println("*****Listar Peliculas*****");
             datos.cargarInformacion(nombreArchivo); //llamamiento
//          for(Pelicula peli: peliculas){//voy ha ir leyendo elemento por elemento en mi lista
//              System.out.println("peli:"+peli);            
               
//           }
       
        } catch (Exception e) {
            System.out.println("Clavos con el acceso a datos");
        }
 
        
    }

    @Override
    public void buscarPeliculas(String nombreArchivo, String buscar) {
       String resultado= "No se encontró";
        try {
            resultado=datos.Buscar(nombreArchivo, buscar);
        } catch (EscrituraDatosEx ex) {
            System.out.println("Error al buscar la peli");
        }
        System.out.println("Resultado"+resultado);
        
    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {
        try {
           if(datos.existen(nombreArchivo)){
               //si existe lo borra
               datos.borrar(nombreArchivo);
            
        }else
               //creamos el archivo
               datos.crear(nombreArchivo);
           
           
           
        } catch (AccesoDatosEx e) {
            System.out.println("Error de acceso a datos");
        }
    }
    
    
}
