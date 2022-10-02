/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import Excepciones.AccesoDatosEx;
import Excepciones.EscrituraDatosEx;
import Excepciones.LecturaDatosEx;
import dominio.Pelicula;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface IAccesoDatos {
    boolean existe(String nombreArchivo) throws AccesoDatosEx;
    public List<Pelicula> listar(String nombreArchivo)throws LecturaDatosEx;
    void escribir(Pelicula pelicula,String nombreArchivo, boolean anexar)  throws EscrituraDatosEx;
    public String Buscar(String nombreArchivo,String buscar) throws EscrituraDatosEx;
    public void crear (String nombreArchivo) throws AccesoDatosEx;
    public void borrar(String nombreArchivo) throws AccesoDatosEx;
    
    
}
