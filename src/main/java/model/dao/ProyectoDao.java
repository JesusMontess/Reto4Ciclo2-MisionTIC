package model.dao;

//Estructura de datos
import java.util.ArrayList;

import model.vo.Lider;
import model.vo.Proyecto;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

public class ProyectoDao {
    

    public ArrayList<Proyecto> query_requerimiento_1() throws SQLException {
        //Conexion con la BD
        Connection conexion = JDBCUtilities.getConnection();
        //Creamos un Arreglo para para almacenar objetos tipo proyecto
        ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
        //Consultas
        try {
            //Consulta para mostrar los datos de la BD
            String consulta = "SELECT Fecha_Inicio, Numero_Habitaciones, Clasificacion FROM Proyecto WHERE Ciudad= 'Manizales' ";
            //Ejecutamos la consulta
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();
            //Recorremos los registros en los VO especifivos
            while (resultSet.next()){
                //Almacenamos los resultados del query e un objeto Proyecto
                Proyecto objProyecto = new Proyecto();
                objProyecto.setFecha_inicio(resultSet.getString("Fecha_Inicio"));
                objProyecto.setNum_habitaciones(resultSet.getInt("Numero_Habitaciones"));
                objProyecto.setClasificacion(resultSet.getString("clasificacion"));
                //Añadimos todos los objetos al array proyectos
                proyectos.add(objProyecto);
            }
            //cerramos el query
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            //Todo: handle exception
            System.err.println("Error en la Consulta "+ e);
 
        } finally {
            //cerramos la conexion a la BD
            if (conexion != null){
                conexion.close();
            }
        }
        //Retornamos el ArrayList la coleccion de VO
        return proyectos;

    }

    public ArrayList<Proyecto> query_requerimiento_2() throws SQLException {
        //Conexion con la BD
        Connection conexion = JDBCUtilities.getConnection();
        //Creamos un Arreglo para para almacenar objetos tipo proyecto
        ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
        //Consultas
        try {
            //Ejecutamos el query de la consulta
            ResultSet query = conexion.createStatement().executeQuery(
                "SELECT p.Fecha_Inicio, p.Numero_Habitaciones, p.Clasificacion, l.Nombre, l.Primer_Apellido, t.Estrato FROM Proyecto p INNER JOIN Lider l ON l.ID_Lider = p.ID_Lider INNER JOIN Tipo t ON t.ID_Tipo = p.ID_Tipo WHERE p.Ciudad = 'Manizales'"
            );
            //Recorremos los registros en los VO especifivos
            while (query.next()){
                //Almacenamos los resultados del query e un objeto Proyecto
                Proyecto objProyecto = new Proyecto();
                objProyecto.setFecha_inicio(query.getString("Fecha_Inicio"));
                objProyecto.setNum_habitaciones(query.getInt("Numero_Habitaciones"));
                objProyecto.setClasificacion(query.getString("clasificacion"));
                objProyecto.setEstrato_proyecto(query.getInt("Estrato"));
                //Creamos el Objeto Lider
                String nombre_lider = query.getString("Nombre");
                String apellido_lider = query.getString("Primer_Apellido");
                Lider objLider = new Lider(nombre_lider, apellido_lider);
                objProyecto.setLider(objLider);
                //Añadimos todos los objetos al array proyectos
                proyectos.add(objProyecto);
            }
            
        } catch (Exception e) {
            //Todo: handle exception
            System.out.println(e);
 
        } 
        //Retornamos el ArrayList proyecto
        return proyectos;
        
    }// Fin del método query_requerimiento_2


    public ArrayList<Proyecto> query_requerimiento_3() throws SQLException {
        //Conexion con la BD
        Connection conexion = JDBCUtilities.getConnection();
        //Creamos un Arreglo para para almacenar objetos tipo proyecto
        ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
        //Consultas
        try {
            //Ejecutamos el query de la consulta
            ResultSet query = conexion.createStatement().executeQuery(
                "SELECT COUNT(p.Clasificacion) AS Condominios, Constructora FROM Proyecto p WHERE p.Clasificacion = 'Condominio' GROUP BY Constructora"
            );
            //Recorremos los registros en los VO especifivos
            while (query.next()){
                //Almacenamos los resultados del query e un objeto Proyecto
                Proyecto objProyecto = new Proyecto();
                objProyecto.setNum_condominios(query.getInt("Condominios"));
                objProyecto.setNombre_constructora(query.getString("Constructora"));
                
                //Añadimos todos los objetos al array proyectos
                proyectos.add(objProyecto);
            }
            
        } catch (Exception e) {
            //Todo: handle exception
            System.out.println(e);
 
        } 
        //Retornamos el ArrayList proyecto
        return proyectos;
        
    }// Fin del método query_requerimiento_3
    


    public ArrayList<Proyecto> query_requerimiento_5() throws SQLException{
        //Conexion con la BD
        Connection conexion = JDBCUtilities.getConnection();
        //Creamos un Arreglo para para almacenar objetos tipo proyecto
        ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
        //Consultas
        try {
            //Ejecutamos el query de la consulta
            ResultSet query = conexion.createStatement().executeQuery(
                "SELECT COUNT(p.Clasificacion) AS 'Condominios', p.Constructora  AS 'Constructora' FROM Proyecto p WHERE p.Clasificacion = 'Condominio' GROUP BY p.Constructora HAVING COUNT(p.clasificacion) > 11 ORDER BY COUNT(p.clasificacion) ASC "
            );
            //Recorremos los registros en los VO especifivos
            while (query.next()){
                //Almacenamos los resultados del query e un objeto Proyecto
                Proyecto objProyecto = new Proyecto();
                objProyecto.setNum_condominios(query.getInt("Condominios"));
                objProyecto.setNombre_constructora(query.getString("Constructora"));
                
                //Añadimos todos los objetos al array proyectos
                proyectos.add(objProyecto);
            }
            
        } catch (Exception e) {
            //Todo: handle exception
            System.out.println(e);
 
        } 
        //Retornamos el ArrayList proyecto
        return proyectos;
        
        
    }// Fin del método query_requerimiento_5

}