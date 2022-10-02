/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import Excepciones.AccesoDatosEx;
import Excepciones.EscrituraDatosEx;
import Excepciones.LecturaDatosEx;
import dominio.Pelicula;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class AccesoDatoslmp implements IAccesoDatos{

    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx {
        List<Pelicula>peliculas = new ArrayList();
        try{
            BufferedReader entrada = null;
            File archivo= new File(nombreArchivo);
            entrada = new BufferedReader (new FileReader (archivo));
            String Linea = null;
            Linea= entrada.readLine();
            while (Linea != null){
                Pelicula pelicula = new Pelicula(Linea);
                peliculas.add(pelicula);
                Linea = entrada.readLine();
            }
           entrada.close();
        }
        catch (FileNotFoundException ex){
            
            System.out.println("No se encuentra el archivo");
            
        }catch (IOException ex){
            System.out.println("Tienes problemas al abrir el archivo");
        }
        
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
         
        PrintWriter salida = null;
        try {
            File archivo = new File(nombreArchivo);
            salida = new PrintWriter(new FileWriter(archivo,anexar));
            salida.print(pelicula.toString ());
            salida.close();
            System.out.println("A escrito una nueva pelicula");
                
        }catch (Exception e){
            
        }
    }

    @Override
    public String Buscar(String nombreArchivo, String buscar) throws EscrituraDatosEx {
        
        BufferedReader entrada = null;
      String resultado=null;
        try {
           File archivo = new File (nombreArchivo);
           
           entrada = new BufferedReader (new FileReader (archivo));
           String linea=null;
           int i =0;
           linea = entrada.readLine();
           
           while (linea != null){
               
               if (buscar != null && buscar.equalsIgnoreCase(linea)){
                   resultado ="peli:"+linea+"encontrada en la linea="+i;
                   break;
               }
               linea=entrada.readLine();
               i++;
           }
           entrada.close();
           
        } catch (FileNotFoundException ex) {
            System.out.println("no se encontro"+ ex.getMessage());
            
        }catch (IOException ex){
            System.out.println("problema de archivo"+ ex.getMessage());
        }finally{
            
            
            try {
                entrada.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar el archivo");
            }
        }
 
        return resultado;
        
 
    }


    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        PrintWriter salida= null;
        try {
            File archivo = new File (nombreArchivo);
            salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
        }catch (IOException ex){
            System.out.println("Problema al crear el archivo"+ ex.getMessage());
        }

    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File (nombreArchivo);
archivo.delete();
System.out.println("EL archivo se eliminó");
    }
    
    
}
